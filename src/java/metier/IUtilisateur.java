/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author HP
 */
import MesBeans.Users;
import java.util.List;

public interface IUtilisateur {
    public String authentification(Users ub);
    public String Enregistrer(Users ub);
    public String Supprimer(String username);
    public  List<Users> getListUser();
    public Users getById(String username);
    public void update(Users cl);
}
