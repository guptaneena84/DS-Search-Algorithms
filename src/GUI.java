import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JCheckBox linearSearchCheckBox;
    private JCheckBox binarySearchCheck;
    private JCheckBox binarySearchTreeCheckBox;
    private JCheckBox redBlackTreeCheckBox;
    private JTextField dataSizeValue;
    private JButton buttonTest;
    private JPanel panelMain;
    private JLabel labelInputSize;
    private JTextArea textAreaMsg1;
    private JTextArea textAreaMsg2;

    public GUI() {
        buttonTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(linearSearchCheckBox.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "Hello");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
