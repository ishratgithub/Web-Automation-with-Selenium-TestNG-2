package testrunner.user;

import config.ItemDataset;
import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.user.AddItemCostPage;
import pages.admin.AdminLoginPage;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class AddItemCostTestRunnerCSV extends Setup {
    @Test(priority = 1, description = "Login with user")
    public void doLogin() throws IOException, ParseException {
        AdminLoginPage loginPage = new AdminLoginPage(driver);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size()-1);
        String email =(String) userObj.get("email");
        loginPage.adminLogin(email, "1234");
    }
    @Test(priority = 2, dataProvider = "itemCSVData", dataProviderClass = ItemDataset.class, description = "Add two items from csv file")
    public void addTwoItems(String itemName, int quantity, String amount, String purchaseDate, String month, String remarks) throws InterruptedException {
        AddItemCostPage addCostPage = new AddItemCostPage(driver);
        Thread.sleep(2000);
        addCostPage.btnAddCost.click();
        addCostPage.txtItemName.sendKeys(itemName);
        for(int i = 1; i <quantity; i++){
            addCostPage.btnPlus.click();
        }
        addCostPage.txtAmount.sendKeys(amount);
        Thread.sleep(1000);
        addCostPage.purchaseDate.click();
        addCostPage.purchaseDate.clear();
        addCostPage.purchaseDate.sendKeys(purchaseDate);

        Select dropMonth = new Select(driver.findElement(By.id("month")));
        dropMonth.selectByVisibleText(month);
        Utils.scroll(driver,500);
        addCostPage.txtRemarks.sendKeys(remarks);
        addCostPage.btnSubmit.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

    }

}
