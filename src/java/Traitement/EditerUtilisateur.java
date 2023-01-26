/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traitement;

import DAO.UtilisateurDAO;
import MesBeans.Users;
import java.io.IOException;
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
@WebServlet(name = "EditerUtilisateur", urlPatterns = {"/EditerUtilisateur"})
public class EditerUtilisateur extends HttpServlet {

    UtilisateurDAO u=new UtilisateurDAO();
    
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String id = request.getParameter("username");
    Users user = u.getById(id);
    session.setAttribute("userSelected", user);
    getServletContext().getRequestDispatcher("/ModifierUtilisateur.jsp").forward(request, response);

  }
}
