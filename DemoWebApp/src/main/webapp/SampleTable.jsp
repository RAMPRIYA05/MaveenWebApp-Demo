<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import=" com.chainsys.model.Demo" %>
     <%@ page import="java.util.ArrayList" %>
       <%@ page import="java.util.List" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <table border="1">
    <thead>
    <tr>
    <th>Name</th>
    <th>EmailId</th>
    <th>Password</th>
    </tr>
    </thead>

<%List<Demo> list=(ArrayList<Demo>)request.getAttribute("list");
for(Demo obj:list)
{
%>
<tr> 
        <td><%=obj.getName() %></td>
        <td><%=obj.getEmailId() %></td>
        <td><%=obj.getPassword() %></td>
        
        
<td>
<input type="hidden" name="emailId" value="<%=obj.getEmailId() %>">
<a href="UpdateName.jsp?editEmailId=<%=obj.getEmailId() %>">
<button style="color:brown;background-color:navajowhite;" type="button">Update</button></a>
</td>
        
        
<td>
<form action="Update" method="post">
  <input type="hidden" name="deleteemailId" value="<%=obj.getEmailId()%>">
  <input type="submit" style="color:brown;background-color:navajowhite;" name="delete" value="Delete">
</form>
</td>
        
</tr>


<%
}
%>



</table>
    
</body>
</html>