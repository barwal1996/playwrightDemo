package org.example.playwrightSession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasic {
    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("firefox");
        lp.setHeadless(false);
        Browser browser = playwright.firefox().launch(lp);
        Page page = browser.newPage();

        page.navigate("https://www.amazon.com");

        String title = page.title();
        System.out.println("title is "+title);
        browser.close();
        playwright.close();
    }
}
