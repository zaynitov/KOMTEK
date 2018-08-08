<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <style>
        .blue-button {
            background: #25A6E1;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#25A6E1', endColorstr='#188BC0', GradientType=0);
            padding: 3px 5px;
            color: #fff;
            font-family: 'Helvetica Neue', sans-serif;
            font-size: 12px;
            border-radius: 2px;
            -moz-border-radius: 2px;
            -webkit-border-radius: 4px;
            border: 1px solid #1A87B9
        }

        table {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            width: 50%;
        }

        th {
            background: SteelBlue;
            color: white;
        }

        td, th {
            border: 1px solid gray;
            width: 25%;
            text-align: left;
            padding: 5px 10px;
        }
    </style>
</head>
<body>

<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<c:set var="viewname" value="getAllBloodsForPatient/"/>
<c:set var="viewname2" value="updateBlood/"/>


<c:set var="patientid"
       value="${fn:substring(url, fn:indexOf(url,viewname)+fn:length(viewname),fn:length(url)) }"/>

<c:if test="${fn:contains(patientid, viewname2)}">
<c:set var="patientid"
       value="${fn:substringBefore(patientid, viewname2)}"/>

</c:if>
<form:form method="get" modelAttribute="blood"
           action="/addBloodForPatient/${patientid}">
    <table>
        <tr>
            <th colspan="2">Add Blood</th>
        </tr>

        <tr>

            <form:hidden path="id"/>
            <td><form:label path="measuredate">measuredate(yyyy-MM-dd):</form:label></td>
            <td><form:input path="measuredate" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="hemoglobin">hemoglobin:</form:label></td>
            <td><form:input path="hemoglobin" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="redbloodcell">redbloodcell:</form:label></td>
            <td><form:input path="redbloodcell" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="avgrbc">avgrbc:</form:label></td>
            <td><form:input path="avgrbc" size="30" maxlength="30"></form:input></td>
        </tr>


        <tr>
            <td><form:label path="HGB">HGB:</form:label></td>

            <td><form:input path="HGB" size="30" maxlength="30"></form:input></td>
        </tr>


        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button"/></td>
        </tr>
    </table>
</form:form>
</br>
<h3>Blood List</h3>
<c:if test="${!empty listOfBloods}">
    <table class="tg">
        <tr>
            <th width="120">measuredate(yyyy-MM-dd)</th>
            <th width="120">hemoglobin</th>
            <th width="120">redbloodcell</th>
            <th width="120">avgrbc</th>
            <th width="120">HGB</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOfBloods}" var="blood">
            <tr>
                <td>${blood.measuredate}</td>
                <td>${blood.hemoglobin}</td>
                <td>${blood.redbloodcell}</td>
                <td>${blood.avgrbc}</td>
                <td>${blood.HGB}</td>
                <td><a href="<c:url value='/getAllBloodsForPatient/${patientid}/updateBlood/${blood.id}' />">Edit</a>
                </td>
                <td><a href="<c:url value='/getAllBloodsForPatient/${patientid}/deleteBlood/${blood.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
