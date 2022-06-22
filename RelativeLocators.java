package org.example.playwrightSession;

import com.microsoft.playwright.*;

import java.util.List;

public class RelativeLocators {
    static Page page;
    public static void main(String[] args) {
        Playwright playwright =Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        page=browser.newPage();

        page.navigate("https://selectorshub.com/xpath-practice-page/");

       // page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();

    //  page.locator("td:right-of(:text('"+userRole+"'))").first().textContent();

        selectUser("Joe.Root");
        selectUser("Jasmine.Morgan");

        System.out.println(getUserRole("Joe.Root"));

        Locator nearElements=page.locator("td:near(:text('Joe.Root'),400)");
        List<String> nearEleText=nearElements.allInnerTexts();
        for(String e:nearEleText){
            System.out.println(e);
        }
    }
    public static  void  selectUser(String userName){
        page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))").first().click();
    }
    public static String getUserRole(String userName){
        return  page.locator("td:right-of(:text('"+userName+"'))").first().textContent();
    }
}
