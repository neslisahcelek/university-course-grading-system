/*author: neslisah celek
 * date: 09.01.2021
 */
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseGrade_20190808063 {
	public static void main(String[] args) throws Exception{
		String baseFile = args[0];
		File file = new File(baseFile + "_CourseDetails.txt");
		int lineNumber = countCategory(baseFile + "_CourseDetails.txt");
	    String[] category = new String[lineNumber];
	    int weight[] = new int[lineNumber];
	    int[] quantity = new int[lineNumber];

		File file1 = new File(baseFile + "_StudentScores.txt");
		int countLine = countLine(baseFile + "_StudentScores.txt");
		int quantitySum = quantitySum(category, quantity, weight, file);
		String[] student = new String[countLine];
		double[][] grade = new double[countLine][quantitySum];
		
		if(controlWeight(category, quantity, weight, file) == 100) {
			BufferedReader br = new BufferedReader(new FileReader(file1)); 		  
			List<String> students = new ArrayList<String>();
			List<Double> grades = new ArrayList<Double>();
			String st; 
		    while ((st = br.readLine()) != null) {
			   String name = "";	
			   String word = "";
			   boolean first = true;
			for(char c :st.toCharArray()) {			
			  if(c == ' ') {
			    if(first == true)
			    {
			    	first = false;
			        name = word;
			    }
			    else {
			    	grades.add(Double.parseDouble(word.replace(",", ".")));
			    }
			    word="";
			  }
			  else {
				  word += c;
			  }		  
			  if(c == st.charAt(st.length()-1)) {
				  grades.add(Double.parseDouble(word.replace(",", ".")));
			  }		  
		    }
			students.add(name);
		  } 
			for(int i = 0; i < countLine; i++) {
				student[i] = students.get(i);
				for(int j = 0; j < quantitySum; j++) {
					if(i == 0) {
						grade[i][j] = grades.get(j);
					}
					else {		
						grade[i][j] = grades.get(j + quantitySum*i);			
					}			
				}
			}
			br.close();
		}		
		else {
			for(int i = 0; i < countLine; i++) {
				student[i] = null;
			}		    	
		}
		writeGrades(student, grade, baseFile);
	}
	public static int countCategory(String filename) throws Exception{	
	    FileReader fr = new FileReader(filename);
	    int line = 0;
	    BufferedReader br = new BufferedReader(fr);
	    while(br.readLine() != null) {
	        line++;    
	    }
	    br.close();
		return line;
	}	
	public static void getCategory(String[] category, int[] quantity,
			int[] weight, String filename) throws Exception{
		Scanner input = new Scanner(new File(filename));
		int i = 0, j = 0, k = 0;
	    while((input.hasNext())){		    	
		    	category[i] = input.next();
		    	quantity[j] = input.nextInt();
		    	weight[k] = input.nextInt();	
		        i++;
		        j++;
		        k++;	        
	   }
	    input.close();
	}	
	public static void writeGrades(String[] student, double[][] grade,
			String basefilename) throws Exception{
	    File file = new File(basefilename + "_StudentGrades.txt");
	    PrintWriter output = new PrintWriter(file);
		int countLine = countLine(basefilename + "_StudentScores.txt");
		
		File file1 = new File(basefilename + "_log");
		PrintWriter output1 = new PrintWriter(file1);	
		if(student[0] == null) { //if weight does not sum to 100, 
			output1.print("ERROR: Course details - invalid weight -"
					+ " does not sum to 100");
			output1.close();
			System.exit(1);
		}
		File file2 = new File(basefilename + "_CourseDetails.txt");
	    Scanner input = new Scanner(file2);
		int[] quantity = new int[countCategory(basefilename +
				"_CourseDetails.txt")];
		int[] weight = new int[countCategory(basefilename +
				"_CourseDetails.txt")];
		String[] category = new String[countCategory(basefilename +
				"_CourseDetails.txt")];
		int i = 0, j = 0, k = 0;
	    while((input.hasNext())){		    	
		    	category[i] = input.next(); //unnecessary
		    	quantity[j] = input.nextInt();
		    	weight[k] = input.nextInt();	
		        i++;
		        j++;
		        k++;	        
	    }
	    double[] avgQ = new double[countLine];
	    double[] avgH = new double[countLine];
	    double[] avgM = new double[countLine];
	    double[] avgF = new double[countLine];		
		double[] TS = new double[countLine];
			
		int quantitySum = quantitySum(category, quantity, weight, file2);
	    for(int x = 0; x < countLine; x++) {
	    	for(int y = 0; y < quantitySum; y++) {
	    		if(grade[x][y] < 0 || grade[x][y] > 100) {
	    			output1.println("ERROR: Student " + student[x] + 
	    					" - cannot calculate due to invalid grade entered");
	    			student[x] = null;
	    			break;
		    	}	    	
	    	}
	    if(student[x] != null) {
	    	double sumQ = 0; //Q = Quiz
			for(int a = 0; a < quantity[0]; a++){
				sumQ += grade[x][a];
			}
			avgQ[x] = sumQ / quantity[0];
					
			double sumH = 0; //H = Homework
			for(int b = 0; b < quantity[1]; b++) {
				sumH += grade[x][quantity[0] + b];	
			}
			avgH[x] = sumH / quantity[1];			
			
			double sumM = 0; //M = Midterm
			for(int c = 0; c < quantity[2]; c++) {
				sumM += grade[x][quantity[0] + quantity[1] + c];		
			}
		    avgM[x] = sumM / quantity[2];
			
			double sumF = 0; //F = Final
			for(int d = 0; d < quantity[3]; d++) {
				sumF += grade[x][quantity[0] + quantity[1] + quantity[2] + d];		
			}
			avgF[x] = sumF / quantity[3];
			
		    int y = 0;
		    TS[x] = ((avgQ[x] * weight[y]) + (avgH[x] * weight[y+1]) +
		    		(avgM[x] * weight[y+2]) + (avgF[x] * weight[y+3])) / 100;
				
			output.print(student[x] + " ");
			output.print(TS[x] + " ");
			output.print(gradeLetter(TS[x]) + " ");
			output.print(gpaPoints(TS[x]) + " ");
			output.println(status(TS[x]));		
	     }
	  }	  		
	 output.close();
	 output1.close();
	 input.close();	 
    }

	public static int countLine(String filename) throws Exception{	
	    FileReader fr = new FileReader(filename);
	    int line = 0;
	    BufferedReader br = new BufferedReader(fr);
	    while(br.readLine() != null) {
	        line++;    
	    }
	    br.close();
		return line;
	}
	public static int quantitySum(String[] category, int[] quantity,
			int[] weight, File filename) throws Exception{
		Scanner input = new Scanner(filename);
		int sum = 0, i = 0, j = 0, k = 0;
	    while((input.hasNext())){		    	
		    	category[i] = input.next();
		    	quantity[j] = input.nextInt();
		    	sum += quantity[j];
		    	weight[k] = input.nextInt();	
		        i++;
		        j++;
		        k++;
	   }
	    input.close();
	   return sum;	   
	}
	public static int controlWeight(String[] category, int[] quantity,
			int[] weight, File filename) throws Exception{
		Scanner input = new Scanner(filename);
		int sum = 0, i = 0, j = 0, k = 0;
	    while((input.hasNext())){		    	
		    	category[i] = input.next();
		    	quantity[j] = input.nextInt();
		    	weight[k] = input.nextInt();	
		    	sum += weight[k];		    	
		        i++;
		        j++;
		        k++;
	    }
	    input.close();
	    return sum;
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

