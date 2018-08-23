package dao;

import org.springframework.stereotype.Repository;
import pojo.EmployeeProject;
import pojo.EmployeeProjectExample;

/**
 * EmployeeProjectMapDAO继承基类
 */
@Repository
public interface EmployeeProjectMapDAO extends MyBatisBaseDao<EmployeeProject, Integer, EmployeeProjectExample> {
}