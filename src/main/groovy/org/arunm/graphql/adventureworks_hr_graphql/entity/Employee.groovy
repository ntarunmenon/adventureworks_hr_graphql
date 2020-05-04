package org.arunm.graphql.adventureworks_hr_graphql.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import java.time.LocalDate

@Entity
@Table(name="employee",schema="humanresources")
class Employee {

    @Column(name="businessentityid")
    @Id
    Integer employeeId

    @Column(name="jobtitle")
    String jobTitle

    @Column(name="birthdate")
    LocalDate birthDate

    @Column(name="maritalstatus")
    Character martialStatus

    @Column(name="gender")
    Character gender

    @Column(name="hiredate")
    LocalDate hireDate

    @Column(name="salariedflag")
    Boolean salariedFlag

    @Column(name="vacationhours")
    Integer vacationHours

    @Column(name="sickleavehours")
    Integer sickLeaveHours

    @Column(name="currentflag")
    Boolean currentFlag

}
