package org.example.playwrightSession;

import com.microsoft.playwright.*;

public class JSPopUpHandle {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browser.newPage();

        page.onDialog(dialog -> {
            String text=dialog.message();
            System.out.println(text);

            //dialog.accept();
            //pass msg on dialog box
            dialog.accept("Accepted aage bado");
            //dialog.dismiss();
        });

        page.navigate("http://the-internet.herokuapp.com/javascript_alerts");


        page.click("//button[text()='Click for JS Alert']");
        String result =page.textContent("#result");
        System.out.println(result);
        Thread.sleep(1500);

        page.click("//button[text()='Click for JS Confirm']");
        String result1 =page.textContent("#result");
        System.out.println(result1);
        Thread.sleep(1500);

        page.click("//button[text()='Click for JS Prompt']");
        Thread.sleep(1500);

        String result2 =page.textContent("#result");
        System.out.println(result2);

        page.close();
        browser.close();
        playwright.close();

        //Js alerts,
    }
}
