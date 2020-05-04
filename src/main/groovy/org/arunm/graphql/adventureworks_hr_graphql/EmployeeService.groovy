package org.arunm.graphql.adventureworks_hr_graphql

import org.arunm.graphql.adventureworks_hr_graphql.entity.Employee
import org.arunm.graphql.adventureworks_hr_graphql.repositories.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService {

    EmployeeRepository employeeRepository

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository
    }

    Optional<Employee> findEmployeeById(Integer id) {
         this.employeeRepository.findById(id)
    }
}
