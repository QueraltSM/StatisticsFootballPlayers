public class Goalkeeper extends Player {
    private int stops, number;
    private String name;

    public Goalkeeper(String name, int number){
        super(name, number);
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return number + " " +  name + " (Goalkeeper) " + " Goals: " + getGoals() +
                " Stops: " + getStops() + " Valoration: " + valoration();
    }

    public int getStops(){
        return stops;
    }

    public void setStops(){
        stops++;
    }

    public int valoration() {
        return  (getGoals()*10) + (getStops()*5);
    }
}