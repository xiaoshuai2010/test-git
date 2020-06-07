package com.xxs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xxs.pojo.Employee;

public interface EmployeeMapper {

	/**
	 * ����������ѯEmployee��Ϣ
	 * @param map
	 * @return
	 */
	public List<Employee> getEmployeeList(Map map);
	
	/**
	 * ����Ա����Ų�ѯԱ����Ϣ
	 * @param eid
	 * @return
	 */
	public Employee getEmployeeById(@Param("eid")int eid);
	
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
	 * @param: ���������뵽map�У��ṩ��mybatis����
	 */
	public int deleteEmployee(@Param("eid")int eid);
	
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
	
	public List<Employee> selectPage(Map map);
	
	public int getCount(Map map);
}
