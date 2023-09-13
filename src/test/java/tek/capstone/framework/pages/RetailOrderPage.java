package tek.capstone.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.guardians.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{
	
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "search")
	public WebElement allDepartmentDropdown;
	
	@FindBy(id = "searchInput")
	public WebElement searchInputField;
	
	@FindBy(id = "searchBtn")
	public WebElement searchBttn;
	
	@FindBy(xpath = "//img[@alt='Kasa Outdoor Smart Plug']")
	public WebElement itemkasaoutdoorsmartplug;
	
	@FindBy(xpath = "//select[starts-with(@class,'product')]")
	public WebElement qtyDropdown;
	
	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBttn;
	
	@FindBy(xpath = "//span[@id='cartQuantity']")
	public WebElement cartItemQty;
	
	@FindBy(id = "cartBtn")
	public WebElement cartBttn;
	
	@FindBy(id = "proceedBtn")
	public WebElement proceedToCheckoutBttn;
	
	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBttn;
	
	@FindBy(xpath = "//div[text()='Order Placed Successfully']")
	public WebElement orderPlacedSuccessfullyMssg;
	
	@FindBy(xpath = "//img[starts-with(@alt,'Apex Legends')]")
	public WebElement apexLegendsItem;
	//to cancel order from cart

    @FindBy(id = "orderLink")
    public WebElement OrderLink;

    @FindBy(xpath = "//div[@class='order']//descendant::p[7]")
    public List<WebElement> listOfOrders;

    @FindBy(xpath = "//button[text()='Cancel The Order']")
    public List<WebElement> cancelOrderBttn;

    @FindBy(id = "reasonInput")
    public WebElement reasonForCancelation;

    @FindBy(id = "orderSubmitBtn")
    public WebElement cancelationSubmitBttn;

    @FindBy(xpath = "//p[text()='Your Order Has Been Cancelled']")
    public WebElement orderCancelledSuccessMssg;
    
  @FindBy(xpath ="//button[text()='Return Items']")
  public List<WebElement> returnItemsList;

  @FindBy(id="reasonInput")
  public WebElement returnReason;

  @FindBy (xpath= "(//input[@type='checkbox'])[1]")
  public WebElement selectReturnItem;

  @FindBy(id ="dropOffInput")
  public WebElement returnShipOption;

  @FindBy(id ="orderSubmitBtn")
  public WebElement returnOrderBttn;

  @FindBy(xpath = "//p[text()='Return was successfull']")
  public WebElement returnSuccessMsg;

  @FindBy(xpath ="//button[text()='Review']")
  public List <WebElement> reviewButtonList;

  @FindBy(id ="headlineInput")
  public WebElement reviewHeadline;

  @FindBy(id ="descriptionInput")
  public WebElement reviewText;
    
    @FindBy(id ="reviewSubmitBtn")
    public WebElement addReviewBtn;
    
    @FindBy(xpath = "//div[text()='Your revew was added successfully'")
    public WebElement reviewSuccessMSg;
	
	

}
