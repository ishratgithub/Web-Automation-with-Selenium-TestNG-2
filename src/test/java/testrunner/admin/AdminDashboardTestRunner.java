package testrunner.admin;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.admin.AdminDashboardPage;
import pages.admin.AdminLoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class AdminDashboardTestRunner extends Setup {
    @Test(priority = 1, description = "Login with admin account")
    public void doLogin() {
        AdminLoginPage loginPage = new AdminLoginPage(driver);
        if (System.getProperty("username") != null && System.getProperty("password") != null) {
            loginPage.adminLogin(System.getProperty("username"), System.getProperty("password"));
        } else {
            loginPage.adminLogin("admin@test.com", "admin123");
        }
    }

    @Test(priority = 2, description = "Search by the updated email")
    public void searchUpdatedGmail() throws IOException, ParseException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        String email = (String) userObj.get("email");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adminDashboardPage.searchInput.sendKeys(email);
        List<WebElement> allData = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        String actualEmail = allData.get(2).getText();
        Assert.assertTrue(actualEmail.contains(email));

    }
}
