package dao;

import org.springframework.stereotype.Repository;
import pojo.EmployeeSkill;
import pojo.EmployeeSkillExample;

/**
 * EmployeeSkillMapDAO继承基类
 */
@Repository
public interface EmployeeSkillMapDAO extends MyBatisBaseDao<EmployeeSkill, Integer, EmployeeSkillExample> {
}