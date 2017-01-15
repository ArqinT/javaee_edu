<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Resource Type Page</title>
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
<br>
<h3>Add Type</h3>
<c:url var="addAction" value="/resource_type/add"></c:url>
<form:form action="${addAction}" commandName="resourceType">
    <table>
        <c:if test="${!empty resourceType.code}">
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
            <td colspan="2">
                <c:if test="${!empty resourceType.code}">
                    <input type="submit"
                           value="<spring:message text="Edit resourceType"/>"/>
                </c:if>
                <c:if test="${empty resourceType.code}">
                    <input type="submit"
                           value="<spring:message text="Add resourceType"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<br>
<h3>Resources List</h3>
<c:if test="${!empty listResources}">
    <table class="tg">
        <tr>
            <th width="80">Type ID</th>
            <th width="120">Type Code</th>
            <th width="120">Type Resources</th>
            <th width="120" colspan="2">Actions</th>
        </tr>
        <c:forEach items="${listResources}" var="type">
            <tr>
                <td>${type.id}</td>
                <td>${type.code}</td>
                <td>
                    <c:forEach items="${type.resources}" var="resource">
                        ${resource.code}<br>
                    </c:forEach>
                </td>
                <td><a href="<c:url value='/resource_type/edit/${type.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/resource_type/remove/${type.id}' />" >Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty listResources}">
    <h1>Не найдены типы ресурсов</h1>
</c:if>
</body>
</html>
