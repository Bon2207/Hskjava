package BaiTap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class GiaiPTB2 extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JLabel lblNhapA;
    private JTextField txtA;
    private JLabel lblNhapB;
    private JTextField txtB;
    private JLabel lblNhapC;
    private JTextField txtC;
    private JLabel lblKq;
    private JTextField txtKq;
    private JButton btnGiai;
    private JButton btnXoa;
    private JButton btnThoat;

    public GiaiPTB2() {
        JPanel pNorth = new JPanel();
        pNorth.add(lblTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 2"));
        Font fp = new Font("Times new Roman", Font.BOLD, 30);
        lblTitle.setFont(fp);
        pNorth.setBackground(Color.BLUE);
        add(pNorth, BorderLayout.NORTH);

        JPanel pCen = new JPanel();
        pCen.add(lblNhapA = new JLabel("Nhập A:"));
        pCen.add(txtA = new JTextField(30));
        pCen.add(lblNhapB = new JLabel("Nhập B:"));
        pCen.add(txtB = new JTextField(30));
        pCen.add(lblNhapC = new JLabel("Nhập C:"));
        pCen.add(txtC = new JTextField(30));
        pCen.add(lblKq = new JLabel("Kết quả:"));
        pCen.add(txtKq = new JTextField(30));
        add(pCen, BorderLayout.CENTER);

        JPanel pSouth = new JPanel();
        pSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
        pSouth.add(btnGiai = new JButton("Giải"));
        pSouth.add(btnXoa = new JButton("Xóa rỗng"));
        pSouth.add(btnThoat = new JButton("Thoát"));
        add(pSouth, BorderLayout.SOUTH);

        btnGiai.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int a, b, c, delta;
        double kq, x1, x2;
        DecimalFormat fmt = new DecimalFormat("0.#");
        Object source = e.getSource();

        if (source.equals(btnGiai)) {
            try {
                a = Integer.parseInt(txtA.getText());
                b = Integer.parseInt(txtB.getText());
                c = Integer.parseInt(txtC.getText());

                if (a == 0) {
                    if (b == 0) {
                        if (c == 0) {
                            txtKq.setText("Phương trình vô số nghiệm");
                        } else {
                            txtKq.setText("Phương trình vô nghiệm");
                        }
                    } else {
                        kq = -1.0 * c / b;
                        txtKq.setText(fmt.format(kq));
                    }
                } else {
                    delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        txtKq.setText("Phương trình vô nghiệm");
                    } else if (delta == 0) {
                        kq = -1.0 * b / (2 * a);
                        txtKq.setText(fmt.format(kq));
                    } else {
                        x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        txtKq.setText("x1 = " + fmt.format(x1) + "; x2 = " + fmt.format(x2));
                    }
                }
            } catch (NumberFormatException ex) {
                txtKq.setText("Lỗi nhập liệu!");
            }
        } else if (source.equals(btnXoa)) {
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            txtKq.setText("");
        } else if (source.equals(btnThoat)) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new GiaiPTB2();
    }
}
