package com.claro.miclaro.cuenta.prepago.client;

import com.claro.miclaro.cuenta.prepago.config.ApplicationProperties;
import com.claro.miclaro.cuenta.prepago.dto.DetallePlanResponse;

public interface DetailPlanProxy {
	
	DetallePlanResponse obtenerDetallePlan(String subTipo, ApplicationProperties properties) throws Exception;

}
