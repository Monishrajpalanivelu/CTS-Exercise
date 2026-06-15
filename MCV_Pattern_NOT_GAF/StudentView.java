package MCV_Pattern_NOT_GAF;
 // This is the View in MVC 
public class StudentView {
      public void displayStudentDetails(Student student) {
            System.out.println("Student Details:");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Grade: " + student.getGrade());
      }
}
