package org.example.playwrightSession;

import com.microsoft.playwright.*;

import java.awt.*;

public class MaximumBrowser {
    public static void main(String[] args) {
        //to find size of screen
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)screenSize.getWidth();
        int height=(int)screenSize.getHeight();
        System.out.println(width+": "+height);
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));


        BrowserContext browserContext = browser.newContext
                (new Browser.NewContextOptions().setViewportSize(1366,768));
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com");

    }
}
