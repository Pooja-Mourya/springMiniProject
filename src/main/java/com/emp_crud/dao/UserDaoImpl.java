package com.emp_crud.dao;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emp_crud.entity.UserEntity;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired

	private HibernateTemplate hibernateTemplate;
	@Override
	public int registerUser(UserEntity user) {
		// TODO Auto-generated method stub
		int i = (Integer) hibernateTemplate.save(user);
		return i;
	}

	@Override
	public int userLogin(String email, String password) {
		// TODO Auto-generated method stub
//		String sql = "from user where email=:em and password=:pa";
//		
//		UserEntity se = (UserEntity) hibernateTemplate.execute( s-> {
//			Query q = s.createQuery(sql);
//			q.setString("em", email);
//			q.setString("pa", password);
//			return q.unidueResult();
//		}) ;
//		return se;
		int i = 0;
		return i ;
		
	}
	

}
