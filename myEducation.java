// Imports
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

/**
 * PROGRAM TITLE: North Vancouver School District My Education BC
 *
 * PROGRAM ELEMENT LIST: functions, methods, Student object, if statements,  try catch, case switch, int, double, Strings
 * 
 * PROGRAM DESCRIPTION: This program is a program for teacher for them to manage their classrooms and students.
 */
public class myEducation
{
    
    /**
     * Constructor for objects of class myEducation
     */
    public myEducation()
    {
        
        // None
        
    } // End of constructor
    
    
    
    /**
     * Function Summary: This function pauses the program for a specific amount of time
     * 
     * Parameters: time - time is an int parameter. This is the number of seconds that the program is going to pause for.
     * 
     * Return: void function (no return)
     */
    public static void pauseProgram(int time) {
        
        try { // Pause program
            Thread.sleep(time * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } // End of try catch
        
    } // End of pauseProgram
    
    
    
    /**
     * Function Summary: This function clears the console
     * 
     * Parameters: no parameters
     * 
     * Return: void function (no return)
     */
    public static void clearConsole() {
      
        System.out.print("\f\n\n"); // Clears console and prints 2 blank lines

    } // End of clearConsole
    
    
    
    /**
     * Function Summary: This is the welcome function. It welcomes the user.
     * 
     * Parameters: No parameters
     * 
     * Return: No return
     */
    public static char welcome() {
        
        // Variables
        char userChoice;
        Scanner myScanner = new Scanner(System.in); // Scanner declaration
        
        clearConsole();
        System.out.println("  _   _            _   _      __     __                                           ____       _                 _   ____  _     _        _      _   ");
        System.out.println(" | \\ | | ___  _ __| |_| |__   \\ \\   / /_ _ _ __   ___ ___  _   ___   _____ _ __  / ___|  ___| |__   ___   ___ | | |  _ \\(_)___| |_ _ __(_) ___| |_ ");
        System.out.println(" |  \\| |/ _ \\| '__| __| '_ \\   \\ \\ / / _` | '_ \\ / __/ _ \\| | | \\ \\ / / _ \\ '__| \\___ \\ / __| '_ \\ / _ \\ / _ \\| | | | | | / __| __| '__| |/ __| __|"); // Logo
        System.out.println(" | |\\  | (_) | |  | |_| | | |   \\ V / (_| | | | | (_| (_) | |_| |\\ V /  __/ |     ___) | (__| | | | (_) | (_) | | | |_| | \\__ \\ |_| |  | | (__| |_ ");
        System.out.println(" |_| \\_|\\___/|_|   \\__|_| |_|    \\_/ \\__,_|_| |_|\\___\\___/ \\__,_| \\_/ \\___|_|    |____/ \\___|_| |_|\\___/ \\___/|_| |____/|_|___/\\__|_|  |_|\\___|\\__|");
        System.out.println("");
        
        System.out.println("\nThis is a great program for managing your classrooms and students' grades."); // Introduction
        System.out.println("You will be able to add and remove students, as well as changing their grades and even calculating the class average.");
        
        System.out.print("\nPress ENTER to continue.");
        myScanner.nextLine();
        
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nYou are in the title screen. Please login here.");
        System.out.println("If you don't have an account yet, Please register."); // Instructions
        System.out.println("\nType in E if you want to exit the program");
        System.out.print("\nPress (L) to login, or (R) to register: ");
        userChoice = getValidChar('L', 'R', 'E'); // Getting valid user input
        
        return userChoice; // return statement
        
    } // End of function welcome
    
    
    
    /**
     * Function Summary: This function allows the user to log in.
     * 
     * Parameters: No parameters
     * 
     * Return: No return
     */
    public static String logIn(ArrayList usernames, ArrayList passwords) {
        
        // Variables
        String username;
        String password;
        int index;
        Scanner myScanner = new Scanner(System.in);
        
        // Main
        clearConsole();
        System.out.println("  _                _       ");
        System.out.println(" | |    ___   __ _(_)_ __  ");
        System.out.println(" | |   / _ \\ / _` | | '_ \\ ");
        System.out.println(" | |__| (_) | (_| | | | | |"); // Logo
        System.out.println(" |_____\\___/ \\__, |_|_| |_|");
        System.out.println("             |___/         ");
        System.out.println("\nPlease enter in your username and password below. If you want to go back to the main screen, type in BACK."); // Instructions
        System.out.println("\n-------------------------------------------------");
        
        System.out.print("\nUsername: ");
        while (true) { // Getting valid input
            
            username = myScanner.nextLine();
            if (username.equals("back") || username.equals("BACK")) { // if the user pressed back
                System.out.println("\nGoing back to main screen...");
                pauseProgram(2); // pauses program for 2 seconds
                return "";
            }
            if (usernames.contains(username)) { // if username exists
                index = usernames.indexOf(username);
                break;
            } else { // if username does not exist
                System.out.println("This username does not exist. Please enter in a valid username.");
                System.out.print("\nUsername: ");
            } // End of if else
            
        } // End of while
        
        System.out.println("\nNow, please enter in the password for this username.");
        System.out.println("\n----------------------------------------------------");
        
        System.out.print("\nPassword: ");
        for (int i = 1; i <= 3; i++) { // repeats 3 times
            
            password = myScanner.nextLine();
            if (password.equals(passwords.get(index))) { // if password is correct
                System.out.println("\nLogin successful!");
                System.out.println("You will be directed to your profile page in 3 seconds.");
                pauseProgram(3);
                break;
            } else { // if password is not correct
                System.out.println("Wrong password!");
                if (i == 3) {
                    System.out.println("You got the password wrong 3 times! You will be directed back to the main screen in 3 seconds."); // warning message
                    pauseProgram(3);
                    return "";
                } else {
                    System.out.println("You have gotten the password wrong " + i + " times.");
                    System.out.println("Please try again.");
                    System.out.print("\nPassword: ");
                } // End of if, else
            } // End of if, else
            
        } // End of while
        
        return username; // return statement
        
    } // End of function logIn
    
    
    
    /**
     * Function Summary: This function allows the user to register an account
     * 
     * Parameters: No parameters
     * 
     * Return: No return
     */
    public static boolean register(ArrayList usernames, ArrayList passwords) {
        
        // Variables
        Scanner myScanner = new Scanner(System.in);
        String username;
        String password;
        
        
        
        clearConsole();
        System.out.println("  ____            _     _            ");
        System.out.println(" |  _ \\ ___  __ _(_)___| |_ ___ _ __ ");
        System.out.println(" | |_) / _ \\/ _` | / __| __/ _ \\ '__|");
        System.out.println(" |  _ <  __/ (_| | \\__ \\ ||  __/ |   "); // Logo
        System.out.println(" |_| \\_\\___|\\__, |_|___/\\__\\___|_|   ");
        System.out.println("            |___/                    ");
        System.out.println("\nTo register, please fill in the personal information below. If you want to go back to the main scree, type in BACK."); // Instructions
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
        
        
        
        System.out.print("\nCreate Username: ");
        while (true) { // Getting valid user input
            
            username = myScanner.nextLine();
            if (username.equals("back") || username.equals("BACK")) { // if the user pressed back
                System.out.println("\nGoing back to main screen...");
                pauseProgram(3); // pause program for 3 seconds
                return false;
            } else {
                
                if (usernames.contains(username)) { // if username already exists
                    System.out.println("\nThis username already exists! Please type in another username."); // error message
                    System.out.print("\nCreate Username: ");
                } else { // if username does not exist yet
                    System.out.print("\nThis username is valid. Are you happy with this username? (Y/N): ");
                    if (getValidChar('Y', 'N') == 'Y') { // if user clicked yes
                        System.out.println("\nOk, now create a password.");
                    } else { // if user clicked no
                        System.out.println("\nOk, please choose another username.");
                        System.out.print("\nCreate Username: ");
                        continue;
                    } // end of if else
                    break;
                } // End of if, else
                
            } // End of if, else
            
        } // End of while
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------");        
        
        
        
        System.out.print("\nCreate Password: ");
        while (true) { // getting password
            
            password = myScanner.nextLine();
            System.out.print("\nYour chosen password is: " + password + ". Are you happy with this password? (Y/N): ");
            if (getValidChar('Y', 'N') == 'Y') { // if user clicks yes
                usernames.add(username);
                passwords.add(password);
                System.out.println("\nYour account has been successfully created! You will be returned to the main screen, where you can log in.");
                pauseProgram(3);
                break;
            } else { // if they clicked no
                System.out.println("\nOk, Please enter in a different password.");
                System.out.print("\nCreate Password: ");
            } // End of if, else
            
        } // End of while
        
        return true;
        
    } // End of class register
    
    
    
    /**
     * Function Summary: This function asks the user if they want to restart or not.
     *
     * Parameters: char validChars - this is basically an array, so there can be any number of parameters. This is the chars that are allowed.
     *
     * Return: returnValue - this is a char variable that is either the value of a or b.
     */
    public static char getValidChar(char... validChars) {
    
        // Variables
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char i : validChars) {
            chars.add(i);
        } // end of for each
        char returnValue;
        Scanner myScanner = new Scanner(System.in);
        
        while (true) { // repeats until the user enters in a valid input
          
            try {
            
                returnValue = myScanner.next().charAt(0);
                returnValue = Character.toUpperCase(returnValue); // converts to uppercase
                if (chars.contains(returnValue)) { // if user's command is valid
                  
                    return returnValue; // return value

                } else { // if user's command is not valid
                  
                    System.out.print("\nThat is not a valid command! Please select one of "); // error message
                    chars.forEach((i) -> System.out.print("(" + i + ") ")); // for each
                    System.out.print(": ");

                } // end of if, else
            
            } catch (Exception e) { // if there is an error
            
                System.out.print("\nThat is not a valid command! Please select one of "); // error message
                chars.forEach((i) -> System.out.print("(" + i + ") "));
                System.out.print(": ");
            
            } // end of try catch
          
        } // end of while
        
    } // end of function restart
    
    
    
