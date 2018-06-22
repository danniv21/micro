/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author user
 */
@Configuration
@EnableAutoConfiguration
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {pe.com.claro.JpaConfig.class})
public class JpaConfigTest {
    //@Mock
    // private UserRepository userRepository;

    @Value("${spring.dataSource.driverClassName2:admin@example.com}")
    private String theSubscriber;
    // private UserService userService;
    @Autowired
    private JpaConfig jpa;

    @Before
    public void beforeClass() {
        System.setProperty("spring.dataSource.driverClassName", "valorNuevo");
        System.setProperty("spring.dataSource.url", "valor");
        System.setProperty("spring.dataSource.username", "valor");
        System.setProperty("spring.dataSource.password", "valor");
        System.setProperty("spring.hibernate.dialect", "valor");
        System.setProperty("spring.hibernate.show_sql", "valor");
        System.setProperty("spring.hibernate.format_sql", "valor");
        System.setProperty("entity.manager.packagesToScan", "valor");
        System.setProperty("spring.hibernate.unicode", "valor");
        System.setProperty("spring.hibernate.characterEncoding", "valor");
        System.setProperty("spring.hibernate.cachePrepStmts", "valor");
        System.setProperty("spring.hibernate.prepStmtCacheSize", "valor");
        System.setProperty("spring.hibernate.prepStmtCacheSqlLimit", "valor");
        System.setProperty("spring.hibernate.useServerPrepStmts", "valor");
        System.setProperty("spring.dataSource.connectionTimeout", "valor");

    }

    @Test
    public void setUp() throws Exception {
        System.out.println("Nombre Driver: " + System.getProperty("spring.dataSource.driverClassName"));
        System.out.println("Nombre Driver: " + System.getProperty("spring.hibernate.useServerPrepStmts"));
        System.out.println("Otra prueba valor: " + theSubscriber);
//        JpaConfig jpaConf = new JpaConfig();
        jpa = new JpaConfig();

        System.out.println("Value Driver: " + jpa.getDriverName());
        jpa.configureDataSource();
    }

    @Test
    public void jpaConfigTest() throws Exception {
//        final User savedUser = stubRepositoryToReturnUserOnSave();
//        final User user = UserUtil.createUser();
//        final User returnedUser = userService.save(user);
//        verify(userRepository, times(1)).save(user);
//        assertEquals("Returned user should come from the repository", savedUser, returnedUser);
    }
}
