import TestData.Trip;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.codeborne.selenide.testng.ScreenShooter;

import java.io.IOException;

@Listeners({ScreenShooter.class})
public class Tests extends BaseTest {

    Steps steps = new Steps();
    Trip trip = new Trip("Минск-Пассажирский", "Молодечно", "05.05.2020");

    @BeforeClass
    public void setDriver(){
        setDriverProperties("chrome");
    }

    @Test
    public void defaultDirection(){
        Assert.assertTrue(steps.searchForTrip(trip.getDestinationFrom(), trip.getDestinationTo(), trip.getDate())
                .isDirectionTypeSelectedByDefault("В одну сторону"));
    }

    @Test
    public void electronicRegistration(){
        Assert.assertTrue(steps.searchForTrip(trip.getDestinationFrom(), trip.getDestinationTo(), trip.getDate())
                .isERegistrationFilterWorksProperly("ВЫБРАТЬ МЕСТА"));
    }

    @Test
    public void dateFiltersCount(){
        Assert.assertEquals(steps.searchForTrip(trip.getDestinationFrom(), trip.getDestinationTo(), trip.getDate())
                .getDateFiltersCount(), 5);
    }

    @Test
    public void imagesCount() throws IOException {
        Assert.assertTrue(steps.searchForTrip(trip.getDestinationFrom(), trip.getDestinationTo(), trip.getDate())
                .getImagesCount()>5);
    }

}
