package com.example.demo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.vo.Page;
import com.example.demo.vo.UserGroupVo;

@Service
public class UserService{
	
	@Autowired
    RestTemplate restTemplate;
	
	@SuppressWarnings("rawtypes")
	public User insertUser(@RequestBody User user) {
		RequestEntity requestEntity=null;
		try {
			requestEntity = RequestEntity.post(new URI("http://demo-service/api/user/addUser"))
					                     .contentType(MediaType.APPLICATION_JSON)
					                     .accept(MediaType.APPLICATION_JSON)
					                     .body(user);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		return this.restTemplate.exchange(requestEntity, User.class).getBody();
	};

	public void deleteUser(@PathVariable("uid") String uid) {
		this.restTemplate.getForObject("http://demo-service/api/user/deleteUser/" + uid, void.class);
	};

	@SuppressWarnings("rawtypes")
	public User updateUser(@RequestBody User user) {
		RequestEntity requestEntity=null;
		try {
			requestEntity = RequestEntity.post(new URI("http://demo-service/api/user/updateUser"))
					                     .contentType(MediaType.APPLICATION_JSON)
					                     .accept(MediaType.APPLICATION_JSON)
					                     .body(user);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		return this.restTemplate.exchange(requestEntity, User.class).getBody();
	};

	public User findUserById(@PathVariable("uid") String id) {
		return this.restTemplate.getForObject("http://demo-service/api/user/" + id, User.class);
	};

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<User> findAllUserByPage(@RequestBody Page page){
		RequestEntity requestEntity=null;
		try {
			requestEntity = RequestEntity.post(new URI("http://demo-service/api/user/findAllUserByPage"))
					                     .contentType(MediaType.APPLICATION_JSON)
					                     .accept(MediaType.APPLICATION_JSON)
					                     .body(page);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		return this.restTemplate.exchange(requestEntity, List.class).getBody();
	};

	public UserGroupVo findUserGroupVo( String id) {
		return this.restTemplate.getForObject("http://demo-service/api/user/find/" + id, UserGroupVo.class);
		
	};

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> findUserByCondition( User user){
		RequestEntity requestEntity=null;
		try {
			requestEntity = RequestEntity.post(new URI("http://demo-service/api/user/findUserByCondition"))
					                     .contentType(MediaType.APPLICATION_JSON)
					                     .accept(MediaType.APPLICATION_JSON)
					                     .body(user);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		return this.restTemplate.exchange(requestEntity, List.class).getBody();
		
	};

	@SuppressWarnings("unchecked")
	public List<User> findAllUser(String name, String gid){
		return this.restTemplate.getForObject("http://demo-service/api/user/findAllUserByGroupId?gid=" + gid + "&name=" + name, List.class);
		
	};
  
	@SuppressWarnings("unchecked")
	public List<User> findAllUser(){
		return this.restTemplate.getForObject("http://demo-service/api/user/findAllUser", List.class);
	};
}
