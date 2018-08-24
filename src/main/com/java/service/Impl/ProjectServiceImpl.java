package service.Impl;

import mapper.ProjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Projects;
import pojo.ProjectsExample;
import service.IProjectService;

import java.util.List;

@Service("iProjectService")
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectsMapper projectsMapper;


    public List<Projects> list() {
        return projectsMapper.selectByExample(new ProjectsExample());
    }

    public Projects selectById(int id) {
        return projectsMapper.selectByPrimaryKey(id);
    }
}
