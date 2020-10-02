import Config.ServerConfig;
import WebDriverFactory.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class OtusWebFactoryDriverTest {
    private WebDriver driver;
    private Logger logger = LogManager.getLogger(OtusWebFactoryDriverTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class,
                                                    System.getProperties(),
                                                    System.getenv());


    @Before
    public void setUp() {
        String browser = cfg.getBrowser();
        logger.info(browser);
        driver = WebDriverFactory.create(browser);
        logger.info("Драйвер поднят");
    }

    @Test
    public void openPage() {
        logger.info(cfg.url());
        driver.get(cfg.url());
        logger.info("Открыта страница отус");
        driver.manage().window().maximize();
        logger.info("Развернуто на полный экран");
        assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям", driver.getTitle());
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
