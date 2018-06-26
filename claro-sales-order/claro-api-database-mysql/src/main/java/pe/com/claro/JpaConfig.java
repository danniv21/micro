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
public class JpaConfig implements TransactionManagementConfigurer {


    @Value("${spring.dataSource.driverClassName:Default}")
    private String driver;
    @Value("${spring.dataSource.url}")
    private String url;
    @Value("${spring.dataSource.username}")
    private String username;
    @Value("${spring.dataSource.password}")
    private String password;
    @Value("${spring.hibernate.dialect}")
    private String dialect;
    @Value("${spring.hibernate.show_sql}")
    private Boolean showSql;
    @Value("${spring.hibernate.format_sql}")
    private Boolean formatsql;
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
    HikariConfig config = new HikariConfig();

    @Bean
    public DataSource configureDataSource() {
        config.setDriverClassName(getDriver());
        config.setJdbcUrl(getUrl());
        config.setUsername(getUsername());
        config.setPassword(getPassword());
        // We will wait for 15 seconds to get a connection from the pool.
        // Default is 30, but it shouldn't be taking that long.
        config.setConnectionTimeout(TimeUnit.SECONDS.toMillis(getConnectionTimeout())); // 15000

        config.addDataSourceProperty("useUnicode", getUnicode());
        config.addDataSourceProperty("characterEncoding", getCharacterEncoding());
        config.addDataSourceProperty("cachePrepStmts", getCachePrepStmts());
        config.addDataSourceProperty("prepStmtCacheSize", getPrepStmtCacheSize());
        config.addDataSourceProperty("prepStmtCacheSqlLimit", getPrepStmtCacheSqlLimit());
        config.addDataSourceProperty("useServerPrepStmts", getUseServerPrepStmts());
        
        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(configureDataSource());
        entityManagerFactoryBean.setPackagesToScan(getPackagesToScan());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, getDialect());
        jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, getShowSql());
        jpaProperties.put(org.hibernate.cfg.Environment.FORMAT_SQL, getFormatSql());
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }

    public String getDriverName() {
        return getDriver();
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the dialect
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * @param dialect the dialect to set
     */
    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    /**
     * @return the showSql
     */
    public Boolean getShowSql() {
        return showSql;
    }

    /**
     * @param showSql the showSql to set
     */
    public void setShowSql(Boolean showSql) {
        this.showSql = showSql;
    }

    /**
     * @return the formatsql
     */
    public Boolean getFormatSql() {
        return formatsql;
    }

    /**
     * @param formatsql the formatsql to set
     */
    public void setFormatSql(Boolean formatsql) {
        this.formatsql = formatsql;
    }

    /**
     * @return the packagesToScan
     */
    public String getPackagesToScan() {
        return packagesToScan;
    }

    /**
     * @param packagesToScan the packagesToScan to set
     */
    public void setPackagesToScan(String packagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    /**
     * @return the unicode
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * @param unicode the unicode to set
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * @return the characterEncoding
     */
    public String getCharacterEncoding() {
        return characterEncoding;
    }

    /**
     * @param characterEncoding the characterEncoding to set
     */
    public void setCharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    /**
     * @return the cachePrepStmts
     */
    public String getCachePrepStmts() {
        return cachePrepStmts;
    }

    /**
     * @param cachePrepStmts the cachePrepStmts to set
     */
    public void setCachePrepStmts(String cachePrepStmts) {
        this.cachePrepStmts = cachePrepStmts;
    }

    /**
     * @return the prepStmtCacheSize
     */
    public String getPrepStmtCacheSize() {
        return prepStmtCacheSize;
    }

    /**
     * @param prepStmtCacheSize the prepStmtCacheSize to set
     */
    public void setPrepStmtCacheSize(String prepStmtCacheSize) {
        this.prepStmtCacheSize = prepStmtCacheSize;
    }

    /**
     * @return the prepStmtCacheSqlLimit
     */
    public String getPrepStmtCacheSqlLimit() {
        return prepStmtCacheSqlLimit;
    }

    /**
     * @param prepStmtCacheSqlLimit the prepStmtCacheSqlLimit to set
     */
    public void setPrepStmtCacheSqlLimit(String prepStmtCacheSqlLimit) {
        this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
    }

    /**
     * @return the useServerPrepStmts
     */
    public String getUseServerPrepStmts() {
        return useServerPrepStmts;
    }

    /**
     * @param useServerPrepStmts the useServerPrepStmts to set
     */
    public void setUseServerPrepStmts(String useServerPrepStmts) {
        this.useServerPrepStmts = useServerPrepStmts;
    }

    /**
     * @return the connectionTimeout
     */
    public long getConnectionTimeout() {
        return connectionTimeout;
    }

    /**
     * @param connectionTimeout the connectionTimeout to set
     */
    public void setConnectionTimeout(long connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
}
