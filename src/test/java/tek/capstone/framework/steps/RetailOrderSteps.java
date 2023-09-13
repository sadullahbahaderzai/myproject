package tek.capstone.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.framework.pages.POMFactory;
import tek.capstone.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility{
	POMFactory pomFactory = new POMFactory();
	
	//Add order to cart
	
	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String category) {
	    selectByVisibleText(pomFactory.retailOrderPage().allDepartmentDropdown, category);
	    logger.info("user changed category successfully");
	}
	@When("User search for an item {string}")
	public void userSearchForAnItem(String item) {
	    sendText(pomFactory.retailOrderPage().searchInputField, item);
	    logger.info("user searched for item and successfully ");
	}
	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
	    click(pomFactory.retailOrderPage().searchBttn);
	    logger.info("user clicked on search button successfully");
	}
	@When("User click on item")
	public void userClickOnItem() {
	    click(pomFactory.retailOrderPage().itemkasaoutdoorsmartplug);
	    logger.info("user clicked on selected item successfully");
	}
	@When("User select quantity {string}")
	public void userSelectQuantity(String quantity) {
	    selectByValue(pomFactory.retailOrderPage().qtyDropdown, quantity);
	    logger.info("user clicked on quantity successfully");
	}
	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
	    click(pomFactory.retailOrderPage().addToCartBttn);
	    logger.info("user added the item to card successfully");
	}
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String quantity) {
		if(pomFactory.retailOrderPage().qtyDropdown.getText().equals("2")) {
			logger.info("icon quantity changed to 2 successfully");
		}
	    
	}
	
	
	//Add item to cart and Place order 
	
	@Given("User change the category to {string} Apex Legends")
	public void userChangeTheCategoryToApexLegends(String category) {
	    selectByVisibleText(pomFactory.retailOrderPage().allDepartmentDropdown, category);
	    logger.info("user select Electronice from category successffully");
	}
	@Given("User search for an item {string} Apex Legends")
	public void userSearchForAnItemApexLegends(String item) {
	   sendText(pomFactory.retailOrderPage().searchInputField, item);
	   logger.info("user searched for item successfully");
	}
	@Given("User click on item Apex Legends")
	public void userClickOnItemApexLegends() {
	    click(pomFactory.retailOrderPage().apexLegendsItem);
	    logger.info("user clicked on item successfully");
	}
	@Given("User select quantity {string} for Apex Legends")
	public void userSelectQuantityForApexLegends(String quantity) {
	   selectByValue(pomFactory.retailOrderPage().qtyDropdown, quantity);
	   logger.info("user select quantity to 5 successfully");
	}
	@Then("the cart icon quantity should change to {string} Apex Legends")
	public void theCartIconQuantityShouldChangeToApexLegends(String quantity) {
	    Assert.assertTrue(pomFactory.retailOrderPage().qtyDropdown.isDisplayed());
	    logger.info("quantity displayed successfully");
	}
	@Then("User click on Cart option")
	public void userClickOnCartOption() {
	    click(pomFactory.retailOrderPage().cartBttn);
	    logger.info("user clicked on cart option successfully");
	}
	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
	    click(pomFactory.retailOrderPage().proceedToCheckoutBttn);
	    logger.info("user clicked on proceed to checkout button successfully");
	}
	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
	    click(pomFactory.retailOrderPage().placeOrderBttn);
	    logger.info("user clicked on place order button successfull");
	}
	@Then("a message should be displayed ‘Order Placed, Thanks’")
	public void aMessageShouldBeDisplayedOrderPlacedThanks() {
	    Assert.assertTrue(pomFactory.retailOrderPage().orderPlacedSuccessfullyMssg.isDisplayed());
	    logger.info("order placed and msg displayed sucessfully");
	}
	
	
	//Cancel order from order list
	
	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
	  click(pomFactory.retailOrderPage().OrderLink);
	  logger.info("user clicked on orders buttn successfully");
	}
	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
	   List <WebElement> orderList = pomFactory.retailOrderPage().listOfOrders;
	   for(int i =0; i<orderList.size();i++) {
		   if (orderList.get(i).getText().equalsIgnoreCase("Hide Details")) {
			   
		   }else if (orderList.get(i).getText().equalsIgnoreCase("Show Details")) {
			  click(pomFactory.retailOrderPage().listOfOrders.get(i));
		   }
	   }
	   logger.info("user select the first order on list successfully ");
	}
	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
	 List<WebElement> cancelOrdersBttn= pomFactory.retailOrderPage().cancelOrderBttn;
	 for(int i=0 ; i< cancelOrdersBttn.size();i++) {
		 click(pomFactory.retailOrderPage().cancelOrderBttn.get(0));
	 }
	   
	    logger.info("user clicked cancel on select item successfully");
	}
	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String Reason) {
	    selectByVisibleText(pomFactory.retailOrderPage().reasonForCancelation, Reason);
	}
	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
	    click(pomFactory.retailOrderPage().cancelOrderBttn);
	    logger.info("user clicked on cancel button successfully");
	}
	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String message) {
		waitTillPresence(pomFactory.retailOrderPage().orderCancelledSuccessMssg);
	    Assert.assertTrue(pomFactory.retailOrderPage().orderCancelledSuccessMssg.isDisplayed());
	    logger.info("order canceled and msg displayed successfully");
	}


	//Return Item from order list
	
	@When("User click on first order in list returning")
	public void userClickOnFirstOrderInListReturning() {
	    List <WebElement> orderLists = pomFactory.retailOrderPage().listOfOrders;
	    for(int i=0; i>orderLists.size();i++) {
	    	if(orderLists.get(i).getText().equalsIgnoreCase("Hide Details")) {
	    }else if(orderLists.get(i).getText().equalsIgnoreCase("Show Details")) {
	    	pomFactory.retailOrderPage().returnItemsList.get(i);
	    }
	    }
	    logger.info("user select the first item on orders successfully");
	}
	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
	   List<WebElement> returnItemList = pomFactory.retailOrderPage().returnItemsList;
	   for(int i =0; i<returnItemList.size();i++) {
		   click(returnItemList.get(i));
	   }
	   pomFactory.retailOrderPage().selectReturnItem.click();
	   logger.info("user clicked return button on selected item list successfully");
	}
	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String Reason) {
		selectByVisibleText(pomFactory.retailOrderPage().returnReason, Reason);
		logger.info("user select the return reason successfully");

	}
	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String service) {
	    selectByVisibleText(pomFactory.retailOrderPage().returnShipOption, service);
	    logger.info("user select the shipping option successfully");
	}
	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
	    click(pomFactory.retailOrderPage().returnOrderBttn);
	    logger.info("user clicked on return button successfully");
	}
	
	@Then("a returning message should be displayed {string}")
	public void aReturningMessageShouldBeDisplayed(String message) {
		waitTillPresence(pomFactory.retailOrderPage().returnSuccessMsg);
		String actual = pomFactory.retailOrderPage().returnSuccessMsg.getText();
		String expected = message;
		Assert.assertEquals(actual, expected);
		logger.info("return msg displayed successfully ");
	}

	
	//Add review
	
	@When("User click on Review button")
	public void userClickOnReviewButton() {
	    List<WebElement> selectReview = pomFactory.retailOrderPage().reviewButtonList;
	    click(selectReview.get(0));
	    logger.info("user clicked on first item on oder to reveiw successfully");
	}
	@When("User write Review headline {string} and review text {string}")
	public void userWriteReviewHeadlineAndReviewText(String headline, String text) {
	    sendText(pomFactory.retailOrderPage().reviewHeadline, headline);
	    sendText(pomFactory.retailOrderPage().reviewText, text);
	    logger.info("user entered headline and text in review section successfully");
	}
	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
	    click(pomFactory.retailOrderPage().addReviewBtn);
	    logger.info("user clicked on add review button successfully");
	}
	
	
	@Then("a review message {string} should be displayed")
	public void aReviewMessageShouldBeDisplayed(String message) {
	   waitTillPresence(pomFactory.retailOrderPage().reviewSuccessMSg);
	   String actual = pomFactory.retailOrderPage().reviewSuccessMSg.getText();
	   String expected = message;
	   Assert.assertEquals(actual, expected);
	   logger.info("added review msg success displayed");
	}

}
