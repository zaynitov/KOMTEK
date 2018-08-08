<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<form:form method="get" modelAttribute="patient" action="${pageContext.request.contextPath}/addPatient">
    <table>
        <tr>
            <th colspan="2">Add Patient</th>
        </tr>

        <tr>

            <td><form:label path="SNILS">SNILS:</form:label></td>
            <td><form:input path="SNILS" size="30" maxlength="30"></form:input></td>
        </tr>

        <tr>


            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="surname">Surname:</form:label></td>
            <td><form:input path="surname" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="patronymic">Patronymic:</form:label></td>
            <td><form:input path="patronymic" size="30" maxlength="30"></form:input></td>
        </tr>



      <tr>
            <td><form:label path="birth">Birth:</form:label></td>

            <td><form:input path="birth" size="30" maxlength="30"></form:input></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button"/></td>
        </tr>
    </table>
</form:form>
</br>
<h3>Patient List</h3>
<c:if test="${!empty listOfPatients}">
    <table class="tg">
        <tr>
            <th width="80">SNILS</th>
            <th width="120">PatientName</th>
            <th width="120">PatientSurmame</th>
            <th width="120">Patronymic</th>
            <th width="120">Birth</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
            <th width="60">Blood</th>
        </tr>
        <c:forEach items="${listOfPatients}" var="patient">
            <tr>
                <td>${patient.SNILS}</td>
                <td>${patient.name}</td>
                <td>${patient.surname}</td>
                <td>${patient.patronymic}</td>
                <td>${patient.birth}</td>
                <td><a href="<c:url value='/updatePatient/${patient.SNILS}' />">Edit</a></td>
                <td><a href="<c:url value='/deletePatient/${patient.SNILS}' />">Delete</a></td>
                <td><a href="<c:url value='/getAllBloodsForPatient/${patient.SNILS}' />">Blood</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
