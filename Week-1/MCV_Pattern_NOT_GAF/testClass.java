package MCV_Pattern_NOT_GAF;
 //This is the test class for the MVC pattern
public class testClass {
      public static void main(String[] args) {  
            Student student = new Student("John", "1", "A");  
            StudentView view = new StudentView();  
            StudentController controller = new StudentController(student, view);  
            controller.updateView();  
            controller.setStudentName("Jane");  
            controller.updateView();  
      }  
}
