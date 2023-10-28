<%@ page import="com.example.practical_exam.entity.EmployeeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: hoangtu.tran
  Date: 10/28/2023
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Listing</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            margin-top: 20px;
            background: #eee;
        }

        .table-nowrap .table td,
        .table-nowrap .table th {
            white-space: nowrap;
        }

        .table > :not(caption) > * > * {
            padding: 0.75rem 1.25rem;
            border-bottom-width: 1px;
        }

        table th {
            font-weight: 600;
            background-color: #eeecfd !important;
        }

    </style>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-12 mb-3 mb-lg-5">
            <div class="overflow-hidden card table-nowrap table-card">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="mb-0">Customers Listing</h5>
                    <a class="ml-auto p-2" href='${pageContext.request.contextPath}/employees-add'><i class="fa-solid fa-user-plus"></i></a><br/>
                </div>
                <div class="table-responsive">
                    <jsp:useBean id="employees" scope="request" type="java.util.List"/>
                    <table class="table mb-0">
                        <thead class="small text-uppercase bg-body text-muted">
                        <tr>
                            <th>ID</th>
                            <th>Full Name</th>
                            <th>Birthday</th>
                            <th>Address</th>
                            <th>Position</th>
                            <th>Department</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                            List<EmployeeEntity> employeeEntityList = (List<EmployeeEntity>) employees;
                            for (EmployeeEntity employee : employeeEntityList) {

                        %>
                        <tr class="align-middle">
                            <td><%= employee.id %>
                            </td>
                            <td><%= employee.fullname %></td>
                            <td><%= df.format(employee.birthday) %></td>
                            <td><%= employee.address %></td>
                            <td><%= employee.position %></td>
                            <td><%= employee.department %></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
