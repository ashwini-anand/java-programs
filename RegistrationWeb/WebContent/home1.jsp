<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Details</title>
</head>
<body>
<h2>Enter Details here </h2>
<form action="saveDetails" onsubmit="return validation()">
<table>
<tr>
<td>Roll Number</td>
<td><input type="text"  name="rollNo" ><span id="rollSpan" style="color: red"></span></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name" ><span id="nameSpan" style="color: red" ></span></td>
</tr>
<tr>
<td>College</td>
<td><input type="text"  name="college" ><span id="collegespan" style="color: red" ></span></td>
</tr>
<tr>
<td>Course</td>
<td><input type="text"  name="course" ><span id="coursespan" style="color: red" ></span></td>
</tr>
<tr>
<td>Upload image</td>
<td><input type="file" name="txtPhoto" placeholder="Upload Your Image" accept="image/gif, image/jpeg, image/png" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit"></td>
</tr>
</table>
</form>
</body>
</html>