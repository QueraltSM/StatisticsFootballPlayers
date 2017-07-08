import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static CU cu = new CU();
    private static Attacker attacker1 = new Attacker("Lolo",8);
    private static Defender defender1 = new Defender("Martin",5);
    private static Goalkeeper goalkeeper1 = new Goalkeeper("Pepe",1);
    private static JTextArea allPlayers = new JTextArea(10, 10);
    private JScrollPane sp = new JScrollPane(allPlayers, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    private static JRadioButton ord0 = new JRadioButton("Ordered by number");
    private static JRadioButton ord1 = new JRadioButton("Ordered by goals");
    private ButtonGroup bg2 = new ButtonGroup();


    private JButton addPlayer = new JButton("Add player");
    private JButton newGoal = new JButton("New Goal");

    private JButton newPass = new JButton("New Pass");
    private JButton newRecuperation = new JButton("New Recuperation");
    private JButton newStop= new JButton("New Stop");
    private JButton showData = new JButton("Show Data");

    public static JTextArea getAllPlayers() {
        return allPlayers;
    }


    public static JRadioButton getOrd0() {
        return ord0;
    }



    public MainWindow() {

        ord0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cu.setOrder(0);
                allPlayers.setText("");
                String result = "";
                for (Player i : cu.getList()) {
                    result += i.getNumber() + " " + i.getName() + "\n\n";
                }
                allPlayers.setText(result);

            }
        });

        ord1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cu.setOrder(1);
                allPlayers.setText("");
                String result = "";
                for (Player i : cu.getList()) {
                    result += i.situation() + ": " + i.getGoals() + "\n\n";
                }
                allPlayers.setText(result);
            }
        });



        JPanel aux4 = new JPanel();
        aux4.add(sp, BorderLayout.CENTER);

        JPanel aux3 = new JPanel();
        aux3.setLayout(new FlowLayout());
        aux3.add(ord0);
        aux3.add(ord1);
        bg2.add(ord0);
        bg2.add(ord1);


        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3,1));

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());

        p3.add(addPlayer);
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPlayerGUI(new JFrame());

            }
        });


        p3.add(newGoal);
        newGoal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGoalGUI(new JFrame());
            }
        });


        p3.add(newPass);
        newGoal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPassGUI(new JFrame());
            }
        });



        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        p4.add(newRecuperation);

        newRecuperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewRecuperationGUI(new JFrame());
            }
        });


        p4.add(newStop);
        newStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewStopGUI(new JFrame());
            }
        });


        p4.add(showData);
        showData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDataGUI(new JFrame());
            }
        });

        p2.add(new JPanel());
        p2.add(p3, BorderLayout.CENTER);
        p2.add(p4, BorderLayout.CENTER);


        setLayout(new GridLayout(2,1));
        JPanel aux5 = new JPanel();
        aux5.add(aux4, BorderLayout.NORTH);
        aux5.add(aux3, BorderLayout.CENTER);

        add(aux5);
        add(p2);

        initAll();

    }

    private void initAll() {
        setTitle("Football Players Stadistics");
        setVisible(true);
        setSize(450, 520);
        setResizable(false);
        setLocationRelativeTo(null);

        cu.addPlayer(attacker1);
        cu.addPlayer(defender1);
        cu.addPlayer(goalkeeper1);
        allPlayers.setEditable(false);

        ord0.setSelected(true);
        cu.setOrder(0);
        String result = "";
        for (Player i : cu.getList()) {
            result += i.situation() + "\n\n";
        }
        allPlayers.setText(result);
    }

    public static CU getCU(){
        return cu;
    }
    public static void main(String[] args) {
        new MainWindow();
    }
}