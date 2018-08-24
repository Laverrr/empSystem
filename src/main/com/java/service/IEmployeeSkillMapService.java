package service;

import pojo.EmployeeSkillMap;

import java.util.List;

/**
 * Created by L on 2018/8/23.
 */
public interface IEmployeeSkillMapService {

    List<EmployeeSkillMap> selectByEmployeeId(String id);
}
