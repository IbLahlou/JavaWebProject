/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traitement;

import DAO.UtilisateurDAO;
import MesBeans.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "CreerUtilisateur", urlPatterns = {"/CreerUtilisateur"})
public class CreerUtilisateur extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Récupération des paramètres saisis via le formulaire
        String NomUtilsateur = request.getParameter("username");
        String MotDePasse = request.getParameter("password");
        //Création d’un objet bean de type Utilisateur
        Users ub = new Users();
        ub.setUsername(NomUtilsateur);
        ub.setPassword(MotDePasse);
        //Création de l’objet UtilisateurDAO. Cette classe contient la logique de notre 
        //application
        UtilisateurDAO ud = new UtilisateurDAO();
        //Appel à la fonction Authentification dans la classe UtilisateurDAO
        String result = ud.Enregistrer(ub);
        if (result.equals("OK")) {//redirige vers la page Accueil.jsp
            request.setAttribute("UserConnected", NomUtilsateur);
            getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request,
                    response);
        } else {
            String message;
            message = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">";
            message += "<strong>Remplir les champs</strong>";
            message += "  <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n</div>";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
        }

    }

}
