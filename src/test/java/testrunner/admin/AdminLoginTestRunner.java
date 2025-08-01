package testrunner.admin;

import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.admin.AdminDashboardPage;
import pages.admin.AdminLoginPage;

import java.io.IOException;

public class AdminLoginTestRunner extends Setup {
    AdminLoginPage loginPage;
    @Test(priority = 1, description = "Admin Login successfully with valid email and password")
    public void doLogin() throws IOException, ParseException {
        loginPage = new AdminLoginPage(driver);
        loginPage.adminLogin("admin@test.com","admin123");
        String txtHeaderActual = driver.findElement(By.tagName("h2")).getText();
        String txtHeaderExpected="Admin Dashboard";

        Assert.assertEquals(txtHeaderActual,txtHeaderExpected);
    }
    @Test(priority = 2,description = "Admin can logout successfully")
    public void logout(){
        AdminDashboardPage dashboardPage = new AdminDashboardPage(driver);
        dashboardPage.doLogout();
    }
}
