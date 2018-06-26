/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mockito.Mock;

/**
 *
 * @author user
 */
class Utiltest {


    private static HikariDataSource ds;
    @Mock private static final HikariConfig conf = new HikariConfig();
    public Utiltest() {
        conf.setAllowPoolSuspension(true);
        conf.setAutoCommit(true);
        //conf.setDataSourceClassName("jdbc:mysql://mysql:3306/test?serverTimezone=UTC");
        conf.setJdbcUrl("jdbc:mysql://mysql:3306/test?serverTimezone=UTC");
        conf.setDriverClassName("com.mysql.jdbc.Driver");
        conf.setUsername("root");
        ds = new HikariDataSource(conf);
        //jpa.setDataSource(new HikariDataSource(conf));
       // System.out.println("sss"+conf.getDriverClassName());
        //conf.setUsername("root");
    }

    public static HikariDataSource createConnection() {
        return ds ;
    }

//    public static List<Customer> createCustomerList(int howMany) {
//        List<Customer> customerList = new ArrayList<>();
//        for (int i = 0; i < howMany; i++) {
//            customerList.add(new Customer(customerEmail, customerLastName, customerName, status, customerAddresses));
//        }
//        return customerList;
//    }
}
