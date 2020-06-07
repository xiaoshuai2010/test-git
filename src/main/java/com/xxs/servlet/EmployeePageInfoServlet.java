package com.xxs.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxs.service.EmployeeService;
import com.xxs.service.impl.EmployeeServiceImpl;
import com.xxs.utils.PageInfo;

@WebServlet("/employeePage")
public class EmployeePageInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     EmployeeService empService=null;
	 
	 public void init() {
		 empService=new EmployeeServiceImpl();
	 }
    
    public EmployeePageInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("getEmployeeList".equals(method)){
			this.getEmployeeList(request, response);
		}else if("".equals(method)){
			
		}else if("".equals(method)){
			
		}else if("".equals(method)){
			
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
		
		//填写分页相关的参数
		String pageNumStr=request.getParameter("pageNum");
		String pageSizeStr=request.getParameter("pageSize");
		int pageSize=0;
		if( pageSizeStr!=null&& !pageSizeStr.equals("")) {
			pageSize=Integer.parseInt(pageSizeStr);
			
		}else {
			pageSize=new PageInfo().getPageSize();
		}
		map.put("pageSize", pageSize);
		int pageNum=1;
		if( pageNumStr!=null&& !pageNumStr.equals("")) {
			 pageNum=Integer.parseInt(pageNumStr);
		}
		map.put("pageNum", pageNum);
		map.put("beginNum",(pageNum-1)*pageSize);
		
		PageInfo pageInfo=empService.getEmployeeListPage(map);
		//System.out.println(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.getRequestDispatcher("/employeePage.jsp").forward(request, response);
	}


	
}
