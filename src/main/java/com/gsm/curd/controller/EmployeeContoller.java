package com.gsm.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.curd.bean.Employee;
import com.gsm.curd.bean.Msg;
import com.gsm.curd.dao.EmployeeMapper;
import com.gsm.curd.service.EmployeeService;

/**
 * 处理员工的curd请求
 * @author Administrator
 *
 */
@Controller
public class EmployeeContoller {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeMapper empMapper;
	
	/**
	 * c
	 * 
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
		//这不是一个分页查询
		//引入pageHelper插件
		//在查询之前只需要调用PageHelper.startPage，传入页码和每页大小
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> empList = employeeService.getAll();		
		//使用pageInfo包装查询的结果，只需要将pageInfo交给页面就行了
		//封装了详细的分页信息，包括查询出来的数据，传入连续显示的页数 
		PageInfo pageInfo =  new PageInfo(empList,5);
		Msg msg = new Msg();
		return msg.success().add("page", pageInfo);
	}
	
	/**
	 * 查询员工数据
	 * @return
	 */
	@RequestMapping("/empssss")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		//这不是一个分页查询
		//引入pageHelper插件
		//在查询之前只需要调用PageHelper.startPage，传入页码和每页大小
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> empList = employeeService.getAll();		
		//使用pageInfo包装查询的结果，只需要将pageInfo交给页面就行了
		//封装了详细的分页信息，包括查询出来的数据，传入连续显示的页数 
		PageInfo pageInfo =  new PageInfo(empList,5);
		model.addAttribute("pageInfo", pageInfo);	
		return "list";
	}
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String addEmployee(Model model) {
		return "add";
	}
}
