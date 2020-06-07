package com.xxs.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxs.pojo.Employee;
import com.xxs.service.EmployeeService;
import com.xxs.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeServelt
 */
public class EmployeeServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 EmployeeService empService=null;
	 
	 public void init() {
		 empService=new EmployeeServiceImpl();
	 }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("getEmployeeList".equals(method)){
			this.getEmployeeList(request, response);
		}else if("deleteById".equals(method)){
			this.deleteById(request, response);
		}else if("updateEmployee".equals(method)){
			this.updateEmployee(request, response);
		}else if("getEmployeeById".equals(method)){
			this.getEmployeeById(request, response);
		}else if("".equals(method)){
			
		}else {
			System.out.println("暂时还没有此实现方法");
		}
	}
	
	protected void getEmployeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//第二步：多条件查询
		//1. 定义map来封装查询条件
		Map<String,Object> map=new HashMap<String,Object>();
		String name=request.getParameter("name");
		System.out.println("name:"+name);
		if(name!=null&&!name.equals("")) {
			map.put("name", name);
		}
		String sexStr=request.getParameter("sex");
		if(sexStr!=null && !sexStr.equals("")) {
			//判断是否非空，将字符串的第一个值截取成字符
			map.put("sex", sexStr.charAt(0));
		}
		String bbirthdayStr=request.getParameter("bbirthday");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if( bbirthdayStr!=null&& !bbirthdayStr.equals("")) {
			//日期转换
			try {
				map.put("bbirthday",sdf.parse(bbirthdayStr));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String ebirthdayStr=request.getParameter("ebirthday");
		if(ebirthdayStr!=null&&!ebirthdayStr.equals("")) {
			try {
				map.put("ebirthday",sdf.parse(ebirthdayStr));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String bsalaryStr=request.getParameter("bsalary");
		if( bsalaryStr!=null&&!bsalaryStr.equals("") ) {
			map.put("bsalary",Double.parseDouble(bsalaryStr));
		}
		String esalarySgr=request.getParameter("esalary");
		if( esalarySgr!=null&& !esalarySgr.equals("")) {
			map.put("esalary",Double.parseDouble(esalarySgr));
		}
		
		//第一步：基础查询列表
		List<Employee> empList=empService.getEmployeeList(map);
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("/employee.jsp").forward(request, response);
	}
	
	protected void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eidStr=request.getParameter("eid");
		
		if(null!=eidStr&&!eidStr.equals("")) {
			int result=empService.deleteEmployee(Integer.parseInt(eidStr));
			request.getRequestDispatcher("/employeePage?method=getEmployeeList").forward(request, response);
		}else {
			System.out.println("请输入有效的职员编号");
		}
	}
	protected void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eidStr=request.getParameter("eid");
		String name=request.getParameter("name");
		String sexStr=request.getParameter("sex");
		String birthdayStr=request.getParameter("birthday");
		String salaryStr=request.getParameter("salary");
		String[] hobby=request.getParameterValues("hobby");
		
		Employee employee =new Employee();
		if(eidStr!=null && !eidStr.equals("")) {
			employee.setEid(Integer.parseInt(eidStr));
		}
		if(name!=null && !name.equals("")) {
			employee.setName(name);
		}
		if(sexStr!=null && !sexStr.equals("")) {
			employee.setSex(sexStr.charAt(0));
		}
		if(salaryStr!=null && !salaryStr.equals("")) {
			employee.setSalary(Double.parseDouble(salaryStr));
		}
		if(birthdayStr!=null && !birthdayStr.equals("")) {
			employee.setBirthday(new Date(salaryStr));
		}
		if(hobby!=null && hobby.length>0) {
			String str="";
			for(int i=0;i<hobby.length;i++) {
				if(i==hobby.length-1) {
					str+=hobby[i]+",";
				}else {
					str+=hobby[i];
				}
				
			}
			employee.setHobby(str);
		}
		int result=empService.updateEmployee(employee);
		response.sendRedirect("employee?method=getEmployeeList");
		
	}
	protected void getEmployeeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eidStr=request.getParameter("eid");
		int eid=0;
		if(eidStr!=null && !eidStr.equals("")) {
			eid=Integer.parseInt(eidStr);
		}
		Employee employee=empService.getEmployeeById(eid);
		request.setAttribute("emp", employee);
		request.getRequestDispatcher("updateEmployee.jsp").forward(request, response);
	}
	
}
