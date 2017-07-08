import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowDataGUI extends JDialog {
    private JTextField number = new JTextField(3);
    private JTextArea text = new JTextArea(10, 20);
    private JButton search = new JButton("Search player");
    private JScrollPane sp = new JScrollPane(text, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    public ShowDataGUI(JFrame f){
        super(f, "Players Data");

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(number);
        p.add(search);

        setLayout(new GridLayout(3,1));
        add(p);
        JPanel p1 = new JPanel();
        p1.add(sp);
        text.setEditable(false);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!number.getText().equals("") && MainWindow.getCU().search(Integer.parseInt(number.getText()))) {
                    text.setText(MainWindow.getCU().showData(Integer.parseInt(number.getText())));
                } else {
                    JOptionPane.showMessageDialog(ShowDataGUI.this, "Player not found.");
                }
            }
        });

        add(p1);
        setVisible(true);
        setSize(350, 300);
        setLocationRelativeTo(f);
        setResizable(false);

    }
}