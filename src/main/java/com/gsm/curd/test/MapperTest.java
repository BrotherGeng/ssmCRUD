package com.gsm.curd.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsm.curd.bean.Department;
import com.gsm.curd.bean.Employee;
import com.gsm.curd.dao.DepartmentMapper;
import com.gsm.curd.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * @author Administrator
 *1、使用spring的单元测试，可以自动注入需要的组件
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件即可
 *导入
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper mapper;
	@Autowired
	EmployeeMapper empMapper;
	@Autowired
	SqlSession sqlSession;
	@Test
	public void test() {
		System.out.println(mapper);	
//		Department dept = new Department();
//		dept.setDeptId(01);
//		Department selectByPrimaryKey = mapper.selectByPrimaryKey(02);
//		System.out.println(selectByPrimaryKey);
		System.out.println(empMapper.selectByExampleWithDept(null));
//		EmployeeMapper mapper2 = sqlSession.getMapper(EmployeeMapper.class);
//		for (int i = 0; i < 1000; i++) {
//			String substring = UUID.randomUUID().toString().substring(0, 5);
//			mapper2.insertSelective(new Employee(null, substring, "M",substring+"aa@qq.com", 2, null));
//		}
//		System.out.println("批量操作完成");
	}
}
