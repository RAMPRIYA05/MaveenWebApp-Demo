<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<fieldset>
<form action="Update" method="get">
      <center><h1>Update Form</h1></center>
      <center>Name: <input type="text" placeholder="Enter your new name" name="name" required></center><br>
      
      
  
     <input type="hidden" name="emailId" value="<%=request.getParameter("editEmailId") %>">
     <input type="submit" style="color:brown;background-color:navajowhite;border:none;padding:5px 15px;text-align:center;text-decoration:none;display:inline-block;font-size:16px;margin:4px 2px;cursor:pointer;"  name="update">
</form>
</fieldset>


</body>
</html>