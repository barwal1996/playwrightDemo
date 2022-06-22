package org.example.playwrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Auth {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //React Locators
        BrowserContext browserContext = browser.newContext();
        Page page = browser.newPage();

        page.navigate("http://www.automationpractice.com/index.php");

        page.click("a:text('Sign in')");

        page.fill("#email","testrigornaveen@gmail.com");
        page.fill("#passwd","testrigor123");

        page.click("#SubmitLogin");

        browserContext.storageState(new BrowserContext.StorageStateOptions().
                setPath(Paths.get("appLogin.json")));

    }
}
