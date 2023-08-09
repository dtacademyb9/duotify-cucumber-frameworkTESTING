package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


@Getter
public class UpdateDetailsPage {

    public UpdateDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(xpath = "//button[.=\"SAVE\"]")
    private WebElement saveButton;

    @FindBy(xpath = "(//span[@class=\"message\"])[1]")
    private WebElement successMessage;



}
