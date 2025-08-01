package testrunner.user;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.admin.AdminLoginPage;
import pages.user.UpdateGmailPage;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;


public class UpdateGmailTestRunner extends Setup {
    @Test(priority = 1, description = "Login with last user")
    public void doLogin() throws IOException, ParseException {
        AdminLoginPage loginPage = new AdminLoginPage(driver);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size()-1);
        String email =(String) userObj.get("email");
        loginPage.adminLogin(email, "1234");
    }
   @Test(priority = 2, description = "Update gmail with new gmail")
    public void updateGmail() throws IOException, ParseException, InterruptedException {
        UpdateGmailPage updateGmailPage = new UpdateGmailPage(driver);
        updateGmailPage.btnProfileIcon.click();
        updateGmailPage.btnProfileMenuItems.get(0).click();
        updateGmailPage.editBtn.click();
        updateGmailPage.txtEmail.sendKeys(Keys.CONTROL, "a");
        updateGmailPage.txtEmail.sendKeys(Keys.BACK_SPACE);
        updateGmailPage.txtEmail.sendKeys("abcd455@gmail.com");
        updateGmailPage.updateBtn.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size()-1);
        String email =(String) userObj.get("email");
        Utils.updateEmail("./src/test/resources/users.json",email, "abcd455@gmail.com");
        Thread.sleep(2000);
        updateGmailPage.btnProfileIcon.click();
        updateGmailPage.btnProfileMenuItems.get(1).click();
    }
}
