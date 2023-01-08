package bdbt_bada_project.SpringApplication;

import java.util.Date;

public class Klienci {

    private int id;
    private String imie;
    private String nazwisko;
    private String nr_telefonu;
    private String email;
    private float zuzycie_pradu;
    private Date data_zawarcia_umowy;
    private Date data_zakonczenia_umowy;
    private int id_adresu;

    public Klienci(){

    }

    public Klienci(int id, String imie, String nazwisko, String nr_telefonu, String email, float zuzycie_pradu, Date data_zawarcia_umowy, Date data_zakonczenia_umowy, int id_adresu) {

        super();
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.zuzycie_pradu = zuzycie_pradu;
        this.data_zawarcia_umowy = data_zawarcia_umowy;
        this.data_zakonczenia_umowy = data_zakonczenia_umowy;
        this.id_adresu = id_adresu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getZuzycie_pradu() {
        return zuzycie_pradu;
    }

    public void setZuzycie_pradu(float zuzycie_pradu) {
        this.zuzycie_pradu = zuzycie_pradu;
    }

    public Date getData_zawarcia_umowy() {
        return data_zawarcia_umowy;
    }

    public void setData_zawarcia_umowy(Date data_zawarcia_umowy) {
        this.data_zawarcia_umowy = data_zawarcia_umowy;
    }

    public Date getData_zakonczenia_umowy() {
        return data_zakonczenia_umowy;
    }

    public void setData_zakonczenia_umowy(Date data_zakonczenia_umowy) {
        this.data_zakonczenia_umowy = data_zakonczenia_umowy;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Klienci{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", email='" + email + '\'' +
                ", zuzycie_pradu=" + zuzycie_pradu +
                ", data_zawarcia_umowy=" + data_zawarcia_umowy +
                ", data_zakonczenia_umowy=" + data_zakonczenia_umowy +
                ", id_adresu=" + id_adresu +
                '}';
    }
}
