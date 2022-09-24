import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object.*;
import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

    public class FirstTest {
        public WebDriver driver;
        public WebDriverWait wait;


        @BeforeEach
        public void setup() {
            driver = new ChromeDriver();
        }


        @Test
        public void eightComponents() {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
            driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

            String title = driver.getTitle();
            assertEquals("Web form", title);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            WebElement textBox = driver.findElement(By.name("my-text"));
            WebElement submitButton = driver.findElement(By.cssSelector("button"));

            textBox.sendKeys("Selenium");
            submitButton.click();

            WebElement message = driver.findElement(By.id("message"));
            String value = message.getText();
            assertEquals("Received!", value);
            driver.navigate().back();
            driver.navigate().refresh();
        }



        @Test
        public void secondTest(){
            driver.get("http://suninjuly.github.io/alert_accept.html");
            WebElement b1 = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            b1.click();

            //       wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            System.out.println(text);
            alert.dismiss();


        }

        @Test
        public void thirdTest(){
            driver.get("http://example.com/some404page");
          driver.manage().addCookie(new Cookie("_gid","value"));
            driver.manage().addCookie(new Cookie("uid","value"));
            driver.manage().addCookie(new Cookie("fit-size","value"));
            Cookie cookie1 = driver.manage().getCookieNamed("key");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Test
        public void frames(){
            ((JavascriptExecutor)driver).executeScript("window.frames; getTextAttribute();");

            driver.switchTo().frame("iframe");
            driver.findElement(By.tagName("button")).click();
            driver.switchTo().defaultContent();
        }


    @Test
    public void windowAndTabs(){
        driver.get("https://chromedriver.chromium.org/downloads");
        String mainWindHand = driver.getWindowHandle();
        driver.findElement(By.className("XqQF9c")).click();
        System.out.println(driver.getWindowHandles().size());
        //wait.until(numberOfWindowsToBe(2));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String windowHan:driver.getWindowHandles()) {
            if (mainWindHand.contains(windowHan)){
                driver.switchTo().window(windowHan);
            }
        }
        driver.switchTo().newWindow(WindowType.TAB);
        driver.close();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void manegeSizeWindow(){
        driver.get("https://chromedriver.chromium.org/downloads");
        int width = driver.manage().window().getSize().getWidth();
        Dimension size  = driver.manage().window().getSize();
        System.out.println("Width is: "+size.getWidth());
        driver.manage().window().setSize(new Dimension(1024, 768));
        int getX = driver.manage().window().getPosition().getX();
        driver.manage().window().maximize();


    }
    @Test
    public void takeScreenShot() {
        driver.get("https://chromedriver.chromium.org/downloads");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printPage(){
        driver.get("https://chromedriver.chromium.org/downloads");
        PrintsPage printer = (PrintsPage)driver;
        PrintOptions options= new PrintOptions();
        options.setPageRanges("1-2");
        Pdf pdf = printer.print(options);
        String cont = pdf.getContent();
        System.out.println(cont);

    }

    @Test
    public void someTest(){
        driver.get("https://krop.itstep.org/");
        WebElement el1 = driver.findElement(By.className("dropbtn-phones"));
        WebElement el1_1 = el1.findElement(By.tagName("div"));
        List<WebElement> ls1 = driver.findElements(By.tagName("jhbsd"));
        for (WebElement webElement : ls1) {
            webElement.getText();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By field = RelativeLocator.with(By.className("dropbtn-phones")).above(By.id("kjbfdkjbf"));
    }




    @AfterEach
    public void quit() {
        driver.quit();
    }

}
