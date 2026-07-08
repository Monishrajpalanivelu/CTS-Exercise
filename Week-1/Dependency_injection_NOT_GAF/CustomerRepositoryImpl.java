package Dependency_injection_NOT_GAF;
 // This is the implementation class for the CustomerRepository interface
public class CustomerRepositoryImpl implements CustomerRepository {
      @Override
      public String findCustomerById(int id) {
            return "Customer" + id;
      }
}
