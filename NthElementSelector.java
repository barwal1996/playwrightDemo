package org.example.playwrightSession;

import com.microsoft.playwright.*;

public class NthElementSelector
{
    static Page page;
    public static void main(String[] args) {
        Playwright playwright =Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        page=browser.newPage();

        page.navigate("http://www.bigbasket.com");
        Locator firstEle= page.locator("div.footer-links li a >> nth=0");
        String first_Ele= firstEle.textContent();
        System.out.println(first_Ele);
        firstEle.click();

        Locator lastEle= page.locator("div.footer-links li a >> nth=-1");
        String last_Ele= lastEle.textContent();
        System.out.println(last_Ele);


    }
}
