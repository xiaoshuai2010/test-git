package com.xxs.test;

import java.util.List;

import org.junit.Test;

import com.xxs.pojo.Employee;
import com.xxs.service.EmployeeService;
import com.xxs.service.impl.EmployeeServiceImpl;

public class EmployeeTest {
  EmployeeService empService=new EmployeeServiceImpl();
  
  @Test
  public void test() {
	  System.out.println((long)'ÄÐ');
	  System.out.println((long)'Å®');
  }
  //@Test
  public void testGetList() {
	  List<Employee> empList=empService.getEmployeeList(null);
	  for(Employee emp:empList) {
		  System.out.println(emp);
	  }
  }
}
