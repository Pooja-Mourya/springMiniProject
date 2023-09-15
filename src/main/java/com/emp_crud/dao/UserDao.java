package com.emp_crud.dao;

import com.emp_crud.entity.UserEntity;

public interface UserDao {

	public int registerUser(UserEntity useer);
	
	public int userLogin(String email, String password);
}
