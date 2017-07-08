import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlayerGUI extends JDialog {
    private JTextField name = new JTextField(10);
    private JTextField number = new JTextField(3);

    private JRadioButton a = new JRadioButton("Attacker");
    private JRadioButton d = new JRadioButton("Defender");
    private JRadioButton g = new JRadioButton("Goalkeeper");
    private ButtonGroup bg = new ButtonGroup();

    private JButton add = new JButton("Add");
    private JButton cancel = new JButton("Cancel");


    public AddPlayerGUI(JFrame f) {
        super(f, "Add a new Player");

        setLayout(new GridLayout(4,1));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,1));

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(new JLabel("Player name:"));
        p2.add(name);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(new JLabel("Player number:"));
        p3.add(number);

        JPanel paux = new JPanel();
        paux.add(p2, BorderLayout.NORTH);
        paux.add(p3, BorderLayout.CENTER);
        add(paux);


        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,1));
        JPanel aux1 = new JPanel();
        aux1.add(a, BorderLayout.CENTER);
        p1.add(aux1);

        JPanel aux2 = new JPanel();
        aux2.add(d, BorderLayout.CENTER);
        p1.add(aux2);

        JPanel aux3 = new JPanel();
        aux3.add(g, BorderLayout.CENTER);
        p1.add(aux3);

        bg.add(a);
        bg.add(d);
        bg.add(g);

        add(p1);

        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        p4.add(add);
        p4.add(cancel);

        add(new JPanel());
        add(p4);


        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a.isSelected()) {
                    if (MainWindow.getCU().addPlayer(new Attacker(name.getText(), Integer.parseInt(number.getText())))) {
                        JOptionPane.showMessageDialog(AddPlayerGUI.this, "Player added.");
                        MainWindow.getAllPlayers().setText("");
                        check();
                        f.dispose();
                    } else {
                        JOptionPane.showMessageDialog(AddPlayerGUI.this, "Player not added.");
                        f.dispose();
                    }
                } else if (d.isSelected()) {
                    if (MainWindow.getCU().addPlayer(new Defender(name.getText(), Integer.parseInt(number.getText())))) {
                        JOptionPane.showMessageDialog(AddPlayerGUI.this, "Player added.");
                        check();
                        f.dispose();
                    } else {
                        JOptionPane.showMessageDialog(AddPlayerGUI.this, "Player not added.");
                        f.dispose();
                    }
                } else {
                    if(MainWindow.getCU().addPlayer(new Goalkeeper(name.getText(), Integer.parseInt(number.getText())))) {
                        JOptionPane.showMessageDialog(AddPlayerGUI.this, "Player added.");
                        check();
                        f.dispose();
                    } else {
                        JOptionPane.showMessageDialog(AddPlayerGUI.this, "Player not added.");
                        f.dispose();
                    }
                }
            }
        });


        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                number.setText("");
            }
        });

        setVisible(true);
        setSize(300, 340);
        setLocationRelativeTo(f);
        setResizable(false);
    }

    private void check(){
        MainWindow.getAllPlayers().setText("");
        if (MainWindow.getOrd0().isSelected()) {
            MainWindow.getCU().setOrder(0);
            String result = "";
            for (Player i : MainWindow.getCU().getList()) {
                result += i.situation() + "\n\n";
            }
            MainWindow.getAllPlayers().setText(result);
        } else {

            MainWindow.getCU().setOrder(1);
            MainWindow.getAllPlayers().setText("");
            String result = "";
            for (Player i : MainWindow.getCU().getList()) {
                result += i.situation() + ": " + i.getGoals() + "\n\n";
            }
            MainWindow.getAllPlayers().setText(result);

        }
    }

}