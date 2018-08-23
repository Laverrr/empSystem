package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.EmployeeSkillMap;
import pojo.EmployeeSkillMapExample;

public interface EmployeeSkillMapMapper {
    int countByExample(EmployeeSkillMapExample example);

    int deleteByExample(EmployeeSkillMapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeSkillMap record);

    int insertSelective(EmployeeSkillMap record);

    List<EmployeeSkillMap> selectByExample(EmployeeSkillMapExample example);

    EmployeeSkillMap selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeSkillMap record, @Param("example") EmployeeSkillMapExample example);

    int updateByExample(@Param("record") EmployeeSkillMap record, @Param("example") EmployeeSkillMapExample example);

    int updateByPrimaryKeySelective(EmployeeSkillMap record);

    int updateByPrimaryKey(EmployeeSkillMap record);
}