package service;

import pojo.EmployeeProjectMap;
import vo.EmployeeDetail;
import vo.EmployeeDetailVo;
import vo.EmployeeProjectDetail;

import java.util.List;
import java.util.Set;

/**
 * Created by L on 2018/8/23.
 */
public interface IEmployeeProjectMapService {
    List<EmployeeProjectMap> selectByEmployeeIdAndProjectId(String employeeId,String projectId);

    Set<String> selectProjectIdsByEmployeeId(String id);

    EmployeeDetailVo getEmployeeDetailVo(String id);



}
