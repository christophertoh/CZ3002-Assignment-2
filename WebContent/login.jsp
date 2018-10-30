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
	        <h1>Login Form</h1>
	        <s:property value="resultsMsg" /><br/>
	        <s:text name = "Please enter your credentials below:" />
		    <s:form action="home" method="post">
		        <s:textfield label="Username" name="username"></s:textfield>
		        <s:textfield label="Password" name="password" type="password"></s:textfield>
		        <s:submit value="Login"></s:submit>
		    </s:form>
	    </div>
    </body>
</html>