package Dependency_injection_NOT_GAF;
 //This is the test class for the Dependency Injection pattern
public class testClass { // Main Class
      public static void main(String[] args) {  
            CustomerRepository customerRepository = new CustomerRepositoryImpl();  // creating an instance of the repository class
            CustomerService customerService = new CustomerService(customerRepository);  // Injecting the dependency through constructor 
            System.out.println(customerService.getCustomerById(1));  // calling the method
      }  
}
