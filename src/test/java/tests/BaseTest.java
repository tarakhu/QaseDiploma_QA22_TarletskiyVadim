package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import modals.CreatedCaseModal;
import modals.NewProjectModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners(TestListener.class)
public abstract class BaseTest {
    protected final static String BASE_URL = "https://app.qase.io/login";
    protected final static String USER_NAME = "zursan@gmail.com";
    protected final static String PASSWORD = "P@ssword1";

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ProjectsPage projectPage;
    protected NewProjectModal newProjectModal;
    protected CreatedCaseModal createdCaseModal;
    protected ProjectDetailsPage projectDetailsPage;
    protected CreateNewTestCasePage createNewTestCasePage;
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());



    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        testContext.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        projectPage = new ProjectsPage(driver);
        newProjectModal = new NewProjectModal(driver);
        createdCaseModal = new CreatedCaseModal(driver);
        projectDetailsPage = new ProjectDetailsPage(driver);
        createNewTestCasePage = new CreateNewTestCasePage(driver);



    }

    @BeforeMethod(alwaysRun = true)
    public void navigate()  {
        driver.get(BASE_URL);
    }



    @AfterClass(alwaysRun = true)
    public void tearDown()  {
        driver.quit();
    }
}
