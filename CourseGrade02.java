/*author : Neslisah Celek
 * date : 24.11.2020
 */
import java.util.Scanner;
public class CourseGrade02 {
		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("************ Category Information Entry ************");
			
			System.out.println( "Please enter the name of category 1:");
		    String name = input.nextLine();
		    capitalize(name);
		    
			System.out.println("Please enter how many items of type "
			+ capitalize(name) + " were given:");
		    int quantity = input.nextInt();
		    validQuantity(quantity);
		    while (validQuantity(quantity) == false) {
		    	 System.out.println("Please enter how many items of type "
		    				+ capitalize(name) + " were given:");
		    	 quantity = input.nextInt();
		    	 continue;
		    }
		    
		    System.out.println("Please enter the percentage weight of " 
		    + capitalize(name) + ":");
		    int weight = input.nextInt();
		    if (weight < 0 || weight > 100) {
		    	System.out.println("Please enter the percentage weight of " 
		    		    + capitalize(name) + ":");
		    	weight = input.nextInt();
		    }
		    
		    input.nextLine();
		    
		    
		    System.out.println( "Please enter the name of category 2:");
		    String name2 = input.nextLine();
		    capitalize(name2);
		    	    
		    System.out.println("Please enter how many items of type " + capitalize(name2) 
		    + " were given :");
		    int quantity2 = input.nextInt();
		    validQuantity(quantity2);
		    while (validQuantity(quantity2) == false) {
		    	 System.out.println("Please enter how many items of type " 
		    + capitalize(name2) + " were given :");
		    	 quantity2 = input.nextInt();
		    	 continue;
		    }
		    
		    System.out.println("Please enter the percentage weight of " 
		    + capitalize(name2) + ":");
		    int weight2 = input.nextInt();
		    if (weight2 < 0 || weight + weight2 > 100) {
		    	System.out.println("Please enter the percentage weight of " 
		    		    + capitalize(name2) + ":");
		    	weight2 = input.nextInt();
		    }
		    
		    input.nextLine();
		    
		    System.out.println( "Please enter the name of category 3:");
		    String name3 = input.nextLine();
		    capitalize(name3);
		    
		    System.out.println("Please enter how many items of type " + capitalize(name3) 
		    + " were given:");
		    int quantity3 = input.nextInt();
		    validQuantity(quantity3);
		    while (validQuantity(quantity3) == false) {
		    	 System.out.println("Please enter how many items of type " 
		    + capitalize(name3) + " were given:");
		    	 quantity3 = input.nextInt();
		    	 continue;
		    }
		    
		    System.out.println("Please enter the percentage weight of " 
		    + capitalize(name3) + ":");
		    int weight3 = input.nextInt();
		    if (weight3 < 0 || weight + weight2 + weight3 > 100) {
		    	System.out.println("Please enter the percentage weight of " 
		    		    + capitalize(name3) + ":");
		    	weight3 = input.nextInt();
		    }
		    
		    input.nextLine();
		    
		    System.out.println( "Please enter the name of category 4:");
		    String name4 = input.nextLine();
		    capitalize(name4);
		    
		    System.out.println("Please enter how many items of type " + capitalize(name4) 
		    + " were given:");
		    int quantity4 = input.nextInt();
		    validQuantity(quantity4);
		    while (validQuantity(quantity2) == false) {
		    	 System.out.println("Please enter how many items of type " 
		    + capitalize(name4) + " were given:");
		    	 quantity4 = input.nextInt();
		    	 continue;
		    }
		    
		    System.out.println("Please enter the percentage weight of "
		    + capitalize(name4) + ":");
		    int weight4 = input.nextInt();
		    if (weight4 < 0 || weight + weight2 + weight3 + weight4 > 100) {
		    	System.out.println("Please enter the percentage weight of "
		    		    + capitalize(name4) + ":");
		    	weight4 = input.nextInt();
		    }

		   
		    int totalWeight = weight + weight2 + weight3 + weight4;
		    validWeight(weight, totalWeight);
		    
		    
		    
		    System.out.println("************ Student Grades Entry ************");
		    System.out.println("Please enter values that the student earned for each item:");
		    
		    int i;
		    double sum1 = 0;
		    for(i=1 ; quantity >= i ;  i++){
		    
		    System.out.println(capitalize(name) + " " + i + ":");
		    double a1 = input.nextDouble();
		    sum1 += a1;
		  	   
		    }
		    
		    double sum2 = 0;
		    for(i=1; quantity2 >= i; i++) {
		    	
		    System.out.println(capitalize(name2) + " " + i + ":");
		    double a2 = input.nextDouble();
		    sum2 += a2;
		    
		    }
		    
		    double sum3 = 0;
		    for(i=1; quantity3 >= i; i++) {
		    	
		    System.out.println(capitalize(name3) + " " + i + ":");
		    double a3 = input.nextDouble();
		    sum3 += a3;
		    
		    }
		    
		    double sum4 = 0;
		    for(i=1; quantity4 >= i; i++) {
		    	
		    System.out.println(capitalize(name4) + " " + i + ":");
		    double a4 = input.nextDouble();
		    sum4 += a4;
		    
		    }
		    
		    
		    
		    System.out.println("************ Student Results ************");
		    
		    double n1 = sum1 / quantity;
		    double n2 = sum2 / quantity2;
		    double n3 = sum3 / quantity3;
		    double n4 = sum4 / quantity4;
		    
		    System.out.println( capitalize(name)  + ": " + n1 );
		    System.out.println( capitalize(name2) + ": " + n2 );
		    System.out.println( capitalize(name3) + ": " + n3 );
		    System.out.println( capitalize(name4) + ": " + n4 );
		
		    
		    double TS = (( n1 * weight ) + ( n2 * weight2 ) + ( n3 * weight3 ) +
		    		( n4 * weight4 )) / 100 ;
		    
		    System.out.println("The student has " + status(TS) +
		    		" CSE 101 with a score of " + TS + ", GPA points of " 
		    		+ gpaPoints(TS) + ", and a grade letter of " + gradeLetter(TS));
		
		}
		    
		    

		  
		public static String capitalize(String name) {
			
		    name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase(); 
		    
		    return (name);
	    }
	      
		public static boolean validQuantity(int quantity) {
	        
		    boolean q = true;

		    if (quantity <= 0) {
				q = false;
			}
			else {
				q = true;
			}
			
		    return q;
		
			
		}
	   
		public static boolean validWeight(int weight, int totalWeight) {
			
			boolean w = true;
			if (totalWeight != 100) {
				w = false;
				System.out.println("ERROR: The values sum to " + totalWeight + " but should sum to 100.");
				System.exit(1);
			}
			else
				w = true;
			
			return w;
			
		}
		
		public static String gradeLetter(double grade) {
			
		
			if (grade >= 88) {
	        	return "AA";
			}
	                  
	        
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
			
			if (gpa >= 88) {
	        	return 4.0;
			}
	                  
	        
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
				
				if (status >= 88) {
		        	return "passed!";
				}
		                  
		        
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
		}

