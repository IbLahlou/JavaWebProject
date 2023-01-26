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
import javax.servlet.http.HttpSession;

/**
 *
 * @author ILD01
 */
@WebServlet(name = "Modification", urlPatterns = {"/Modification"})
public class Modification extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UtilisateurDAO ud = new UtilisateurDAO();
        
        HttpSession session = request.getSession();
        Users us = (Users) session.getAttribute("userSelected");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        us.setUsername(username);
        us.setPassword(password);
        ud.update(us);
        
         getServletContext().getRequestDispatcher("/GestionUtilisateur?").forward(request, response);
        
    }
}
