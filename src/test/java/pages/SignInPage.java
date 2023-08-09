package pages;


import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


@Getter
public class SignInPage {

    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "loginUsername")
    private WebElement username;

    @FindBy (xpath = "//span[.='Your username or password was incorrect']")
    private WebElement errorMessage;

    @FindBy (id = "loginPassword")
    private WebElement password;


    @FindBy (name = "loginButton")
    private WebElement loginButton;

    @FindBy (id = "hideLogin")
    private WebElement signUpLink;


    public void login(String username, String pass){
        this.username.sendKeys(username);
        this.password.sendKeys(pass, Keys.ENTER);
    }

}
