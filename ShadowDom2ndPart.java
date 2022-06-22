package org.example.playwrightSession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDom2ndPart {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //check page--> dom -- then check shadow DOm --> elements
        //page -->DOM-->iframe-->Shadow DOM-->elements

        Page page = browser.newPage();

        page.navigate("https://selectorshub.com/xpath-practice-page/");

        page.frameLocator("#pact").locator("div#snacktime #tea").fill("cutting chai");

    }
}
