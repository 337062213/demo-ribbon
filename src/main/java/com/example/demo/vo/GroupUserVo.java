package com.example.demo.vo;

import java.io.Serializable;
import java.util.List;

import com.example.demo.entity.User;

public class GroupUserVo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -384974392916530346L;

	private String id;

    private String groupName;

    private List<User> users;

    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
