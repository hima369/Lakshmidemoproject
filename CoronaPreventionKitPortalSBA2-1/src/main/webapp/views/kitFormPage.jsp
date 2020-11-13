<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kit form</title>
</head>
<body>

<%-- <jsp:include page="header.jsp" /> --%>
<jsp:include page="/AdminHomepage" />


<h3>${isNew?"New Kit":"Edit Kit" }</h3>

<form:form action='${isNew?"addkit":"savekit" }' method="POST" modelAttribute="kit">

<div>
	<form:label path="kitID">kitID: </form:label>
	<input type="number" path="kitID" readonly="${!isNew}" />
	<form:errors path="kitID" />
 </div>
 
 <div>
	<form:label path="productname">productname: </form:label>
	<input type="text" path="productname"/>
	<form:errors path="productname" />
 </div>
 
 <div>
	<form:label path="cost">cost: </form:label>
	<input type="decimal" path="cost" />
	<form:errors path="cost" />
 </div>
 
 <div>
	<form:label path="productdescription">productdescription: </form:label>
	<input type="text" path="productdescription" />
	<form:errors path="productdescription" />
 </div>
 
 <button>Save</button>

</form:form>


</body>
</html>