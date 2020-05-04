package org.arunm.graphql.adventureworks_hr_graphql.graphql

import graphql.GraphQL
import graphql.schema.GraphQLSchema
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.schema.idl.TypeDefinitionRegistry
import graphql.schema.idl.TypeRuntimeWiring
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct
import java.nio.file.Files

import static graphql.schema.idl.TypeRuntimeWiring.*

@Component
class GraphQLProvider {

    private GraphQL graphQL

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    @Bean
    GraphQL graphQL() {
        graphQL
    }

    @PostConstruct
    void init() throws IOException{
        File resource = new ClassPathResource("schema.graphqls").getFile();
        String sdl = new String(Files.readAllBytes(resource.toPath()));
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(sdl)
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }


    private RuntimeWiring buildWiring() {
        RuntimeWiring.newRuntimeWiring()
            .type(newTypeWiring("Query")
                .dataFetcher("employeeById",graphQLDataFetchers.getEmployeeByIdDataFetcher()))
                .build();
    }
}
