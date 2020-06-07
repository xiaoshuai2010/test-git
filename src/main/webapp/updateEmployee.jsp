<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工信息修改</title>
<style>
  form{
    margin:0 auto;
     border:1px solid red;
     width:800px;
  }
</style>
</head>
<body>
  <h1>修改页面</h1>
  <form action="" method="post">
         员工编号：<input type="text" name="eid" value="${emp.eid }" readonly="readonly"><p/>
   员工姓名:<input type="text" name="name" value="${emp.name }"><p/>
   员工性别：男<input type="radio" name="sex" value="男"  ${emp.sex eq  30007 ?"checked":""}  >&nbsp;&nbsp;
   女<input type="radio" name="sex" value="女"   ${emp.sex eq  22899 ?"checked":""}><p/>
   出生日期：<input type="date" name="birthday" value='<fmt:formatDate value="${emp.birthday }" pattern="yyyy-MM-dd"/>'><p/>
  薪资水平：<input type="number" name="salary" value="${emp.salary }"><p/>
  兴趣爱好：游泳<input type="checkbox" name="hobby" value="游泳" ${emp.hobby.indexOf("游泳")>=0? "checked":""}>&nbsp;&nbsp;
  逛街<input type="checkbox" name="hobby" value="逛街" ${emp.hobby.indexOf("逛街")>=0? "checked":""}>&nbsp;&nbsp;
 音乐 <input type="checkbox" name="hobby" value="音乐" ${emp.hobby.indexOf("音乐")>=0? "checked":""}>&nbsp;&nbsp;
  读书<input type="checkbox" name="hobby" value="读书" ${emp.hobby.indexOf("读书")>=0? "checked":""}>&nbsp;&nbsp;
  写代码<input type="checkbox" name="hobby" value="写代码" ${emp.hobby.indexOf("写代码")>=0? "checked":""}>&nbsp;&nbsp;
  爬山<input type="checkbox" name="hobby" value="爬山" ${emp.hobby.indexOf("爬山")>=0? "checked":""}>&nbsp;&nbsp;
  摄影<input type="checkbox" name="hobby" value="摄影" ${emp.hobby.indexOf("摄影")>=0? "checked":""}>&nbsp;&nbsp;<p/>
  注册时间<input type="datetime" name="registerTime"  value='<fmt:formatDate value="${emp.registerTime }" pattern="yyyy-MM-dd HH:dd:ss"/>'>
  <input type="submit" value="提交"><input type="reset" value="重置">
  </form>
</body>
</html>