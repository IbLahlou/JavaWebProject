<%-- 
    Document   : ModifierUtilisateur
    Created on : Dec 27, 2022, 11:56:48 PM
    Author     : ILD01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <% String message = (String) session.getAttribute("message");
            if (message == null) {
                message = "";
            }
        %>




        <form method="POST" action="Modification">
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
                            Modification d'un Utilisateur
                        </p>
                    </div>
                    <div class="card-body">
                        ${message}
                        <div class="mb-3">
                            <label class="form-label">Nom  :</label>
                            <input type="text" class="form-control"  name="username" value="${userSelected.username}" >

                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password :</label>
                            <input type="password" class="form-control" name="password" value="${userSelected.password}" >
                        </div>



                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Verifier le formulaire</label>
                        </div>
                        <button type="submit" class="btn btn-primary">Modify User</button>
                        <button type="reset" class="btn btn-danger">Reset</button>


                    </div>
                </div>
            </div>
        </form>


        <div class="m-5">
            <div class="card shadow-lg">

                <div class="card-body">



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
