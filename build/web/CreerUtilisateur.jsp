<%-- 
    Document   : CreerUtilisateur
    Created on : 13 déc. 2022, 09:26:12
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>

    <body>

        <% String message = (String) session.getAttribute("message");
            if (message == null) {
                message = "";
            }%>




        <form method="POST" action="CreerUtilisateur">
            <div class="m-5">
                <div class="card shadow-lg">
                    <div class="card-body ">
                        <a href="Accueil.jsp">
                            <img src="home.gif" width="30px">
                        </a> 
                        
                        <a href="Deconnexion" style="float: right">
                            <img src="key.gif" width="30px">
                        </a> 
                    </div>
                    <div class="card-body">
                        <p class="h3">
                            Creation d'un Utilisateur
                        </p>
                    </div>
                    <div class="card-body">
                        ${message}
                        <div class="mb-3">
                            <label class="form-label">Nom  :</label>
                            <input type="text" class="form-control"  name="username" >

                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password :</label>
                            <input type="password" class="form-control" name="password" >
                        </div>



                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Verifier le formulaire</label>
                        </div>
                        <button type="submit" class="btn btn-primary">Create User</button>
                        <button type="reset" class="btn btn-danger">Reset</button>


                    </div>
                </div>
            </div>
        </form>





</html>
