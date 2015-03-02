<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<div align="left">
		<h1>Client List</h1>

		<div>
		  Insert NIF or name to find client:
		  <input id="searchBox" type="text">
		  <button onclick="window.location.href = '${pageContext.request.contextPath}/getClientByNIF?nif='+document.getElementById('searchBox').value">Find Client By NIF</button>
		  <button onclick="window.location.href = '${pageContext.request.contextPath}/getClientByName?name='+document.getElementById('searchBox').value">Find Client By Name</button>
		</div>
		
		<br>

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

		<button align="right"
			onclick="window.location.href = '${pageContext.request.contextPath}/new'">Add
			Client</button>

	</div>

</body>
</html>
