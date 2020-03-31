package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private static final String PAGE_PATH = "https://www.rw.by/";

    private SelenideElement destinationFromField =  $(".index-tabs-content #acFrom");

    private SelenideElement destinationToField =  $(".index-tabs-content #acTo");

    private SelenideElement dateField = $(".index-tabs-content #yDate");

    private SelenideElement searchButton = $("#tickets_form .std-button");

    public HomePage openPage(){
        open(PAGE_PATH);
        return this;
    }

    public HomePage fillDestinationFromField(String destination){
        destinationFromField.shouldBe(Condition.visible);
        destinationFromField.setValue(destination);
        return this;
    }

    public HomePage fillDestinationToField(String destination){
        destinationToField.shouldBe(Condition.visible);
        destinationToField.setValue(destination);
        return this;
    }

    public HomePage setDate(String date){
        dateField.shouldBe(Condition.visible);
        dateField.setValue(date);
        return this;
    }

    public void performSearch(){
        searchButton.click();
    }
}
