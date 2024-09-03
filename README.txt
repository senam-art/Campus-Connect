README - CampusConnect Application

Introduction:

CampusConnect is a Java-based application designed to enhance university student life by facilitating connections among students for hostel selection, academic decision-making, and evaluating educational staff. This guide provides instructions on how to compile and run the application from the command line.
Utilizes Javafx

Prerequisites:

1. Java Development Kit (JDK) - You need JDK 11 or higher installed on your machine. You can download it from https://www.oracle.com/java/technologies/javase-jdk11-downloads.html

2. Ensure Java's `bin` directory is added to your system's PATH environment variable.

Installation:

1. Download and extract the CampusConnect.zip file into a directory on your computer.


After extraction, your directory should include the following files:
- `src/` - Contains all Java source files (.java).
- `lib/` - Contains all required libraries (.jar files) if any.
- `data/` - Directory for data files used by the application.

Compiling the Application:

1. Open a command prompt or terminal window.

2. Navigate to the directory where you extracted the files. For example: cd path/to/CampusConnect

3.Change to the source directory: cd src
4.Compile the Java files. If they are in the same directory, use: javac *.java

If they are in different directories, use: javac -cp .;../lib/* path/to/your/java/files/*.java

Replace ";" with ":" on Linux/Mac

Running the Application
1. After compilation, remain in the `src` directory or navigate to the root of the compiled Java files.
2. Run the main class using the `java` command.Specify the full package name: java com.campusconnect.Main


3. Follow any on-screen prompts to interact with the application.

Troubleshooting:
- Ensure all Java files are compiled without errors.
- Check that all external libraries (if any) are included in the classpath.
- Make sure JDK is correctly installed and configured.




