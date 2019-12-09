<%-- 
    Document   : resOverzicht
    Created on : 01-Dec-2019, 13:05:18
    Author     : Pieter-Jan Steeman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservatie overzicht</title>
    </head>
    <body>
        <h1>Reservatie overzicht - ${sessionScope.compinfo.CNaam}</h1>
        <table>
            <tr>
                <th>Begin</th>
                <th>Einde</th>
                <th>Naam student</th>
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
                </tr>
            </c:forEach>
        </table>
        <c:if test="${sessionScope.rol == 'docent'}">
            <c:if test="${sessionScope.richting == sessionScope.compinfo.COpl}">
                <form method="post" action='<c:url value="CVcontroller"/>'>
                    <p>Gelieve de datums en tijden in te geven volgens dd/MM/yyyy HH:mm:ss</p>
                    <table>
                        <tr>
                            <th>Begin datum en tijd</th>
                            <th>Eind datum en tijd</th>
                        </tr>
                        <tr>
                            <td><input type="text" name="Van"></td>
                            <td><input type="text" name="Tot"></td>
                        </tr>
                    </table>
                    <br>
                    <input name="submitKnop" type="submit" value="Nieuw Moment">
                </form>
            </c:if>
        </c:if>
    </body>
</html>
