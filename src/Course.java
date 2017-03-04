/**
 * Title: Course.java
 * Abstract: This program emulates a college CMS
 * Author: Joshua Smith
 * ID: 3535
 * Date: 10/6/16
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Course {
	// private variables
	private Instructor instructor;
	private int courseNum;
	private String courseTitle;
	private int maxCapacity;
	private String location;
	private ArrayList<Object> enrolledStudent;
	NumberFormat use = new DecimalFormat("#0.00");
	
	// contructors
	Course(){
		   this(0, "", 0);
		   enrolledStudent = new ArrayList<>();
		   instructor = new Instructor();
	}
	Course(int courseNum, String courseTitle, int maxCapacity){
		   setCourseNum(courseNum);
		   setCourseTitle(courseTitle);
		   setMaxCapacity(maxCapacity);
		   enrolledStudent = new ArrayList<>();
		   instructor = new Instructor();
	}
	
	// class methods
	public void setInstructor(Instructor instructor){
		   this.instructor = instructor;
	}
	public void setCourseNum(int courseNum){
		   this.courseNum = courseNum;
	}
	public void setCourseTitle(String courseTitle){
		   this.courseTitle = courseTitle;
	}
	public void setMaxCapacity(int maxCapacity){
		   this.maxCapacity = maxCapacity;
	}
	public void setLocation(String location){
		   this.location = location;
	}
	public void updateLocation(String location){
		   this.location = location;
	}
	public Instructor getInstructor(){
		   return instructor;
	}
	
	public int getCourseNum(){
		   return courseNum;
	}
	public String getCourseTitle(){
		   return courseTitle;
	}
	public int getMaxCapacity(){
		   return maxCapacity;
	}
	
	public String getLocation(){
		   return location;
	}
	
	public void addStudent(Student obj){
		enrolledStudent.add(obj);
	}
	public void dropStudent(Student obj){
		enrolledStudent.remove(obj);
		obj.courseDropped(courseNum);
	}
	public boolean isEnrolled(Student obj){
		return enrolledStudent.contains(obj);
	}
	
	public int numEnrolled(){
		return enrolledStudent.size();
	}
	
	public boolean equals(Object obj){
		return(((Course)obj).courseNum == courseNum);
	}
    public String toString(int courseNum){
		   String stringToReturn = "Course Number: ";

		   stringToReturn += courseNum + "\n";
		   stringToReturn += "Instructor: " + instructor.getName() +"\n";   
		   stringToReturn += "Course Title: " + courseTitle +"\n"; 
		   stringToReturn += "Room: " + location+ "\n";
		   stringToReturn += "Total Enrolled: " + enrolledStudent.size() + "\n";
		 
           double count = 0;
           int count1 = 0;
		   if(!enrolledStudent.isEmpty()){
		    	for(Object student : enrolledStudent){
		   		if(((Student)student).containsScore(courseNum)){
		   			count += ((Student)student).getScore(courseNum);
		   			count1++;
		   		}
		   		
			}
		}
		// if the count is zero NA
		if(count1 != 0){
			stringToReturn += "Course Average: " + use.format((count/count1)) + "\n";
		}else{
			stringToReturn += "Course Average: " + "NA" + "\n";
		}
			 
		return stringToReturn;
	   }
    public String toString(){
		   String stringToReturn = "Course Number: ";

		   stringToReturn += courseNum + "\n";
		   stringToReturn += "Instructor: " + instructor.getName() +"\n";   
		   stringToReturn += "Course Title: " + courseTitle +"\n"; 
		   stringToReturn += "Room: " + location+ "\n";
		   stringToReturn += "Total Enrolled: " + enrolledStudent.size() + "\n";
		 
		return stringToReturn;
	   }
	   
}
