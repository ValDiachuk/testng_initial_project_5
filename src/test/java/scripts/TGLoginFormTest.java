package scripts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TGFrontendTestingHomePage;
import pages.TGLoginFormPage;
public class TGLoginFormTest extends TGBase{
    @BeforeMethod
    public void setPage(){
        tgFrontendTestingHomePage = new TGFrontendTestingHomePage();
        tgLoginFormPage = new TGLoginFormPage();
        tgFrontendTestingHomePage.getFrontendTestingPage();
        tgFrontendTestingHomePage.clickOnCard("Login Form");
    }
    /*
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
Then user should heading1 as “Login Form”
And user should see “Please enter your username” label and username input box
And user should see “Please enter your password” label and password input box
And user should see “LOGIN” button
And user should see “Forgot Password?” link
 */
        @Test(priority = 1, description = "Validate TechGlobal Login Form card")
        public void validateLoginForm(){

            Assert.assertTrue(tgLoginFormPage.mainHeading.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.labelUserName.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.inputUserName.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.labelPassword.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.inputPassword.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.loginBtn.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.forgotPassword.isDisplayed());
    }
    /*
Test Case 2: Validate TechGlobal Login Form card valid login
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user enters username as “TechGlobal” and password as “Test1234”
And user clicks on “LOGIN” button
Then user should see “You are logged in” message
And user should see “LOGOUT” button
     */
    @Test(priority = 2, description = "Validate TechGlobal Login Form card valid login")
    public void validateTechGlobalLoginFormCardValidLogin(){
        tgLoginFormPage.inputUserName.sendKeys("TechGlobal");
        tgLoginFormPage.inputPassword.sendKeys("Test1234");
        tgLoginFormPage.loginBtn.click();
        tgLoginFormPage.successLdn.isDisplayed();
        tgLoginFormPage.logout.isDisplayed();
    }
    /*
Test Case 3: Validate TechGlobal Login Form card valid login and then
logout
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user enters username as “TechGlobal” and password as “Test1234”
And user clicks on “LOGIN” button
And user clicks on “LOGOUT” button
Then user should be navigated back to Login Form
     */
    @Test (priority = 3, description = "Validate TechGlobal Login Form card valid login and then logout")
    public void validateTechGlobalLoginFormCardValidLoginAndLogOut(){
        tgLoginFormPage.inputUserName.sendKeys("TechGlobal");
        tgLoginFormPage.inputPassword.sendKeys("Test1234");
        tgLoginFormPage.loginBtn.click();
        tgLoginFormPage.successLdn.isDisplayed();
        tgLoginFormPage.logout.click();
    }
/*
Test Case 4: Validate TechGlobal Login Form card Forgot Password?
Link and Reset Password page
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user clicks on “Forgot Password?” link
Then user should see “Reset Password” heading1
And user should see “Enter your email address and we'll send you a link to reset
your password.” message
And user should see email input box
And user should see “SUBMIT” button
 */
    @Test (priority = 4, description = "Validate TechGlobal Login Form card Forgot Password")
    public void validateLoginFormForgotPassword(){
        tgLoginFormPage.forgotPassword.click();
        tgLoginFormPage.resetPasswordHeading.isDisplayed();
        tgLoginFormPage.resetPasswordHeading.getText();
        tgLoginFormPage.emailEnterMessage.isDisplayed();
        Assert.assertEquals(tgLoginFormPage.emailEnterMessage.
                getText(), "Enter your email address and we'll send you a link to reset your password.");
        tgLoginFormPage.enterEmail.isDisplayed();
        tgLoginFormPage.submitBtn.isDisplayed();
    }
    /*
Test Case 5: Validate TechGlobal Login Form card Reset Password link
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user clicks on “Forgot Password?” link
When user enters a valid email to email input box
And user clicks on “SUBMIT” button
Then user should see “A link to reset your password has been sent to your email
address.” message
     */
@Test (priority = 5, description = "Validate TechGlobal Login Form card Reset Password link")
    public void validateLoginFormResetPasswordLink(){
    tgLoginFormPage.forgotPassword.click();
    tgLoginFormPage.enterEmail.sendKeys("valdiachuk9@gmail.com");
    tgLoginFormPage.submitBtn.click();
    Assert.assertEquals(tgLoginFormPage.confirmationMessage.
            getText(), "A link to reset your password has been sent to your email address.");
}
/*
Test Case 6: Validate TechGlobal Login Form card invalid login with
wrong username
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user enters username as “john” and password as “Test1234”
And user clicks on “LOGIN” button
Then user should see “Invalid Username entered!” message
 */
    @Test(priority = 6, description = "Validate TechGlobal Login Form card invalid login with \n" +
            "wrong username")
    public void validateLoginFormWithWrongUN(){

        tgLoginFormPage.inputUserName.sendKeys("john");
        tgLoginFormPage.inputPassword.sendKeys("Test1234");
        tgLoginFormPage.loginBtn.click();
        tgLoginFormPage.errorMessage.isDisplayed();
        Assert.assertEquals(tgLoginFormPage.errorMessage.getText(), "Invalid Username entered!");
    }
    /*
Test Case 7: Validate TechGlobal Login Form card invalid login with
wrong password
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user enters username as “TechGlobal” and password as “1234”
And user clicks on “LOGIN” button
Then user should see “Invalid Password entered!” message
     */
    @Test(priority = 7, description = "Validate TechGlobal Login Form card invalid login with \n" +
            "wrong password")
    public void validateLoginFormInvalidLoginWrongPassword(){
        tgLoginFormPage.inputUserName.sendKeys("TechGlobal");
        tgLoginFormPage.inputPassword.sendKeys("1234");
        tgLoginFormPage.loginBtn.click();
        tgLoginFormPage.errorMessage.isDisplayed();
        Assert.assertEquals(tgLoginFormPage.errorMessage.getText(), "Invalid Password entered!");
    }
    /*
Test Case 8: Validate TechGlobal Login Form card invalid login with
both wrong credentials
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user enters username as “john” and password as “1234”
And user clicks on “LOGIN” button
Then user should see “Invalid Username entered!” message
     */
    @Test(priority = 8, description = "Validate TechGlobal Login Form card invalid login with \n" +
            "both wrong credentials")
    public void validateLoginFormWithBothWrongCredentials(){
        tgLoginFormPage.inputUserName.sendKeys("john");
        tgLoginFormPage.inputPassword.sendKeys("1234");
        tgLoginFormPage.loginBtn.click();
        tgLoginFormPage.errorMessage.isDisplayed();
        Assert.assertEquals(tgLoginFormPage.errorMessage.getText(), "Invalid Username entered!");
    }
}