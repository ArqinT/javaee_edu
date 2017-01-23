<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h3>Add/Edit User</h3>
<c:url var="addAction" value="/user/add"></c:url>
<form:form action="${addAction}" commandName="user">
	<table>
		<c:if test="${!empty user.username}">
			<tr>
				<td>
					<form:label path="id">
						<spring:message text="ID"/>
					</form:label>
				</td>
				<td>
					<form:input path="id" readonly="true" size="8" disabled="true"/>
						<%--<form:hidden path="id" />--%>
				</td>
			</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="username">
					<spring:message text="Username"/>
				</form:label>
			</td>
			<td>
				<form:input path="username"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="password">
					<spring:message text="Password"/>
				</form:label>
			</td>
			<td>
				<form:password path="password"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="roles">
					<spring:message text="Roles"/>
				</form:label>
			</td>
			<td>
				<form:select path="roles" items="${listRoles}" multiple="true" itemValue="id" itemLabel="code"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${!empty user.username}">
					<input type="submit"
						   value="<spring:message text="Edit role"/>"/>
				</c:if>
				<c:if test="${empty user.username}">
					<input type="submit"
						   value="<spring:message text="Add role"/>"/>
				</c:if>
			</td>
		</tr>
	</table>
</form:form>

<br>
<br>
<h3>User List</h3>
<c:if test="${!empty listUsers}">
	<table class="tg">
	<tr>
		<th width="80">User ID</th>
		<th width="120">User Name</th>
		<th width="120">User Password</th>
                <th width="120">User Password</th>
	</tr>
	<c:forEach items="${listUsers}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
                        <td>
                        <c:forEach items="${user.roles}" var="role">
                            ${role.code} 
                            [
                                <c:forEach items="${role.resources}" var="res">
                                    ${res.type.code} : ${res.code}<br/>
                                </c:forEach>
                            ]
                        </c:forEach>
                        </td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${empty listUsers}">
    <h1>????????????? ?? ???????</h1>
</c:if>
</body>
</html>
