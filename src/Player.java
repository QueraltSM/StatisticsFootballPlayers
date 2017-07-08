public abstract class Player implements Comparable<Player> {
    private int goals, number;
    private String name;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber(){
        return number;
    }

    public boolean equals(Player p) {
        return p.getNumber() == getNumber();
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals() {
        goals++;
    }

    public abstract int valoration();


    public int compareTo(Player p) {
        if (CU.getOrder() == 0) {
            if (p.getNumber()<getNumber()) {
                return 1;
            } else if(p.getNumber() == getNumber()) {
                return 0;
            }
            return -1;

        } else if (CU.getOrder() == 1) {
            if (p.getGoals()<getGoals()) {
                return -1;
            } else if(p.getGoals() == getGoals()) {
                return 0;
            }
            return 1;
        }
        return 0;
    }


    public String situation(){
        if (this instanceof Goalkeeper) {
            return getNumber() + " " + getName() + " (Goalkeeper)";
        } else if (this instanceof Attacker) {
            return getNumber() + " " + getName() + " (Attaker)";
        }
        return getNumber() + " " + getName() + " (Defender)";
    }
}