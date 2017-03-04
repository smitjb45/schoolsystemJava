/**
 * Title: Student.java
 * Abstract: This program emulates a college CMS
 * Author: Joshua Smith
 * ID: 3535
 * Date: 10/6/16
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Student {
	
   // private variables
   private String name;
   private int id;
   private boolean graduated;
   private HashMap<Integer, Double> scores;
   NumberFormat use = new DecimalFormat("#0.00");

   //constructors
   Student(){
	   name = "";
	   id = 0;
	   graduated = false;
	   scores = new HashMap<>();
   }
   
   Student(int id, String name){
	   setId(id);
	   setName(name);
	   graduated = false;
	   scores = new HashMap<>();
   }
   
   // class methods
   public void setName(String name){
	   this.name = name;
   }
   public void setId(int id){
	   if(id < 0){
		   System.out.println("Error, Id can't be negative");
		   return;
	   }
	   this.id = id;
   }
   public void setScore(double score, int classId){
	   if(score < 0){
		   System.out.println("Error, score can't be negative");
		   return;
	   }
	   scores.put(classId, score);
   }
   
   public String getName(){
	   return name;
   }
   public int getId(){
	   return id;
   }
   public double getScore(int classId){
	   return scores.get(classId);
   }
   public boolean graduateStatus(){
	   return graduated;
   }
   public void graduate(){
	   graduated = true;
   }
   public boolean containsScore(int classId){
	   return scores.containsKey(classId);
   }
  
   public void courseDropped(int key){
	   scores.remove(key);   
   }
   
   public boolean equals(Object obj){
	   return ((id) == ((Student)obj).getId());
   }
   
   public String toString(){
	   int count = 0;
	   double avg = 0;
	   String stringToReturn = "Student Number: ";
	   
	   stringToReturn += id + "\n";
	   if(graduated){
		   return stringToReturn += "No student information.\n";
	   }
	   stringToReturn += "Name: " + name + "\n";
	   stringToReturn += "Courses Enrolled:\n";
	   
   	for(Object key : scores.keySet()){
   		count++;
   		avg += scores.get(key);
   		
		stringToReturn += key + ": " + use.format(scores.get(key)) + "\n";
	}
   	
   	avg = avg/count;
   	
   	stringToReturn += "Course Average:" + use.format(avg);
	   return stringToReturn;
   }
}
