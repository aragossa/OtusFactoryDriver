package Properties;

import java.io.IOException;

public class PropertiesReader {
    public String readProperties() throws IOException {

        String browserName = System.getProperty("browser");
        if (browserName != null) {
            if (browserName.toLowerCase().equals(Browser.chrome.toString())) {
                return Browser.chrome.toString();
            } else if (browserName.toLowerCase().equals(Browser.firefox.toString())) {
                return Browser.firefox.toString();
            } else {
                return Browser.chrome.toString();
            }
        } else {
            return Browser.chrome.toString();
        }
    }

    public enum Browser{
        chrome,
        firefox
    }
}
