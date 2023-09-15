package com.emp_crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.emp_crud.entity.EmpEntity;

@Repository

public class EmpDaoImpl implements EmpDao {

	@Autowired
	private HibernateTemplate hibernateTemplate ;

	@Transactional
	public int saveEmp(EmpEntity emp) {
		// TODO Auto-generated method stub
		int i = (Integer) hibernateTemplate.save(emp);

		return i;
	}

	@Override
	public EmpEntity getEmpById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpEntity> getAllEmp() {
		// TODO Auto-generated method stub
		List<EmpEntity> list = hibernateTemplate.loadAll(EmpEntity.class);
		return list;
	}

	
	
	@Transactional
	public void update(EmpEntity emp) {
		hibernateTemplate.update(emp);

	}

	@Transactional
	public void deleteEmp(int id) {
		EmpEntity emp = hibernateTemplate.get(EmpEntity.class, id);
		hibernateTemplate.delete(emp);
	}
}
