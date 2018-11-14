import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FirstExample {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hi");
        System.setProperty("webdriver.gecko.driver", "C:\\\\dev\\tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        driver.findElement(By.id("lst-fb")).click();
        driver.findElement(By.id("lst-fb")).sendKeys("Naruto");
        driver.findElement(By.name("btnR")).click();

        driver.findElement(By.linkText("imagenes")).click();
        List<WebElement> imagenes = driver.findElements(By.tagName("img"));

        if(imagenes.size() > 2) {
            imagenes.get(2).click();
        }

        Thread.sleep(25000);
        driver.quit();
    }
}
