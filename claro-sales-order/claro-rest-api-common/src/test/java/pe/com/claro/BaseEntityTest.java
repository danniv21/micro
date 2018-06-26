/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pe.com.claro.common.model.BaseEntity;
import pe.com.claro.common.resource.exception.ApiError;

/**
 *
 * @author user
 */
@RunWith(MockitoJUnitRunner.class)
public class BaseEntityTest {

    BaseEntity bentity;

    public void inicial() {
    }

    @Test()
    public void baseEntityTest() throws Exception {
        BaseEntity bentity = stubServiceToReturnStoredCustomer();
        BaseEntity bentityInit;
        bentityInit = Utiltest.createBaseEntity();
        //System.out.println("ssssss"+bentityInit.getLastModifiedBy());
        assertEquals(bentity.getLastModifiedBy(), bentityInit.getLastModifiedBy());

    }

    @Test()
    public void ApiErrorTest() throws Exception {
        ApiError apiError = new ApiError();
        //assertEquals(bentity.getLastModifiedBy(), bentityInit.getLastModifiedBy());

    }

    private BaseEntity stubServiceToReturnStoredCustomer() {
        BaseEntity baseEntity = Utiltest.createBaseEntity();
        //when(bentity).thenReturn(baseEntity);
        return baseEntity;
    }
}
