package TestData;

public class Trip {

    private String destinationFrom;
    private String destinationTo;
    private String date;

    public Trip(String destinationFrom, String destinationTo, String date){
        this.destinationFrom = destinationFrom;
        this.destinationTo = destinationTo;
        this.date = date;
    }

    public String getDestinationFrom() {
        return destinationFrom;
    }

    public String getDestinationTo() {
        return destinationTo;
    }

    public String getDate() {
        return date;
    }
}
