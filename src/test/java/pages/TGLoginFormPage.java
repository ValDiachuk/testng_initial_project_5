package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TGLoginFormPage {

   public TGLoginFormPage(){
       PageFactory.initElements(Driver.getDriver(), this);
   }
   @FindBy(id = "main_heading")
    public WebElement mainHeading;
   @FindBy(xpath = "(//label)[1]")
    public WebElement labelUserName;
   @FindBy(xpath = "(//input)[1]")
    public WebElement inputUserName;

   @FindBy(xpath = "(//label)[2]")
    public WebElement labelPassword;

    @FindBy(xpath = "(//input)[2]")
    public WebElement inputPassword;

    @FindBy(id = "login_btn")
    public WebElement loginBtn;

    @FindBy(id = "forgot-password")
    public WebElement forgotPassword;
}
