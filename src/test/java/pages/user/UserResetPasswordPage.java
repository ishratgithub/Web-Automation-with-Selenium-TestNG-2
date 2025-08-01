package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserResetPasswordPage {
    @FindBy(xpath = "//a[normalize-space()='Reset it here']")
    public WebElement btnReset;
    @FindBy(xpath = "//input[@id=':r0:']")
    public WebElement inputEmail;
    @FindBy(xpath = "//button[normalize-space()='Send Reset Link']")
    public WebElement btnResetLink;
    @FindBy(xpath = "//input[@id=':r1:']")
    public WebElement confirmEmail;
    @FindBy(xpath = "//button[normalize-space()='Reset Password']")
    public WebElement resetPassBtn;

    public UserResetPasswordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
