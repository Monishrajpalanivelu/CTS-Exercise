package com.app.EmployeeManagementSystem.Repository;

import com.app.EmployeeManagementSystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // --- 1. Derived query method (Keyword-based) ---
    Department findByName(String name);
    List<Department> findByNameIgnoreCase(String name);

    // --- 2. Custom query using @Query annotation ---
    @Query("SELECT d FROM Department d WHERE d.name LIKE %:keyword%")
    List<Department> findDepartmentsByKeyword(@Param("keyword") String keyword);

    // --- 3. Named Query mapping ---
    // (Matches @NamedQuery(name = "Department.findByNameNamed") in Department entity)
    Department findByNameNamed(@Param("name") String name);

    // --- 4. Projections ---
    // Interface-based Projection
    @Query("SELECT d FROM Department d")
    List<com.app.EmployeeManagementSystem.Projection.DepartmentProjection> findAllDepartmentProjections();
}
