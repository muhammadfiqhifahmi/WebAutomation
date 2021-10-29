package Pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessYoutubePages extends PageObject {

    @FindBy(xpath = "//a[contains(.,'Sign in')]")
    WebElement btnLogin;
    public void clickButtonLogin(){
        element(btnLogin).waitUntilVisible();
        btnLogin.click();
    }

    @FindBy(css = ".wLBAL")
    WebElement account;

    @FindBy(id = "identifierId")
    WebElement txtEmailOrPonsel;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(css = ".VfPpkd-LgbsSe-OWXEXe-k8QpJ")
    WebElement btnContinue;

    public void flowLogin(String name, String password){
        if (!element(txtEmailOrPonsel).isVisible()){
            element(account).shouldBeVisible();
            account.click();
        }else {
            element(txtEmailOrPonsel).waitUntilVisible();
            txtEmailOrPonsel.sendKeys(name);
            btnContinue.click();
        }
        element(txtPassword).waitUntilVisible();
        txtPassword.sendKeys(password);
        element(btnContinue).waitUntilVisible();
        btnContinue.click();
    }


    @FindBy(xpath = "//tp-yt-paper-icon-button[@class='style-scope ytmusic-settings-button']/tp-yt-iron-icon[@id='icon']")
    WebElement btnAvatar;
    public void clickBtnAvatar(){
        element(btnAvatar).waitUntilVisible();
        btnAvatar.click();
    }

    @FindBy(css = "ytd-active-account-header-renderer")
    WebElement borderManageYourAccount;
    public void borderManageYourAccountShow(String name){
        element(borderManageYourAccount).waitUntilVisible();
        Assert.assertTrue(borderManageYourAccount.getText().contains(name));
    }

    @FindBy(css = ".search-box")
    WebElement iconSearch;
    @FindBy(xpath = "//input[@id='input']")
    WebElement txtSearch;
    public void setTxtSearch(String search){
        element(iconSearch).shouldBeVisible();
        iconSearch.click();
        element(txtSearch).waitUntilVisible();
        txtSearch.clear();
        txtSearch.sendKeys(search);
        txtSearch.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//ytmusic-section-list-renderer[@class='style-scope ytmusic-tabbed-search-results-renderer']")
    WebElement listMusic;
    public void listMusicAfterSearch(String videoname){
        try { Thread.sleep(5000); }catch (Exception e){}
        element(listMusic).waitUntilVisible();
        try { Thread.sleep(5000); }catch (Exception e){}
        String result = "//ytmusic-shelf-renderer[1]//a[.='"+videoname+"']";
        element(getDriver().findElement(By.xpath(result))).waitUntilVisible();
        getDriver().findElement(By.xpath(result)).click();
    }

    @FindBy(xpath = "//yt-formatted-string[@class='title style-scope ytmusic-player-bar']")
    WebElement titleMusic;
    public void validasiSearchMusic(String videoname){
        try { Thread.sleep(60000); }catch (Exception e){}
        element(titleMusic).waitUntilVisible();
        Assert.assertEquals(videoname, titleMusic.getText());
    }

    public void accessChannelName(String cName){
        String result = "[aria-label='"+cName+"']";
        element(getDriver().findElement(By.cssSelector(result))).waitUntilVisible();
        getDriver().findElement(By.cssSelector(result)).click();
    }

    @FindBy(css = "[aria-label='Subscribe channel ini']")
    WebElement btnSubscribe;
    @FindBy(css = "[aria-label='Unsubscribe dari channel ini']")
    WebElement btnUnsubscribe;
    @FindBy(xpath = "//yt-confirm-dialog-renderer[@class='style-scope ytmusic-popup-container']")
    WebElement popUpDialogUnsubscribe;
    @FindBy(css = "[aria-label='Unsubscribe']")
    WebElement btnConfirmUnsubscribe;
    @FindBy(xpath = "//tp-yt-paper-button[@class='style-scope ytmusic-subscribe-button-renderer']")
    WebElement assertionText;
    public void clickBtnSubscribe(){
        if (element(btnUnsubscribe).isVisible()){
            btnUnsubscribe.click();
            element(popUpDialogUnsubscribe).waitUntilVisible();
            btnConfirmUnsubscribe.click();
        }else {
            element(btnSubscribe).waitUntilVisible();
        }
        try { Thread.sleep(5000); }catch (Exception e){}
        element(btnSubscribe).waitUntilVisible();
        btnSubscribe.click();
        Assert.assertTrue(assertionText.getText().contains("DISUBSCRIBE"));
    }

    @FindBy(xpath = "//ytmusic-like-button-renderer[@id='like-button-renderer']/tp-yt-paper-icon-button[@class='like style-scope ytmusic-like-button-renderer']/tp-yt-iron-icon[@id='icon']")
    WebElement btnLike;
    @FindBy(css = ".like[aria-pressed='true'] > #icon > .style-scope")
    WebElement btnLikeActive;

    @FindBy(xpath = "//ytmusic-like-button-renderer[@id='like-button-renderer']/tp-yt-paper-icon-button[@class='dislike style-scope ytmusic-like-button-renderer']/tp-yt-iron-icon[@id='icon']")
    WebElement btnDislike;
    @FindBy(css = ".dislike[aria-pressed='true'] > #icon > .style-scope")
    WebElement btnDislikeActive;
    public void clickBtnLikeOrDislike(String param){
        try { Thread.sleep(60000); }catch (Exception e){}
        if (param.equals("Like")){
            element(btnLike).shouldBeVisible();
            btnLike.click();
        }else {
            element(btnDislike).shouldBeVisible();
            btnDislike.click();
        }
    }

    public void assertLikeOrDislike(String param){
        try { Thread.sleep(5000); }catch (Exception e){}
        if (param.equals("Like")){
            Assert.assertTrue(element(btnLikeActive).isVisible());
        }else {
            setTxtSearch("Restoe Boemi (feat. Virzha)");
            listMusicAfterSearch("Restoe Boemi (feat. Virzha)");
            Assert.assertTrue(element(btnDislikeActive).isVisible());
        }
    }

    @FindBy(xpath = "//a[contains(.,'Sign out')]")
    WebElement btnSignOut;
    @FindBy(xpath = "//a[contains(.,'Logout')]")
    WebElement btnLogout;
    public void signout(){
        clickBtnAvatar();
        if (element(btnSignOut).isVisible()){
            element(btnSignOut).waitUntilVisible();
            btnSignOut.click();
        }else {
            element(btnLogout).waitUntilVisible();
            btnLogout.click();
        }
    }

    public void assertionSignOut(){
        element(btnLogin).shouldBeVisible();
    }

    @FindBy(xpath = "//yt-formatted-string[.='Explore']")
    WebElement menuExplore;

    @FindBy(xpath = "//yt-formatted-string[.='Eksplorasi']")
    WebElement menuEksplorasi;

    @FindBy(xpath = "//button[contains(.,'New releases')]")
    WebElement submenuNewReleases;

    @FindBy(xpath = "//button[contains(.,'Rilisan terbaru')]")
    WebElement submenuRilisanterbaru;

    @FindBy(xpath = "//yt-formatted-string[@class='title style-scope ytmusic-header-renderer']")
    WebElement assertionSubmenuPages;

    @FindBy(xpath = "//button[contains(.,'Charts')]")
    WebElement submenuCharts;

    @FindBy(xpath = "//button[contains(.,'Tangga lagu')]")
    WebElement submenuTanggaLagu;

    @FindBy(xpath = "//button[contains(.,'Moods & genres')]")
    WebElement submenuMoodandGenres;

    @FindBy(xpath = "//button[contains(.,'Jenis musik & suasana')]")
    WebElement submenuJenisMusikDanSuasana;

    public void accessSubmenuExplore(String param){
        if (element(menuExplore).isVisible()){
            element(menuExplore).waitUntilVisible();
            menuExplore.click();
        }else {
            element(menuEksplorasi).waitUntilVisible();
            menuEksplorasi.click();
        }
        if (param.equals("New releases")){
            if (element(submenuNewReleases).isVisible()){
                element(submenuNewReleases).waitUntilVisible();
                submenuNewReleases.click();
            }else {
                element(submenuRilisanterbaru).waitUntilVisible();
                submenuRilisanterbaru.click();
            }
        }else if(param.equals("Charts")){
            if (element(submenuCharts).isVisible()){
                element(submenuCharts).waitUntilVisible();
                submenuCharts.click();
            }else {
                element(submenuTanggaLagu).waitUntilVisible();
                submenuTanggaLagu.click();
            }
        }else if (param.equals("Moods & genres")){
            if (element(submenuMoodandGenres).isVisible()){
                element(submenuMoodandGenres).waitUntilVisible();
                submenuMoodandGenres.click();
            }else {
                element(submenuJenisMusikDanSuasana).waitUntilVisible();
                submenuJenisMusikDanSuasana.click();
            }
        }
    }

    public void assertionSubmenuPagesIsShow(String param){
        element(assertionSubmenuPages).waitUntilVisible();
        if (assertionSubmenuPages.getText().equals("Rilisan terbaru")){
            Assert.assertEquals("Rilisan terbaru", assertionSubmenuPages.getText());
        }else if (assertionSubmenuPages.getText().equals("Tangga lagu")){
            Assert.assertEquals("Tangga lagu", assertionSubmenuPages.getText());
        }else if (assertionSubmenuPages.getText().equals("Jenis musik & suasana")){
            Assert.assertEquals("Jenis musik & suasana", assertionSubmenuPages.getText());
        }else {
            Assert.assertEquals(param, assertionSubmenuPages.getText());
        }
    }

    @FindBy(xpath = "//yt-formatted-string[.='Library']")
    WebElement menuLibrary;
    @FindBy(xpath = "//yt-formatted-string[.='Koleksi']")
    WebElement menuKoleksi;

    @FindBy(xpath = "//yt-formatted-string[.='Playlist']")
    WebElement submenuPlaylist;
    @FindBy(xpath = "//yt-formatted-string[.='Album']")
    WebElement submenuAlbum;
    @FindBy(xpath = "//yt-formatted-string[.='Lagu']")
    WebElement submenuLagu;
    @FindBy(xpath = "//yt-formatted-string[.='Artis']")
    WebElement submenuArtis;
    @FindBy(xpath = "//yt-formatted-string[.='Subscription']")
    WebElement submenuSubscription;
    public void accessLibraryMenu(){
        if (element(menuLibrary).isVisible()){
            element(menuLibrary).waitUntilVisible();
            menuLibrary.click();
        }else {
            element(menuKoleksi).waitUntilVisible();
            menuKoleksi.click();
        }
    }

    @FindBy(xpath = "//ytmusic-grid-renderer[@class='style-scope ytmusic-item-section-renderer']/div[@id='items']")
    WebElement assertContentA;
    @FindBy(xpath = "//ytmusic-shelf-renderer[@class='style-scope ytmusic-item-section-renderer']/div[@id='contents']")
    WebElement assertContentB;
    public void assertSubmenuLibrary(){
        try { Thread.sleep(5000); }catch (Exception e){}
        element(submenuPlaylist).waitUntilVisible();
        submenuPlaylist.click();
        element(assertContentA).isVisible();
        try { Thread.sleep(5000); }catch (Exception e){}
        element(submenuAlbum).waitUntilVisible();
        submenuAlbum.click();
        element(assertContentA).getText().contains("NOAH");
        try { Thread.sleep(5000); }catch (Exception e){}
        element(submenuLagu).waitUntilVisible();
        submenuLagu.click();
        element(assertContentB).getText().contains("NOAH");
        try { Thread.sleep(5000); }catch (Exception e){}
        element(submenuArtis).waitUntilVisible();
        submenuArtis.click();
        element(assertContentB).getText().contains("NOAH");
        try { Thread.sleep(5000); }catch (Exception e){}
        element(submenuSubscription).waitUntilVisible();
        submenuSubscription.click();
        element(assertContentB).getText().contains("NOAH");
    }

    public void assertMenuLibraryWithoutSignin(){
        element(txtEmailOrPonsel).isVisible();
    }
}
