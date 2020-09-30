package WebDriverFactory;
import Properties.PropertiesReader.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver create(String name){
        logger.info(name);
        if (name.equals(Browser.chrome.toString())) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (name.equals(Browser.firefox.toString())) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}