import java.util.*;
public class CU {
    private ArrayList<Player> players = new ArrayList<>();
    private static int order;

    public CU(){}

    public boolean search(int number) {
        for (Player i : players) {
            if (i.getNumber() == number) return true;
        }
        return false;
    }
    public String showData(int number) {
        for (Player i : players) {
            if (i.getNumber() == number) {
                return i.toString();
            }
        }
        return "";
    }


    public void setOrder(int ord) {
        order = ord;
        Collections.sort(players);
    }

    public static int getOrder() {
        return order;
    }

    public List<Player> getList() {
        return players;
    }

    public boolean newStop(int number) {
        for (Player i : players) {
            if (i.getNumber() == number && i instanceof Goalkeeper) {
                ((Goalkeeper) i).setStops();
                return true;
            }
        }
        return false;
    }


    public boolean newRecuperation(int number) {
        for (Player i : players) {
            if (i.getNumber() == number) {
                if (i instanceof Attacker) {
                    ((Attacker) i).setRecuperations();
                    return true;
                } else if (i instanceof Defender) {
                    ((Defender) i).setRecuperations();
                    return true;
                }
            }
        }
        return false;
    }


    public boolean newGoal (int number) {
        for (Player i : players) {
            if (i.getNumber() == number) {
                i.setGoals();
                return true;
            }
        }
        return false;
    }


    public boolean addPlayer(Player p) {
        for (Player i : players) {
            if (i.equals(p)) return false;
        }
        players.add(p);
        return true;
    }

    public boolean passSuccessfully(int number) {
        for(Player i : players) {
            if (number == i.getNumber()) {
                if (i instanceof Attacker) {
                    ((Attacker)i).setPasses();
                    return true;
                } else if (i instanceof Defender) {
                    ((Defender)i).setPasses();
                    return true;
                }
            }
        }
        return false;
    }
}