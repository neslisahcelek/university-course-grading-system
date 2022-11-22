/*author: Neslisah Celek
 * date: 28.12.2020 */
import java.util.Scanner;
public class CourseGrade03 {
		public static void main(String[] args) {
	        String[] category = {"Quiz", "homework", "MidTerm exam", "FiNAL Exam"};
	        int[] quantity = {4, 3, 1, 1};
	        int[] weight = {10, 20, 30, 40};       
	            //checking quantity and weight values//
	        if (quantity[0] != 4 || quantity[1] != 3 || quantity[2] != 1 || 
	        		quantity[3] != 1) {
	        	System.out.println("ERROR: Invalid quantity entered.");
	        	System.exit(1);
	        }
	        
	        if (weight[0] != 10 || weight[1] != 20 || weight[2] != 30 || 
	        		weight[3] != 40){
	        	System.out.println("ERROR: Invalid weight entered.");
	        	System.exit(1);
	        }      
	        courseGrade(category, quantity, weight);
	    }

	    public static void courseGrade(String[] category, int[] quantity, int[] weight) {
	        double[] quiz = new double[4];
	        double[] homework = new double[3];
	        double[] midterm = new double[1];
	        double[] finalExam = new double[1];

	        Scanner input = new Scanner(System.in);
	        System.out.println("Welcome to our university grade system.");
	        String[] choicesList = {"Enter all grades", "Change a single grade",
	                "Display grade information"};

	        while (true) {   	
	            System.out.println("Please enter a choice below: ");
	            int choice = displayMenu(choicesList, input);
	            if (choice == 1) {
	            	int i;
	            	for (i = 1; i <= quantity[0]; i++) {
	                    System.out.println("Please enter grade for " + 
	                    capitalize1(category[0]) + " " + i + " >>");
	                    quiz[i - 1] = input.nextDouble();
	                }
	                for (i = 1; i <= quantity[1]; i++) {
	                    System.out.println("Please enter grade for " +
	                    capitalize1(category[1]) + " " + i + " >>");
	                    homework[i - 1] = input.nextDouble();
	                }
	                System.out.println("Please enter grade for " + 
	                capitalize1(category[2]) + " 1 >>");
	                midterm[0] = input.nextDouble();

	                System.out.println("Please enter grade for " + 
	                capitalize1(category[3]) + " 1 >>");
	                finalExam[0] = input.nextDouble();
	                System.out.println(" ");
	            } 
	            else if (choice == 2) {
	                System.out.println("Please enter the category");
	                capitalize(category);
	                System.out.println("0 - to Exit");
	                int choice2 = input.nextInt();
	                if (choice2 == 1) {
	                    System.out.println("Please enter which " + capitalize1(category[0])
	                            + " you would like to change (1 - " + quantity[0] + ") >> ");
	                    int change = input.nextInt();
	                    if (change <= quantity[0] && change >= 0) {
	                    System.out.println("The current grade of " + capitalize1(category[0]) +
	                    		" " + change + " is " + quiz[change - 1]);
	                    System.out.println("Please enter the new grade value >> ");
	                    quiz[change - 1] = input.nextInt();
	                    System.out.println(" ");
	                    }
	                    else {
	                    	System.out.println("Invalid choice.\n");
	                    }
	                } 
	                else if (choice2 == 2) {
	                    System.out.println("Please enter which " + capitalize1(category[1])
	                            + " you would like to change (1 - " + quantity[1] + ") >> ");
	                    int change = input.nextInt();
	                    if (change <= quantity[0] && change >= 0) {
	                    System.out.println("The current grade of " + capitalize1(category[1]) 
	                    +  " " + change + " is " + homework[change - 1]);
	                    System.out.println("Please enter the new grade value >> ");
	                    homework[change - 1] = input.nextInt();
	                    System.out.println(" ");
	                    }
	                    else {
	                    	System.out.println("Invalid choice.\n");
	                    }
	                } 
	                else if (choice2 == 3) {
	                    System.out.println("The current grade of " + capitalize1(category[2])
	                            + " is " + midterm[0]);
	                    System.out.println("Please enter the new grade value >> ");
	                    midterm[0] = input.nextInt();
	                    System.out.println(" ");

	                }
	                else if (choice2 == 4) {
	                    System.out.println("The current grade of " + capitalize1(category[3])
	                            + " is " + finalExam[0]);
	                    System.out.println("Please enter the new grade value >> ");
	                    finalExam[0] = input.nextInt();
	                    System.out.println(" ");

	                } 
	                else if (choice2 == 0) {
	                    System.out.println("Thank you for using our system. Have a nice day.");
	                    System.exit(1);
	                } 
	                else {
	                    System.out.println("Invalid choice.\n");
	                }
	            } 
	            else if (choice == 3) {

	                System.out.println("Category Information:");

	                System.out.println("Quiz - " + calculateQ(quiz));
	                System.out.println("Homework - " + calculateH(homework));
	                System.out.println("Midterm exam - " + calculateM(midterm));
	                System.out.println("Final exam - " + calculateF(finalExam) + "\n");

	                System.out.println("Overall grade - " + TS(calculateQ(quiz),
	                        calculateH(homework), calculateM(midterm), 
	                        calculateF(finalExam), weight));
	                System.out.println("Grade letter - " + gradeLetter(TS(calculateQ(quiz),
	                        calculateH(homework), calculateM(midterm), 
	                        calculateF(finalExam), weight)));
	                System.out.println("GPA Points - " + gpaPoints(TS(calculateQ(quiz),
	                        calculateH(homework), calculateM(midterm), 
	                        calculateF(finalExam), weight)));
	                System.out.println("Status - " + status(TS(calculateQ(quiz),
	                        calculateH(homework), calculateM(midterm), 
	                        calculateF(finalExam), weight)) + "\n");
	            } 
	            else if (choice == 0) {
	                System.out.println("Thank you for using our system. Have a nice day.");
	                break;
	            } 
	            else {
	                System.out.println("Invalid choice.\n");
	            }
	        }
	    }
	    
