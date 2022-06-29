import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Search {

    static String Link = "http://localhost:8080";

    static ChromeDriver browser;


    public static boolean SearchEntry(boolean SupossedtoFail, WebDriver browser) {


        Create.CreateNewEntry("899", "898", browser);


        browser.findElement(By.xpath("//a[normalize-space()='Atliktos operacijos']")).click();

        List<WebElement> Results;

        if (SupossedtoFail) {

            Results = browser.findElements(By.xpath("//td[contains(.,'IMGOINGTOFAIL')]"));

        } else {

            Results = browser.findElements(By.xpath("//td[contains(.,'1797')]"));
        }

        if (Results.size() > 0) {
            System.out.println("Found: " + Results.size());
            return true;
        } else {

            System.out.println("Found: " + Results.size());
            return false;
        }
    }


    public static void OpenChrome() {

        browser = new ChromeDriver();
        browser.get(Link);

    }


    public static void CloseChrome() {
        browser.close();
    }


}
