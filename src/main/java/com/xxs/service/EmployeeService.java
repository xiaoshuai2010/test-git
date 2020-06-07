package com.xxs.service;

import java.util.List;
import java.util.Map;

import com.xxs.pojo.Employee;
import com.xxs.utils.PageInfo;

public interface EmployeeService {
	/**
	 * 根据条件查询Employee信息
	 * @param map
	 * @return
	 */
	public List<Employee> getEmployeeList(Map map);
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public PageInfo getEmployeeListPage(Map map) ;
	/**
	 * 根据员工编号查询员工信息
	 * @param eid
	 * @return
	 */
	public Employee getEmployeeById(int eid);
	
	/**
	 * 添加员工
	 * @param employee
	 * @return
	 */
	public int addEmployee(Employee employee);
	/**
	 * 删除员工
	 * @param eid
	 * @return
	 */
	public int deleteEmployee(int eid);
	
	/**
	 * 批量删除员工
	 * @param eids
	 * @return
	 */
	public int deleteEmployees(int[] eids);
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 */
	public int updateEmployee(Employee employee);
}
