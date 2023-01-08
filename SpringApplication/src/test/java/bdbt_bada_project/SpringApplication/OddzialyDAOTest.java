package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OddzialyDAOTest extends Object {

    private OddzialyDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("BDBTGRC14");
        dataSource.setPassword("BDBTGRC14");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new OddzialyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Oddzialy> listOddzialy = dao.list();
        System.out.println(Arrays.toString(listOddzialy.toArray()));

        assertTrue(!listOddzialy.isEmpty());
    }

    @Test
    void save() {
        fail("Not yet implemented");
    }

    @Test
    void get() {
        fail("Not yet implemented");
    }

    @Test
    void update() {
        fail("Not yet implemented");
    }

    @Test
    void delete() {
    }
}