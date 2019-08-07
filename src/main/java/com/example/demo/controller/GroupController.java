package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Group;
import com.example.demo.service.GroupService;
import com.example.demo.vo.GroupUserVo;

@RestController
@RequestMapping(value="group")
public class GroupController {
	
	@Autowired
    GroupService iGroupService;

    @GetMapping("/{id}")
    public Group findGroupById(@PathVariable("id") String gid) {
        Group group = iGroupService.findGroupById(gid);
        return group;
    }

    @PostMapping("/add")
    public Group addGroup(@RequestBody Group group) {
        return iGroupService.addGroup(group);
    }

    @PostMapping("/update")
    public Group updateGroup(@RequestBody Group group) {
        return iGroupService.updateGroup(group);
    }

    @GetMapping("/delete/{id}")
    public void deleteGroup(@PathVariable("id") String gid) {
    	iGroupService.deleteGroup(gid);
    }

    @GetMapping("")
    public List<Group> findAllGroup() {
        List<Group> groups = iGroupService.findAllGroup();
        return groups;
    }

    @GetMapping("/find/{id}")
    public GroupUserVo findGroupUsersByGid(@PathVariable("id") String gid) {
        GroupUserVo groupUserVo = iGroupService.findGroupUsersByGid(gid);
        return groupUserVo;
    }

}
