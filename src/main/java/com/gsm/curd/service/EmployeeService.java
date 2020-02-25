package com.gsm.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.curd.bean.Employee;
import com.gsm.curd.dao.EmployeeMapper;

@Controller
public class EmployeeService {
	
	@Autowired
	EmployeeMapper empMapper;
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Employee> getAll(){
		return empMapper.selectByExampleWithDept(null);
	}
}
