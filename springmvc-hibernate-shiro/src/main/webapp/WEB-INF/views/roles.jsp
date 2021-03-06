<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Person Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h3>Add Role</h3>
<c:url var="addAction" value="/role/add"></c:url>
<form:form action="${addAction}" commandName="role">
    <table>
        <c:if test="${!empty role.code}">
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
                <form:label path="code">
                    <spring:message text="Code"/>
                </form:label>
            </td>
            <td>
                <form:input path="code"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="resources">
                    <spring:message text="Resources"/>
                </form:label>
            </td>
            <td>
                <form:select path="resources" items="${listResources}" multiple="true" itemValue="id" itemLabel="code"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty role.code}">
                    <input type="submit"
                           value="<spring:message text="Edit role"/>"/>
                </c:if>
                <c:if test="${empty role.code}">
                    <input type="submit"
                           value="<spring:message text="Add role"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<br>
<br>
<h3>Role List</h3>
<c:if test="${!empty listRoles}">
    <table class="tg">
        <tr>
            <th width="80">Role ID</th>
            <th width="120">Role Name</th>
            <th width="120">Resources</th>
            <th width="120" colspan="2">Actions</th>
        </tr>
        <c:forEach items="${listRoles}" var="role">
            <tr>
                <td>${role.id}</td>
                <td>${role.code}</td>
                <td>
                    <c:forEach items="${role.resources}" var="resource">
                        ${resource.type.code}: ${resource.code}<br/>
                    </c:forEach>
                </td>
                <td><a href="<c:url value='/role/edit/${role.id}' />">Edit</a></td>
                <td><a href="<c:url value='/role/remove/${role.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty listRoles}">
    <h1>Роли не заведены в системе</h1>
</c:if>
</body>
</html>
