package Steps;

import Pages.AccessYoutubePages;
import net.thucydides.core.steps.ScenarioSteps;

public class AccessYoutubeSteps extends ScenarioSteps {

    AccessYoutubePages accessYoutubePages;

    public void openURL(){
        accessYoutubePages.open();
    }

    public void clickButtonLogin(){
        accessYoutubePages.clickButtonLogin();
    }

    public void loginUsingAccountAvailable(String name, String password){
        accessYoutubePages.flowLogin(name, password);
    }

    public void validasiAfterSuccessLogin(String name){
        accessYoutubePages.clickBtnAvatar();
        accessYoutubePages.borderManageYourAccountShow(name);
    }
    public void searchMusic(String musicname){
        accessYoutubePages.setTxtSearch(musicname);
    }

    public void accessMusic(String musicname){
        accessYoutubePages.listMusicAfterSearch(musicname);
    }

    public void validasiSearchMusic(String musicname){
        accessYoutubePages.validasiSearchMusic(musicname);
    }

    public void accessChannelName(String channelName){
        accessYoutubePages.accessChannelName(channelName);
    }

    public void subscribeChannelName(){
        accessYoutubePages.clickBtnSubscribe();
    }

    public void clickBtnLikeOrDislike(String param){
        accessYoutubePages.clickBtnLikeOrDislike(param);
    }

    public void assertionLikeOrDislike(String param){
        accessYoutubePages.assertLikeOrDislike(param);
    }

    public void signout(){
        accessYoutubePages.signout();
    }
    public void assertionSuccessSignout(){
        accessYoutubePages.assertionSignOut();
    }

    public void accessSubmenuExplore(String param){
        accessYoutubePages.accessSubmenuExplore(param);
    }

    public void assertionSubmenuExploreIsShow(String param){
        accessYoutubePages.assertionSubmenuPagesIsShow(param);
    }

    public void clickMenuLibrary(){
        accessYoutubePages.accessLibraryMenu();
    }

    public void assertSubmenuLibrary(){
        accessYoutubePages.assertSubmenuLibrary();
    }

    public void assertMenuLibraryWithoutSignInFirst(){
        accessYoutubePages.assertMenuLibraryWithoutSignin();
    }
}
