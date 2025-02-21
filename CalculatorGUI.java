package bai3hskjv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    private JTextField txtA, txtB, txtResult;
    private JRadioButton rdoAdd, rdoSub, rdoMul, rdoDiv;
    private JButton btnSolve, btnClear, btnExit;

    public CalculatorGUI() {
        setTitle("Cộng - Trừ - Nhân - Chia");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel tiêu đề
        JPanel pnlTitle = new JPanel();
        JLabel lblTitle = new JLabel("Cộng Trừ Nhân Chia");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(Color.BLUE);
        pnlTitle.add(lblTitle);
        add(pnlTitle, BorderLayout.NORTH);

        // Panel chức năng bên trái
        JPanel pnlLeft = new JPanel();
        pnlLeft.setLayout(new GridLayout(3, 1, 5, 5));
        btnSolve = new JButton("Giải");
        btnClear = new JButton("Xóa");
        btnExit = new JButton("Thoát");
        pnlLeft.add(btnSolve);
        pnlLeft.add(btnClear);
        pnlLeft.add(btnExit);
        add(pnlLeft, BorderLayout.WEST);

        // Panel chính chứa các thành phần nhập liệu và kết quả
        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new GridLayout(5, 2, 5, 5));

        pnlMain.add(new JLabel("Nhập a:"));
        txtA = new JTextField();
        pnlMain.add(txtA);

        pnlMain.add(new JLabel("Nhập b:"));
        txtB = new JTextField();
        pnlMain.add(txtB);

        pnlMain.add(new JLabel("Phép toán:"));
        JPanel pnlOperators = new JPanel();
        ButtonGroup group = new ButtonGroup();
        rdoAdd = new JRadioButton("Cộng", true);
        rdoSub = new JRadioButton("Trừ");
        rdoMul = new JRadioButton("Nhân");
        rdoDiv = new JRadioButton("Chia");
        group.add(rdoAdd);
        group.add(rdoSub);
        group.add(rdoMul);
        group.add(rdoDiv);
        pnlOperators.add(rdoAdd);
        pnlOperators.add(rdoSub);
        pnlOperators.add(rdoMul);
        pnlOperators.add(rdoDiv);
        pnlMain.add(pnlOperators);

        pnlMain.add(new JLabel("Kết quả:"));
        txtResult = new JTextField();
        txtResult.setEditable(false);
        pnlMain.add(txtResult);

        add(pnlMain, BorderLayout.CENTER);

        // Panel màu sắc phía dưới
        JPanel pnlColor = new JPanel();
        pnlColor.setLayout(new FlowLayout());
        pnlColor.setBackground(Color.PINK);
        pnlColor.add(new JLabel(" "));
        add(pnlColor, BorderLayout.SOUTH);

        // Sự kiện cho nút Giải
        btnSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        // Sự kiện cho nút Xóa
       
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        // Sự kiện cho nút Thoát
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void calculate() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double result = 0;

            if (rdoAdd.isSelected()) {
                result = a + b;
            } else if (rdoSub.isSelected()) {
                result = a - b;
            } else if (rdoMul.isSelected()) {
                result = a * b;
            } else if (rdoDiv.isSelected()) {
                if (b == 0) {
                    txtResult.setText("Lỗi chia 0!");
                    return;
                }
                result = a / b;
            }

            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            txtResult.setText("Lỗi nhập liệu!");
        }
    }

    private void clearFields() {
        txtA.setText("");
        txtB.setText("");
        txtResult.setText("");
        rdoAdd.setSelected(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorGUI().setVisible(true);
        });
    }
}