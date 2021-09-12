package TestRunner;

import Pages.Signup;
import Setup.Setup;
import org.testng.annotations.Test;

public class SignupTestRunner extends Setup {
    Signup objSignup;
    @Test(enabled = true)
    public void doSignup() throws Exception {
        driver.get("http://automationpractice.com");
        objSignup = new Signup(driver);
        objSignup.memberSignUp();

    }

}
