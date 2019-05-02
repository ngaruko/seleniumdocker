import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxTest {

    @Test
    public void testFirefox() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setBrowserName("firefox");
        caps.setPlatform(Platform.LINUX);
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"),caps);
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle;

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println("Title" + actualTitle);

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!" + actualTitle);
        } else {
            System.out.println("Test Failed");
        }


        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
        driver.manage().window().setSize(new Dimension(600, 500));
        Thread.sleep(5000);
        driver.close();
        driver.quit();

    }
}
