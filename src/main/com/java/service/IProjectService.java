package service;

import pojo.Projects;

import java.util.List;

public interface IProjectService {

    List<Projects> list();

    Projects selectById(int id);
}
