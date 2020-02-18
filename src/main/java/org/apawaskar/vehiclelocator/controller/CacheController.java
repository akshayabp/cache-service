package org.apawaskar.vehiclelocator.controller;

import org.apawaskar.vehiclelocator.domain.RouteInfo;
import org.apawaskar.vehiclelocator.services.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CacheController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheController.class);	
	
	@Autowired
	private CacheService cacheService;
	
	@RequestMapping(value="/route/{id}",  method=RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable("id") String routeId){			
		cacheService.deleteRouteInfo(routeId);		
		
	}

	@RequestMapping("/route/{id}")
	public RouteInfo getRouteInfo(@PathVariable("id") String routeId){
		RouteInfo savedRoute = cacheService.getRouteInfo(routeId);		
		LOGGER.info("Route details for id: {} : {}", routeId, savedRoute);		
		return savedRoute;
	}
}
