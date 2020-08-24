<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<html>
<body>
<h2>Applicant Registration</h2>


<form name="frm" method="POST" action="saveuser" modelAttribute="applicant">
<table>
<tr>
<td> Enter Username </td>
<td> <input type=text name="uname"> </td>
</tr>
<tr>
<td> Enter password</td>
<td> <input type=text name="password"> </td>
</tr>

<tr>
<td> Enter Address </td>
<td> <input type=text name="addr"> </td>
</tr>

</table>
<br>
<input type=submit value="Add Details"/>
</form>

<table border=2>
<tr>
<td>Name</td><td>Passowrd</td><td>Address</td>
</tr>
<c:forEach items="${applidetails}" var="app">
<tr>
<td> ${app.uname} </td>
<td> ${app.password}</td>
<td> ${app.addr}</td>
<td> <a href="delrecord?aname=${app.uname}"> Delete </a> </td>
<td> <a href="modirecord?aname=${app.uname}"> Update </a> </td>
</tr>
</c:forEach>
</table> 

<form method="PUT" action="update" modelAttribute="applicant">
 <input type=hidden name=uname value="${appresult.uname}">
Password <input type=text name=password value="${appresult.password}"><br>
Address <input type=text name=addr value="${appresult.addr}"><br>
<input type="submit" value="Update Record">
</form>

</form>


</body>

</html>
