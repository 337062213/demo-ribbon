package com.example.demo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Group;
import com.example.demo.vo.GroupUserVo;

@Service
public class GroupService {
	
	@Autowired
    RestTemplate restTemplate;

	public Group findGroupById( String id) {
		return this.restTemplate.getForObject("http://demo-service/api/group/" + id,Group.class);
	};
	
	@SuppressWarnings("rawtypes")
	public Group addGroup( Group group) {
		RequestEntity requestEntity=null;
		try {
			requestEntity = RequestEntity.post(new URI("http://demo-service/api/group/add"))
					                     .contentType(MediaType.APPLICATION_JSON)
					                     .accept(MediaType.APPLICATION_JSON)
					                     .body(group);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		return this.restTemplate.exchange(requestEntity, Group.class).getBody();
	};
	
	@SuppressWarnings("rawtypes")
	public Group updateGroup( Group group) {
		RequestEntity requestEntity=null;
		try {
			requestEntity = RequestEntity.post(new URI("http://demo-service/api/group/update"))
					                     .contentType(MediaType.APPLICATION_JSON)
					                     .accept(MediaType.APPLICATION_JSON)
					                     .body(group);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		return this.restTemplate.exchange(requestEntity, Group.class).getBody();
	};
	
	public Void deleteGroup(String id) {
		return this.restTemplate.getForObject("http://demo-service/api/group/delete/" + id, void.class);
	};
	
	@SuppressWarnings("unchecked")
	public List<Group> findAllGroup(){
		return this.restTemplate.getForObject("http://demo-service/api/group/", List.class);
	};

	public GroupUserVo findGroupUsersByGid( String id) {
		return this.restTemplate.getForObject("http://demo-service/api/group/find/" + id, GroupUserVo.class);
	};
}
