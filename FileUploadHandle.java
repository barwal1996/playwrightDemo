package org.example.playwrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadHandle {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browser.newPage();

        page.navigate("https://davidwalsh.name/demo/mulitple-file-upload.php");

        //input type file

        //select one file

        page.setInputFiles("input#filesToUpload", Paths.get("applogin.json"));
        Thread.sleep(4000);

        //dismiss the file
        page.setInputFiles("input#filesToUpload",new Path[0]);

        //multiple FIles

        page.setInputFiles("input#filesToUpload",
                new Path[] {
                        Paths.get("awpplogin.json"),
                        Paths.get("apploin.json"),
                        Paths.get("applogn.json"),

                });

        //detach everyhing
        Thread.sleep(4000);

        //dismiss the file
        page.setInputFiles("input#filesToUpload",new Path[0]);

        //run-time file upload


    }
}
