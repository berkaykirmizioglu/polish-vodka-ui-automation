package com.polishvodka.pageobjects.steps.homepage;

import com.polishvodka.pageobjects.pages.homepage.HomePage;
import net.thucydides.core.annotations.Step;

public class HomePageSteps {

    HomePage homePage;

    @Step("Should see 'Age' form on the page.")
    public void should_open_homepage() {

        homePage.open();
    }

    @Step("Checks age form basic usability")
    public HomePageSteps check_age_form_basic_usability() {

        homePage.lblMain.shouldBeVisible();
        homePage.lblAge.shouldBeVisible();
        homePage.lblAcceptContract.shouldBeVisible();
        homePage.txtAge.shouldBeEnabled();
        homePage.chbAccept.shouldBeEnabled();
        return this;
    }

    @Step("Should type into age textbox field: {0}")
    public HomePageSteps type_age(String age){

        homePage.typeAge(age);
        return this;
    }

    @Step("Should click accept checkbox")
    public HomePageSteps click_to_accept_checkbox(){

        homePage.clickToAcceptCheckbox();
        return this;
    }

    @Step("Should click submit button")
    public HomePageSteps click_to_submit_button(){

        homePage.clickToSubmitButton();
        return this;
    }

    @Step("When I type an age < 18, validation message should be displayed.")
    public HomePageSteps should_displayed_age_validation_message(){

        homePage.lblAgeValidationMessage.shouldBeVisible();
        return this;
    }

    @Step("Should see form successfully passed message")
    public HomePageSteps should_see_success_message(String message){

        homePage.lblSuccessMessage.shouldBeVisible();
        homePage.lblSuccessMessage.shouldContainText(message);
        return this;
    }
}
