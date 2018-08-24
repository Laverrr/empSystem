package service.Impl;

import mapper.EmployeeMapper;
import mapper.EmployeeProjectMapMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;
import service.IEmployeeService;
import vo.EmployeeDetail;
import vo.EmployeeProjectDetail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("iEmployeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeProjectMapMapper employeeProjectMapMapper;

    public List<Employee> searchByName(Employee employee) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        if (StringUtils.isNotEmpty(employee.getFirstName())){
            criteria.andFirstNameLike("%"+employee.getFirstName()+"%");
        }
        if (StringUtils.isNotEmpty(employee.getLastName())){
            criteria.andLastNameLike("%"+employee.getLastName()+"%");
        }
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        return employeeList;
    }

    public Set<Employee> searchByProjectId(String projectId) {
        EmployeeProjectMapExample employeeProjectMapExample = new EmployeeProjectMapExample();
        EmployeeProjectMapExample.Criteria criteria = employeeProjectMapExample.createCriteria();
        criteria.andProjectIdEqualTo(projectId);
        List<EmployeeProjectMap> employeeProjectMaps = employeeProjectMapMapper.selectByExample(employeeProjectMapExample);
        HashSet<Employee> employeeHashSet = new HashSet<Employee>();
        for (EmployeeProjectMap e:employeeProjectMaps){
            employeeHashSet.add(employeeMapper.selectByPrimaryKey(Integer.parseInt(e.getEmployeeId())));
        }
        return employeeHashSet;
    }

    public Employee selectById(int id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }


}
