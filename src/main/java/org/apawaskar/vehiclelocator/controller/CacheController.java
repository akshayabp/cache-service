package org.apawaskar.vehiclelocator.controller;

import org.apawaskar.vehiclelocator.domain.RouteInfo;
import org.apawaskar.vehiclelocator.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CacheController {
	
	@Autowired
	private CacheService cacheService;

	@RequestMapping("/route/{id}")
	public RouteInfo getRouteInfo(@PathVariable("id") String routeId){
		RouteInfo savedRoute = cacheService.getRouteInfo(routeId);	
		return savedRoute;
	}
}
