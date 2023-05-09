package Entities;

public class Client {
   private String idFormation;
   private String nomCli;

    public Client(String idFormation, String nomCli) {
        this.idFormation = idFormation;
        this.nomCli = nomCli;
    }

    public String getIdFormation() {
        return idFormation;
    }

    public String getNomCli() {
        return nomCli;
    }
}
