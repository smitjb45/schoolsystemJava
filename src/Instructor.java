/**
 * Title: Instructor.java
 * Abstract: This program emulates a college CMS
 * Author: Joshua Smith
 * ID: 3535
 * Date: 10/6/16
 */
import java.util.HashMap;

public class Instructor {
	
   // private variables
   private int employeeNum;
   private String name;
   private String email;
   private String phoneNum;
   private HashMap<Integer, Object> coursesTeach;
   
   // constructors
   Instructor(){
	   this(0, "", "", "");
	   coursesTeach = new HashMap<>();
   }
   Instructor(int employeeNum, String name, String email, String phoneNum){
	   setEmployeeNum(employeeNum);
	   setName(name);
	   setEmail(email);
	   setPhoneNum(phoneNum);
	   coursesTeach = new HashMap<>();
   }
   
   // class methods
   public void setEmployeeNum(int employeeNum){
	   this.employeeNum = employeeNum;
   }
   public void setName(String name){
	   this.name = name;
   }
   public void setEmail(String email){
	   this.email = email;
   }
   public void setPhoneNum(String phoneNum){
	   this.phoneNum = phoneNum;
   }
   
   public void addCourse(Object obj){
	   if(!coursesTeach.containsKey(((Course)obj).getCourseNum()))
	   coursesTeach.put(((Course)obj).getCourseNum(), obj);
   }
   
   public void dropCourse(Object obj){
	   coursesTeach.remove(((Course)obj).getCourseNum());
   }
   
   public int getEmployeeNum(){
	   return employeeNum;
   }
   public String getName(){
	   return name;
   }
   public String getEmail(){
	   return email;
   }
   public String getPhoneNum(){
	   return phoneNum;
   }
   
   public boolean equals(Object obj){
	   return (employeeNum == ((Instructor)obj).employeeNum);
   }
   
   public String toString(){
	   String stringToReturn = "Instructor Number: ";
	   
	   stringToReturn += employeeNum + "\n";
	   stringToReturn += name + "\n";
	   stringToReturn += "Courses Teaching:\n";
	 
	if(!coursesTeach.isEmpty()){
	   	for(Object key : coursesTeach.keySet()){
			stringToReturn += "    " + ((Course)coursesTeach.get(key)).getCourseNum() + ": " + 
			                          + ((Course)coursesTeach.get(key)).numEnrolled()  + " enrolled\n";
		}
	}
	   return stringToReturn;
   }
}
