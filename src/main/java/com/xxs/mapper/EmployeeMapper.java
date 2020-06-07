package com.xxs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xxs.pojo.Employee;

public interface EmployeeMapper {

	/**
	 * 根据条件查询Employee信息
	 * @param map
	 * @return
	 */
	public List<Employee> getEmployeeList(Map map);
	
	/**
	 * 根据员工编号查询员工信息
	 * @param eid
	 * @return
	 */
	public Employee getEmployeeById(@Param("eid")int eid);
	
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
	 * @param: 将参数放入到map中，提供给mybatis处理
	 */
	public int deleteEmployee(@Param("eid")int eid);
	
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
	
	public List<Employee> selectPage(Map map);
	
	public int getCount(Map map);
}
