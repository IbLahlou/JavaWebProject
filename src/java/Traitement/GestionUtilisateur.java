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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "GestionUtilisateur", urlPatterns = {"/GestionUtilisateur"})
public class GestionUtilisateur extends HttpServlet {

    private UtilisateurDAO user;

    @Override
    public void init() throws ServletException {
        user = new UtilisateurDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        //Récupération des paramètres saisis via le formulaire 
        String NomUtilsateur = request.getParameter("username");
        String MotDePasse = request.getParameter("password");
        String message;
        message = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">";
        message += "<strong>Remplir les champs</strong>";
        message += "  <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n</div>";
        if (NomUtilsateur.equals("") || (MotDePasse.equals(""))) {

            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
        } else {
            //Création d’un objet bean de type UtilisateurBeans
            Users ub = new Users();
            ub.setUsername(NomUtilsateur);
            ub.setPassword(MotDePasse);
            //Création de l’objet UtilisateurDAO. Cette classe contient la logique de notre application
            UtilisateurDAO con = new UtilisateurDAO();
            //Appel à la fonction ajouterUtilisateur dans la classe UtilisateurDAO
            String result = con.Enregistrer(ub);
            if (result.equals("OK")) {//Si la fonction renvoie la chaine Ok alors on redirige vers la page CreerUtilisateur.jsp
                message = "";
            } else {//Si la fonction renvoie autre que la chaine la chaine Ok alors on redirige vers la page CreerUtilisateur.jsp

            }
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        /*            if (action.equals("Editer")) {
        
        request.setAttribute("Username", username);
        getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
        }*/
        List<Users> listUser = user.getListUser();
        request.setAttribute("listUser", listUser);
        getServletContext().getRequestDispatcher("/ListeUtilisateur.jsp").forward(request, response);

    }

}
