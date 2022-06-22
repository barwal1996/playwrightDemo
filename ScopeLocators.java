package org.example.playwrightSession;

import com.microsoft.playwright.*;

public class ScopeLocators {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //React Locators
        BrowserContext browserContext = browser.newContext();
        Page page = browser.newPage();
        page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
        //page.navigate("https://www.primefaces.org/primeng/table");
        Locator row= page.locator("table#example tr");
        row.locator(":scope",new Locator.LocatorOptions().setHasText("Ashton Cox")).locator(".select-checkbox").click();

        //fetching all rows text
        row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));


    }
}
