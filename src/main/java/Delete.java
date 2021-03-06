import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class Delete {

    static String Link = "http://localhost:8080";

    static ChromeDriver browser;


    public static boolean DeleteEntry(boolean SupposedToFail, WebDriver browser) {


        browser.findElement(By.xpath("//a[normalize-space()='Atliktos operacijos']")).click();

        List<WebElement> NumberOfEntriesBefore = browser.findElements(By.xpath("/html/body/div/table/tbody/tr"));
        System.out.println("Num rows: " + NumberOfEntriesBefore.size());


        browser.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/a[2]")).click();


        if (SupposedToFail) {
            browser.switchTo().alert().dismiss();
            System.out.println("Dismissing the alert");
        } else {

            browser.switchTo().alert().accept();
            System.out.println("Accepting the alert");
        }


        List<WebElement> NumberOfEntriesAfter = browser.findElements(By.xpath("/html/body/div/table/tbody/tr"));
        System.out.println("Num rows: " + NumberOfEntriesAfter.size());


        if (NumberOfEntriesBefore.size() > NumberOfEntriesAfter.size()) {

            return true;

        } else {

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
