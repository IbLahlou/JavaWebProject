/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traitement;

import DAO.UtilisateurDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ILD01
 */
@WebServlet(name = "SupprimerUtilisateur", urlPatterns = {"/SupprimerUtilisateur"})
public class SupprimerUtilisateur extends HttpServlet {

    UtilisateurDAO u = new UtilisateurDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("username");
        u.Supprimer(id);
       
        getServletContext().getRequestDispatcher("/GestionUtilisateur?").forward(request, response);

    }

}
