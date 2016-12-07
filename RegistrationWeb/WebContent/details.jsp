<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
<h2>Details of student</h2>
<form>
<table>
<tr>
<td>Roll Number</td>
<td><input  name="rollNo" value="${roll_no}" ><span id="rollSpan" style="color: red"></span></td>
</tr>
<tr>
<td>Name</td>
<td><input type="" name="name" value="${name}"><span id="nameSpan" style="color: red" ></span></td>
</tr>
<tr>
<td>College</td>
<td><input type="text"  name="college" value="${college}"><span id="collegespan" style="color: red" ></span></td>
</tr>
<tr>
<td>Course</td>
<td><input type="text"  name="course" value="${course}"><span id="coursespan" style="color: red" ></span></td>
</tr>
<tr>
<td>Profile Photo</td>
<td><img src="pic_mountain.jpg" alt="Mountain View" style="width:200px;height:200px;"></td>
</tr>
<tr>
<td></td>
<td><a href="index.jsp">Go to Home page</a></td>
</tr>
</table>
</form>
</body>
</html>