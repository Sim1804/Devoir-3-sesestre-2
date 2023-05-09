package Vues;

import Controlers.*;
import Tools.ConnexionBDD;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class FrmCommander extends JFrame{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumCommande;
    private JTextField txtNumCommande;
    private JLabel lblClients;
    private JComboBox cboClients;
    private JLabel lblLivreurs;
    private JTable tblPizzas;
    private JComboBox cboLivreurs;
    private JButton btnCommander;
    private ModelJTable modelJTable;
    private  CtrlClient ctrlClient;
    private  CtrlCommande ctrlCommande;
    private CtrlLigneCommande ctrlLigneCommande;
    private CtrlLivreur ctrlLivreur;
    private CtrlPizza ctrlPizza;

    public FrmCommander() throws SQLException, ClassNotFoundException {
        this.setTitle("Commander");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ConnexionBDD maCnx = new ConnexionBDD();

        // A vous de jouer
        ctrlClient = new CtrlClient();
        ctrlCommande = new CtrlCommande();
        ctrlLigneCommande = new CtrlLigneCommande();
        ctrlPizza = new CtrlPizza();
        ctrlLivreur = new CtrlLivreur();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);

                modelJTable = new ModelJTable();
                modelJTable.loadDatasPizzas(ctrlPizza.getAllPizzas());
                tblPizzas.setModel(modelJTable);

                for (String livreur : ctrlLivreur.getAllLivreurs()){
                    cboLivreurs.addItem(livreur);
                }
                for (String client : ctrlClient.getAllClients()){
                    cboClients.addItem(client);
                }
            }
        });
        btnCommander.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // A vous de jouer
                ctrlLigneCommande.InsertLigneCommande(txtNumCommande.getText(),l);

            }
        });
    }
}
