package com.UNLa.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	//HOME
	public final static String INDEX = "/";

	//GET
	public final static String DISPOSITIVOS_INDEX = "dispositivos/";
	public final static String DISPOSITIVOS_ABM ="/devices/crud";
	
	public final static String SENSORES_ESTACIONAMIENTO_INDEX = "/dispositivos/SensorEstacionamiento";
	public final static String SENSORES_ESTACIONAMIENTO_ABM = "/devices/parkingSensor/crud";

	public final static String ESTACIONAMIENTO_INDEX= "/estacionamientos";
	public final static String ESTACIONAMIENTO_ABM = "/parkingSpots/crud";
	
	public final static String HOME_MAP= "/mapa";
	public final static String HOME_ESTACIONAR = "/buscarEstacionamiento";
	public final static String ESTACIONAR = "/simulateParking";
	
	
	//USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";

	/**** Redirects ****/
	public final static String ROUTE = "/";
	
}
