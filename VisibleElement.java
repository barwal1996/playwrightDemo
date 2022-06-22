package org.example.playwrightSession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class VisibleElement {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        //button : visible
        //button >> visible =true

//        page.navigate("https://127.0.0.1/DummyPageForvisibleButton");
//        String  text = page.locator("button:visible").textContent();
//        System.out.println(text);

        page.navigate("https://www.amazon.com/");
        List<String> list = page.locator("a:visible").allTextContents();
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));

        }

        //by xpath need all img which are visible in website
        int imgCount=page.locator("xpath=//img >> visible=true").count();
        System.out.println(imgCount);
    }
}
