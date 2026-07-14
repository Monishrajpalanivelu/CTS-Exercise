package com.app.EmployeeManagementSystem.Repository;

import com.app.EmployeeManagementSystem.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // --- 1. Derived query methods (Keyword-based) ---
    List<Employee> findByName(String name);
    Employee findByEmail(String email);
    List<Employee> findByDepartmentName(String departmentName);
    
    // New derived query using keywords
    List<Employee> findByNameContaining(String keyword);
    Page<Employee> findByNameContaining(String keyword, Pageable pageable);

    // --- 2. Custom query using @Query annotation ---
    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:domain%")
    List<Employee> findEmployeesByEmailDomain(@Param("domain") String domain);

    // --- 3. Named queries mapping ---
    // (Matches @NamedQueries in Employee entity)
    Employee findByEmailNamed(@Param("email") String email);
    List<Employee> findByDepartmentIdNamed(@Param("deptId") Long deptId);

    // --- 4. Projections ---
    // Interface-based Projection
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<com.app.EmployeeManagementSystem.Projection.EmployeeProjection> findEmployeeProjectionsByDepartmentName(@Param("departmentName") String departmentName);

    // Class-based Projection (DTO)
    @Query("SELECT new com.app.EmployeeManagementSystem.Projection.EmployeeDTO(e.name, e.email, e.department.name) FROM Employee e")
    List<com.app.EmployeeManagementSystem.Projection.EmployeeDTO> findAllEmployeeDTOs();
}
