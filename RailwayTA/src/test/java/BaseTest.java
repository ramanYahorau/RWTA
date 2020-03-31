abstract class BaseTest {

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";

    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.firefox.driver";
    private static final String FIREFOX_DRIVER_PATH = "src/main/resources/geckodriver.exe";

    public void setDriverProperties(String driver){
        switch(driver){
            case ("chrome"):
                System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_PATH);
            case("firefox"):
                System.setProperty(FIREFOX_DRIVER_PROPERTY, FIREFOX_DRIVER_PATH);
        }
    }
}
