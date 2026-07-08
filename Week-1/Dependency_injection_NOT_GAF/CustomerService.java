package Dependency_injection_NOT_GAF;

public class CustomerService {  // This is the Service class
      private CustomerRepository customerRepository;  // This is the dependency
      public CustomerService(CustomerRepository customerRepository) {  // This is the constructor
            this.customerRepository = customerRepository;  // This is the dependency injection
      }
      public String getCustomerById(int id) {  // This is the method that uses the dependency
            return customerRepository.findCustomerById(id);  // This is the method that uses the dependency
      }
}
