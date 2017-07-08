public class Attacker extends Player {
    private int passes, recuperations, number;
    private String name;

    public Attacker(String name, int number) {
        super(name, number);
        this.name = name;
        this.number = number;
    }


    public int getPasses() {
        return passes;
    }

    public String toString() {
        return number + " " +  name + " (Attacker) " + " Goals: " + getGoals() +
                " Passes: " + getPasses() + " Recuperations: " + getRecuperations() +
                " Valoration: " + valoration();
    }

    public int getRecuperations() {
        return recuperations;
    }



    public void setPasses() {
        passes++;
    }


    public void setRecuperations() {
        recuperations++;
    }


    public int valoration() {
        return (getGoals()*30) + getPasses() + (getRecuperations()*3);
    }
}