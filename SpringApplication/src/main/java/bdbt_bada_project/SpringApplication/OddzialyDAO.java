package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OddzialyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List (zawiera info z bazy danych) */
    public OddzialyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Oddzialy> list(){
        String sql = "SELECT * FROM ODDZIALY";

        List<Oddzialy> listEmployee = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Oddzialy.class));

        return listEmployee;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Oddzialy employee) {
    }
    /* Read – odczytywanie danych z bazy */
    public Oddzialy get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Oddzialy oddzial) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}