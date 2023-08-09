package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;
@Getter
public class Homepage {


    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='gridViewContainer']//div[@class='gridViewInfo']")
    private List<WebElement> albumsNames;

    @FindBy(xpath = "//nav//span[@role='link'][@class='navItemLink']")
    private List<WebElement> navBarLinks;


    @FindBy(xpath = "//span[.='Your Music']")
    private WebElement yourMusicLink;

    public void clickOnLink(String linkText){
        Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='"+linkText+"']")).click();
    }

    public void clickOnUsernameLink(){
        Driver.getDriver().findElement(By.xpath("//span[@onclick=\"openPage('settings.php')\"]")).click();
    }

    public void clickOnAlbum(String name){
        Driver.getDriver().findElement(By.xpath("//div[@class='gridViewInfo'][.='"+name+"']")).click();

    }

}
