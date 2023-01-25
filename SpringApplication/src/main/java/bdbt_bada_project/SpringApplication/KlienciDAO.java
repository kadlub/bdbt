package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlienciDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List (zawiera info z bazy danych) */
    public KlienciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Klienci> list(){
        String sql = "SELECT * FROM KLIENCI2 NATURAL JOIN ADRESY NATURAL JOIN (select id_adresu, miasto, ulica, nr_lokalu, id_poczty, kod_pocztowy, poczta FROM ADRESY NATURAL JOIN POCZTY) ORDER BY ID_KLIENTA";

        List<Klienci> listKlienci = jdbcTemplate.query(sql,
                (rs, arg1) ->{
                    Klienci klient = new Klienci();
                    Adresy adres = new Adresy();
                    Poczty poczta = new Poczty();


                    klient.setId_klienta(rs.getInt("id_klienta"));
                    klient.setImie(rs.getString("imie"));
                    klient.setNazwisko(rs.getString("nazwisko"));
                    klient.setNr_telefonu(rs.getString("nr_telefonu"));
                    klient.setEmail(rs.getString("email"));
                    klient.setZuzycie_pradu(rs.getFloat("zuzycie_pradu"));
                    klient.setData_zawarcia_umowy(rs.getDate("data_zawarcia_umowy"));
                    klient.setData_zakonczenia_umowy(rs.getDate("data_zakonczenia_umowy"));
                    klient.setId_adresu(rs.getInt("id_adresu"));

                    
                    adres.setId_adresu(rs.getInt("id_adresu"));
                    adres.setMiasto(rs.getString("miasto"));
                    adres.setUlica(rs.getString("ulica"));
                    adres.setNr_lokalu(rs.getInt("nr_lokalu"));
                    adres.setId_poczty(rs.getInt("id_poczty"));

                    poczta.setId_poczty(rs.getInt("id_poczty"));
                    poczta.setPoczta(rs.getString("poczta"));
                    poczta.setKod_pocztowy(rs.getString("kod_pocztowy"));




                    klient.setAdres(adres);
                    klient.setPoczta(poczta);
                   return klient; 
                });

        return listKlienci;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klienci klient) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KLIENCI2").usingColumns("id_klienta","imie", "nazwisko", "nr_telefonu","email",
                "zuzycie_pradu","data_zawarcia_umowy", "data_zakonczenia_umowy", "id_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Klienci get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM KLIENCI2 NATURAL JOIN ADRESY NATURAL JOIN (select id_adresu, miasto, " +
                "ulica, nr_lokalu, id_poczty FROM ADRESY) WHERE ID_KLIENTA=?";

        Klienci klient = jdbcTemplate.queryForObject(sql, args,
                (rs, arg1) -> {
                    Klienci newKlient = new Klienci();
                    Adresy adres = new Adresy();

                    newKlient.setId_klienta(rs.getInt("id_klienta"));
                    newKlient.setImie(rs.getString("imie"));
                    newKlient.setNazwisko(rs.getString("nazwisko"));
                    newKlient.setNr_telefonu(rs.getString("nr_telefonu"));
                    newKlient.setEmail(rs.getString("email"));
                    newKlient.setZuzycie_pradu(rs.getFloat("zuzycie_pradu"));
                    newKlient.setData_zawarcia_umowy(rs.getDate("data_zawarcia_umowy"));
                    newKlient.setData_zakonczenia_umowy(rs.getDate("data_zakonczenia_umowy"));
                    newKlient.setId_adresu(rs.getInt("id_adresu"));
                    newKlient.setAdres(adres);

                    adres.setId_adresu(rs.getInt("id_adresu"));
                    adres.setMiasto(rs.getString("miasto"));
                    adres.setUlica(rs.getString("ulica"));
                    adres.setNr_lokalu(rs.getInt("nr_lokalu"));
                    adres.setId_poczty(rs.getInt("id_poczty"));



                    return newKlient;
                });

        return klient;
    }
    /* Update – aktualizacja danych */
    public void update(Klienci klient) {
        String sql = "UPDATE KLIENCI2 SET imie=:imie, nazwisko=:nazwisko, nr_telefonu=:nr_telefonu, email=:email, " +
                "Zuzycie_pradu=:zuzycie_pradu, data_zawarcia_umowy=:data_zawarcia_umowy ," +
                "data_zakonczenia_umowy=:data_zakonczenia_umowy,id_adresu=:id_adresu " +
                "WHERE id_klienta=:id_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql ="DELETE FROM KLIENCI2 WHERE id_klienta = ?";
        jdbcTemplate.update(sql, id);
    }
}