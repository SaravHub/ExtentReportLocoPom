package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.ServiceLoginPage;

public class TC_AssignIncident extends TestNgHooks{
	@BeforeTest
	public void setData() {
		testCaseName="Assign Incident";
		testDescription="Assiging the Incident with Group and 'Assigned to field'";
		nodes="Incidents";
		dataSheetName="TC_AssignIncident";
		category="Smoke";
		authors="Sarav";
	}
	@Test(dataProvider="fetchData")
	public void assignIncident(String userName, String password, String filterNav, String existingIncNum, String assnGrp,String assToGrp) 
			throws InterruptedException  {
		new ServiceLoginPage()
		.typeUName(userName)
		.typePwd(password)
		.clickLoginButton()
		.filterNavigatorIncident(filterNav)
		.clickOpenOption()
		.assignExistingIncidentNum(existingIncNum)
		.clickOnResultingIncNum()
		.clickAssignLookup()
		.assignGroup(assnGrp)
		.clickOnIncSoftware()
		.clickAssignToLookup()
		.assignToGroup(assToGrp)
		.clickOnITILUser()
		.clickUpdateBtn()
		.getResultantIncAssignedTo()
		.verifyAssessIncident(existingIncNum);
	}
}

/* Output:-
 * The Window With index: 1 switched successfully
Software
[1632651176.227][SEVERE]: Unable to receive message from renderer
The browser has been closed.
The Window With index: 0 switched successfully
The Window With index: 1 switched successfully
ITIL User
The browser has been closed.
The Window With index: 0 switched successfully
Num: INC0010022AssignedTo: ITIL User

0 Scenarios
0 Steps
4m37.510s
PASSED: assignIncident("admin", "247$@r@Gemini247", "Incident", "INC0010022", "Software", "ITIL User")*/
