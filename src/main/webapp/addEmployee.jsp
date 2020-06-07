<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form{
    margin:0 auto;
    border:1px solid red;
    width:800px;
  }
</style>
</head>
<body>
  <h1>新增页面</h1>
    <form action="" method="post">
   员工姓名:<input type="text" name="name"><p/>
   员工性别：男<input type="radio" name="sex" value="男" >&nbsp;&nbsp;
   女<input type="radio" name="sex" value="女" ><p/>
   出生日期：<input type="date" name="birthday" pattern="yyyy-MM-dd"><p/>
  薪资水平：<input type="number" name="salary"><p/>
  兴趣爱好：游泳<input type="checkbox" name="hobby" value="游泳">&nbsp;&nbsp;
  逛街<input type="checkbox" name="hobby" value="逛街" >&nbsp;&nbsp;
 音乐 <input type="checkbox" name="hobby" value="音乐">&nbsp;&nbsp;
  读书<input type="checkbox" name="hobby" value="读书">&nbsp;&nbsp;
  写代码<input type="checkbox" name="hobby" value="写代码">&nbsp;&nbsp;
  爬山<input type="checkbox" name="hobby" value="爬山" >&nbsp;&nbsp;
  摄影<input type="checkbox" name="hobby" value="摄影" >&nbsp;&nbsp;<p/>
  注册时间<input type="datetime" name="registerTime" pattern="yyyy-MM-dd HH:dd:ss">
  <input type="submit" value="提交"><input type="reset" value="重置">
  </form>
</body>
</html>