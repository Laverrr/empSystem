package service.Impl;

import mapper.EmployeeMapper;
import mapper.EmployeeProjectMapMapper;
import mapper.EmployeeSkillMapMapper;
import mapper.ProjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;
import service.IEmployeeProjectMapService;
import service.IEmployeeSkillMapService;
import service.ISkillService;
import vo.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by L on 2018/8/23.
 */
@Service("iEmployeeProjectMapService")
public class EmployeeProjectMapServiceImpl implements IEmployeeProjectMapService {


    @Autowired
    private EmployeeProjectMapMapper employeeProjectMapMapper;

    @Autowired
    private ProjectsMapper projectsMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private IEmployeeSkillMapService iEmployeeSkillMapService;

    @Autowired
    private ISkillService iSkillService;



    public List<EmployeeProjectMap> selectByEmployeeIdAndProjectId(String employeeId,String projectId) {
        EmployeeProjectMapExample employeeProjectMapExample = new EmployeeProjectMapExample();
        EmployeeProjectMapExample.Criteria criteria = employeeProjectMapExample.createCriteria();
        if (employeeId!=null){
            criteria.andEmployeeIdEqualTo(employeeId);
        }
        if (projectId!=null){
            criteria.andProjectIdEqualTo(projectId);
        }
        List<EmployeeProjectMap> employeeProjectMaps = employeeProjectMapMapper.selectByExample(employeeProjectMapExample);
        return employeeProjectMaps;
    }

    public Set<String> selectProjectIdsByEmployeeId(String id) {
        List<EmployeeProjectMap> employeeProjectMaps = selectByEmployeeIdAndProjectId(id,null);
        Set<String> ProjectIds=new HashSet<String>();
        for (EmployeeProjectMap e:employeeProjectMaps){
            ProjectIds.add(e.getProjectId());
        }
        return ProjectIds;
    }

    public EmployeeDetailVo getEmployeeDetailVo(String id) {
        Employee employee = employeeMapper.selectByPrimaryKey(Integer.parseInt(id));
        List<EmployeeSkillMap> employeeSkillMaps = iEmployeeSkillMapService.selectByEmployeeId(id);
        List<EmployeeSkillMapVo> employeeSkillMapVoList = getEmployeeSkillMapVoList(employeeSkillMaps);
        EmployeeDetailVo employeeDetailVo = assembleEmployeeDetailVo(employee,getEmployeeProjectDetails(id),employeeSkillMapVoList);
        return employeeDetailVo;
    }

    public List<ProjectRole> getProjectRoles(String employeeId,String projectId){
        List<EmployeeProjectMap> employeeProjectMaps = selectByEmployeeIdAndProjectId(employeeId, projectId);
        List<ProjectRole> projectRoleList=new ArrayList<ProjectRole>();
        for (EmployeeProjectMap e:employeeProjectMaps){
            projectRoleList.add(assembleProjectRole(e));
        }
        return projectRoleList;
    }

    ProjectRole assembleProjectRole(EmployeeProjectMap employeeProjectMap){
        ProjectRole projectRole = new ProjectRole();
        projectRole.setID(Long.parseLong(employeeProjectMap.getEmployeeId()));
        projectRole.setRole(employeeProjectMap.getEmployeeRole());
        projectRole.setStartDate(employeeProjectMap.getStartDate());
        projectRole.setEndDate(employeeProjectMap.getEndDate());
        return projectRole;
    }

    List<EmployeeProjectDetail> getEmployeeProjectDetails(String id){
        List<EmployeeProjectDetail> employeeProjectDetails=new ArrayList<EmployeeProjectDetail>();
        Set<String> strings = selectProjectIdsByEmployeeId(id);
        for (String s:strings){
            Projects project = projectsMapper.selectByPrimaryKey(Integer.parseInt(s));
            EmployeeProjectDetail employeeProjectDetail = assembleEmployeeProjectDetail(project, getProjectRoles(id,String.valueOf(project.getId())));
            employeeProjectDetails.add(employeeProjectDetail);
        }
        return employeeProjectDetails;
    }

    EmployeeSkillMapVo assembleEmployeeSkillMapVo(EmployeeSkillMap employeeSkillMap){
        EmployeeSkillMapVo employeeSkillMapVo = new EmployeeSkillMapVo();
        employeeSkillMapVo.setRating(employeeSkillMap.getRating());
        Skill skill = iSkillService.selectById(Integer.parseInt(employeeSkillMap.getSkillId()));
        employeeSkillMapVo.setName(skill.getName());
        employeeSkillMapVo.setDescription(skill.getDescription());
        return employeeSkillMapVo;
    }

    List<EmployeeSkillMapVo> getEmployeeSkillMapVoList(List<EmployeeSkillMap> employeeSkillMaps){
        List<EmployeeSkillMapVo> employeeSkillMapVoList=new ArrayList<EmployeeSkillMapVo>();
        for (EmployeeSkillMap e:employeeSkillMaps){
            employeeSkillMapVoList.add( assembleEmployeeSkillMapVo(e));
        }
        return employeeSkillMapVoList;
    }

    EmployeeDetail assembleEmployeeDetail(Employee employee, List<EmployeeProjectDetail> projectList, List<EmployeeSkillMap> skillList){
        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setEmployee(employee);
        employeeDetail.setProjectList(projectList);
        employeeDetail.setSkillList(skillList);
        return employeeDetail;
    }

    EmployeeDetailVo assembleEmployeeDetailVo(Employee employee, List<EmployeeProjectDetail> projectList, List<EmployeeSkillMapVo> skillList){
        EmployeeDetailVo employeeDetailVo = new EmployeeDetailVo();
        employeeDetailVo.setEmployee(employee);
        employeeDetailVo.setProjectList(projectList);
        employeeDetailVo.setSkillList(skillList);
        return employeeDetailVo;
    }



    EmployeeProjectDetail assembleEmployeeProjectDetail(Projects project, List<ProjectRole> projectRoles){
        EmployeeProjectDetail employeeProjectDetail = new EmployeeProjectDetail();
        employeeProjectDetail.setProject(project);
        employeeProjectDetail.setProjectRoles(projectRoles);
        return employeeProjectDetail;
    }
}
