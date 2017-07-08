public class Defender extends Player {
    public int passes, recuperations, number;
    private String name;

    public Defender(String name, int number){
        super(name, number);
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return number + " " +  name + " (Defender) " + " Goals: " + getGoals() +
                " Passes: " + getPasses() + " Recuperations: " + getRecuperations() +
                " Valoration: " + valoration();
    }

    public int getPasses() {
        return passes;
    }

    public int getRecuperations() {
        return recuperations;
    }

    public void setRecuperations() {
        recuperations++;
    }


    public void setPasses() {
        passes++;
    }

    public int valoration() {
        return  (getGoals()*20) + getPasses() + (getRecuperations()*4);
    }
}