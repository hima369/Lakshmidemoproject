<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
	<title>
		CoronaKitPortal	
	</title>
</head>
	<body>
	
		<jsp:include page="/AdminHomepage"></jsp:include>
		<c:if test="${msg != null}">
			<p><strong>${msg }</strong>
		</c:if>

	</body>
</html>