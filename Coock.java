package FirstTest;
public class Coock {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void setDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }


    @Test
    public void CookieTest(){
        driver.get("http://example.com/some404page");
        driver.manage().addCookie(new Cookie("message", "welcome"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
}
