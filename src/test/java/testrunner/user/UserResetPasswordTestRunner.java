package testrunner.user;

import config.Setup;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.user.UserResetPasswordPage;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;

public class UserResetPasswordTestRunner extends Setup {
    @Test(priority = 1, description = "Login with invalid password and check error message")
    public void sendUnregisteredMail() throws InterruptedException {
        UserResetPasswordPage resetPass = new UserResetPasswordPage(driver);
        resetPass.btnReset.click();
        resetPass.inputEmail.sendKeys("billgates14@gmail.com");
        resetPass.btnResetLink.click();
        Thread.sleep(5000);
        String unregisteredUserMessage = driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-gjwoc1']")).getText();
        String expectedUnregisteredMessage = "Your email is not registered";
        Assert.assertTrue(unregisteredUserMessage.contains(expectedUnregisteredMessage));
    }
    @Test(priority = 2, description = "Leave both email and password fields empty and check error messages")
    public void sendEmptyMail() throws InterruptedException {
        Thread.sleep(2000);
        UserResetPasswordPage resetPass = new UserResetPasswordPage(driver);
        resetPass.inputEmail.sendKeys(Keys.CONTROL, "a");
        resetPass.inputEmail.sendKeys(Keys.BACK_SPACE);
        resetPass.btnResetLink.click();
        Thread.sleep(3000);
        String requiredActual = resetPass.inputEmail.getAttribute("validationMessage");
        String expectedTxt = "Please fill out this field";
        Assert.assertTrue(requiredActual.contains(expectedTxt));
    }
    @Test(priority = 3, description = "Enter valid registered email and click 'Send Reset Link' button")
    public void sendRegisteredMail() throws InterruptedException, IOException, ParseException {
        UserResetPasswordPage resetPass = new UserResetPasswordPage(driver);
        Thread.sleep(2000);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size()-1);
        String email =(String) userObj.get("email");
        resetPass.inputEmail.sendKeys(email);
        resetPass.btnResetLink.click();
        Thread.sleep(5000);

    }

    }
