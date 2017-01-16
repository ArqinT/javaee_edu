<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Resources Page</title>
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
<h3>Add Resource Type</h3>
<c:url var="addAction" value="/resource/add"></c:url>
<form:form action="${addAction}" commandName="resourceItem">
    <table>
        <c:if test="${!empty resourceItem.code}">
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
                <form:label path="type_id">
                    <spring:message text="Type"/>
                </form:label>
            </td>
            <td>
                <form:input path="type_id"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty resourceItem.code}">
                    <input type="submit"
                           value="<spring:message text="Edit resourceItem"/>"/>
                </c:if>
                <c:if test="${empty resourceItem.code}">
                    <input type="submit"
                           value="<spring:message text="Add resourceItem"/>"/>
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
            <th width="80">ID</th>
            <th width="120">Code</th>
            <th width="120">Type</th>
            <th width="120" colspan="2">Actions</th>
        </tr>
        <c:forEach items="${listResources}" var="resource">
            <tr>
                <td>${resource.id}</td>
                <td>${resource.code}</td>
                <td><%--<c:if test="${!empty resource.type}">${resource.type.code}</c:if>--%></td>
                <td><a href="<c:url value='/resource/edit/${type.id}' />">Edit</a></td>
                <td><a href="<c:url value='/resource/remove/${type.id}' />">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty listResources}">
    <h1>Не найдены ресурсы</h1>
</c:if>
</body>
</html>
