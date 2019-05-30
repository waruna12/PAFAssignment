<%@page import="com.DAO.ItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

 ItemDAO item = new ItemDAO();
 String itemsGrid = item.GetItems();
%>
 
<html>
<head>
<style>
table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
  
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 15px;
}
tr:hover {background-color: #f5f5f5;}

a{
	font-family: Verdana;
	font-size: 14px;
}

/* unvisited link */
a:link {
  color: purple;
}

/* visited link */
a:visited {
  color: darkblue;
}

/* mouse over link */
a:hover {
  color: gray;
}

/* selected link */
a:active {
  color: blue;
}
</style>

<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="Controller/Validation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item Management Screen</title>
</head>
<body>
	<form id="formItems" action="index.jsp" method="post">
		<table>
            <input type="hidden" id="id" name="id" value="0">
            <tr>
                <td>Name:</td>
                <td><input id="name" name="name" placeholder="Item Name.."/></td>
            </tr>
            <tr>
                <td>Brand:</td>
                <td><input id="brand" name="brand" placeholder="Brand.."/></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><input id="qty" name="qty" placeholder="Quantity.."/></td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><input id="color" name="color" placeholder="Color.."/></td>
            </tr>
            
            <tr>
                <td colspan="2" align="center"><input type="button" name="btnSave" id="btnSave" value="Save"></td>
            </tr>
        </table>
			
		<div id="divStsMsgItem"></div>
		<div id="divItemsTable"><% out.println(itemsGrid); %></div>
	</form>

</body>
</html>