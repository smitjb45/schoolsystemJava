/**
 * Title: School.java
 * Abstract: This program emulates a college CMS
 * Author: Joshua Smith
 * ID: 3535
 * Date: 10/6/16
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class School {

    // private variables	
	private String name;
	private ArrayList<Object> classes;
	private ArrayList<Object> instructors;
	private ArrayList<Object> students;
	private ArrayList<String> tokens;
	private ArrayList<String> fileInput;

	// constructors
	School(String name){
		this.name = name;
		classes = new ArrayList<>();
		instructors = new ArrayList<>();
		students = new ArrayList<>();
	}
	
	// class methods
	public void addCourse(int courseNum, String title, int maxCapacity, String location){
		Course theCourse = new Course();
		
		theCourse.setCourseNum(courseNum);
		theCourse.setCourseTitle(title);
		theCourse.setMaxCapacity(maxCapacity);
		theCourse.setLocation(location);
		
		if(classes.contains(theCourse)){
			System.out.println("Course addition failed – Course number already used.");
			return;
		}
		classes.add(theCourse);
	}
	
	public void addInstructor(int id, String name, String email, String phoneNum){
		Instructor theInstructor = new Instructor(id, name, email, phoneNum);
		if(instructors.equals(theInstructor)){
			System.out.println("Instructor" + id +  "already exist");
			return;
		}
		instructors.add(theInstructor);
	}
	
	public void addStudent(int id, String name){
		Student theStudent = new Student(id, name);
		students.add(theStudent);
	}
	
	public void assignInstructor(int classId, int instructorId){
		for(Object course : classes){
			if(((Course)course).getCourseNum() == classId){
				for(Object instructor : instructors){
					if(((Instructor)instructor).getEmployeeNum() == instructorId){
						((Course)course).setInstructor(((Instructor)instructor));
						((Instructor)instructor).addCourse(course);
						return;
					}
				}
				System.out.println("Instructor " + instructorId + " does not exist.");
			}
		}
	}
	
	public void register(int classId, int studentId){
		
		for(Object course : classes){
			if(((Course)course).getCourseNum() == classId){
				if(((Course)classes.get(classes.indexOf(((Course)course)))).numEnrolled() >=
				  ((Course)classes.get(classes.indexOf(((Course)course)))).getMaxCapacity()){
					System.out.println("Registration failed – Class is full.");
					return;
				}
				for(Object student : students){
					if(((Student)student).getId() == studentId){
						((Course)course).addStudent(((Student)student));
						return;
					}
				}
				System.out.println("Student " + studentId + " does not exist.");
			}
		}
	}
	
	public void unRegister(int classId, int studentId){
		
		for(Object course : classes){
			if(((Course)course).getCourseNum() == classId){
				for(Object student : students){
					if(((Student)student).getId() == studentId){
						if(((Course)course).isEnrolled(((Student)student))){
							((Course)course).dropStudent((Student) student);
						}
						return;
					}
				}
			}
		}
		System.out.println("Class " + classId + " does not exist.");
	}
	
	public void deleteCourse(int classId){
		int count = 0;
		boolean flag = false;
		for(Object theClass : classes){
			count++;
			if(((Course)theClass).getCourseNum() == classId && ((Course)theClass).numEnrolled() == 0 ){
				flag = true;
			   break;
			}
		}
		if(flag == true){
			classes.remove(count);	
		}else{
			System.out.println("Error, Students still enrolled in class or class DNE");
		}
		
	}
	public void putScore(int classId, int studentId, double score){
	
		for(Object course : classes){
			if(((Course)course).getCourseNum() == classId){
				for(Object student : students){
					if(((Student)student).getId() == studentId){
						if(((Course)course).isEnrolled(((Student)student))){
							((Student)student).setScore(score, classId);
						}
						else{
							System.out.println("Student " + ((Student)student).getId() + 
									        " ("+ ((Student)student).getName() +") is not enrolled in "+ 
									           classId +".");
						}
						break;
					}
				}
			}
		}
	}
	
	public Course getCourse(int courseId){
		if(courseId < 0 || courseId != (int)courseId){
			System.out.println("Instructor Id cant be nagative and has to be an int");
			System.exit(-1);
		}
		for(Object theClass : classes){
			if(((Course)theClass).getCourseNum() == courseId){
				return ((Course)theClass);
			}
		}
		return null;
	}
	
	public Instructor getInstructor(int instructorId){
		if(instructorId < 0 || instructorId != (int)instructorId){
			System.out.println("Instructor Id cant be nagative and has to be an int");
			System.exit(-1);
		}
		for(Object instructor : instructors){
			if(((Instructor)instructor).getEmployeeNum() == instructorId){
				return (((Instructor)instructor));
			}
		}
		return null;
	}
	
	public Student getStudent(int studentId){
		for(Object student : students){
			if(((Student)student).getId() == studentId){
				return (((Student)student));
			}
		}
		return null;
	}
	
	public void readData(String filePath){
		fileInput = new ArrayList<>();
		
		while(true){
			try{
				String theFile = filePath;
				System.out.println();
			    File file = new File(theFile);
	
			        Scanner sc = new Scanner(file);
			        while (sc.hasNextLine()) {
			            fileInput.add(sc.nextLine());
			        }
			        sc.close();
			    
			        break;
			    } 
			    catch (FileNotFoundException e1) {
			    	System.out.println("Please enter a valid file name!");
			    	System.out.println();
			    	break;
			    }	
	}
		
		int theCount = 0;
		boolean theFlag = false;
		tokens = new ArrayList<>();
		
		for(String string : fileInput){
	       StringTokenizer st = new StringTokenizer(string,",");  
		   while (st.hasMoreTokens()) {  
	          tokens.add(st.nextToken());  
		   }
	    }
	
	    int theLength = Integer.parseInt(tokens.get(theCount));
	    for(int i = 0; i < theLength; i++){
	    	theFlag = true;
			Instructor theInstructor = new Instructor();
			theInstructor.setEmployeeNum(Integer.parseInt(tokens.get(++theCount)));
			theInstructor.setName(tokens.get(++theCount));
			theInstructor.setEmail(tokens.get(++theCount));
			theInstructor.setPhoneNum(tokens.get(++theCount));
			for(Object instructor : instructors){
				if(((Instructor)instructor).getEmployeeNum() == theInstructor.getEmployeeNum()){
					System.out.println("Instructor info reading failed – Number already used.");
					theFlag = false;
					break;
				}
			}
			if(theFlag == true)
			instructors.add(theInstructor);
	}
	
		theLength = Integer.parseInt(tokens.get(++theCount));
		
		for(int i = 0; i < theLength; i++){
			theFlag = true;
			Course theCourse = new Course();
			theCourse.setCourseNum(Integer.parseInt(tokens.get(++theCount)));
			theCourse.setCourseTitle(tokens.get(++theCount));
			theCourse.setMaxCapacity(Integer.parseInt(tokens.get(++theCount)));
			theCourse.setLocation(tokens.get(++theCount));
			for(Object course : classes){
				if(((Course)course).getCourseNum() == theCourse.getCourseNum()){
					System.out.println("Course info reading failed – Number already used.");
					theFlag = false;
					break;
				}
			}
			if(theFlag == true)
			classes.add(theCourse);
		}
	
		theLength = Integer.parseInt(tokens.get(++theCount));
		
		for(int i = 0; i < theLength; i++){
			theFlag = true;
			Student theStudent = new Student();
			theStudent.setId(Integer.parseInt(tokens.get(++theCount)));
			theStudent.setName(tokens.get(++theCount));
			for(Object student : students){
				if(((Student)student).getId() == theStudent.getId()){
					System.out.println("Student info reading failed – Number already used.");
					theFlag = false;
					break;
				}
			}
			if(theFlag == true)
			students.add(theStudent);	
			
			
		}
	    System.out.println("Done.");
	}
	
	public void graduateStudent(int studentId){
	    
		for(Object course : classes){
			
			if(((Course)course).isEnrolled(getStudent(studentId))){
				Student theStudent = getStudent(studentId);
				theStudent.graduate();
				((Course)course).dropStudent(theStudent);
				
			}
		}
	}
	public void courseInfo(){
		System.out.println("Number of Courses: " + classes.size());
		for(Object course : classes){
			System.out.println("       " + ((Course)course).getCourseNum() +
					    ": " + ((Course)course).numEnrolled() + " enrolled");
		}
	}
	
	public void courseInfo(int classId){
		for(Object theClass : classes){
			if(((Course)theClass).getCourseNum() == classId){
				System.out.println(((Course)theClass).toString(classId));
				break;
			}
		}
	}
	
	public void schoolInfo(){
	
	    System.out.println("School Name: " + name);
	    System.out.println("Instructor Information");
	    for(Object instructor : instructors){
	    	System.out.println("       " + ((Instructor)instructor).getName());
	    }
	    
	    System.out.println("Course Information");
	    for(Object course : classes){
	    	System.out.println("       " + ((Course)course).getCourseTitle());
	    }
	    
	    System.out.println("Student Information");
	    for(Object student : students){
	    	System.out.println("       " + ((Student)student).getName());
	    }
			
	}

}
