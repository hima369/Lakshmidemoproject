<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VisitorOrderForm</title>
</head>
<body>
Place Corona Kit Order


	
	<form action="orderSummary.jsp" method ="post"> 
	
				ProductItem: <select name="ProductItem"><br><br><br>
					<%
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpkDb", "root","root");						
						String productitemquery = "SELECT productitem from Kits";
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(productitemquery);
						while(rs.next())
									{
									%>
										<option value="<%=rs.getString("productitem")%>">
										<%=rs.getString("productitem")%>
										</option>
									<%}		

					}
					catch(Exception e){
						out.print(e.getMessage());						
					}					
					%>
				</select>
				
				
				Cost: <select name="CostItem">
					<%
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpkDb", "root","root");						
						String productitemquery = "SELECT cost from Kits";
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(productitemquery);
						while(rs.next())
									{
									%>
										<option value="<%=rs.getString("cost")%>">
										<%=rs.getString("cost")%>
										</option>
									<%}		
						

					}
					catch(Exception e){
						out.print(e.getMessage());						
					}					
					%>
				</select>

</body>
</html>