package pe.com.claro;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({"pe.com.claro"})
class JpaConfig implements TransactionManagementConfigurer {

    @Value("${spring.dataSource.driverClassName}")
    private String driver;
    @Value("${spring.dataSource.url}")
    private String url;
    @Value("${spring.dataSource.username}")
    private String username;
    @Value("${spring.dataSource.password}")
    private String password;
    @Value("${spring.hibernate.dialect}")
    private String dialect;
/*    @Value("${spring.hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;*/
    @Value("${spring.hibernate.show_sql}")
    private Boolean showSql;
    @Value("${spring.hibernate.format_sql}")
    private Boolean format_sql;
    @Value("${entity.manager.packagesToScan}")
    private String packagesToScan;
    
    @Value("${spring.hibernate.unicode}")
    private String unicode;
    
    @Value("${spring.hibernate.characterEncoding}")
    private String characterEncoding;
    
    @Value("${spring.hibernate.cachePrepStmts}")
    private String cachePrepStmts;
    
    @Value("${spring.hibernate.prepStmtCacheSize}")
    private String prepStmtCacheSize;
      
    @Value("${spring.hibernate.prepStmtCacheSqlLimit}")
    private String prepStmtCacheSqlLimit;
    
    @Value("${spring.hibernate.useServerPrepStmts}")
    private String useServerPrepStmts;
    
    @Value("${spring.dataSource.connectionTimeout}")
    private long connectionTimeout;
    
    
    
    @Bean
    public DataSource configureDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        // We will wait for 15 seconds to get a connection from the pool.
        // Default is 30, but it shouldn't be taking that long.
        config.setConnectionTimeout(TimeUnit.SECONDS.toMillis(connectionTimeout)); // 15000

        config.addDataSourceProperty("useUnicode", unicode);
        config.addDataSourceProperty("characterEncoding", characterEncoding);
        config.addDataSourceProperty("cachePrepStmts", cachePrepStmts);
        config.addDataSourceProperty("prepStmtCacheSize", prepStmtCacheSize);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", prepStmtCacheSqlLimit);
        config.addDataSourceProperty("useServerPrepStmts", useServerPrepStmts);

        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(configureDataSource());
      //  entityManagerFactoryBean.setPackagesToScan("com.raysmond.blog");
        entityManagerFactoryBean.setPackagesToScan(packagesToScan);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
        //jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
        jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, showSql);
        jpaProperties.put(org.hibernate.cfg.Environment.FORMAT_SQL, format_sql);
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }
}
