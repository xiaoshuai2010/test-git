<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工管理页面</title>
<style type="text/css">
  td{
    text-align: center;
  }
 
</style>
</head>
<body>
    <form action="employee?method=getEmployeeList" method="post">
	      姓名：<input type="text" name="name"> &nbsp;&nbsp;&nbsp;
	      性别：    男<input type="radio" name="sex" value="男">&nbsp;&nbsp;
	                      女<input type="radio" name="sex" value="女">&nbsp;&nbsp;
	  出生日期：开始<input type="date" name="bbirthday">&nbsp;&nbsp;
	                       结束<input type="date" name="ebirthday">&nbsp;&nbsp;<br/>
	  薪资： 起始<input type="number" name="bsalary">&nbsp;&nbsp;
	               结束<input type="number" name="esalary">
	               <input type="submit" value="提交"><input type="reset" value="提交">
    </form>
    <div>
       <button onclick="window.open('addEmployee.jsp')">添加</button>
    </div>
	<table width="800" border="1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>出生日期</th>
			<th>薪资</th>
			<th>兴趣爱好</th>
			<th>注册时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${empList}" var="emp">
			<tr>
				<td><c:out value="${emp.eid}"></c:out>  </td>
				<td><c:out value="${emp.name}"></c:out>  </td>
				<td><c:out value="${emp.sex}"></c:out>  </td>
				<td>
				   <%-- <c:out value="${emp.birthday}"></c:out> --%>
				   <fmt:formatDate value="${emp.birthday}" pattern="yyyy-MM-dd"/> 
				
				</td>
				<td><c:out value="${emp.salary}"></c:out>  </td>
				<td><c:out value="${emp.hobby}"></c:out>  </td>
				<td>
				<%-- <c:out value="${emp.registerTime}"></c:out> --%>
				<fmt:formatDate value="${emp.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
				  <a href="addEmployee.jsp">增加</a>
				  <a href="employee?method=deleteById&eid=${emp.eid}">删除</a>
				  <a href="employee?method=getEmployeeById&eid=${emp.eid}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>