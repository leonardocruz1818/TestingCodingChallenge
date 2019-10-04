1) INTRODUCTION
2) TECHNOLOGY AND OTHER TOOLS
3) DETAILS ON TECHNOLOGY USED FOR THIS APPLICATION
4) RECOMMENDATIONS
5) HOW TO RUN AND COMPILE JAVA CLASS AND TEST CLASS
6) ASSUMPTIONS IN GENERAL
7) ASSUMPTIONS ABOUT CODING CHALLENGE

=====================================================

1) INTRODUCTION
This README file is a guideline on how to compile and run the test cases provided for the coding challenge. 
It provides the TECHNOLOGY that a user needs to have on her/his machine in order to run the Java application.
It also provide some ASSUMPTIONS made in order to run the test cases in a simple manner.

=====================================================

2) TECHNOLOGY AND OTHER TOOLS
In order to run this application, the user needs:
1) Java 1.8 SDK
2) junit-4.12.jar
3) hamcrest-core-1.3.jar
4) Java editor

=====================================================

3) DETAILS ON TECHNOLOGY USED FOR THIS APPLICATION
This is a list of tools that a user needs to run the test cases on the machine. It also provides where to find them and how to check if they have been installed on your machine.
1) Java 1.8.0_211 (It doesn't have to be exactly this version, as long as it is Java 1.8 and version 211 or newer)
Note: In case the user do not have Java installed please follow the steps provided on this site to download and install: https://www.oracle.com/technetwork/java/javase/downloads/index.html

Note: It is important to know that the Java SDK needs to be installed. To check if a Java file can be compiled through the terminal, please run the "javac" command.
If  it's installed, the user will see a similar output to this:
$ javac
Usage: javac <options> <source files>
where possible options include:
... [Provide list of options]

Note: Once you have installed Java, please and run this command:
java -version

You should see something similar to the prompt below:
java version "1.8.0_211"
Java(TM) SE Runtime Environment (build 1.8.0_211-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.211-b12, mixed mode) 

2) junit-4.12.jar
Note: For simplicity purposes, I've included this jar in the repository. In case you need to download it, please visit this site: https://mvnrepository.com/artifact/junit/junit/4.12 and click on the "jar" link to download.

3) hamcrest-core-1.3.jar 
Note: For simplicity purposes, I've included this jar in the repository. In case you need to download it, please visit this site: https://mvnrepository.com/artifact/org.hamcrest/hamcrest-core/1.3

4) Any Java editor to read Java files

5) Java and jar files to run the application. Please visit this git repository to download files: SecureworksCodingChallenge
https://github.com/bravlioguzman/SecureworksCodingChallenge

=====================================================

4) RECOMMENDATIONS
For simplicity purposes, I've designed the test cases to run by having all the required jars and text files in the same folder. Therefore, please extract files from git repository and store them in a single folder.
Once this is done, you should see something like this: 
/Users/<username>/Desktop/<folder_created_by_user>/hamcrest-core-1.3.jar
/Users/<username>/Desktop/<folder_created_by_user>/junit-4.12.jar
/Users/<username>/Desktop/<folder_created_by_user>/README.md
/Users/<username>/Desktop/<folder_created_by_user>/SecureworksCodingChallenge.java
/Users/<username>/Desktop/<folder_created_by_user>/SecureworkCodingChallengeTest.java
/Users/<username>/Desktop/<folder_created_by_user>/secureworkstestfile.txt

=====================================================

5) HOW TO RUN AND COMPILE JAVA CLASS AND TEST CLASS

Note: Make sure that before running any of these commands you are located in the terminal inside the folder where all the files from Step 4 were stored.

In order to compile and run the test cases for this application please follow these steps:
1) Compile your Java class by running this command: 

	javac SecureworksCodingChallenge.java 

2) Run the Java application to provide the result by running this command:

	java SecureworksCodingChallenge
	
3) Once the application has been verified that it's providing the correct result, compile the JUnit classs by running this command:
	
	MacOS/Linux:
	
	javac -cp junit-4.12.jar:. *.java
	
	Windows:
	
	javac -cp junit-4.12.jar;. *.java
	
4) Run the JUnit tests by running this command:
	
	MacOS/Linux:
	
	java -cp junit-4.12.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore SecureworksCodingChallengeTest
	
	Windows:
	
	java -cp junit-4.12.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore SecureworksCodingChallengeTest
	
NOTE: For simplicity purposes, I did not use any tool or framework other than those that were essential to create and run the test cases. Unfortunately, for this reason we cannot create Test Reports as we usually do when we have a complete environment setup correctly. In prior experiences, I've generated JUnit style XML reports for Jenkins. If you wish to see the output of these test cases in a regular file, please pipe it to a text file as it is usually done through the terminal by running this command:

	MacOS/Linux:
	
	java -cp junit-4.12.jar:hamcrest-core1.3.jar:. org.junit.runner.JUnitCore SecureworkCodingChallengeTest > testReport.txt
	
	Windows:
	java -cp junit-4.12.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore SecureworksCodingChallengeTest > testReport.txt

=====================================================
	
6) ASSUMPTIONS IN GENERAL
- User has placed the Java class and the JUnit Test class inside the same folder created by the user.
- JUnit and Hamcrest jar files are inside the same folder as the Java classes created by the user.
- Text File exists inside the same folder as the Java classes and the Jar files created by the user.

=====================================================

7) ASSUMPTIONS ABOUT CODING CHALLENGE
- Text file will be called secureworkstestfile.txt
- There is one specific test case that checks the size of the file. Since the requirements do not specify the size, the assumption is that the file is no bigger than 1 gigabyte.
- There is one specific test case that checks the extension of the file. Since the requirements do not specify the file extension, the assumption is that the file will be simple text file. 
- In Java, a single String can contain more than one word, for this specific exercise, we are assuming that a String will be a single word with no spaces.
- The application will return ONLY ONE word even if there are more than one word with the same length. The assumption is that the application will satisfy the requirement as long as it return one of those words with the the biggest length.

	
