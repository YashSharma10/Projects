package Project;
import java.util.*;

public class Student_tracker {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> physicsMarks = new ArrayList<>();
        ArrayList<Integer> chemistryMarks = new ArrayList<>();
        ArrayList<Integer> mathsMarks = new ArrayList<>();
        ArrayList<Integer> englishMarks = new ArrayList<>();
        ArrayList<Integer> csMarks = new ArrayList<>();
        ArrayList<Double> attendance = new ArrayList<>();
        ArrayList<String> extracurricularActivities = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║    WELCOME TO STUDENT ACADEMIC PERFORMANCE ANALYSIS SYSTEM     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        while (true) {
        	System.out.println("Student Academic Performance Analysis System Menu:\n");
            System.out.println("1. \u001B[36mAdd Student Data\u001B[0m");
            System.out.println("   - Add information about a new student, including marks in different subjects.");
            System.out.println("2. \u001B[36mCheck Student Grade And Percentage\u001B[0m");
            System.out.println("   - View the grade and percentage of a specific student.");
            System.out.println("3. \u001B[36mMark Attendance\u001B[0m");
            System.out.println("   - Mark the attendance percentage for a specific student.");
            System.out.println("4. \u001B[36mAdd Extracurricular Activity\u001B[0m");
            System.out.println("   - Add details about extracurricular activities for a student.");
            System.out.println("5. \u001B[36mDisplay Students Table\u001B[0m");
            System.out.println("   - View a table containing details of all students.");
            System.out.println("6. \u001B[36mDisplay Class Statistics\u001B[0m");
            System.out.println("   - View statistics for the entire class, including highest and lowest percentages.");
            System.out.println("7. \u001B[36mExit\u001B[0m");
            System.out.println("   - Exit the Student Academic Performance Analysis System.\n");
            System.out.print("Enter your choice: ");


            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter an integer menu choice.\u001B[0m");
                scanner.next();
                continue;
            }

            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudentAndMarks(studentNames, physicsMarks, chemistryMarks, mathsMarks, englishMarks, csMarks, attendance, extracurricularActivities, scanner);
                    break;
                case 2:
                    checkStudentGrade(studentNames, physicsMarks, chemistryMarks, mathsMarks, englishMarks, csMarks, scanner);
                    break;
                case 3:
                    markAttendance(attendance, studentNames, scanner);
                    break;
                case 4:
                    addActivity(extracurricularActivities, studentNames, scanner);
                    break;
                case 5:
                    displayStudentTable(studentNames, physicsMarks, chemistryMarks, mathsMarks, englishMarks, csMarks, attendance, extracurricularActivities);
                    break;
                case 6:
                    calculateAndDisplayClassStatistics(studentNames, physicsMarks, chemistryMarks, mathsMarks, englishMarks, csMarks, attendance);
                    break;
                case 7:
                    System.out.println("\u001B[34mThanks for using....\nExiting Student Academic Performance Analysis System.\u001B[0m");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("\u001B[31mInvalid choice. Please enter a valid menu option.\u001B[0m");
                    pressEnterToContinue();
            }
        }
    }
    
    public static void addStudentAndMarks(ArrayList<String> studentNames, ArrayList<Integer> physicsMarks, ArrayList<Integer> chemistryMarks, ArrayList<Integer> mathsMarks, ArrayList<Integer> englishMarks, ArrayList<Integer> csMarks, ArrayList<Double> attendance, ArrayList<String> extracurricularActivities, Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        if (studentName.isEmpty() || !studentName.matches("^[a-zA-Z]+$")) {
            System.out.println("Invalid input for student name. Please enter a valid string.");
            pressEnterToContinue();
            return;
        }

        if (studentNames.contains(studentName)) {
            System.out.println("Error: Student with the same name already exists. Please enter a different name.");
            pressEnterToContinue();
            return;
        }

        int totalMarks = 0;

        for (String subject : Arrays.asList("Physics", "Chemistry", "Maths", "English", "Computer Science")) {
            System.out.print("Enter " + subject + " marks (OUT OF 100): ");
            int marks;

            if (scanner.hasNextInt()) {
                marks = scanner.nextInt();

                if (marks > 100) {
                    System.out.println("Error: " + subject + " marks cannot exceed 100.");
                    pressEnterToContinue();
                    return;
                }
            } else {
                System.out.println("Invalid input for " + subject + " marks. Please enter a valid integer.");
                pressEnterToContinue();
                return;
            }
            totalMarks += marks;
            if (subject.equals("Physics")) {
                physicsMarks.add(marks);
            } else if (subject.equals("Chemistry")) {
                chemistryMarks.add(marks);
            } else if (subject.equals("Maths")) {
                mathsMarks.add(marks);
            } else if (subject.equals("English")) {
                englishMarks.add(marks);
            } else if (subject.equals("Computer Science")) {
                csMarks.add(marks);
            }
        }

        double percentage = (double) totalMarks / 500 * 100;
        studentNames.add(studentName);
        attendance.add(0.0);

        // Initialize extracurricularActivities ArrayList for each student
        extracurricularActivities.add("None"); 

        System.out.println("\nStudent data added successfully.");
        pressEnterToContinue();
    }



    public static String getGradeFromMarks(double percentage) {
        if (percentage >= 95) {
            return "A+";
        } else if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void markAttendance(ArrayList<Double> attendance, ArrayList<String> studentNames, Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter attendance percentage: ");
        double attendancePercentage;

        if (scanner.hasNextDouble()) {
            attendancePercentage = scanner.nextDouble();

            if (attendancePercentage < 0 || attendancePercentage > 100) {
                System.out.println("Invalid input for attendance percentage. Please enter a valid percentage.");
                pressEnterToContinue();
                return;
            }
        } else {
            System.out.println("Invalid input for attendance percentage. Please enter a valid percentage.");
            pressEnterToContinue();
            return;
        }

        int studentIndex = studentNames.indexOf(studentName);
        if (studentIndex != -1) {
            attendance.set(studentIndex, attendancePercentage);
            System.out.println("Attendance marked successfully.");
            pressEnterToContinue();
        } else {
            System.out.println("Student not found. Attendance not marked.");
            pressEnterToContinue();
        }
    }
    



    public static void displayStudentTable(
        ArrayList<String> studentNames,
        ArrayList<Integer> physicsMarks,
        ArrayList<Integer> chemistryMarks,
        ArrayList<Integer> mathsMarks,
        ArrayList<Integer> englishMarks,
        ArrayList<Integer> csMarks,
        ArrayList<Double> attendance,
        ArrayList<String> extracurricularActivities
    ) {
        if (studentNames.isEmpty()) {
            System.out.println("No student records available to display.");
            pressEnterToContinue();
            return;
        }

        System.out.println("Student Records:");
        System.out.printf("%-20s%-10s%-10s%-10s%-10s%-10s%-15s%-15s%-40s%n", "Name", "Physics", "Chemistry", "Maths", "English", "CS", "Percentage", "Attendance", "Extracurricular Activities");

        for (int i = 0; i < studentNames.size(); i++) {
            String name = studentNames.get(i);
            int physics = physicsMarks.get(i);
            int chemistry = chemistryMarks.get(i);
            int maths = mathsMarks.get(i);
            int english = englishMarks.get(i);
            int cs = csMarks.get(i);
            double studentAttendance = attendance.get(i);

            int totalMarks = physics + chemistry + maths + english + cs;
            double percentage = (double) totalMarks / 500 * 100;

            String grade = getGradeFromMarks(percentage);
            String activities = i < extracurricularActivities.size() ? extracurricularActivities.get(i) : "None";

            System.out.printf("%-20s%-10d%-10d%-10d%-10d%-10d%-15.2f%-15.2f%-40s%n", name, physics, chemistry, maths, english, cs, percentage, studentAttendance, activities);
        }

        pressEnterToContinue();
    }
    
    public static void calculateAndDisplayClassStatistics(
    	    ArrayList<String> studentNames,
    	    ArrayList<Integer> physicsMarks,
    	    ArrayList<Integer> chemistryMarks,
    	    ArrayList<Integer> mathsMarks,
    	    ArrayList<Integer> englishMarks,
    	    ArrayList<Integer> csMarks,
    	    ArrayList<Double> attendance
    	) {
    	    if (studentNames.isEmpty()) {
    	        System.out.println("No student records available to calculate statistics.");
    	        pressEnterToContinue();
    	        return;
    	    }

    	    double highestPercentage = 0.0;
    	    double lowestPercentage = 100.0;
    	    List<String> studentsWithHighestPercentage = new ArrayList<>();
    	    List<String> studentsWithLowestPercentage = new ArrayList<>();

    	    System.out.println("Class Statistics:");
    	    System.out.printf("%-20s%-15s%n", "Name", "Percentage");

    	    for (int i = 0; i < studentNames.size(); i++) {
    	        int physics = physicsMarks.get(i);
    	        int chemistry = chemistryMarks.get(i);
    	        int maths = mathsMarks.get(i);
    	        int english = englishMarks.get(i);
    	        int cs = csMarks.get(i);

    	        int totalMarks = physics + chemistry + maths + english + cs;
    	        double percentage = (double) totalMarks / 500 * 100;

    	        if (percentage > highestPercentage) {
    	            highestPercentage = percentage;
    	            studentsWithHighestPercentage.clear();
    	            studentsWithHighestPercentage.add(studentNames.get(i));
    	        } else if (percentage == highestPercentage) {
    	            studentsWithHighestPercentage.add(studentNames.get(i));
    	        }

    	        if (percentage < lowestPercentage) {
    	            lowestPercentage = percentage;
    	            studentsWithLowestPercentage.clear();
    	            studentsWithLowestPercentage.add(studentNames.get(i));
    	        } else if (percentage == lowestPercentage) {
    	            studentsWithLowestPercentage.add(studentNames.get(i));
    	        }

    	        System.out.printf("%-20s%-15.2f%n", studentNames.get(i), percentage);
    	    }

    	    System.out.println("Highest Percentage: " + highestPercentage + "% (Secured by: " + String.join(", ", studentsWithHighestPercentage) + ")");
    	    System.out.println("Lowest Percentage: " + lowestPercentage + "% (Secured by: " + String.join(", ", studentsWithLowestPercentage) + ")");
    	    pressEnterToContinue();
    	}


    public static void addActivity(ArrayList<String> extracurricularActivities, ArrayList<String> studentNames, Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter extracurricular activity: ");
        String activity = scanner.nextLine();

        int studentIndex = studentNames.indexOf(studentName);
        if (studentIndex != -1) {
            extracurricularActivities.set(studentIndex, activity);
            System.out.println("Extracurricular activity added successfully.");
        } else {
            System.out.println("Student not found. Extracurricular activity not added.");
        }

        pressEnterToContinue();
    }

    public static void checkStudentGrade(
        ArrayList<String> studentNames,
        ArrayList<Integer> physicsMarks,
        ArrayList<Integer> chemistryMarks,
        ArrayList<Integer> mathsMarks,
        ArrayList<Integer> englishMarks,
        ArrayList<Integer> csMarks,
        Scanner scanner
    ) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        int studentIndex = studentNames.indexOf(studentName);

        if (studentIndex != -1) {
            int physics = physicsMarks.get(studentIndex);
            int chemistry = chemistryMarks.get(studentIndex);
            int maths = mathsMarks.get(studentIndex);
            int english = englishMarks.get(studentIndex);
            int cs = csMarks.get(studentIndex);

            
            int totalMarks = physics + chemistry + maths + english + cs;
            double percentage = (double) totalMarks / 500 * 100;
            String grade = getGradeFromMarks(percentage);

            System.out.println("Student: " + studentName);
            System.out.println("Percentage: " + percentage + "%");
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Student not found. Cannot check grade.");
        }

        pressEnterToContinue();
    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}