package testngImplementation;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLib.BaseClass;
import genericLib.IConstantPath;
import genericLib.TabNames;

public class CreateAndDuplicateLeadTest extends BaseClass {

	@Test
	public void createAndDuplicateLeadTest() {
		SoftAssert soft = new SoftAssert();
		
		home.clickRequiredTab(TabNames.LEADS, webUtil);
		soft.assertTrue(driver.getTitle().contains("Leads"));
		
		leads.clickPlusButton();
		soft.assertTrue(createLead.getPageHeader().contains("Creating New Lead"));
		
		Map<String,String> map = excel.getDataFromExcel("LeadsTestData", "Create and Duplicate Lead");

		String lastName = map.get("Last Name")+ jutil.generateRandomNumber(100);
		createLead.setLastName(lastName);
		
		String company = map.get("Company")+ jutil.generateRandomNumber(100);
		createLead.setCompanyName(company);
		createLead.clickSaveButton();
		
		soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
		newLeadInfo.clickDuplicateButton();
		
		soft.assertTrue(duplicatingLead.getPageHeader().contains("Duplicating \""+lastName+"\""));
		
		String newLastName = map.get("New Last Name")+jutil.generateRandomNumber(100);
		duplicatingLead.setLastName(newLastName);
		duplicatingLead.clickSaveButton();
		
		soft.assertTrue(newLeadInfo.getPageHeader().contains(newLastName));
		if(newLeadInfo.getPageHeader().contains(newLastName)) 
			excel.writeDataToExcel("LeadsTestData", "Create and Duplicate Lead", "Pass", IConstantPath.EXCEL_PATH);
		else 
			excel.writeDataToExcel("LeadsTestData", "Create and Duplicate Lead", "Fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
	}

}
