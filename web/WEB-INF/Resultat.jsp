<%--
  Created by IntelliJ IDEA.
  User: ydrouet2021
  Date: 09/06/2021
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chifoumi</title>
</head>
<body>
    <h1>Resultat</h1>
    <p>Vous avez joué <%= request.getParameter("jeuUtilisateur")%> et la machine à joué <%= request.getAttribute("jeuMachine")%></p>
    <h3><%= request.getAttribute("resultat")%></h3>

    <form method="get" action="Traitement">
        <input type="submit" value="Rejouer ?">
    </form>
</body>
</html>
