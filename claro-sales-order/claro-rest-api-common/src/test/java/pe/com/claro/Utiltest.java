/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.mockito.Mock;
import pe.com.claro.common.model.BaseEntity;

/**
 *
 * @author user
 */
class Utiltest {

    private static Long id = new Long("10");

    private static String createdBy = " Usuario";

    private static Date createdDate = new Date("28/03/2018");

    private static String lastModifiedBy = "usuario";

    private static Date lastModifiedDate = new Date("28/03/2018");

    private static boolean deleted = false;

    public Utiltest() {

    }

    public static BaseEntity createBaseEntity() {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setCreatedBy(createdBy);
        baseEntity.setCreatedDate(createdDate);
        baseEntity.setDeleted(deleted);
        baseEntity.setId(id);
        baseEntity.setLastModifiedBy(lastModifiedBy);
        baseEntity.setLastModifiedDate(lastModifiedDate);
        return baseEntity;
    }
}
