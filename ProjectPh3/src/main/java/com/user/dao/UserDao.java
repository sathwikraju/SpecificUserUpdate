package com.user.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.user.beans.User;

public class UserDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	public int update(User user) {
		String sql = "update Users set  uname=?, email=? where uid=?";
		int ans = template.update(sql, user.getUname(), user.getEmail(), user.getUid());
		return ans;
	}

	public int delete(int id) {
		String sql = "delete from Users where uid=?";
		int ans = template.update(sql, id);
		return ans;
	}

	public User getUserId(int id) {
		String sql = "select * from Users where uid=?";
		List<User> users = template.query(sql, new Object[]{id}, new UserMapper());
		if (users.isEmpty()) {
            return null; // User not found
        } else {
            return users.get(0); // Return the first user in the list (assuming uid is unique)
        }
	}

	public List<User> getUserDetails() {
		String sql = "select * from Users";
		List<User> userList = template.query(sql, new UserMapper());
		return userList;
	}

}