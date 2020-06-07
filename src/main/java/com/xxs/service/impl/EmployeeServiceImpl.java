package com.xxs.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.xxs.mapper.EmployeeMapper;
import com.xxs.pojo.Employee;
import com.xxs.service.EmployeeService;
import com.xxs.utils.DBUtil;
import com.xxs.utils.PageInfo;

public class EmployeeServiceImpl implements EmployeeService {
    
	/**
	 *     列表和条件查询
	 */
	public List<Employee> getEmployeeList(Map map) {
		SqlSession session=DBUtil.createSqlSession();
		List<Employee> empList=session.selectList("com.xxs.mapper.EmployeeMapper.getEmployeeList",map);
		return empList;
	}

	/**
	 *     分页查询
	 */
	public PageInfo getEmployeeListPage(Map map) {
		SqlSession session=DBUtil.createSqlSession();
		//数据集合
		List<Employee> empList=session.getMapper(EmployeeMapper.class).selectPage(map);
		//总条数
		int count=session.getMapper(EmployeeMapper.class).getCount(map);
		//起始
		PageInfo pageInfo=new PageInfo();
		pageInfo.setList(empList);
		pageInfo.setTotal(count%pageInfo.getPageSize()==0?count/pageInfo.getPageSize():count/pageInfo.getPageSize()+1);
		pageInfo.setPageNum((Integer) map.get("pageNum"));
		return pageInfo;
	}
	
	/**
	 * 根据编号找到对应的员工对象
	 */
	public Employee getEmployeeById(int eid) {
	   SqlSession session=DBUtil.createSqlSession();
	   Employee employee=(Employee) session.getMapper(EmployeeMapper.class).getEmployeeById(eid);
		return employee;
	}

	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		SqlSession session=DBUtil.createSqlSession();
		int result=session.getMapper(EmployeeMapper.class).addEmployee(employee);
		session.commit();
		return result;
	}

	public int deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		SqlSession session=DBUtil.createSqlSession();
		int result=session.getMapper(EmployeeMapper.class).deleteEmployee(eid);
		session.commit();
		return result;
		
	}

	public int deleteEmployees(int[] eids) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		SqlSession session=DBUtil.createSqlSession();
		int result=session.getMapper(EmployeeMapper.class).updateEmployee(employee);
		session.commit();
		return result;
	}

}
