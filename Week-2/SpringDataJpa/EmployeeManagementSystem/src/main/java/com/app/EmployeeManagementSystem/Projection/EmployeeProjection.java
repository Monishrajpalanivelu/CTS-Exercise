package com.app.EmployeeManagementSystem.Projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    String getName();
    String getEmail();

    // Using @Value to fetch data conditionally or combine fields
    @Value("#{target.name + ' works in ' + target.department.name}")
    String getEmployeeDetails();
}
