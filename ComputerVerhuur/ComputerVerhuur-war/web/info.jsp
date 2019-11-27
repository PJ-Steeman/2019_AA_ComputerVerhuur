<%-- 
    Document   : Info Pagina
    Created on : 24-Nov-2019, 10:58:35
    Author     : Pieter-Jan Steeman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Pagina</title>
    </head>
    <body>
        <h1>Info Pagina</h1>
        <table>
            <tr>
                <th>Naam</th>
                <th>Omschrijving</th>
                <th>Lokaal</th>
                <th>Opleiding</th>
                <th>Serienummer</th>
                <th>Aankoopprijs</th>
                <th>Huurprijs</th>
            </tr>
            <tr>
                <td>
                    <p>${sessionScope.compinfo.CNaam}</p>
                </td>
                <td>
                    <p>${sessionScope.compinfo.COmsch}</p>
                </td>
                <td>
                    <p>${sessionScope.compinfo.CLok}</p>
                </td>
                <td>
                    <p>${sessionScope.compinfo.COpl}</p>
                </td>
                <td>
                    <p>${sessionScope.compinfo.CSerie}</p>
                </td>
                <td>
                    <p>${sessionScope.compinfo.CAankoop}</p>
                </td>
                <td>
                    <p>${sessionScope.compinfo.CHuur}</p>
                </td>
        </table>
        <c:if test="${sessionScope.docent == comp.COpl}">
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
                    <td><input type="text" name="Naam" value="${sessionScope.compinfo.CNaam}"></td>
                    <td><input type="text" name="Omsch" value="${sessionScope.compinfo.COmsch}"></td>
                    <td><input type="text" name="Lokaal" value="${sessionScope.compinfo.CLok}"></td>
                    <td><input type="text" name="SerieNr" value="${sessionScope.compinfo.CSerie}"></td>
                    <td><input type="text" name="Aankoop" value="${sessionScope.compinfo.CAankoop}"></td>
                    <td><input type="text" name="Huur" value="${sessionScope.compinfo.CHuur}"></td>
                </tr>
            </table>
            <br>
            <input name="submitKnop" type="submit" value="Wijzig Computer">
            </form>
        </c:if>
    </body>
</html>
