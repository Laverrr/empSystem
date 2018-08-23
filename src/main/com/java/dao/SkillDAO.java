package dao;

import org.springframework.stereotype.Repository;
import pojo.Skill;
import pojo.SkillExample;

/**
 * SkillDAO继承基类
 */
@Repository
public interface SkillDAO extends MyBatisBaseDao<Skill, Integer, SkillExample> {
}