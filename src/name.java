import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class name {
    private JButton Button;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable table1;
    private JPanel frame;

    private void createTable() {
        table1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "X", "Y", "S"
                }
        ));
    }

    public name() {
        createTable();
        textField1.setText("-3");
        textField2.setText("-0.6");
        textField3.setText("0.2");
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double Xn = Double.parseDouble(textField1.getText());
                double Xk = Double.parseDouble(textField2.getText());
                double dX = Double.parseDouble(textField3.getText());
                int i = 0;
                for (double x = Xn; x <= Xk; x += dX) {
                    double s = 0;
                    int n = 0;
                    double T = -Math.pow((1 + x), 2);
                    while (Math.abs(T) >= Math.pow(10, -3)) {
                        s += T;
                        T *= -((n * Math.pow(x, 2) + 2 * n * x + n) / (n + 1));
                        n++;
                    }
                    double a = Math.log(1 / (2 + 2 * x + x * x));
                    table1.setValueAt(String.valueOf(x), i, 0);
                    table1.setValueAt(String.valueOf(s), i, 1);
                    table1.setValueAt(String.valueOf(a), i, 2);
                    i++;
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Вычисление рядов");
        frame.setContentPane(new name().frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //размер окна минимальный
        frame.setMinimumSize(new Dimension(600, 400));
        // открытие окна в центре
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.pack();
        frame.setVisible(true);
    }
}