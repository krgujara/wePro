package com.ip.wePro.skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    @RequestMapping(value = "/skills/all", method = RequestMethod.GET)
    List<Skills> getAllSkills(){
        return skillsService.getAllSkills();
    }
}
