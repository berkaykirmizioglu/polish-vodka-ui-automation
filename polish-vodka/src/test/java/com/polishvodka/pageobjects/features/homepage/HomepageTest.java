package com.polishvodka.pageobjects.features.homepage;

import com.polishvodka.pageobjects.steps.homepage.HomePageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.polishvodka.statics.Tag.*;
import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;

@Narrative(text={"As a user",
        "I want to check polish vodka website homepage"})
@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(HOMEPAGE),
        @WithTag(AGE_FORM)
})
public class HomepageTest {

    @Managed(clearCookies=BeforeEachTest)
    WebDriver driver;

    @Steps
    HomePageSteps homePageSteps;

    @Before
    public void before(){

        homePageSteps.should_open_homepage();
    }

    @Test
    @Title("Checks usability of age form")
    public void check_usability_of_age_form() {

        homePageSteps.check_age_form_basic_usability();
    }

    @Test
    @Title("Should see the success message after age validation form")
    public void should_see_success_message_after_age_validation() {

        homePageSteps
                .check_age_form_basic_usability()
                .type_age("19")
                .click_to_accept_checkbox()
                .click_to_submit_button()
                .should_see_success_message("Now you can navigate to our homepage!");
    }

    @Test
    @Title("Should see validation message after age validation form on age < 18")
    public void should_see_validation_message_after_age_validation_lower() {

        homePageSteps
                .type_age("17")
                .click_to_accept_checkbox()
                .click_to_submit_button()
                .should_displayed_age_validation_message();
    }
}