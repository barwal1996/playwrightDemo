package org.example.playwrightSession;

import com.microsoft.playwright.*;

import java.util.List;

public class LocatorConcept {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //locators

        BrowserContext browserContext=browser.newContext();
        Page page=browserContext.newPage();
        page.navigate("https://www.orangehrm.com/hris-hr-software-demo/");

//        Locator contactSales=page.locator("text=CONTACT SALES");
//        contactSales.hover();
//        contactSales.click();

        //single element
//        Locator loginBtn=page.locator("text=Login");
//        int totalLogin = loginBtn.count();
//        System.out.println(totalLogin);
//
//        loginBtn.first().click();

//        loginBtn.hover();
//        loginBtn.click();

        //multiple Locators
        Locator countryOptions = page.locator("select#Form_submitForm_Country option");
        System.out.println(countryOptions.count());

        //one -way
//        for (int i=0;i<countryOptions.count();i++){
//            String text = countryOptions.nth(i).textContent();
//            System.out.println(text);
//        }

        //2nd way

        List<String> optionTextList =countryOptions.allTextContents();
//        for(String e:optionTextList){
//            System.out.println(e);
//        }

        //Lambda way

        optionTextList.forEach(ele -> System.out.println(ele));

    }
}
