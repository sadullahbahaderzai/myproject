package tek.capstone.framework.steps;

import java.util.List;   
import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.framework.pages.POMFactory;
import tek.capstone.framework.utilities.CommonUtility;

public class RetailHomeSteps extends CommonUtility{
	

	
	POMFactory pomFactory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection() {
		
		click(pomFactory.homePage().allOptions);
		logger.info("All Options dropdown was clicked");

	}
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		
		List<List<String>> shopByDepartment = dataTable.asLists(String.class);
		for(int i = 0; i < shopByDepartment.get(0).size(); i++) {
			Assert.assertTrue(isElementDisplayed(
					getDriver().findElement(By.xpath("//div[@class='sidebar__content']//span[text()='"+shopByDepartment.get(0).get(i)+"']"))));
			logger.info("Option " + shopByDepartment.get(0).get(i) + " is displayed");
		}

	}
}
