package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminDashboardPage {
    @FindBy(css = "[data-testid=AccountCircleIcon]")
    WebElement btnProfileIcon;
    @FindBy(tagName = "li")
    List<WebElement> comboMenu;
    @FindBy(className = "search-box")
    public WebElement searchInput;

    public AdminDashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doLogout(){
        btnProfileIcon.click();
        comboMenu.get(1).click();
    }
}
