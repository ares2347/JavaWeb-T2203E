<%@ page import="com.example.assignment_slot_12.entity.StudentEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add New Student</title>
    <style>
        html {
            background-color: white;
        }

        table {
            border: 1px solid black;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid;
        }

        table th {
            width: 100px;
            padding: 5px 20px;
            text-align: center;
        }

        table th:last-child {
            width: 150px;
        }

        table td {
            padding: 2px 5px;
        }
    </style>
</head>
<body>
<h1>Student Listing</h1><br/>
<a href='${pageContext.request.contextPath}/add-student'>Add new student</a><br/>
<jsp:useBean id="students" scope="request" type="java.util.List"/>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Birth Year</th>
        <th>Phone Number</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<StudentEntity> studentsList = (List<StudentEntity>) students;
        for (StudentEntity student : studentsList) {

    %>
    <tr>
        <td><%= student.id %></td>
        <td><%= student.name %></td>
        <td><%= student.birthyear %></td>
        <td><%= student.phone %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>