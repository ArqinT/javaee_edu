<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<br>
<h3>Role List</h3>
<c:if test="${!empty listRoles}">
	<table class="tg">
	<tr>
		<th width="80">Role ID</th>
		<th width="120">Role Name</th>
		<th width="120">Role Password</th>
                <th width="120">Role Password</th>
	</tr>
	<c:forEach items="${listRoles}" var="role">
		<tr>
			<td>${role.id}</td>
			<td>${role.rolename}</td>
			<td>${role.password}</td>
                        <td>
                        <c:forEach items="${role.resources}" var="resource">
                            ${resource.type.code}: ${resource.code}
                        </c:forEach>
                        </td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${empty listRoles}">
    <h1>Роли не заведены в системе</h1>
</c:if>
</body>
</html>
