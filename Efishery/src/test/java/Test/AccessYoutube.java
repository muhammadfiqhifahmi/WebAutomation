package Test;

import Steps.AccessYoutubeSteps;
import net.serenitybdd.jbehave.SerenityStory;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AccessYoutube extends SerenityStory {

    @Steps
    AccessYoutubeSteps accessYoutubeSteps;

    @Given("I want login to Music Youtube")
    public void givenIWantLoginToMusicYoutube(){
        accessYoutubeSteps.openURL();
    }

    @When("I input valid username and password")
    public void whenIInputValidUsernameAndPassword(){
        accessYoutubeSteps.clickButtonLogin();
        accessYoutubeSteps.loginUsingAccountAvailable("testefishery@gmail.com","qwerty.123456");
    }

    @Then("I success login to Music Youtube using valid username and password google account")
    public void thenISuccessLoginToMusicYoutubeUsingValidUsernameAndPassword(){
        accessYoutubeSteps.validasiAfterSuccessLogin("testefishery@gmail.com");
    }

    @Given("I want search music on Music Youtube with condition login or without login first $condition")
    public void givenIWantSearchMusicOnYoutube(String param){
        if(param.equals("login")){
            accessYoutubeSteps.openURL();
            accessYoutubeSteps.clickButtonLogin();
            accessYoutubeSteps.loginUsingAccountAvailable("testefishery@gmail.com","qwerty.123456");
        }else {
            accessYoutubeSteps.openURL();
        }
    }

    @When("I input keyword $key music on feature search")
    public void whenIInputKeywordMusicOnFeatureSearch(String key){
        accessYoutubeSteps.searchMusic(key);
    }

    @Then("searching music success and valid with keyword $key")
    public void thenSearchingMusicSuccessAndValid(String key){
        accessYoutubeSteps.accessMusic(key);
        accessYoutubeSteps.validasiSearchMusic(key);
    }

    @Given("I have logged in music youtube using a valid account")
    public void givenIHaveLoggedInYoutubeUsingAValidAccount(){
        accessYoutubeSteps.openURL();
        accessYoutubeSteps.clickButtonLogin();
        accessYoutubeSteps.loginUsingAccountAvailable("testefishery@gmail.com","qwerty.123456");
    }

    @When("I search and subscribe a channel music youtube $channelname")
    public void whenISearchAndSubscribeAChannelYoutub(String channelname){
        accessYoutubeSteps.searchMusic(channelname);
        accessYoutubeSteps.accessChannelName(channelname);
    }

    @Then("I success search and subscribe a channel music youtube")
    public void thenISuccessSearchAndSubscribeAChannelYoutube(){
        accessYoutubeSteps.subscribeChannelName();
    }

    @When("I search a channel music youtube for like or dislike $param")
    public void whenISearchAChannelYoutubeForLikeOrDislike(String param){
        accessYoutubeSteps.searchMusic("Restoe Boemi (feat. Virzha)");
        accessYoutubeSteps.accessMusic("Restoe Boemi (feat. Virzha)");
        accessYoutubeSteps.clickBtnLikeOrDislike(param);
    }

    @Then("I success like or dislike a channel music youtube $param")
    public void thenISuccessLikeOrDislikeAChannelYoutube(String param){
        accessYoutubeSteps.assertionLikeOrDislike(param);
    }


    @Given("I want access explore page music on Music Youtube with condition login or without login first $condition")
    public void givenIWantAccessExplorePageMusicOnMusicYoutubeWithConditionLoginOrWithoutLoginFirst(String condition){
        if(condition.equals("login")){
            accessYoutubeSteps.openURL();
            accessYoutubeSteps.clickButtonLogin();
            accessYoutubeSteps.loginUsingAccountAvailable("testefishery@gmail.com","qwerty.123456");
        }else {
            accessYoutubeSteps.openURL();
        }
    }

    @When("I access submenu $submenu on explore page")
    public void whenIAccessSubmenuOnExplorePage(String submenu){
        accessYoutubeSteps.accessSubmenuExplore(submenu);
    }

    @Then("I success access submennu $submenu on explore page for find out New Releases, Charts, Mood & Genre of music with condition login or without login first")
    public void thenISuccessAccessSubmenuOnExplorePage(String submenu){
        accessYoutubeSteps.assertionSubmenuExploreIsShow(submenu);
    }

    @When("I access menu library on Music Youtube")
    public void whenIAccessMenuLibraryOnMusicYoutube(){
        accessYoutubeSteps.clickMenuLibrary();
    }

    @Then("I success access menu library and find out his Playlist, Song, Album, Artis and Subscribtions")
    public void thenISuccessAccessMenuLibraryAndFindOutPlaylistSongAlbumArtisSubscribtions(){
        accessYoutubeSteps.assertSubmenuLibrary();
    }

    @Given("I have not sign in first on music youtube")
    public void givenIHaveNotSignInFirstOnMusicYoutube(){
        accessYoutubeSteps.openURL();
    }

    @Then("System will directed to form payment for subscriptions Music Youtube")
    public void thenSystemWillDirectedToFormPaymentForSubscriptionsMusicYoutube(){
        accessYoutubeSteps.assertMenuLibraryWithoutSignInFirst();
    }

    @When("I access avatar logo and click sign out")
    public void whenIAccessAvatarLogoAndClickSignOut(){
        accessYoutubeSteps.signout();
    }

    @Then("I success sign out from Music Youtube")
    public void thenISuccessSignoutFromMusicYoutube(){
        accessYoutubeSteps.assertionSuccessSignout();
    }
}
