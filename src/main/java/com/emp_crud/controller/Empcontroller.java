package com.emp_crud.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emp_crud.dao.EmpDao;
import com.emp_crud.dao.EmpDaoImpl;
import com.emp_crud.dao.UserDao;
import com.emp_crud.entity.EmpEntity;
import com.emp_crud.entity.UserEntity;

@Controller
public class Empcontroller {

	@Autowired
	private EmpDao EmpDao;
	@Autowired
	private UserDao userDao;
	@RequestMapping(path = "/home")
	public String home(Model m) {

		List<EmpEntity> list = EmpDao.getAllEmp();
		m.addAttribute("empList", list);
		return "home";
	}

	@RequestMapping(path = "/addEmp")
	public String addEmp() {
		return "add_emp";
	}
	
	
	@RequestMapping(path = "/createEmp", method = RequestMethod.POST)
	public String createEmp(@ModelAttribute EmpEntity emp, HttpSession session) {
		System.out.println(emp);

		int i = EmpDao.saveEmp(emp);
		session.setAttribute("msg", "User Register Sucessfully");
		return "redirect:/home";
	}

	@RequestMapping(path = "/editEmp/{id}")
	public String editEmp(@PathVariable int id, Model m) {
		EmpEntity emp = EmpDao.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit_emp";
	}
	
	@RequestMapping(path = "/updateEmp", method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute EmpEntity emp, HttpSession session) {
		
		EmpDao.update(emp);
		session.setAttribute("msg", "update Sucessfully");
		return "redirect:/home";
	}
	
	@RequestMapping(path = "/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		EmpDao.deleteEmp(id);
		session.setAttribute("msg", "delete Sucessfully");
		return "redirect:/home";
	}
	
	@RequestMapping(path = "/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(path = "/login")
	public String signup() {
		return "login";
	}
	
	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute UserEntity user, HttpSession session) {
		System.out.println(user);

		int i = userDao.registerUser(user);
		session.setAttribute("msg", "User Register Sucessfully");
		return "redirect:/home";
	}

}
