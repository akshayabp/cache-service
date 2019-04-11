package org.apawaskar.vehiclelocator.domain;

public class Route {
	
	private String routeId;
	
	private Location source;
	
	private Location destination;
			
	private long driverId;
	
	private long vehcileId;

	public Location getSource() {
		return source;
	}

	public void setSource(Location source) {
		this.source = source;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	
	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public long getVehcileId() {
		return vehcileId;
	}

	public void setVehcileId(long vehcileId) {
		this.vehcileId = vehcileId;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", driverId="
				+ driverId + ", vehcileId=" + vehcileId + "]";
	}

	

}
