package org.example.playwrightSession;

import com.microsoft.playwright.*;

import java.util.List;

public class HasElements {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

//        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
//
//        Locator locator=page.locator("select#form_submitForm_Country:has(option[value='India'])");
//        locator.allInnerTexts().forEach(e-> System.out.println(e));

        page.navigate("https://www.amazon.com/");

        Locator footerList=page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");

        footerList.allInnerTexts().forEach(e-> System.out.println(e));

    }
}