    /**
     * Function Summary: This function takes the user to the profile screen.
     * 
     * Parameters: ArrayList<String> classrooms - This arraylist is a list of all the classrooms.
     *             ArrayList<ArrayList<Student>> students - This arraylist is a 2d list of all the students.
     * 
     * Return: returns true if the user logged out, returns false otherwise
     */
    public static boolean profile(ArrayList<String> classrooms, ArrayList<ArrayList<Student>> students) {
        
        // Variables
        Scanner myScanner = new Scanner(System.in);
        char userCommand;
        int classChoice;
        String classroomName;
        
        clearConsole();
        System.out.println("  ____             __ _ _      ");
        System.out.println(" |  _ \\ _ __ ___  / _(_) | ___ ");
        System.out.println(" | |_) | '__/ _ \\| |_| | |/ _ \\"); // logo
        System.out.println(" |  __/| | | (_) |  _| | |  __/");
        System.out.println(" |_|   |_|  \\___/|_| |_|_|\\___|");
        System.out.println("                               ");
        
        System.out.println("\nThis is the profile page. Here you will be able to add a classroom, and add students to that classroom."); // instructions and description
        System.out.println("You will also be able to put in the marks of your students. You will be able to calculate the average class score.");
        System.out.println("\n------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("         OPTIONS         ");
        System.out.println("-------------------------");
        System.out.println("|  C: Create New Class  |");
        System.out.println("|  R: Remove Class      |"); // optins box
        System.out.println("|  E: Enter Class       |");
        System.out.println("|  L: Log Out           |");
        System.out.println("-------------------------");
        
        
        
        System.out.println("\n\n           Your Classrooms           "); // lists the user's classrooms
        System.out.println("-------------------------------------\n");
        for (int i = 1; i <= classrooms.size(); i++) { // for every class in classrooms
            System.out.println(i + ": " + classrooms.get(i-1)); // prints out student
        } // End of for loop
        if (classrooms.size() == 0) { // if there are no students
            System.out.println("You currently don't have any classes.");
        } // End of if
        System.out.println("\n-------------------------------------");
        
        System.out.print("\n\nYour option: ");
        userCommand = getValidChar('C', 'E', 'R', 'L'); // gets valid input
        if (userCommand == 'C') {
            if (classrooms.size() == 8) { // if user has 8 classes
                System.out.println("\nThe maximum number of classes you can have is 8, but you already have 8 classes!"); // error message
                System.out.println("Please remove a class if you wish to create one.");
                pauseProgram(3);
                return false;
            } // End of if
            System.out.print("\nPlease enter in the name of your class: ");
            classroomName = myScanner.nextLine();
            classrooms.add(classroomName); // adding classroom
            students.add(new ArrayList<Student>());
            System.out.println("\nSuccessfully added class!"); // success message
            pauseProgram(3);
        } else if (userCommand == 'E') {
            if (classrooms.size() == 0) { // if user doesn't have any classes
                System.out.println("\nYou don't have any classes!");
                pauseProgram(3); // pause program for 3 seconds
                return false;
            } // end of if
            System.out.println("\nWhich class do you want to enter?");
            System.out.print("Enter the number of the class you want to enter: ");
            classChoice = getValidInt(1, classrooms.size()); // gets valid input
            System.out.println("\nYou chose to enter: " + classrooms.get(classChoice-1));
            pauseProgram(3);
            while (true) {
                if (enterClass(classChoice-1, students, classrooms.get(classChoice-1))) { // entering class
                    return false;
                } // end of if
            } // end of while
        } else if (userCommand == 'R') {
            if (classrooms.size() == 0) { // if user doesn't have any classes
                System.out.println("\nYou don't have any classes, so you cannot remove any!");
                pauseProgram(3); // pause program for 3 seconds
                return false;
            }
            System.out.println("\nWhich class do you want to remove?");
            System.out.print("Enter the number of the class you want to remove: ");
            classChoice = getValidInt(1, classrooms.size());
            System.out.println("You chose to remove: " + classrooms.get(classChoice-1));
            pauseProgram(3);
            classrooms.remove(classChoice-1); // remove class and students for the class
            students.remove(classChoice-1);
        } else if (userCommand == 'L') {
            
            System.out.print("\nAre you sure you want to log out? (Y/N): "); // confirm message
            if (getValidChar('Y', 'N') == 'Y') {
                System.out.println("\nLogging out...");
                pauseProgram(3);
                return true; // log out
            } // End of if
            System.out.println("Cancelled logout...");
            pauseProgram(3); // pause program for 3 seconds
            return false;
            
        } // End of if, else if
        
        return false;
        
    } // End of function currentUser
    
    
    
    /**
     * Function Summary: This function gets a valid input for ints
     * 
     * Parameters: int low - the lowest possible int
     *             int high - the highest possible int
     * 
     * Return: returns the integer that the user inputted
     */
    public static int getValidInt(int low, int high) {
        
        // Variables
        int returnValue;
        Scanner myScanner = new Scanner(System.in);
        
        while (true) { // repeats until user enters in a valid int
            if (!myScanner.hasNextInt()) {
            
                System.out.print("\nThat is not an integer, please enter in an integer from " + low + " to " + high + ": ");
                myScanner.next();
            
            } else {
                
                returnValue = myScanner.nextInt();
                if ((returnValue >= low) && (returnValue <= high)) {
                    return returnValue;
                } else {
                    System.out.print("\nPlease enter in an integer from " + low + " to " + high + ": ");
                } // End of if else
                
            } // End of if else
        } // End of while
                
    } // End of getValidInt
    
    
    
    /**
     * Function Summary: This function enters the class that the user chose
     * 
     * Parameters: int classIndex - the index of the class that the user chose
     *             ArrayList<ArrayList<Students>> students - the arraylist with all the students
     *             String className - the name of the classroom
     * 
     * Return: returns true if user exited the class, returns false otherwise
     */
    public static boolean enterClass(int classIndex, ArrayList<ArrayList<Student>> students, String className) {
        
        // Variables
        DecimalFormat df = new DecimalFormat("0.00");
        ArrayList<Student> currentClass = students.get(classIndex);
        char userCommand;
        boolean finished = false;
        Scanner myScanner = new Scanner(System.in);
        String name = "";
        int age;
        int grade;
        int studentIndex;
        int sumGrades;
        double average;
        
        printClassroomAndStudents(currentClass, className);
        
        System.out.println("             OPTIONS             ");
        System.out.println("---------------------------------");
        System.out.println("|  A: Add New Student           |");
        System.out.println("|  R: Remove Student            |");
        System.out.println("|  U: Update Student Grade      |"); // options box
        System.out.println("|  C: Calculate Class Average   |");
        System.out.println("|  E: Exit Classroom            |");
        System.out.println("---------------------------------");
        
        
        
        System.out.print("\n\nYour option: ");
        userCommand = getValidChar('A', 'R', 'U', 'E', 'C'); // gets valid char input
        if (userCommand == 'A') {
            
            System.out.println("\nYou chose to add a student...");
            pauseProgram(2);
            printClassroomAndStudents(currentClass, className);
            System.out.print("\nWhat is your student's name?: ");
            name += myScanner.nextLine();
            pauseProgram(2);
            printClassroomAndStudents(currentClass, className);
            System.out.println("Your Student: " + name);
            System.out.print("\nWhat is your student's age? Their age should be between 13 and 18, inclusive: ");
            age = getValidInt(13, 18);
            pauseProgram(2);
            printClassroomAndStudents(currentClass, className);
            System.out.println("Your Student: " + name + ", " + age);
            System.out.print("\nWhat is your student's grade? If they don't have a grade yet, please input 0: ");
            grade = getValidInt(0, 100);
            pauseProgram(2);
            printClassroomAndStudents(currentClass, className);
            System.out.println("Your Student: " + name + ", " + age + ", " + grade + "%");
            System.out.print("\nIs this information correct? (Y/N): ");
            userCommand = getValidChar('Y', 'N');
            if (userCommand == 'Y') {
                currentClass.add(new Student(name, age, grade)); // adds student
                System.out.println("\nSuccessfully added student to your class!");
                pauseProgram(3);
            } else {
                System.out.println("\nCancelled... Student was not added to class."); // cancel message
                pauseProgram(3);
            }
            
        } else if (userCommand == 'R') {
            
            System.out.println("\nYou chose to remove a student...");
            pauseProgram(2);
            printClassroomAndStudents(currentClass, className);
            System.out.print("\nEnter in the number of the student you want to remove: ");
            studentIndex = getValidInt(1, currentClass.size())-1;
            pauseProgram(2);
            printClassroomAndStudents(currentClass, className);
            System.out.print("\nYou want to remove " + currentClass.get(studentIndex).name + ", is this correct? (Y/N): ");
            userCommand = getValidChar('Y', 'N');
            pauseProgram(2);
            if (userCommand == 'Y') {
                currentClass.remove(studentIndex); // remvoes chosen student
                System.out.println("\nSuccessfully removed student!");
                pauseProgram(3);
            } else {
                System.out.println("\nCancelled... Student was not removed from the class.");
                pauseProgram(3);
            } // end of if else
            
        } else if (userCommand == 'U') {
            
            System.out.println("\nYou chose to update a grade...");
            pauseProgram(2);
            printClassroomAndStudents(currentClass, className);
            System.out.print("\nEnter the number of the student you want to change the grade for: ");
            studentIndex = (getValidInt(1, currentClass.size()) - 1);
            pauseProgram(2);
            printClassroomAndStudents(currentClass, className);
            System.out.println("\nYou are changing the grade for " + currentClass.get(studentIndex).name + ".");
            System.out.print("\nPlease enter in their new grade: ");
            grade = getValidInt(0, 100); // getting valid int
            currentClass.get(studentIndex).grade = grade; // updating mark
            System.out.println("\nSuccessfully updated mark!");
            pauseProgram(3);
            
        } else if (userCommand == 'C') {
            
            System.out.println("\nCalculating class average...");
            pauseProgram(2);
            printClassroomAndStudents(currentClass, className);
            
            sumGrades = 0;
            for (int i = 0; i < currentClass.size(); i++) { // for each student
                sumGrades += currentClass.get(i).grade; // adds each student's grade to sumGrades
            } // end of for
            average = (sumGrades / currentClass.size());
            average = Double.parseDouble(df.format(average)); // rounds to two decimal places
            
            System.out.println("Your classroom average is: " + average + "%"); // prints average
            System.out.println("\nPlease press ENTER to continue.");
            myScanner.nextLine();
            
        } else if (userCommand == 'E') {
            
            System.out.println("\nExiting classroom...");
            pauseProgram(3);
            finished = true; // exit classroom
            
        } // end of if, else if, else
        
        return finished;
        
    } // End of function enterClass
    
    
    
    /**
     * Function Summary: this function prints the classroom logo and the students
     * 
     * Parameters: ArrayList<Student> currentClass - this is an array with all the students inside
     *             String className - the name of the classroom
     * 
     * return: none
     */
    public static void printClassroomAndStudents(ArrayList<Student> currentClass, String className) {
                
        clearConsole();
        System.out.println("   ____ _                                         ");
        System.out.println("  / ___| | __ _ ___ ___ _ __ ___   ___  _ __ ___  ");
        System.out.println(" | |   | |/ _` / __/ __| '__/ _ \\ / _ \\| '_ ` _ \\ ");
        System.out.println(" | |___| | (_| \\__ \\__ \\ | | (_) | (_) | | | | | |"); // logo
        System.out.println("  \\____|_|\\__,_|___/___/_|  \\___/ \\___/|_| |_| |_|");
        System.out.println("                                                  ");
        
        System.out.println("\nClassroom name: " + className.toUpperCase());
        System.out.println("\n\n               STUDENTS               ");
        System.out.println("--------------------------------------\n");
        for (int i = 1; i <= currentClass.size(); i++) { // printing out all students
            System.out.println(i + ": " + currentClass.get(i-1).name + ", " + currentClass.get(i-1).age + ", " + currentClass.get(i-1).grade + "%");
        } // End of for loop
        if (currentClass.size() == 0) { // if there are no students
            System.out.println("You currently don't have any students.");
        } // End of if
        System.out.println("\n--------------------------------------\n");
        
    } // End of printClassroomsAndStudents
    
    
    
    /**
     * This is the main method.
     */
    public static void main(String[] args) {
        
        // Variables
        String username;
        ArrayList usernames = new ArrayList<String>();
        ArrayList passwords = new ArrayList<String>();
        char logInRegister;
        ArrayList<ArrayList<ArrayList<Student>>> students = new ArrayList<ArrayList<ArrayList<Student>>>();
        ArrayList<ArrayList<String>> classrooms = new ArrayList<ArrayList<String>>();
        int currentUserIndex;
        ArrayList<String> currentUserClassrooms;
        ArrayList<ArrayList<Student>> currentUserStudents;
        
        
        
        // UI
        while (true) { // loops the whole program
            
            while (true) { // login and register process
                
                logInRegister = welcome(); // welcomes the user
                if (logInRegister == 'L') { // login
                    
                    System.out.println("\nYou selected LOG IN!");
                    pauseProgram(2);
                    username = logIn(usernames, passwords);
                    if (username == "") {
                        continue;
                    } else {
                        currentUserIndex = usernames.indexOf(username); // index of the chosen username
                        currentUserClassrooms = classrooms.get(currentUserIndex); // classes of the current user
                        currentUserStudents = students.get(currentUserIndex); // students of the current user
                        break;
                    } // End of if else
                    
                } else if (logInRegister == 'R') { // register
                    
                    System.out.println("\nYou selected REGISTER!");
                    pauseProgram(2);
                    if (register(usernames, passwords)) {
                        students.add(new ArrayList<ArrayList<Student>>());
                        classrooms.add(new ArrayList<String>());
                    } else {
                        continue;
                    } // if else
                    
                } else if (logInRegister == 'E') { // exit program
                    
                    System.out.print("\nAre you sure you want to quit the program? (Y/N): ");
                    if (getValidChar('Y', 'N') == 'Y') { // if user clicks yes
                        pauseProgram(2);
                        clearConsole();
                        System.out.println("\nThank you for using North Vancouver School District MyEd BC."); // thank you message
                        System.out.println("If you are having trouble using the program, or have any questions, please feel free to contact us using one of the options below.");
                        System.out.println("\nPhone: 604-123-4567");
                        System.out.println("Email: sd44@sd44.ca");
                        System.out.println("\nHope to see you soon.");
                        System.exit(0);
                    } else { // user clicks no
                        System.out.println("Cancelled...");
                        pauseProgram(2);
                        continue;
                    } // End of if else
                    
                } // End of if, else if
                
            } // End of while
            
            while (true) {
                
                if (profile(currentUserClassrooms, currentUserStudents)) { // goes to  profile
                    break;
                } // End of if
                
            } // End of while
            
        } // End of while
        
        
        
        
    } // End of main method
    
} // End of class





/*
 * NOTES: 
 * none
 * 
 * TEST CODE: 
 * System.out.println(students);
 * System.out.println(classrooms);
 */




