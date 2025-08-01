package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddItemCostPage {
    @FindBy(className = "add-cost-button")
    public WebElement btnAddCost;
    @FindBy(id = "itemName")
    public WebElement txtItemName;
    @FindBy(xpath = "//button[normalize-space()='+']")
    public WebElement btnPlus;
    @FindBy(id= "amount")
    public WebElement txtAmount;
    @FindBy(id = "remarks")
    public WebElement txtRemarks;
    @FindBy(css = "[type=submit]")
    public WebElement btnSubmit;
    @FindBy(id = "purchaseDate")
    public WebElement purchaseDate;


    public AddItemCostPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
