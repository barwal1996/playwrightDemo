package org.example.playwrightSession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomElement {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //check page--> dom -- then check shadow DOm --> elements
        //page -->DOM-->iframe-->Shadow DOM-->elements

        Page page = browser.newPage();

        page.navigate("https://books-pwakit.appspot.com/");

        page.locator("book-app[apptitle='BOOKS'] #input ").fill("Testing Books");
        String header= page.locator("book-app[apptitle='BOOKS'] .books-desc ").textContent();
        System.out.println(header);
    }
}
