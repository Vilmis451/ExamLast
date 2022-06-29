import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Edit {

    static String Link = "http://localhost:8080";

    static ChromeDriver browser;


    public static boolean EditEntry(boolean SupossedToFail, String NumberChange, WebDriver browser) {


        browser.findElement(By.xpath("//a[normalize-space()='Atliktos operacijos']")).click();


        browser.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/a[1]")).click();


        if (SupossedToFail) {

            WebElement FirstNumberField = browser.findElement(By.xpath("//input[@name='sk1']"));
            FirstNumberField.clear();
            FirstNumberField.submit();


        } else {

            WebElement FirstNumberField = browser.findElement(By.xpath("//input[@name='sk1']"));
            FirstNumberField.clear();
            FirstNumberField.sendKeys(NumberChange);
            FirstNumberField.submit();
        }


        boolean success;
        try {


            browser.findElement(By.xpath("//a[@type='button']"));
            success = true;
        } catch (NoSuchElementException e) {
            success = false;
        }
        System.out.println("Was the entry edit successful: " + success);
        return success;


    }


    public static void OpenChrome() {

        browser = new ChromeDriver();
        browser.get(Link);

    }

    public static void CloseChrome() {
        browser.close();
    }


}
