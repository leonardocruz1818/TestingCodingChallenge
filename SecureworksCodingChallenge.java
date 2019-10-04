import java.io.*;
import java.util.Scanner;

/**
 *
 * @author bravlio
 */
public class SecureworksCodingChallenge {
    
    public static boolean ONLY_LETTERS_AND_NUMBERS = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Set static file for demoing purposes. This will be an assumption in the README file.
        //secureworkstestfile.txt
        File file = new File("secureworkstestfile.txt");
        transposeString(fileReader(file));
    }
    
        /**
     * 
     * @param file
     * @return
     * @throws FileNotFoundException 
     */
    public static String longestWord(File file) throws FileNotFoundException {
        
        String longestWord = "";
        String currentWord;
        Scanner scanner = new Scanner(file);
                
        //If the file has words, read it.
        while (scanner.hasNext()) {
            currentWord = scanner.next();
            
            //Check that file and string only contain letters and numbers
            if(currentWord.matches("[a-zA-Z0-9]*")) {
                //Checking words length and compare them.
                //Pick the first word and continue comparing until you find a longer word
                //If you find a longer word, set it as "Longest" word and continue
                //going through the file
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
            } else {
                ONLY_LETTERS_AND_NUMBERS = false;
            }
            
        }

        if (!ONLY_LETTERS_AND_NUMBERS) {
            longestWord = "ALPHANUMERIC_ERROR: File should only have letters and numbers.";
            System.out.println("\n"+longestWord+"\n");
        } else {
            System.out.println("\n Longest word is: "+longestWord+"\n");
        }
        return longestWord;
    }
    
    /**
     * 
     * Provides the intended value of the file
     * 
     * @param file
     * @return string 
     */
    public static String transposeString(File file) {
        
        //String to return with reversed value
        String reversedStr = "";
        
        try {
            
            //First check if file exists before doing anything with it.
            if(file.exists()) {
                
                String longestWord = longestWord(file);
                
                if(!ONLY_LETTERS_AND_NUMBERS) {
                    String onlyLettersNumbers = "File should contain only letters and numbers";
                    return onlyLettersNumbers;
                }
                
                //read the longest word starting from last character.
                for(int i = longestWord.length() - 1; i >= 0; i--)
                {
                    reversedStr = reversedStr + longestWord.charAt(i);
                }

                System.out.println("\n Longest word reversed: " + reversedStr +"\n");

                //return longest word in file
                return reversedStr;
            } else {
                String error = "File does not exist";
                System.out.println(error);
                return error;
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace(System.err);
        }
        
        return reversedStr;
    }
    
    /**
     * 
     * Provides file information
     * 
     * @param file
     * @return 
     */
    public static File fileReader(File file) {
       
            File newFile = file;
            if(newFile.exists()) {
                
                return newFile;
            } else {
                System.out.println("File does not exist");
            }
    
            return newFile;
    }
}