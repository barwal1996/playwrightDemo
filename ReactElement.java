package org.example.playwrightSession;

import com.microsoft.playwright.*;

public class ReactElement {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //React Locators
        BrowserContext browserContext = browser.newContext();
        Page page = browser.newPage();
        page.navigate("https://www.netflix.com/ae-en/");

        Locator email= page.locator("_react=p[name='email'] >> input").first();

        email.click();
        email.fill("tamit700@gmail.com");


    }
}
