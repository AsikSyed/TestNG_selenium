package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    @FindBy(className="login")
    WebElement linkLogin;
    @FindBy(id="email")
    WebElement txtEmail;
    @FindBy(id="passwd")
    WebElement txtPassword;
    @FindBy(id="SubmitLogin")
    WebElement btnSubmitLogin;
    @FindBy(xpath = "//span[contains(text(),'Test User')]")
    WebElement lblUserName;
    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement lblAuthError;
    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    WebElement lblInvalidEmail;
    public Login(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String doLogin(String email,String password) throws InterruptedException {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmitLogin.click();
        return lblUserName.getText();


    }
    public String doLoginForWrongPassword(String email,String password) throws InterruptedException {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmitLogin.click();
        return lblAuthError.getText();

    }
    public String doLoginForInvalidEmail(String email,String password) throws InterruptedException {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmitLogin.click();
        return lblInvalidEmail.getText();

    }
}
