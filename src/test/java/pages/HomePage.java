package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = ".avatar")
    private WebElement userAvatarIcon;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firsPlaylist;
    @FindBy(css = "input[name='name']")
    private WebElement playlistInputField;
    @FindBy(css = ".fa-plus-circle")
    private WebElement addNewPlaylist;
    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistBtn;
    @FindBy(css = ".show.success")
    private WebElement notification;
    @FindBy(css = ".songs")
    private WebElement allSongs;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement chooseCreateNewPlaylist;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }

    public HomePage doubleClickFirstPlaylist() {
        doubleClick(firsPlaylist);
        return this;
    }

    public HomePage enterPlaylistName(String playlistName) {
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesPlaylistExist(String playlistName) {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
        return playlistElement.isDisplayed();

    }

    public HomePage chooseFirstPlaylist() {
        firsPlaylist.click();
        return this;
    }

    public HomePage deletePlaylist() {
        deletePlaylistBtn.click();
        return this;
    }

    public HomePage addPlaylist() {
        addNewPlaylist.click();
        return this;
    }

    public HomePage selectPlaylist() {
        chooseCreateNewPlaylist.click();
        return this;
    }


    public boolean notificationText() {
        return notification.isDisplayed();
    }
}