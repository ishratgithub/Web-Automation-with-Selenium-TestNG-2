package pages.user;

import config.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserRegistrationPage {
    @FindBy(xpath = "//a[normalize-space()='Register']")
    public WebElement btnRegister;
    @FindBy(id = "firstName")
    public WebElement txtFirstName;
    @FindBy(id = "lastName")
    public WebElement txtLastName;
    @FindBy(id = "email")
    public WebElement txtEmail;
    @FindBy(id = "password")
    public WebElement txtPassword;
    @FindBy(id = "phoneNumber")
    public WebElement txtPhonenum;
    @FindBy(id = "address")
    public WebElement txtAddress;
    @FindBy(css = "[type = radio]")
    public List<WebElement> rbGender;
    @FindBy(css = "[type = checkbox")
    public WebElement chkAcceptTerms;
    @FindBy(id = "register")
    public WebElement submitRegistration;
    public UserRegistrationPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void doRegistration(UserModel userModel) throws InterruptedException {
        txtFirstName.sendKeys(userModel.getFirstname());
        txtLastName.sendKeys(userModel.getLastname());
        txtEmail.sendKeys(userModel.getEmail());
        txtPassword.sendKeys(userModel.getPassword());
        txtPhonenum.sendKeys(userModel.getPhoneNumber());
        txtAddress.sendKeys(userModel.getAddress());
        rbGender.get(0).click();
        chkAcceptTerms.click();
        Thread.sleep(2000);
        submitRegistration.click();
    }
}
