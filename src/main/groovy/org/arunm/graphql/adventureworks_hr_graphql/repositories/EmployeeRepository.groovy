package org.arunm.graphql.adventureworks_hr_graphql.repositories

import org.arunm.graphql.adventureworks_hr_graphql.entity.Employee
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository extends CrudRepository<Employee,Integer>{
}
