<%--
  Created by IntelliJ IDEA.
  User: hoangtu.tran
  Date: 10/28/2023
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>
<div class="container">
    <div class="row">
        <h2>Add new employee</h2>
    </div>
    <form method='post' action='${pageContext.request.contextPath}/employees'>
        <div class="row">
            <div class="col-md-3">
                <div class="form-group form-group-sm">
                    <label for="fullname" class="control-label">Full Name</label>
                    <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Full Name...">
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group form-group-sm">
                    <label for="birthday" class="control-label">Birthday</label>
                    <input type="date" class="form-control" id="birthday" name="birthday" placeholder="Birthday...">
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group form-group-sm">
                    <label for="address" class="control-label">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Address...">
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group form-group-sm">
                    <label for="position" class="control-label">Position</label>
                    <input type="text" class="form-control" id="position" name="position" placeholder="Position...">
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group form-group-sm">
                    <label for="department" class="control-label">Department</label>
                    <input type="text" class="form-control" id="department" name="department"
                           placeholder="Department...">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
            <div class="col-xs-2">
                <button type="reset" class="btn btn-default">Reset</button>
            </div>
        </div>
    </form>
</div>
</body>

</html>
