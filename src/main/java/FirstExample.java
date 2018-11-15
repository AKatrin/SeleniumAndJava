import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driverFirefox = getDriver(0);
        openImage(driverFirefox);
        closeDriver(driverFirefox);

        WebDriver driverChrome = getDriver(1);
        openImage(driverChrome);
        closeDriver(driverChrome);

        WebDriver driverEdge = getDriver(2);
        openImage(driverEdge);
        closeDriver(driverEdge);

        WebDriver driverOpera = getDriver(3);
        openImage(driverOpera);
        closeDriver(driverOpera);
    }

    private static void openImage(WebDriver driver) {
        driver.get("http://www.google.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(6, TimeUnit.SECONDS);

        driver.findElement(By.id("lst-ib")).click();
        driver.findElement(By.id("lst-ib")).sendKeys("Naruto");

        driver.findElement(By.name("btnK")).click();

        driver.findElement(By.linkText("Imágenes")).click();
        List<WebElement> imagenes = driver.findElements(By.tagName("img"));
        imagenes.get(2).click();

    }

    private static void closeDriver(WebDriver driver1) throws InterruptedException {
        Thread.sleep(10000);
        driver1.quit();
    }

    //browsername should be an enum
    private static WebDriver getDriver(int browserName) {
        WebDriver driver1 = null;
        switch (browserName) {
            case 0:
                System.setProperty("webdriver.gecko.driver", "C:\\dev\\tools\\firefoxTools\\geckodriver.exe");
                driver1 = new FirefoxDriver();
                break;
            case 1:
                System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\chromeTools\\chromedriver.exe");
                driver1 = new ChromeDriver();
                break;
            case  2:
                System.setProperty("webdriver.edge.driver", "C:\\dev\\tools\\edgeTools\\MicrosoftWebDriver.exe");
                driver1 = new EdgeDriver();
                break;
            case 3:
                System.setProperty("webdriver.opera.driver", "C:\\dev\\tools\\operaTools\\operadriver.exe");
                driver1 = new OperaDriver();
                break;
        }
        return driver1;
    }

}
