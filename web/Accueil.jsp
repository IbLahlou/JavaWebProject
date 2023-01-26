<%-- 
    Document   : Accueil
    Created on : 13 déc. 2022, 08:43:35
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <style>
        .c1{
            color: grey;

        }
        .c2{
            color: blue;
        }
    </style>
    <body>
  


        <c:if test="${UserConnected != null}">
                    
            <div class="m-5">
                <div class="card shadow-lg">
                    <div class="card-header bg-primary text-white">
                        <p class="h4">
                            Hello ${UserConnected}
                        </p>
                    </div>
                    <div class="card-body">
                        Vous êtes connecter avec Succés !
                        <br>
                        <br>
                        <strong>View Users</strong><br>
                        <a href="GestionUtilisateur?" >
                            <img src="lister.gif" width="100px">
                        </a>

                        <br>
                        
                        <strong>Create a User</strong><br>
                        <a href="CreerUtilisateur.jsp">
                            <img src="user.gif" width="100px">
                        </a>

                        <br>
                        <br>
                        <strong>Disconnect User</strong><br>
                        <a href="Deconnexion" >
                            <img src="key.gif" width="100px">
                        </a> 

                    </div>
                </div>
            </div>
        </c:if>



    </body>
</html>
