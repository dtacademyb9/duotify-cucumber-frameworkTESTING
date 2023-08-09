package pages;

import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

@Getter
public class AllPlaylistsPage {

    public AllPlaylistsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "//div[@class='gridViewInfo']")
    private List<WebElement> allPlaylists;

    @FindBy(xpath = "//button[.=\"NEW PLAYLIST\"]")
    private WebElement newPlaylistButton;

    public void enterPlaylistName(String nameOfThePlaylist){
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(nameOfThePlaylist);
        alert.accept();


    }

    public WebElement getPlaylistByName(String name){
        return Driver.getDriver().findElement(By.xpath("//div[@class=\"gridViewInfo\"][.='"+name+"']"));
    }

    public void clickPlaylistByName(String name){
       Driver.getDriver().findElement(By.xpath("//div[@class=\"gridViewInfo\"][.='"+name+"']")).click();
    }
}
