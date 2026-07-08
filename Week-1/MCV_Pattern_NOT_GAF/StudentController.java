package MCV_Pattern_NOT_GAF;
 // This is the Controller in MVC 
public class StudentController { 
      private Student student;  
      private StudentView view;  
      public StudentController(Student student, StudentView view) {  
            this.student = student;  
            this.view = view;  
      }  
      public void setStudentName(String name) {  
            student.setName(name);  
      }  
      public String getStudentName() {  
            return student.getName();  
      }  
      public void updateView() {  
            view.displayStudentDetails(student);  
      }  
}
