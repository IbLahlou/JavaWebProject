<%-- 
    Document   : ListeUtilisateur
    Created on : 13 déc. 2022, 09:34:40
    Author     : HP
--%>

<%@page import="java.util.List"%>
<%@page import="MesBeans.Users"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Users</title>
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


   
        

        <div class="m-5">
            <div class="card shadow-lg">
                <div class="card-header bg-light">
                    Liste d'Utilisateur
                </div>
                <div class="card-body">
                    <div class="input-group">
                        <input type="search" class="form-control rounded" placeholder="Mot Clé" aria-label="Search" aria-describedby="search-addon" />
                        <button type="button" class="btn btn-outline-primary">Chercher</button>
                    </div>

                    <table class="table table-striped">
                        <tr>
                            <th style="text-align: center">Username</th>
                            <th style="text-align: center">Password</th>
                            <th colspan="2" style="text-align: center">Action</th>

                        </tr>




                        <c:forEach var="u" items="${listUser}">
                            <tr>
                                <td style="text-align: center">
                                    <c:out value="${u.username}" />
                                </td>
                                <td style="text-align: center">
                                    <c:out value="${u.password}" />
                                </td>
                                <td style="text-align: center">
                                    <a href="EditerUtilisateur?username=${u.username}">Editer</a>          
                                </td>
                                <td style="text-align: center">
                                    <a href="SupprimerUtilisateur?username=${u.username}">Supprimer</a>      
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                    
                     <br>
                    <a href="Accueil.jsp">
                        <button type="submit" class="btn btn-light" >
                            Go Back
                        </button>
                    </a> 
                    <br>
                    <br>

                    <a href="Deconnexion">
                        <button type="submit" class="btn btn-dark" >
                            Disconnect
                        </button>
                    </a>
                </div>

            </div>


        </div>




    </body>
</html>
