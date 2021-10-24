package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.ServiceLoginPage;

public class TC_ResolveIncident extends TestNgHooks{
	@BeforeTest
	public void setData() {
		testCaseName="Assign Incident";
		testDescription="Resolving the Incident with Resolution Notes";
		nodes="Incidents";
		dataSheetName="TC_ResolveIncident";
		category="Smoke";
		authors="Sarav";
	}
	@Test(dataProvider="fetchData")
	public void resolveIncident(String userName, String password, String filterNav, String existingIncNum, String resolNotes,
			String expectedStateVal) 
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
		.assignResolutionInformation(resolNotes)
		.clickOnResolveButton()
		.getResultantState()
		.verifyResolvedIncidentStatus(existingIncNum, expectedStateVal);
	}
}

/* Output:-
 * */
