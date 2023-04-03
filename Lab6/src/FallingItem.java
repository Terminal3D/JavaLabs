import javax.swing.*;

public class FallingItem {
    private JPanel panel1;
    private JPanel MainPanel;
    private JTextField textField1;
    private JButton submitButton;
    private JTextField textField2;
    private JTextField textField3;


    FallingItem() {
        submitButton.addActionListener(e -> {
                    if (!textField1.getText().isEmpty() && !textField2.getText().isEmpty() && !textField3.getText().isEmpty()) {

                        new FallingItemFrame(
                                Double.parseDouble(textField1.getText()),
                                Double.parseDouble(textField2.getText()),
                                Double.parseDouble(textField3.getText()));
                    } else {
                        JOptionPane.showMessageDialog(null, "One of the fields is empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

        );
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FallingItem");
        frame.setContentPane(new FallingItem().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
