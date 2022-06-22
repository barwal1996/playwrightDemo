package org.example.playwrightSession;

import com.microsoft.playwright.*;

public class XpathLocator {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //React Locators
        BrowserContext browserContext = browser.newContext();
        Page page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");

        page.locator("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']").click();

        //for checking all checkboxes
        Locator checkBox=page.locator("(//table[@id='resultTable']//input[@type='checkbox'])");
        for(int i=0;i<checkBox.count();i++){
            checkBox.nth(i).click();
        }

        page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[1]").click();
        page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();
    }
}
