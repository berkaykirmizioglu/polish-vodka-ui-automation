package com.polishvodka.pageobjects.pages.homepage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.CacheLookup;

@DefaultUrl("http://127.0.0.1:5000/")
public class HomePage extends PageObject {

    @CacheLookup
    @FindBy(xpath = "//legend[@class='border-bottom mb-4']")
    public WebElementFacade lblMain;

    @CacheLookup
    @FindBy(xpath = "//label[@for='age']")
    public WebElementFacade lblAge;

    @CacheLookup
    @FindBy(id = "age")
    public WebElementFacade txtAge;

    @CacheLookup
    @FindBy(xpath = "//label[@for='accept']")
    public WebElementFacade lblAcceptContract;

    @CacheLookup
    @FindBy(id="accept")
    public WebElementFacade chbAccept;

    @CacheLookup
    @FindBy(id="submit")
    public WebElementFacade btnSubmit;

    @CacheLookup
    @FindBy(xpath="//span[contains(text(),'Age must be greater then to 18')]")
    public WebElementFacade lblAgeValidationMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElementFacade lblSuccessMessage;


    public void typeAge(String age){

        txtAge.type(age);
    }

    public void clickToAcceptCheckbox(){

        chbAccept.click();
    }

    public void clickToSubmitButton(){

        btnSubmit.click();
    }
}
