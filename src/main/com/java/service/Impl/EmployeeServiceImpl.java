package service.Impl;

import mapper.EmployeeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Employee;
import pojo.EmployeeExample;
import service.IEmployeeService;

import java.util.List;

@Service("iEmployeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> searchByName(Employee employee) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        if (StringUtils.isNotEmpty(employee.getFirstName())){
            criteria.andFirstNameLike(employee.getFirstName());
        }
        if (StringUtils.isNotEmpty(employee.getLastName())){
            criteria.andLastNameLike(employee.getLastName());
        }
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        return employeeList;
    }

    public List<Employee> searchByProject(int projectId) {
        return null;
    }
}
