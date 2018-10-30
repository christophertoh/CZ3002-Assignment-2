<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="../cz3002/css/login.css">
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>Struts 2 Login Demo</title>
    </head>
    <body>
        <div id="wrapper">
        	<h1>Successful Login: Welcome <s:property value="username"></s:property>!</h1>
        </div>
    </body>
</html>