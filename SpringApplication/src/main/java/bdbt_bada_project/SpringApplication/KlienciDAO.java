package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
        String sql = "SELECT * FROM KLIENCI2";

        List<Klienci> listKlienci = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Klienci.class));

        return listKlienci;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klienci klient) {
    }
    /* Read – odczytywanie danych z bazy */
    public Klienci get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Klienci klient) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}