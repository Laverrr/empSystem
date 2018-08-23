package service;

import pojo.Employee;

import java.util.List;
import java.util.Set;

public interface IEmployeeService {
    List<Employee> searchByName(Employee employee);

    Set<Employee> searchByProjectId(String projectId);
}
