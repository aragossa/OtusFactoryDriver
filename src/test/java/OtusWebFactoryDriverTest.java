import Config.ServerConfig;
import Properties.PropertiesReader;
import WebDriverFactory.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import java.io.IOException;


public class OtusWebFactoryDriverTest {
    private static WebDriver driver;
    private Logger logger = LogManager.getLogger(OtusWebFactoryDriverTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    PropertiesReader propertiesReader = new PropertiesReader();

    @Before
    public void setUp() throws IOException {
        String browserName = propertiesReader.readProperties();
        driver = WebDriverFactory.create(browserName);
        logger.info("Драйвер поднят");
    }

    @Test
    public void openPage() {
        logger.info(cfg.url());
        driver.get(cfg.url());
        logger.info("Открыта страница отус");
        driver.manage().window().maximize();
        logger.info("Развернуто на полный экран");
        Assert.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям", driver.getTitle());
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
