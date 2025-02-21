package bai3thu2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField txtA, txtB, txtResult;
    private JRadioButton rbtnAdd, rbtnSub, rbtnMul, rbtnDiv;
    private JButton btnSolve, btnClear, btnExit;
    
    public SimpleCalculator() {
        setTitle("Cộng - Trừ - Nhân - Chia");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Tiêu đề
        JLabel lblTitle = new JLabel("Cộng Trừ Nhân Chia", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setBounds(100, 10, 250, 30);
        add(lblTitle);

        // Bảng chọn tác vụ
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(3, 1, 10, 10));
        btnSolve = new JButton("Giải");
        btnClear = new JButton("Xóa");
        btnExit = new JButton("Thoát");
        panelLeft.add(btnSolve);
        panelLeft.add(btnClear);
        panelLeft.add(btnExit);
        panelLeft.setBounds(10, 50, 100, 150);
        add(panelLeft);

        // Panel nhập liệu
        JLabel lblA = new JLabel("Nhập a:");
        txtA = new JTextField();
        JLabel lblB = new JLabel("Nhập b:");
        txtB = new JTextField();
        JLabel lblResult = new JLabel("Kết quả:");
        txtResult = new JTextField();
        txtResult.setEditable(false);
        
        lblA.setBounds(130, 50, 100, 25);
        txtA.setBounds(200, 50, 200, 25);
        lblB.setBounds(130, 80, 100, 25);
        txtB.setBounds(200, 80, 200, 25);
        lblResult.setBounds(130, 200, 100, 25);
        txtResult.setBounds(200, 200, 200, 25);

        add(lblA); add(txtA);
        add(lblB); add(txtB);
        add(lblResult); add(txtResult);

        // Chọn phép toán
        JPanel panelOperations = new JPanel();
        panelOperations.setBorder(BorderFactory.createTitledBorder("Phép toán"));
        panelOperations.setBounds(130, 110, 270, 80);
        rbtnAdd = new JRadioButton("Cộng", true);
        rbtnSub = new JRadioButton("Trừ");
        rbtnMul = new JRadioButton("Nhân");
        rbtnDiv = new JRadioButton("Chia");
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnAdd);
        group.add(rbtnSub);
        group.add(rbtnMul);
        group.add(rbtnDiv);
        panelOperations.add(rbtnAdd);
        panelOperations.add(rbtnSub);
        panelOperations.add(rbtnMul);
        panelOperations.add(rbtnDiv);
        add(panelOperations);

        // Xử lý sự kiện
        btnSolve.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSolve) {
            try {
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());
                double result = 0;
                if (rbtnAdd.isSelected()) result = a + b;
                else if (rbtnSub.isSelected()) result = a - b;
                else if (rbtnMul.isSelected()) result = a * b;
                else if (rbtnDiv.isSelected()) {
                    if (b == 0) throw new ArithmeticException("Không thể chia cho 0");
                    result = a / b;
                }
                txtResult.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnClear) {
            txtA.setText("");
            txtB.setText("");
            txtResult.setText("");
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator().setVisible(true);
    }
}
