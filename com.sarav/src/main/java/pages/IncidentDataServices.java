package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;

public class IncidentDataServices extends TestNgHooks {
	public IncidentDataServices assignStateValue() throws InterruptedException {
		selectDropDownUsingIndex(locateElement("incident.state"), 1);
		return this;
	}
	public IncidentDataServices assignStateValueResolve() throws InterruptedException {
		selectDropDownUsingIndex(locateElement("incident.state"), 3);
		return this;
	}
	public IncidentDataServices assignUrgencyValue() throws InterruptedException {
		selectDropDownUsingIndex(locateElement("incident.urgency"), 0);
		return this;
	}
	public ServiceNowGrpHierarchy clickAssignLookup() throws InterruptedException {
		clickWithNoSnap(locateElement("lookup.incident.assignment_group"));
		switchToWindow(1);
		return new ServiceNowGrpHierarchy();
	}
	public ServiceNowGrpHierarchy clickAssignToLookup() throws InterruptedException {
		clickWithNoSnap(locateElement("lookup.incident.assigned_to"));
		switchToWindow(1);
		return new ServiceNowGrpHierarchy();
	}
	public IncidentSelfService clickUpdateBtn() {
		click(locateElement("sysverb_update_bottom"));
		return new IncidentSelfService();	
	}
	public IncidentSelfService clickOnResolveButton() {
		click(locateElement("resolve_incident"));
		return new IncidentSelfService();
	}
	public IncidentDataServices assignResolutionInformation(String resolNotes) {
		/*Actions act=new Actions(getDriver());*/
		click(locateElement("xpath","//span[text()='Resolution Information']"));
		selectDropDownUsingIndex(locateElement("incident.close_code"), 7);
		WebElement notes = getDriver().findElement(By.id("incident.close_notes"));
		clearAndType(notes, resolNotes);
	    return this;
	}
	public void clickDelBtn() {
		
	}
}