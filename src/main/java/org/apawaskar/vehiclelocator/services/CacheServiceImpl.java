package org.apawaskar.vehiclelocator.services;

import org.apawaskar.vehiclelocator.domain.Driver;
import org.apawaskar.vehiclelocator.domain.Route;
import org.apawaskar.vehiclelocator.domain.RouteInfo;
import org.apawaskar.vehiclelocator.domain.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CacheServiceImpl implements CacheService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	@Cacheable("routeCache")
	public RouteInfo getRouteInfo(String routeId) {
		RouteInfo routeInfo = new RouteInfo();
		
		LOGGER.debug("Fetching route {} from microservices", routeId);		
		routeInfo.setRouteId(routeId);

		Route route = getRoute(routeId);

		routeInfo.setSource(route.getSource());
		routeInfo.setDestination(route.getDestination());

		Vehicle vehicle = getVehicle(route.getVehcileId());
		Driver driver = getDriver(route.getDriverId());

		routeInfo.setVehicle(vehicle);
		routeInfo.setDriver(driver);
		
		return routeInfo;
	}
	
	private Vehicle getVehicle(long vehicleId){
		Vehicle vehicle = null;
		
		 ResponseEntity<Vehicle> restExchange =
	                restTemplate.exchange(
	                        "http://vehicle-locator-management-service/vehicle/{id}",
	                        HttpMethod.GET,
	                        null, Vehicle.class, vehicleId);
		 
		 vehicle = restExchange.getBody();
		
		return vehicle;
	}
	
	private Route getRoute(String routeId){
		ResponseEntity<Route> restExchange =
                restTemplate.exchange(
                        "http://route-service/route/{id}/shortinfo",
                        HttpMethod.GET,
                        null, Route.class, routeId);
	 
	
	return restExchange.getBody();
	}
	
	private Driver getDriver(long driverId){
		ResponseEntity<Driver> restExchange =
                restTemplate.exchange(
                        "http://vehicle-locator-management-service/driver/{id}",
                        HttpMethod.GET,
                        null, Driver.class, driverId);
	 
	
	return restExchange.getBody();
	}

}
