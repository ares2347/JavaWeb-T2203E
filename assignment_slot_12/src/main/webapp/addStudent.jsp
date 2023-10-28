<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add New Student</title>
    <style>html{background-color: white;}</style>
</head>
<body>
<h1>Add new student</h1>
<form method='post' action='${pageContext.request.contextPath}/list-student'>
<input name='name' type='text'/>
<input name='birthyear' type='number' min='1900' max='2099' step='1'/>
<input name='phone' type='tel'/>
<input type='submit'/>
</form>
</body>
</html>