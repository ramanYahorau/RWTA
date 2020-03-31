package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {

    public static String convertToMinutes(String hoursAndMinutes){
        SimpleDateFormat formatter = new SimpleDateFormat("hh ч mm мин");
        Date parsedDate;
        try{
            parsedDate = formatter.parse(hoursAndMinutes);
        }catch (ParseException e){
            return hoursAndMinutes;
        }
        return (String.format("%s мин",parsedDate.getHours()*60 + parsedDate.getMinutes()));
    }
}
