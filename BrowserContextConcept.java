package org.example.playwrightSession;

import com.microsoft.playwright.*;

public class BrowserContextConcept {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext brxc1=browser.newContext(); //it wont share coookie and all data with other browserContext

        Page p1 = brxc1.newPage();
        p1.navigate("https://www.orangehrm.com/hris-hr-software-demo/");

        p1.fill("#Form_submitForm_FirstName","Amit");
        System.out.println(p1.title());

        BrowserContext brxc2=browser.newContext(); //it wont share coookie and all data with other browserContext

        Page p2 = brxc2.newPage();
        p2.navigate("http://automationpractice.com/index.php");

        p2.fill("#search_query_top","Shirt");
        System.out.println(p2.title());

    }
}
