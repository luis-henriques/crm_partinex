<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<div align="left">
		<h1>Results List</h1>

		<table border="1">
			<th>ID</th>
			<th>Name</th>

			<c:forEach var="client" items="${clientList}">
				<tr>
					<td>${client.id}</td>
					<td>${client.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/details?id=${client.id}">Details</a>
						&nbsp;|&nbsp; <a
						href="${pageContext.request.contextPath}/edit?id=${client.id}">Edit</a>
						&nbsp;|&nbsp; <a
						href="${pageContext.request.contextPath}/delete?id=${client.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>

		<br>

		
        <button align="right" onclick="window.location.href = '${pageContext.request.contextPath}/'">Go To Home</button>

	</div>

</body>
</html>
