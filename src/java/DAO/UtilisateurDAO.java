/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.NewHibernateUtil;
import MesBeans.Users;
import java.util.List;
import metier.IUtilisateur;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class UtilisateurDAO implements IUtilisateur {

    @Override
    //Déclaration d’une fonction Authentification de type de retour String
    public String authentification(Users ub) {
        //Conserver les valeurs saisies par l’utilisateur dans des variables temporaires
        String userName = ub.getUsername();
        String passWord = ub.getPassword();
        //Création des paramètres de connexion à la BD
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = se.beginTransaction();
        //Obtention d’une occurrence à partir de son identifiant
        Users user = (Users) se.get(Users.class, userName);
        if (user != null) {
            if (user.getUsername().equals(userName) && (user.getPassword().equals(passWord))) {
                return "OK";
            } else {
                return "KO";
            }
        } else {
            return "KO";
        }
    }

    @Override
    public String Enregistrer(Users ub) {
        try {
            //Création des paramètres de connexion à la BD
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            se.save(ub);
            tr.commit();
            return "OK";
        } catch (HibernateException e) {
            return "AUTRE CHOSE";
        }
    }

    @Override
    public List<Users> getListUser() {
        List< Users> listeUser = null;
        try {
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            listeUser = se.createQuery("from Users").list();

            // commit transaction
            tr.commit();
        } catch (HibernateException e) {
        }
        return listeUser;
    }

    @Override
    public String Supprimer(String username) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Users user = (Users) session.get(Users.class, username);
            session.delete(username, user);
            transaction.commit();
            return "OK";
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "KO";
        } finally {
            session.close();
            return "KOK";
        }
    }

    @Override
    public Users getById(String username) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Users user = (Users) session.get(Users.class, username);
        session.getTransaction().commit();
        return user;
    }

    
    
    @Override
    public void update(Users cl) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //cl = (Users) session.get(Users.class, );
        session.update(cl);
        session.getTransaction().commit();
    }
    
}
