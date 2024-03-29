
public class SchoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         School school1 = new School("CSUMB");
//         school1.readData("/Users/joshuasmith/Desktop/testfile.txt");

		School SCD = new School("SCD");
	    Instructor instructor1;
	    Student student1;
	    System.out.println("===== Read Data =====");
	    SCD.readData("/Users/joshuasmith/Desktop/testfile.txt");
	    SCD.assignInstructor (306,200);
	    SCD.assignInstructor (205,200);
	    SCD.addStudent(5555, "Chris Watson");
	    SCD.addStudent(9999, "Mike Watson");
	    SCD.register (205, 5555);
	    SCD.register (205, 7777);
	    SCD.register (306, 7777);
	    SCD.register (205, 8888);
	    SCD.putScore (205, 5555, 50.0);
	    SCD.putScore (205, 7777, 100.0);
	    SCD.putScore (306, 7777, 100.0);
	    SCD.putScore (205, 8888, 50.0);
	    System.out.println("\n===== Error Messages =====");
	    SCD.register (205, 9999);
	    SCD.unRegister (205, 8888);
	    System.out.println("\n===== Detailed Course Info 5 =====");
	    SCD.courseInfo(205);
	    instructor1 = SCD.getInstructor(200);
	    System.out.println("\n===== Detailed Instructor Info =====");
	    System.out.println(instructor1);
	    student1 = SCD.getStudent(7777);
	    System.out.println("\n===== Detailed Student Info =====");
	    System.out.println(student1);
	    SCD.graduateStudent(7777);
	    System.out.println("\n===== Detailed Student Info 2 =====");
	    System.out.println(SCD.getStudent(7777));
	    System.out.println("\n===== Detailed Course Info 6 =====");
	    SCD.courseInfo(205);
	    System.out.println("\n===== Good Job! Bye! =====");
         
	}

}
