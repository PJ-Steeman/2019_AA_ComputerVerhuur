<%-- 
    Document   : Overzicht
    Created on : 20-Nov-2019, 15:28:57
    Author     : Pieter-Jan Steeman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overzicht</title>
    </head>
    <body>
        <h1>Overzichtspagina</h1>
        <form method="post" action='<c:url value="CVcontroller"/>'>
        <table>
            <tr>
                <th>Naam</th>
                <th>Omschrijving</th>
                <th>Lokaal</th>
                <th></th>
            </tr>
            <c:forEach var="comp" items="${applicationScope.computers}">
            <tr>
                <td>
                    <p>${comp.CNaam}</p>
                </td>
                <td>
                    <p>${comp.COmsch}</p>
                </td>
                <td>
                    <p>${comp.CLok}</p>
                </td>
                <td>
                    <input name="submitKnop" type="submit" value="Info-${comp.CId}">
                </td>
            </c:forEach>
        </table>
        </form>
        
        <c:if test="${!empty sessionScope.docent}">
            <form method="post" action='<c:url value="CVcontroller"/>'>
                <table>
                    <tr>
                        <th>Computer naam</th>
                        <th>Korte omschrijving</th>
                        <th>Lokaal</th>
                        <th>Serienummer</th>
                        <th>Aankoopprijs</th>
                        <th>Huurprijs</th>
                    </tr>
                    <tr>
                        <td><input type="text" name="Naam"></td>
                        <td><input type="text" name="Omsch"></td>
                        <td><input type="text" name="Lokaal"></td>
                        <td><input type="text" name="SerieNr"></td>
                        <td><input type="text" name="Aankoop"></td>
                        <td><input type="text" name="Huur"></td>
                    </tr>
                </table>
                <br>
                <input name="submitKnop" type="submit" value="Nieuwe Computer">
            </form>
        </c:if>
    </body>
</html>
