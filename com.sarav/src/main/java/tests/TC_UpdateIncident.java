package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.ServiceLoginPage;

public class TC_UpdateIncident extends TestNgHooks{
	@BeforeTest
	public void setData() {
		testCaseName="Update Incident";
		testDescription="Updating the Incident with Urgency and State";
		nodes="Incidents";
		dataSheetName="TC_UpdateIncident";
		category="Smoke";
		authors="Sarav";
	}
	@Test(dataProvider="fetchData")
	public void updateIncident(String userName, String password, String filterNav, String existingIncNum,String expectedStateVal, String expectedUrgencyVal) 
			throws InterruptedException  {
		new ServiceLoginPage()
		.typeUName(userName)
		.typePwd(password)
		.clickLoginButton()
		.filterNavigatorIncident(filterNav)
		.clickOpenOption()
		.assignExistingIncidentNum(existingIncNum)
		.clickOnResultingIncNum()
		.assignStateValue()
		.assignUrgencyValue()
		.clickUpdateBtn()
		.getResultantState()
		.getResultantUrgency()
		.verifyUpdatedIncidentStatus(existingIncNum, expectedStateVal, expectedUrgencyVal);
	}
}

/*In Progress
0 Scenarios
0 Steps
2m46.786s
PASSED: updateIncident("admin", "247$@r@Gemini247", "Incident", "INC0010022", "In Progress", "1 - High")*/
