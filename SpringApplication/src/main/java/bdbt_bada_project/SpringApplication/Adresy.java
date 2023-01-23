package bdbt_bada_project.SpringApplication;

public class Adresy {
    private int id_adresu;
    private String miasto;
    private String ulica;
    private int nr_lokalu;
    private int id_poczty;


    public Adresy(int id_adresu, String miasto, String ulica, int nr_lokalu, int id_poczty) {
        this.id_adresu = id_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_lokalu = nr_lokalu;
        this.id_poczty = id_poczty;
    }

    public Adresy(){

    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(int nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    public int getId_poczty() {
        return id_poczty;
    }

    public void setId_poczty(int id_poczty) {
        this.id_poczty = id_poczty;
    }
}
