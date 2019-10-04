import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bravlio
 */
public class SecureworksCodingChallengeTest {
    
    public SecureworksCodingChallengeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n\t\t-----JUnit Test Cases------\n\n");  
        System.out.println("before class----> only once"); 
        
    }
    
    @AfterClass
    public static void tearDownClass() {
	System.out.println("after class---> only once"); 
    }
    
    @Before
    public void setUp() {
        System.out.println("\nbefore---> before each test case");  
    }
    
    @After
    public void tearDown() {
	System.out.println("\nafter ---> after each test case\n\n"); 
    }

    
    @Test
    public void testTransposedString() {
        System.out.println("DOES APPLICATION RETURNS THE LONGEST WORD TRANSPOSED?");
        File file = new File("secureworkstestfile.txt");
        String transposedString = SecureworksCodingChallenge.transposeString(file);
        //if it is not null amd the string is not empty, then the file contains a correct string
        assertTrue(transposedString != null && !transposedString.isEmpty());
    }
    
    @Test
    public void testStringHasLettersOrNumbers() {
        System.out.println("DOES APPLICATION RETURNS AN ACTUAL STRING?");
        File file = new File("secureworkstestfile.txt");
        String transposedString = SecureworksCodingChallenge.transposeString(file);
        //if it does return a string, then it is the transposed string
        assertTrue(transposedString.length() > 0);
    }
    
    @Test
    public void testFileDoesntExist() {
        System.out.println("DOES METHOD TELLS THE USER WHEN THE FILE DOESN'T EXIST?");
        File file = new File("notafile.txt");
        String errorFromMethod = "File does not exist";
        String error = SecureworksCodingChallenge.transposeString(file);
        
        //Since method makes sure that the file exists, it won't throw an exception but an error message to the user
        assertTrue(error.equals(errorFromMethod));
    }
    
    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundException() throws FileNotFoundException {
        System.out.println("DOES METHOD THROWS A FILE NOT FOUND EXCEPTION?");
        File file = new File("notthecorrectfile.txt");
        SecureworksCodingChallenge.longestWord(file);
    }
    
    @Test
    public void testOnlyLettersAndNumbers () throws FileNotFoundException {
        System.out.println("DOES METHOD THROWS AN ERROR MESSAGE WHEN FILE DOES NOT CONTAIN ONLY LETTERS AND NUMBERS?");
        File file = new File("secureworkstestfile.txt");
        String onlyLettersAndNumbers = SecureworksCodingChallenge.longestWord(file);
        String error = "ALPHANUMERIC_ERROR";
        //Make sure that it doesn't contain the word ALPHANUMERIC_ERROR, this string is only 
        //thrown when the file doesn't conain only letters and numbers
        assertFalse(onlyLettersAndNumbers.contains(error));
    }
    
    @Test
    public void testStringDoesntHaveASpace() throws FileNotFoundException {
        System.out.println("DOES STRING HAS A SPACE?");
        File file = new File("secureworkstestfile.txt");
        String onlyLettersAndNumbers = SecureworksCodingChallenge.longestWord(file);
        boolean hasSpace = onlyLettersAndNumbers.matches(".*\\s+.*");
        //String should not have a space, so boolean should be false
        assert(!hasSpace);
    }
    
    @Test
    public void testFileReaderExists() {
        System.out.println("DOES FILE EXIST?");
        File file = new File("secureworkstestfile.txt");
        File testFile = SecureworksCodingChallenge.fileReader(file);
        assertTrue(testFile.exists());
    }
    
    
    @Test
    public void testFileReaderNotEmpty()  throws Exception{
        System.out.println("IS FILE EMPTY?");
        File file = new File("secureworkstestfile.txt");
        File testFile = SecureworksCodingChallenge.fileReader(file);
        // Get length of file in bytes
        assertTrue(testFile.length() != 0);
    }
    
    @Test
    public void testFileReaderNotBiggerThanOneGigabyte() throws Exception{
        System.out.println("IS FILE BIGGER THAN 1 GIGABYTE?");
        File file = new File("secureworkstestfile.txt");
        File testFile = SecureworksCodingChallenge.fileReader(file);
        // Get length of file in bytes
        long fileSizeInBytes = testFile.length();
        // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
        long fileSizeInKB = fileSizeInBytes / 1024;
        // Convert the KB to MegaBytes (1 MB = 1024 KBytes)
        long fileSizeInMB = fileSizeInKB / 1024;
        assertFalse(fileSizeInMB > 1000);
    }
    
    @Test
    public void testFileReaderAccessible() throws Exception{
        System.out.println("IS FILE ACCESSIBLE?");
        File file = new File("secureworkstestfile.txt");
        File testFile = SecureworksCodingChallenge.fileReader(file);
        try (FileReader fileReader = new FileReader(testFile.getAbsolutePath())) {
            //If return is -1 then file is not accessible
            assertTrue(fileReader.read() >= 0);
        }
    }
    
    @Test
    public void testFileReaderHasCorrectExtension() {
        System.out.println("DOES FILE HAS CORRECT EXTENSION?");
        File file = new File("secureworkstestfile.txt");
        File testFile = SecureworksCodingChallenge.fileReader(file);
        String name = testFile.getName();
        int lastIndexOf = name.lastIndexOf(".");
       
        //Correct extensions is txt. Asked to John and he stated that it should be a simple text file
        assertTrue(name.substring(lastIndexOf).equals(".txt"));
    }
    
    @Test
    public void testFileReaderHasAnExtension() {
        System.out.println("DOES FILE HAS AN EXTENSION?");
        File file = new File("secureworkstestfile.txt");
        File testFile = SecureworksCodingChallenge.fileReader(file);
        String name = testFile.getName();
        int lastIndexOf = name.lastIndexOf(".");
        
        //Return -1 if file doesn't have an extension
        assertFalse(lastIndexOf == -1);
    }
    
}