package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KlienciDAOTest extends Object {

    private KlienciDAO dao;
    //private AdresyDAO adrDAO;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("BDBTGRC14");
        dataSource.setPassword("BDBTGRC14");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new KlienciDAO(new JdbcTemplate(dataSource));
       // adrDAO = new AdresyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Klienci> listKlienci = dao.list();
        System.out.println(Arrays.toString(listKlienci.toArray()));

        assertTrue(!listKlienci.isEmpty());
    }

    @Test
    void save() {
        Klienci newKlient = new Klienci(24, "Jan", "Kowal", "8912894012", "kuba@gmail.com", +
                123, new Date(2022,2,5), new Date(2022, 5, 15), 4);


        dao.save(newKlient);
    }

    @Test
    void get() {
        int id = 3;
        Klienci newKlient = dao.get(id);
        System.out.println(newKlient);
        assertNotNull(newKlient);
    }

    @Test
    void update() {
        int id = 8;
        Klienci newKlient = dao.get(id);
        String oldName = newKlient.getImie();
        newKlient.setImie("Kuba_jest_najlepszy");

        dao.update(newKlient);
        newKlient = dao.get(id);

        assertNotEquals(newKlient.getImie(), oldName);
    }

    @Test
    void delete() {
        int nOfRecords = dao.list().size();
        int id = 7;
        dao.delete(7);
        int newNOfRecords = dao.list().size();

        assertEquals(nOfRecords - 1, newNOfRecords);
    }
}