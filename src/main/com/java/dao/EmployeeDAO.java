package dao;

import org.springframework.stereotype.Repository;
import pojo.Employee;
import pojo.EmployeeExample;

/**
 * EmployeeDAO继承基类
 */
@Repository
public interface EmployeeDAO extends MyBatisBaseDao<Employee, Integer, EmployeeExample> {
}