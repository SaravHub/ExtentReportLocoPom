package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.ServiceLoginPage;

public class TC_CreateIncident extends TestNgHooks{
	@BeforeTest
	public void setData() {
		testCaseName = "Create New Incident";
		testDescription = "Create new incident on Service Now application";
		nodes = "Incident";
		dataSheetName = "TC_CreateIncident";
		category = "Sanity";
		authors = "Sarav";
	}
	@Test(dataProvider = "fetchData")
	public void createIncidentTest(String userName, String password, String filterNav, String shortDesc) 
		throws InterruptedException {
		new ServiceLoginPage()
		.typeUName(userName)
		.typePwd(password)
		.clickLoginButton()
		.filterNavigatorIncident(filterNav)
		.clickNewButton()
		.getIncNumber()
		.clickCallerInfoLookup()
		.assignUserValue()
		.assignShortDesc(shortDesc)
		.clickOnSubmitButton()
		.searchOptionNum()
		.assignIncidentNum()
		.verifyCreatedIncident();
		
	}
}

//INC0010022
