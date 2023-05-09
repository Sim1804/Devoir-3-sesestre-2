package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlCommande
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlCommande() {
        cnx = ConnexionBDD.getCnx();
    }

    public int getDernierNumeroDeCommande()
    {
        int maxNumero = 0;

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("SELECT *\n" +
                    "FROM commandes\n" +
                    "WHERE numCde = MAX(numCde)\n");
            rs = ps.executeQuery();
            maxNumero = rs.getInt("numCde");
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            Logger.getLogger(CtrlPizza.class.getName()).log(Level.SEVERE,null,ex);
        }

        return maxNumero;
    }
    public void InsertConsultation(int numCde, int numClient,int numLivreur)
    {
        // A vous de jouer
        try{
            ps = cnx.prepareStatement("INSERT INTO  commandes values (?,?,?)");
            ps.setInt(1,numCde);
            ps.setInt(2,numClient);
            ps.setInt(3,numLivreur);
            ps.executeUpdate();
            ps.close();
            rs.close();

        }
        catch (SQLException ex){
            Logger.getLogger(CtrlCommande.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
}
