package org.apawaskar.vehiclelocator.services;

import org.apawaskar.vehiclelocator.domain.RouteInfo;
import org.springframework.cache.annotation.Cacheable;

public interface CacheService {

	
	RouteInfo getRouteInfo(String routeId);
}
