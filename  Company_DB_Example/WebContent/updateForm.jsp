
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="model.Company"%>

<%
   Company company = (Company) request.getAttribute("company");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update company</title>
</head>
<body>

    <h1>Update company</h1>

    <form name="updateForm" action="updateCompany" method="get">
         
         <table border="1" width="20%">
        <tr>
           <td>Company ID</td>
            <td><input type="text" name="companyID" value="<%= company.getCompanyID()%>"/></td>
        </tr>
        
        <tr>
           <td>Main Company</td>
           <td><input type="text" name="main_company" value="<%= company.getMain_company()%>"/></td>
        </tr>
        
        <tr>
           <td>Subsidiary company</td>
           <td><input type="text" name="sub_company" value="<%= company.getSub_company()%>"/></td>
        </tr>
        <tr>
           <td>Earnings</td>
           <td><input type="text" name="earnings" value="<%= company.getEarnings()%>"/></td>
        </tr>
           <tr>
              <td colspan="2">
                   <input type="submit" name="submit" value="Update the company"/>
              </td>
           </tr>
     </table>

</body>
</html>