import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {


    static String Link = "http://localhost:8080";

    static ChromeDriver browser;


    public static boolean Login(String Username, String Password, WebDriver browser) {


        WebElement UsernameField = browser.findElement(By.xpath("//input[@placeholder='Prisijungimo vardas']"));
        WebElement PasswordField = browser.findElement(By.xpath("//input[@placeholder='Slaptažodis']"));


        UsernameField.sendKeys(Username);
        PasswordField.sendKeys(Password);


        PasswordField.submit();


        boolean success;
        try {

            browser.findElement(By.xpath("//input[@value='skaičiuoti']"));
            success = true;
        } catch (NoSuchElementException e) {
            success = false;
        }
        System.out.println("Was the login successful: " + success);
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
