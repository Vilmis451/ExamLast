import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {


    static String Link = "http://localhost:8080";

    static ChromeDriver browser;


    public static Boolean Register(String Username, String Password, WebDriver browser) {


        WebElement RegisterButton = browser.findElement(By.xpath("//a[contains(text(),'Sukurti naują paskyrą')]"));
        RegisterButton.click();


        WebElement UsernameField = browser.findElement(By.xpath("//input[@id='username']"));
        WebElement PasswordField = browser.findElement(By.xpath("//input[@id='password']"));
        WebElement ConfirmPasswordfield = browser.findElement(By.xpath("//input[@id='passwordConfirm']"));


        UsernameField.sendKeys(Username);
        PasswordField.sendKeys(Password);
        ConfirmPasswordfield.sendKeys(Password);


        ConfirmPasswordfield.submit();


        boolean success;
        try {

            browser.findElement(By.xpath("//input[@value='skaičiuoti']"));
            success = true;
        } catch (NoSuchElementException e) {
            success = false;
        }
        System.out.println("Was the registration successful: " + success);
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
