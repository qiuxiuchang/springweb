<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <a href="wellcome3/niaifd">测试</a>
    
    <form action="wellcome" method="post"> 
       <input  name="name" >
       <input type="submit" value="dfsf">
    </form>
    
    <form action="wellcome" method="post"> 
    <!-- 这种方式一定要配置过滤器，隐藏域的值是put或delete，且请求方式是post，后面响应的是delete或put请求方式 -->
       <input type="hidden" value="delete">
       <input type="submit" value="dfsf">
    </form>
    <form action="wellcome" method="post"> 
    <!-- 隐藏域的值是put或delete，且请求方式是post，后面响应的是value所对应的 put请求方式 -->
       <input type="hidden" value="put">
       <input type="submit" value="dfsf">
    </form>
    
    
    <form action="wellcome7" method="post" >
    学号    <input type="text" name="stuno">
    姓名    <input type="text" name="stuname">
    年龄    <input type="text" name="stuage">
    地址    <input type="text" name="address.homeaddress">
        <input type="text" name="address.schooladdress">
        <input type="submit">
    </form>
    
    <a href="wellcome9">测试ModelAndView</a>
</body>
</html>