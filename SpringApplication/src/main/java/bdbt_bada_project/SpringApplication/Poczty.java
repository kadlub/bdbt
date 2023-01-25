package bdbt_bada_project.SpringApplication;

public class Poczty {
    private int id_poczty;
    private String poczta;
    private String kod_pocztowy;

public Poczty(int id_poczty, String poczta, String kod_pocztowy){
    this.id_poczty = id_poczty;
    this.poczta=poczta;
    this.kod_pocztowy=kod_pocztowy;
}

public Poczty(){

}


    public int getId_poczty() {
        return id_poczty;
    }

    public void setId_poczty(int id_poczty) {
        this.id_poczty = id_poczty;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }
}
