<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Details</title>
</head>
<body>

	<div align="left">
		<h1>${client.name} Details</h1>

		<table border="1">
			<th>ID</th>
			<th>Name</th>
			<th>NIF</th>
			<th>Address</th>
			<th>Phone Number</th>


			<tr>
				<td>${client.id}</td>
				<td>${client.name}</td>
                <td>${client.nif}</td>
                <td>${client.address}</td>
                <td>${client.phoneNumber}</td>
				
				<td><a
					href="${pageContext.request.contextPath}/edit?id=${client.id}">Edit</a>
					&nbsp;|&nbsp; <a
					href="${pageContext.request.contextPath}/delete?id=${client.id}">Delete</a>
				</td>
			</tr>
		</table>
		
		<br>
		
		<button align="right" onclick="window.location.href = '${pageContext.request.contextPath}/'">Go To Home</button>

	</div>

</body>
</html>
