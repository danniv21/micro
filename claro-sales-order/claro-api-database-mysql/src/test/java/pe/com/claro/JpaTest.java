/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro;

import com.zaxxer.hikari.HikariDataSource;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 *
 * @author user
 */
@RunWith(MockitoJUnitRunner.class)
public class JpaTest {

    @Mock
    private JpaConfig jpa;
    private HikariDataSource ds;

    @Before
    public void setUp() throws Exception {

    }
    public void inicial() {
        jpa = new JpaConfig();
        jpa.setCachePrepStmts("yes");
        jpa.setPrepStmtCacheSize("8");
        jpa.setPrepStmtCacheSqlLimit("8");
        jpa.setCharacterEncoding("utf8");
        jpa.setConnectionTimeout(10);
        jpa.setDialect("org.hibernate.dialect.MySQLDialect");
        jpa.setDriver("com.mysql.jdbc.Driver");
        jpa.setFormatSql(Boolean.TRUE);
        jpa.setPackagesToScan("pe.com.claro");
        jpa.setPassword("R00tPass0wrd");
        jpa.setUnicode("true");
        jpa.setUrl("jdbc:mysql://localhost:3306/test");
        jpa.setUseServerPrepStmts("true");
        jpa.setUsername("root");
        //jpa.setDataSource(ds);

    }
    @Test(expected = java.lang.Exception.class)
    public void jpaConfTest() throws Exception {
        LocalContainerEntityManagerFactoryBean lcManager = new LocalContainerEntityManagerFactoryBean();
        final HikariDataSource ds = Utiltest.createConnection();
        inicial();
        //when(jpa.configureDataSource()).thenReturn(ds);
        lcManager = jpa.entityManagerFactory();
    }

}
