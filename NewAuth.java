package org.example.playwrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class NewAuth {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext=browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin.json")));

        Page page=browserContext.newPage();

        page.navigate("http://www.automationpractice.com/index.php");


    }
}
