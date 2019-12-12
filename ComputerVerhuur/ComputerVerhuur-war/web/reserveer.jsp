<%-- 
    Document   : reserveer
    Created on : 09-Dec-2019, 19:44:10
    Author     : Pieter-Jan Steeman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Momenten overzicht</title>
    </head>
    <body>
        <h1>Momenten overzicht - ${sessionScope.compinfo.CNaam}</h1>
        <form method="post" action='<c:url value="CVcontroller"/>'>
            <table>
                <tr>
                    <th>Begin</th>
                    <th>Einde</th>
                    <th>Naam student</th>
                    <th>Keuze</th>
                </tr>
                <c:forEach var="mom" items="${sessionScope.momLijst}">
                    <tr>
                        <td>
                            <p>${mom.MVan}</p>
                        </td>
                        <td>
                            <p>${mom.MTot}</p>
                        </td>
                        <td>
                            <p>${mom.MRes.RUser.UNaam}</p>
                        </td>
                        <td>
                            <input name="keuzeKnop" type="radio" value="Moment-${mom.MId}">
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <c:if test="${sessionScope.rol == 'student'}">
                <input name="submitKnop" type="submit" value="Reserveer">
            </c:if>
            <c:if test="${sessionScope.rol == 'extern'}">
                <input name="submitKnop" type="submit" value="Vraag prijs">
            </c:if>
        </form>
    </body>
</html>
