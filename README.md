# Spring-Boot-GraphQL  

## Pre-requisite

Run the docker image here using the below command

```unix
docker run -p 7000:5432 -i   -d postgres-adventureworks
``` 

Further, details [here](https://ntarunmenon.gitlab.io/my-blog/2020/04/10/docker-postrge-sample-database.html)


## How to test ? 

```unix
curl --header "Content-Type: application/json" \ 
--request POST \
--data '{"query": "{ employeeById(id: \"100\") {employeeId, jobTitle, birthDate }  }"}' \  
localhost:8080/graphql
```

## To Do

- Try more queries. 
- Use Enum from Hibernate as well as GraphQL
- Create Employee Department and Department Query
- Use mutation to create an Employee
