package WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public enum Browser{
        CHROME,
        FIREFOX
    }

    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver create(String browserName){
        logger.info(String.format("--%s--", browserName));
        if (browserName.equalsIgnoreCase("")){
            throw new RuntimeException("Browser name can't be empty or null");
        } else {
            if (browserName.equalsIgnoreCase(Browser.CHROME.toString())) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            } else if (browserName.equalsIgnoreCase(Browser.FIREFOX.toString())) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Browser doesn't defined");
            }
        }
    }
}