package org.arunm.graphql.adventureworks_hr_graphql.graphql

import graphql.schema.DataFetcher
import org.arunm.graphql.adventureworks_hr_graphql.EmployeeService
import org.springframework.stereotype.Component

@Component
class GraphQLDataFetchers {

    private EmployeeService employeeService

    GraphQLDataFetchers(EmployeeService employeeService) {
        this.employeeService = employeeService
    }

    DataFetcher getEmployeeByIdDataFetcher() {
        { dataFetchingEnvironment  ->
            String employeeId = dataFetchingEnvironment.getArgument("id");
            employeeService.findEmployeeById(Integer.parseInt(employeeId))
                .orElse(null)
        }
    }
}
