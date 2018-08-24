package service.Impl;

import mapper.EmployeeSkillMapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EmployeeSkillMap;
import pojo.EmployeeSkillMapExample;
import service.IEmployeeSkillMapService;

import java.util.List;

/**
 * Created by L on 2018/8/23.
 */
@Service("iEmployeeSkillMapService")
public class EmployeeSkillMapServiceImpl implements IEmployeeSkillMapService {

    @Autowired
    private EmployeeSkillMapMapper employeeSkillMapMapper;

    public List<EmployeeSkillMap> selectByEmployeeId(String id) {
        EmployeeSkillMapExample employeeSkillMapExample = new EmployeeSkillMapExample();
        EmployeeSkillMapExample.Criteria criteria = employeeSkillMapExample.createCriteria();
        criteria.andEmployeeIdEqualTo(id);
        List<EmployeeSkillMap> employeeSkillMaps = employeeSkillMapMapper.selectByExample(employeeSkillMapExample);
        return employeeSkillMaps;
    }
}
