package pages;

import hooks.TestNgHooks;

public class ServiceHomePage extends TestNgHooks{
	public IncidentSelfService filterNavigatorIncident(String filterNav) throws InterruptedException {
		TypeAndEnter(locateElement("id", "filter"), filterNav);
		// switchToFrame(0);
		return new IncidentSelfService();
	}
	
}