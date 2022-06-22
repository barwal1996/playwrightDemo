package org.example.playwrightSession;

import com.microsoft.playwright.*;


public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Open new page
            Page page = context.newPage();

            // Go to https://www.facebook.com/
            page.navigate("https://www.facebook.com/");

            // Click [data-testid="royal_email"]
            page.locator("[data-testid=\"royal_email\"]").click();

            // Fill [data-testid="royal_email"]
            page.locator("[data-testid=\"royal_email\"]").fill("tamit700");

            // Press Tab
            page.locator("[data-testid=\"royal_email\"]").press("Tab");

            // Fill [data-testid="royal_pass"]
            page.locator("[data-testid=\"royal_pass\"]").fill("Amit@1996");

            // Click [data-testid="royal_login_button"]
            // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjU0OTc3NDU3LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D"), () ->
            page.waitForNavigation(() -> {
                page.locator("[data-testid=\"royal_login_button\"]").click();
            });

            // Click [data-testid="assistive_id_dialog"] i
            page.locator("[data-testid=\"assistive_id_dialog\"] i").click();
        }
    }
}