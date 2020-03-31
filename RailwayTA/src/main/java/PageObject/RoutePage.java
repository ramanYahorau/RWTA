package PageObject;
import Utils.Converter;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class RoutePage {

    private static final String CHROME_USER_AGENT = "Chrome/80.0.3987.149";

    private static final String DIRECTION_TYPE_PATTERN = "//li[@class='rasp-filter__radio active']//span[text()='%s']";

    private SelenideElement eRegistrationCheckbox = $("span[data-filter-value='eregistration']");

    private List<SelenideElement> orderTicketButtons = $$(".sch-table__row form[action='/ru/order/places/']");

    private List<SelenideElement> dateFilters = $$(".sch-links__item");

    private List<SelenideElement> trainInformationRows = $$("div[class='sch-table__body js-sort-body'] .sch-table__row");

    public boolean isDirectionTypeSelected(String type){
        return $(By.xpath(String.format(DIRECTION_TYPE_PATTERN, type)))
                .exists();
    }

    public RoutePage selectElectronicRegistrationCheckbox(){
        eRegistrationCheckbox.shouldBe(Condition.visible);
        eRegistrationCheckbox.click();
        return this;
    }

    public List<String> getAllTicketsOrderType(){
        List<SelenideElement> activeOrderTicketButtons = orderTicketButtons.stream()
                .filter(SelenideElement::isDisplayed)
                .collect(Collectors.toList());
        return activeOrderTicketButtons.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getDateFiltersValue() {
        return dateFilters.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getTrainsInformation(){
        return trainInformationRows.stream()
                .map(trainInformationRow ->
                        String.format("%s -> %s -> %s", trainInformationRow.find(".train-route").getText(),
                                trainInformationRow.find(".train-to-time").getText(),
                                Converter.convertToMinutes(trainInformationRow.find(".train-duration-time").getText())))
                .collect(Collectors.toList());
    }

    public Elements getImagesFromPage() throws IOException {
        Document document = Jsoup
                .connect(getCurrentURL())
                .userAgent(CHROME_USER_AGENT)
                .timeout(10 * 1000)
                .get();
        return document.select("img[src$='.png']");
    }

    private String getCurrentURL(){
        return WebDriverRunner.url();
    }

}
