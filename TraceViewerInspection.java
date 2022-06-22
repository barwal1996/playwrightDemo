package org.example.playwrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Paths;


public class TraceViewerInspection {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));


            // Open new page
            Page page = context.newPage();

            // Go to https://www.facebook.com/
            page.navigate("https://www.facebook.com/");

            // Click [data-testid="open-registration-form-button"]
            page.locator("[data-testid=\"open-registration-form-button\"]").click();

            // Click [placeholder="First name"]
            page.locator("[placeholder=\"First name\"]").click();

            // Fill [placeholder="First name"]
            page.locator("[placeholder=\"First name\"]").fill("Amit");

            // Press Tab
            page.locator("[placeholder=\"First name\"]").press("Tab");

            // Fill [aria-label="Surname"]
            page.locator("[aria-label=\"Surname\"]").fill("Barwal");

            // Press Tab
            page.locator("[aria-label=\"Surname\"]").press("Tab");

            // Fill [aria-label="Mobile number or email address"]
            page.locator("[aria-label=\"Mobile number or email address\"]").fill("9717855053");

            // Press Tab
            page.locator("[aria-label=\"Mobile number or email address\"]").press("Tab");

            // Fill [aria-label="New password"]
            page.locator("[aria-label=\"New password\"]").fill("Amit@1996");

            // Press Tab
            page.locator("[aria-label=\"New password\"]").press("Tab");

            // Select 20
            page.locator("[aria-label=\"Day\"]").selectOption("20");

            // Select 9
            page.locator("[aria-label=\"Month\"]").selectOption("9");

            // Select 2006
            page.locator("[aria-label=\"Year\"]").selectOption("2006");

            // Check input[name="sex"] >> nth=1
            page.locator("input[name=\"sex\"]").nth(1).check();

            // Click img >> nth=2
            page.locator("img").nth(2).click();

            // Click [data-testid="royal_email"]
            page.locator("[data-testid=\"royal_email\"]").click();

            // Fill [data-testid="royal_email"]
            page.locator("[data-testid=\"royal_email\"]").fill("tamit");

            // Press Tab
            page.locator("[data-testid=\"royal_email\"]").press("Tab");

            // Click #passContainer
            page.locator("#passContainer").click();

            // Fill [data-testid="royal_pass"]
            page.locator("[data-testid=\"royal_pass\"]").fill("fasfafa");

            // Click [data-testid="royal_login_button"]
            page.locator("[data-testid=\"royal_login_button\"]").click();

            // Go to https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjU1MDIyNjM5LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D
            page.navigate("https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjU1MDIyNjM5LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D");

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}
