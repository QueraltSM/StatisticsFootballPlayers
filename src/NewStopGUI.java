import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewStopGUI extends JDialog {
    private JTextField number = new JTextField(3);
    private JButton add = new JButton("Add");
    private JButton cancel = new JButton("Cancel");

    public NewStopGUI(JFrame f) {
        super(f, "Add a new Stop");
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(new JLabel("Player number: "));
        p.add(number);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(add);
        p1.add(cancel);

        setLayout(new GridLayout(4,1));
        add(p);
        add(p1);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.getCU().newStop(Integer.parseInt(number.getText()));
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        setVisible(true);
        setSize(300, 200);
        setLocationRelativeTo(f);
        setResizable(false);

    }

}