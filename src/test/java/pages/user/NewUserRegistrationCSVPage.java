package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewUserRegistrationCSVPage {
    @FindBy(tagName = "input")
    List<WebElement> txtInput;

    @FindBy(id="register")
    WebElement btnRegister;

    public NewUserRegistrationCSVPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void userRegistration(String firstname, String lastname, String email,
                                 String password, String phonenumber, String address){

        txtInput.get(0).sendKeys(firstname); //firstname
        txtInput.get(1).sendKeys(lastname); //lastname
        txtInput.get(2).sendKeys(email);
        txtInput.get(3).sendKeys(password); //password
        txtInput.get(4).sendKeys(phonenumber); //phonenumber
        txtInput.get(5).sendKeys(address);
        txtInput.get(7).click(); //select gender
        txtInput.get(8).click(); //accept terms
        btnRegister.click();
    }
}