	    public static int displayMenu(String[] item, Scanner input) {
	        int choice;
	        capitalize(item);
	        System.out.println("0 - to Exit");
	        choice = input.nextInt();
	        return choice;
	    }
	    
	    public static void capitalize(String[] name) {
	        String a = "";
	        for (int i = 0; i < name.length; i++) {
	            name[i] = capitalize1(name[i]);
	            if (i == name.length - 1) {
	            	a += (i + 1) + " - " + name[i];
	                break;
	            }
	            a += (i + 1) + " - " + name[i] + "\n";
	        }
	        System.out.println(a);
	    }
	    
	    public static String capitalize1(String name1) {
	        name1 = name1.substring(0, 1).toUpperCase() + name1.substring(1).toLowerCase();
	        return name1;
	    }
	    
	    public static boolean validQuantity(int quantity) {
	        boolean q = true;

	        if (quantity < 0){
	            q = false;
	        } else {
	            q = true;
	        }
	        return q;
	    }
	    
	    public static boolean validWeight(int weight, int totalWeight) {
	        boolean w = true;
	        if (totalWeight != 100) {
	            w = false;
	            System.out.println("ERROR: The values sum to " + totalWeight +
	                    " but should sum to 100.");
	            System.exit(1);
	        } else
	            w = true;
	        return w;
	    }

	    public static String gradeLetter(double grade) {
	        if (grade >= 88) 
	            return "AA";
	        else if (grade >= 81)
	            return "BA";
	        else if (grade >= 74)
	            return "BB";
	        else if (grade >= 67)
	            return "CB";
	        else if (grade >= 60)
	            return "CC";
	        else if (grade >= 53)
	            return "DC";
	        else if (grade >= 46)
	            return "DD";
	        else if (grade >= 35)
	            return "FD";
	        else
	            return "FF";
	    }

	    public static double gpaPoints(double gpa) {
	        if (gpa >= 88) 
	            return 4.0;
	        else if (gpa >= 81)
	            return 3.50;
	        else if (gpa >= 74)
	            return 3.00;
	        else if (gpa >= 67)
	            return 2.50;
	        else if (gpa >= 60)
	            return 2.00;
	        else if (gpa >= 53)
	            return 1.50;
	        else if (gpa >= 46)
	            return 1.00;
	        else if (gpa >= 35)
	            return 0.50;
	        else
	            return 0.00;
	    }

	    public static String status(double status) {
	        if (status >= 88) 
	            return "passed!";
	        else if (status >= 81)
	            return "passed";
	        else if (status >= 74)
	            return "passed";
	        else if (status >= 67)
	            return "passed";
	        else if (status >= 60)
	            return "passed";
	        else if (status >= 53)
	            return "conditionally passed";
	        else if (status >= 46)
	            return "failed";
	        else if (status >= 35)
	            return "failed";
	        else
	            return "failed";
	    }

	    public static double calculateQ(double quiz[]) {
	        double sum1 = 0;
	        for (int i = 0; i <= 3; i++) {
	            sum1 += quiz[i];
	        }
	        double n1 = sum1 / 4.0;
	        return n1;
	    }

	    public static double calculateH(double homework[]) {
	        double sum2 = 0;
	        for (int i = 0; i <= 2; i++) {
	            sum2 += homework[i];
	        }
	        double n2 = sum2 / 3.0;
	        return n2;
	    }

	    public static double calculateM(double midterm[]) {
	        double sum3 = midterm[0];
	        return sum3;
	    }

	    public static double calculateF(double finalExam[]) {
	        double sum4 = finalExam[0];
	        return sum4;
	    }

	    public static double TS(double n1, double n2, double n3, double n4, int w[]) {
	        double TS = ((n1 * w[0]) + (n2 * w[1]) + (n3 * w[2]) +
	                (n4 * w[3])) / 100;
	        return TS;
	    }
	}



