package hooks;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.DataLibrary;
import wrappers.BaseDriver;

public class TestNgHooks extends BaseDriver {

	public String dataSheetName;

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}

	@BeforeMethod
	public void beforeMethod() {
		startApp("chrome", "https://dev51224.service-now.com/");
		switchToFrame(0);
		setNode();
	}

	@AfterMethod
	public void afterMethod() {
		close();
	}

}
