package pages;

public class ServiceNowGrpHierarchy extends IncUserServiceNow {
	public ServiceNowGrpHierarchy assignGroup(String assnGrp) throws InterruptedException {
		//click(locateElement("xpath","//input[@placeholder='Search']"));
		System.out.println(assnGrp);
		TypeAndEnter(locateElement("xpath","(//label[text()='Search'])[2]/following::input"), assnGrp);
		return this;
	}
	public ServiceNowGrpHierarchy assignToGroup(String assnToGrp) throws InterruptedException {
		System.out.println(assnToGrp);
		TypeAndEnter(locateElement("xpath","(//label[text()='Search'])[2]/following::input"), assnToGrp);
		return this;
	}
	public IncidentDataServices clickOnIncSoftware() {
		click(locateElement("link", "Software"));
		switchToWindow(0);
		switchToFrame(0);
		return new IncidentDataServices();
	}
	public IncidentDataServices clickOnITILUser() {
		click(locateElement("link", "ITIL User"));
		switchToWindow(0);
		switchToFrame(0);
	return new IncidentDataServices();
	}
}
