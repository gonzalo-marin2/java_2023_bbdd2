package service;

public class FormacionServiceFactory {
	//devuelve una implementación de la interfaz
	public static FormacionService getFormacionService() {
		return new FormacionServiceImpl();
	}

}
