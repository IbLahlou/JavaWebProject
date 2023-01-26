<%-- 
    Document   : formulaire
    Created on : 13 déc. 2022, 08:34:12
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Identificate</title>
    </head>
</head>
<body>

    <% String message = (String) request.getAttribute("message");
        message = (message == null) ? ("") : message;
    %>

    
    
            <form method="POST" action="Identification">
            <div class="m-5">
                <div class="card shadow-lg">
                    <div class="card-header bg-dark text-white">
                        <p class="h3">
                            Formulaire de Connexion
                        </p>
                    </div>
                    <div class="card-body">
                        ${Message}
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
                        
                        <button type="submit" class="btn btn-primary">Connexion</button>
                        <button type="reset" class="btn btn-danger">Reset</button>
                        
                        <p><a href="ModifierUtilisateur.jsp">Mot de passe oublié ?</a></p>
                        <p><a href="CreerUtilisateur.jsp">Créer Compte ?</a></p>
                    </div>
                </div>
            </div>
        </form>
    
</body>
</html>
