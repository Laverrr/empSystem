package dao;

import org.springframework.stereotype.Repository;
import pojo.Project;
import pojo.ProjectExample;

/**
 * ProjectsDAO继承基类
 */
@Repository
public interface ProjectsDAO extends MyBatisBaseDao<Project, Integer, ProjectExample> {
}