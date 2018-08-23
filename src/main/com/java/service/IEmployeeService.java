package service;

import pojo.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> searchByName(Employee employee);

    List<Employee> searchByProject(int projectId);
}
