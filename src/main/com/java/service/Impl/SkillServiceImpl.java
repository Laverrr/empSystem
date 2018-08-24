package service.Impl;

import mapper.SkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Skill;
import service.ISkillService;

/**
 * Created by L on 2018/8/24.
 */
@Service("iSkillService")
public class SkillServiceImpl implements ISkillService {

    @Autowired
    private SkillMapper skillMapper;

    public Skill selectById(int id) {

        Skill skill = skillMapper.selectByPrimaryKey(id);
        return skill;
    }
}
