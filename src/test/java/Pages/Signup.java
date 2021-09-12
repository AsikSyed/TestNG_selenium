package Pages;

import Utils.Utils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.FileWriter;

public class Signup {
    WebDriver driver;
    @FindBy(className="login")
    WebElement linkLogin;
    @FindBy(className="page-heading")
    WebElement lblPageHeading;
    @FindBy(id="email_create")
    WebElement txtEmail;
    @FindBy(className="icon-user")
    WebElement btnCreate;
    @FindBy(className="page-subheading")
    WebElement lblPageSubheading;

    @FindBy(id="id_gender1")
    WebElement rbGender;
    @FindBy(id="customer_firstname")
    WebElement txtFirstName;
    @FindBy(id="customer_lastname")
    WebElement txtLastName;
    @FindBy(id="passwd")
    WebElement txtPassword;
    @FindBy(id="days")
    WebElement dropDays;
    @FindBy(id="months")
    WebElement dropMonths;
    @FindBy(id="years")
    WebElement dropYears;

    @FindBy(id="firstname")
    WebElement txtFirstName2;
    @FindBy(id="lastname")
    WebElement txtLastName2;
    @FindBy(id="address1")
    WebElement txtAddress;
    @FindBy(id="city")
    WebElement txtCity;
    @FindBy(id="id_state")
    WebElement dropState;
    @FindBy(id="postcode")
    WebElement txtPostcode;
    @FindBy(id="phone_mobile")
    WebElement txtMobile;
    @FindBy(id="submitAccount")
    WebElement btnSubmit;
    @FindBy(className="logout")
    WebElement linkLogout;

    public Signup(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Utils utils;
    public void memberSignUp() throws Exception {
        linkLogin.click();
        utils=new Utils(driver);
        String email=utils.generateRandomEmail(100000,999999);
        Reporter.log(email);
        txtEmail.sendKeys(email);
        btnCreate.click();
        JSONObject obj = new JSONObject();
        obj.put("email", email);
        obj.put("password", "P@ssword123");
        FileWriter file = new FileWriter("./src/test/resources/user.json");
        file.write(obj.toJSONString());
        file.flush();
        System.out.print(obj);

        Assert.assertEquals(lblPageSubheading.getText(),"CREATE AN ACCOUNT");
        rbGender.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassword.sendKeys("P@ssword123");
        Select days=new Select(dropDays);
        days.selectByIndex(1);
        Select months=new Select(dropMonths);
        months.selectByIndex(1);
        Select years=new Select(dropYears);
        years.selectByValue("2002");
        Thread.sleep(2000);
        txtFirstName2.sendKeys("Test");
        txtLastName2.sendKeys("User");
        txtAddress.sendKeys("1 Saint Andrews Plaza, New York");
        txtCity.sendKeys("NY");
        Select state=new Select(dropState);
        state.selectByVisibleText("New York");
        txtPostcode.sendKeys("10007");
        txtMobile.sendKeys("+1-202-555-0115 ");
        btnSubmit.click();
        Thread.sleep(1000);
        Assert.assertEquals(lblPageHeading.getText(),"MY ACCOUNT");

        Thread.sleep(2000);
        linkLogout.click();

    }

}
