package testrunner.user;
import config.Setup;
import config.UserDataset;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.user.NewUserRegistrationCSVPage;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class NewUserRegistrationCSVTestRunner extends Setup {
    @Test(priority = 1, description = "New User Registration from CSV", dataProviderClass = UserDataset.class, dataProvider = "UserDataset")
    public void userRegistrationfromCSV(String firstName,String lastName,String email, String password,String phoneNumber,String address) throws InterruptedException, IOException, ParseException {


        //register 3 new users

        driver.findElement(By.partialLinkText("Register")).click();
        NewUserRegistrationCSVPage userRegistrationCSVPage = new NewUserRegistrationCSVPage(driver);
        userRegistrationCSVPage.userRegistration(firstName,lastName,email,password,phoneNumber,address);


        Thread.sleep(2000);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
        String successfulMessageActual= driver.findElement(By.className("Toastify__toast")).getText();
        String successfulMessageExpected= ("registered successfully!");
        System.out.println(successfulMessageActual);

        JSONObject userObj = new JSONObject();
        userObj.put("firstName",firstName);
        userObj.put("email",email);
        userObj.put("password",password);
        userObj.put("phoneNumber",phoneNumber);
        Utils.saveUserInfo("./src/test/resources/users.json",userObj);

        Assert.assertTrue(successfulMessageActual.contains(successfulMessageExpected));

        Thread.sleep(20000);

    }

}
