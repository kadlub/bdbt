package bdbt_bada_project.SpringApplication;

import java.sql.Date;

public class Oddzialy
{
    private int id_oddzialu;
    private Date data_zalozenia;
    private int id_dostawcy;
    private int id_adresu;

    public Oddzialy(){

    }

    public Oddzialy(int id_oddzialu, Date data_zalozenia, int id_dostawcy, int id_adresu) {
        super();
        this.id_oddzialu = id_oddzialu;
        this.data_zalozenia = data_zalozenia;
        this.id_dostawcy = id_dostawcy;
        this.id_adresu = id_adresu;
    }

    public int getId_oddzialu() {
        return id_oddzialu;
    }

    public void setId_oddzialu(int id_oddzialu) {
        this.id_oddzialu = id_oddzialu;
    }

    public Date getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(Date data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public int getId_dostawcy() {
        return id_dostawcy;
    }

    public void setId_dostawcy(int id_dostawcy) {
        this.id_dostawcy = id_dostawcy;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }
    @Override
    public String toString() {
        return "Oddzialy{" +
                "id_oddzialu=" + id_oddzialu +
                ", data_zalozenia=" + data_zalozenia +
                ", id_dostawcy=" + id_dostawcy +
                ", id_adresu=" + id_adresu +
                '}';
    }
}
