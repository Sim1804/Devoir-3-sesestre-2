package Controlers;

import Entities.Client;
import Entities.Livreur;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlLivreur
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlLivreur() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllLivreurs()
    {
        ArrayList<String> lesLivreurs = new ArrayList<>();

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("SELECT numLiv, nomLiv FROM livreurs");

            rs = ps.executeQuery();

            while (rs.next()){
                 Livreur liv = new Livreur(rs.getInt("numLiv"), rs.getString("nomLiv"));
                lesLivreurs.add(String.valueOf(liv));
            }
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            Logger.getLogger(CtrlLivreur.class.getName()).log(Level.SEVERE,null,ex);
        }

        return lesLivreurs;
    }
    public int getIdLivreurByName(String nomLiv)
    {
        int numLiv = 0;

        // A vous de jouer
       try {
           ps = cnx.prepareStatement("SELECT numLiv, nomLiv FROM livreurs WHERE numLiv = ?");
           ps.setString(1, nomLiv);
           rs = ps.executeQuery();
           numLiv = rs.getInt("numLiv");
           ps.close();
           rs.close();
       }
        catch (SQLException ex){
            Logger.getLogger(CtrlClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numLiv;
    }
}
