package org.example.playwrightSession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IframeHandle {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

        //first click on img through css selector and then entered text in input field through xpath selector
        page.locator("img[title='vehicle-registration-forms-and-templates']").click();

        page.frameLocator("//iframe[contains(@id,'frame-one')]")
                .locator("#RESULT_TextField-8").fill("Amit Barwal");



    }
}
