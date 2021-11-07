<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Company</title>
</head>
<body>
	<h1>Add Company</h1>
		<form name="addForm" action="addCompany" method="get">

     <table border="1" width="20%">
  
        <tr>
           <td>Main Company</td>
           <td><input type="text" name="main_company" value=""/></td>
        </tr>
        
        <tr>
           <td>Subsidiary company</td>
           <td> <input type="text" name="sub_company" value=""/></td>
        </tr>
        
        <tr>
           <td>Earnings</td>
           <td><input type="text" name="earnings" value=""/></td>
        </tr>
           <tr>
              <td colspan="2">
                   <input type="submit" name="submit" value="Add the Company"/>
              </td>
           </tr>
     </table>
         
	</form>
</body>
</html>
