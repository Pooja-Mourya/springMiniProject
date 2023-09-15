package com.emp_crud.dao;

import java.util.List;

import com.emp_crud.entity.EmpEntity;

public interface EmpDao {

	public int saveEmp(EmpEntity emp);

	public EmpEntity getEmpById(int id);

	public List<EmpEntity> getAllEmp();

	public void update(EmpEntity emp);

	public void deleteEmp(int id);
}
