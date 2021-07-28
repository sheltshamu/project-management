package com.ss.pma;

import com.ss.pma.domain.*;
import com.ss.pma.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import java.util.*;

@SpringBootApplication
public class ProjectManagementApplication {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(){
        return args -> {

            Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
            Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com");
            Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com");

            Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
            Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com");
            Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com");

            Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com");
            Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com");
            Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com");


            Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
                    + "the final deployment of the software into production");
            Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
                    + "for the year and figureout who will be promoted");
            Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
                    + "been damaged due to hurricane in the region. This needs to be reconstructed");
            Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
                    + "security needs to be improved and proper security team needs to be hired for "
                    + "implementation");

            // need to set both sides of the relationship manually

            pro1.setEmployees(Arrays.asList(emp1,emp2));
            pro2.setEmployees(Arrays.asList(emp3));
            pro3.setEmployees(Arrays.asList(emp1));
            pro4.setEmployees(Arrays.asList(emp1));
            pro4.setEmployees(Arrays.asList(emp3));


            // need to set both sides of the relationship manually

            emp1.setProject(Arrays.asList(pro1, pro3, pro4));
            emp2.setProject(Arrays.asList(pro1));
            emp3.setProject(Arrays.asList(pro2, pro4));

            // save employees in database

            employeeRepository.save(emp1);
            employeeRepository.save(emp2);
            employeeRepository.save(emp3);
            employeeRepository.save(emp4);
            employeeRepository.save(emp5);
            employeeRepository.save(emp6);
            employeeRepository.save(emp7);
            employeeRepository.save(emp8);
            employeeRepository.save(emp9);


            // save projects in database

            projectRepository.save(pro1);
            projectRepository.save(pro2);
            projectRepository.save(pro3);
            projectRepository.save(pro4);


        };
    }


}
