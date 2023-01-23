package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TGFrontendTestingHomePage;
import pages.TGLoginFormPage;

public class TGLoginFormTest extends TGBase{
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

    @BeforeMethod
    public void setPage(){
        tgFrontendTestingHomePage = new TGFrontendTestingHomePage();
        tgLoginFormPage = new TGLoginFormPage();
    }

        @Test(priority = 1, description = "Validate login form")
        public void validateLoginForm(){
            tgFrontendTestingHomePage.getFrontendTestingPage();
            tgFrontendTestingHomePage.clickOnCard("Login Form");

            Assert.assertTrue(tgLoginFormPage.mainHeading.isDisplayed());

            Assert.assertTrue(tgLoginFormPage.labelUserName.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.inputUserName.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.labelPassword.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.inputPassword.isDisplayed());

            Assert.assertTrue(tgLoginFormPage.loginBtn.isDisplayed());
            Assert.assertTrue(tgLoginFormPage.forgotPassword.isDisplayed());






    }

}
