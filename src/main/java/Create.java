import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Create {

    static String Link = "http://localhost:8080";

    static ChromeDriver browser;


    public static boolean CreateNewEntry(String FirstNumber, String SecondNumber, WebDriver browser) {

        WebElement FirstnumberField = browser.findElement(By.xpath("//input[@id='sk1']"));
        WebElement SecondNumberField = browser.findElement(By.xpath("//input[@id='sk2']"));

        FirstnumberField.clear();
        SecondNumberField.clear();

        FirstnumberField.sendKeys(FirstNumber);
        SecondNumberField.sendKeys(SecondNumber);


        SecondNumberField.submit();


        boolean success;
        try {
            browser.findElement(By.xpath("//input[@value='skaičiuoti']"));
            success = false;
        } catch (NoSuchElementException e) {
            success = true;
        }
        System.out.println("Was the entry creation successful: " + success);
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
