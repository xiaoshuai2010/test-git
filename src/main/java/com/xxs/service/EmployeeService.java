package com.xxs.service;

import java.util.List;
import java.util.Map;

import com.xxs.pojo.Employee;
import com.xxs.utils.PageInfo;

public interface EmployeeService {
	/**
	 * ����������ѯEmployee��Ϣ
	 * @param map
	 * @return
	 */
	public List<Employee> getEmployeeList(Map map);
	
	/**
	 * ��ҳ��ѯ
	 * @param map
	 * @return
	 */
	public PageInfo getEmployeeListPage(Map map) ;
	/**
	 * ����Ա����Ų�ѯԱ����Ϣ
	 * @param eid
	 * @return
	 */
	public Employee getEmployeeById(int eid);
	
	/**
	 * ���Ա��
	 * @param employee
	 * @return
	 */
	public int addEmployee(Employee employee);
	/**
	 * ɾ��Ա��
	 * @param eid
	 * @return
	 */
	public int deleteEmployee(int eid);
	
	/**
	 * ����ɾ��Ա��
	 * @param eids
	 * @return
	 */
	public int deleteEmployees(int[] eids);
	
	/**
	 * �޸�Ա����Ϣ
	 * @param employee
	 * @return
	 */
	public int updateEmployee(Employee employee);
}
