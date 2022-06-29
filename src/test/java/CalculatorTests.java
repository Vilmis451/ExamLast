import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTests {

    // Values that can be changed
    String Username = "testerisV";
    String Password = "vilhelmas";


    static ChromeDriver browser;

    @BeforeMethod(onlyForGroups = "DoesntNeedL")
    public void Start() {
        System.setProperty("webdriver.chrome.driver", "src/main/ChromeWebDriver/chromedriver102.exe");
        browser = new ChromeDriver();
        browser.get("http://localhost:8080");
    }

    @BeforeMethod(onlyForGroups = "NeedL")
    public void StartWithLogin() {
        System.setProperty("webdriver.chrome.driver", "src/main/ChromeWebDriver/chromedriver102.exe");
        browser = new ChromeDriver();
        browser.get("http://localhost:8080");

        Login.Login(Username, Password, browser);
    }

    @AfterMethod
    public void Stop() {

        browser.close();

    }

    @Test(groups = "DoesntNeedL")
    public void RegisterPositive() {

        Faker faker = new Faker();
        Assert.assertTrue(Register.Register(faker.name().username(), faker.internet().password(), browser));

    }

    @Test(groups = "DoesntNeedL")
    public void RegisterNegative() {

        Faker faker = new Faker();
        Assert.assertFalse(Register.Register(faker.name().username(), "", browser));

    }

    // Login
    @Test(groups = "DoesntNeedL")
    public void LoginPositive() {

        Assert.assertTrue(Login.Login(Username, Password, browser));

    }

    @Test(groups = "DoesntNeedL")
    public void LoginNegative() {

        Assert.assertFalse(Login.Login(Username, "", browser));

    }

    @Test(groups = "NeedL")
    public void CreateEntryPositive() {

        Assert.assertTrue(Create.CreateNewEntry("55", "12", browser));

    }

    @Test(groups = "NeedL")
    public void CreateEntryNegative() {

        Assert.assertFalse(Create.CreateNewEntry("-55", "12", browser));

    }

    @Test(groups = "NeedL")
    public void SearchResultPositive() {

        Assert.assertTrue(Search.SearchEntry(false, browser));

    }

    @Test(groups = "NeedL")
    public void SearchResultNegative() {

        Assert.assertFalse(Search.SearchEntry(true, browser));

    }

    @Test(groups = "NeedL")
    public void EditEntryPositive() {

        Assert.assertTrue(Edit.EditEntry(false, "12", browser));

    }

    @Test(groups = "NeedL")
    public void EditEntryNegative() {

        Assert.assertFalse(Edit.EditEntry(true, "", browser));

    }

    @Test(groups = "NeedL")
    public void DeleteEntryPositive() {

        Assert.assertTrue(Delete.DeleteEntry(false, browser));

    }

    @Test(groups = "NeedL")
    public void DeleteEntryNegative() {

        Assert.assertFalse(Delete.DeleteEntry(true, browser));

    }

}
