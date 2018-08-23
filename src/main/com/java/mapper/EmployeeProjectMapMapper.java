package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.EmployeeProjectMap;
import pojo.EmployeeProjectMapExample;

public interface EmployeeProjectMapMapper {
    int countByExample(EmployeeProjectMapExample example);

    int deleteByExample(EmployeeProjectMapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeProjectMap record);

    int insertSelective(EmployeeProjectMap record);

    List<EmployeeProjectMap> selectByExample(EmployeeProjectMapExample example);

    EmployeeProjectMap selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeProjectMap record, @Param("example") EmployeeProjectMapExample example);

    int updateByExample(@Param("record") EmployeeProjectMap record, @Param("example") EmployeeProjectMapExample example);

    int updateByPrimaryKeySelective(EmployeeProjectMap record);

    int updateByPrimaryKey(EmployeeProjectMap record);
}