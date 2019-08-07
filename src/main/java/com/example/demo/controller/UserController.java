package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.Page;
import com.example.demo.vo.UserGroupVo;

@RestController
@RequestMapping(value="user")
public class UserController {

	    @Autowired
        UserService iUserService;
	
	    @GetMapping("/{uid}")
	    public User findUserById(@PathVariable("uid") String uid) {
	        User user = iUserService.findUserById(uid);
	        if(null==user) {
	        	user= new User();
	        }
	        return user;
	    }

	    @PostMapping("/addUser")
	    public User addUser(@RequestBody User user) {
	        return iUserService.insertUser(user);

	    }

	    @PostMapping("/updateUser")
	    public User updateUser(@RequestBody User user) {
	        return iUserService.updateUser(user);
	    }

	    @GetMapping("/deleteUser/{uid}")
	    public void deleteUser(@PathVariable("uid") String uid) {
	    	iUserService.deleteUser(uid);

	    }

	    @GetMapping("/findAllUserByGroupId")
	    public List<User> findAllUser(@RequestParam(defaultValue = "") String name,
	                                  @RequestParam(defaultValue = "") String gid) {

	        List<User> users = iUserService.findAllUser(name,gid);
	        return users;

	    }
	    
	    
	    @PostMapping("/findAllUserByPage")
	    public List<User> findAllUserByPage(@RequestBody Page page) {
	    	
	        List<User> users = iUserService.findAllUserByPage(page);
	        return users;

	    }
	    
	    @GetMapping("/findAllUser")
	    public List<User> findAllUser() {
	    	
	        List<User> users = iUserService.findAllUser();
	        return users;

	    }

	    @GetMapping("/find/{uid}")
	    public UserGroupVo findUserGroupVo(@PathVariable("uid") String uid) {
	        UserGroupVo userGroupVo = iUserService.findUserGroupVo(uid);
	        return userGroupVo;
	    }

	    @PostMapping("/findUserByCondition")
	    public List<User> findUserByCondition(@RequestBody User user) {
	        return iUserService.findUserByCondition(user);
	    }
}
