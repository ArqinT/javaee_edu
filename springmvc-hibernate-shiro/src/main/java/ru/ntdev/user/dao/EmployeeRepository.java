package ru.ntdev.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ntdev.user.entity.Employee;
import java.util.List;

/**
 * Created by atursunov on 13.01.17.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);
}
