import PageObject.HomePage;
import PageObject.RoutePage;

import java.io.IOException;
import java.util.List;

public class Steps {

    HomePage homePage = new HomePage();
    RoutePage routePage = new RoutePage();

    public Steps searchForTrip(String from, String to, String date){
        homePage.openPage()
                .fillDestinationFromField(from)
                .fillDestinationToField(to)
                .setDate(date)
                .performSearch();
        return this;
    }

   public boolean isDirectionTypeSelectedByDefault(String type){
       return routePage.isDirectionTypeSelected(type);
   }

   public boolean isERegistrationFilterWorksProperly(String registrationOrderType){
        routePage.selectElectronicRegistrationCheckbox();
        List<String> eRegistrationOrderTypes = routePage.getAllTicketsOrderType();
        return eRegistrationOrderTypes.stream()
                .allMatch(eRegistrationOrderType -> eRegistrationOrderType.equals(registrationOrderType));
   }

   public int getDateFiltersCount(){
        return routePage.getDateFiltersValue().size();
   }

   public List<String> getTrainsInformation(){
        return routePage.getTrainsInformation();
   }

   public int getImagesCount() throws IOException {
       return routePage.getImagesFromPage().size();
   }

}
