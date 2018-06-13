package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import DB.DBConnection;
import DB.DBInstruction;

public class LoginFrame extends JFrame {

	private JTextField login_id;
	private JPasswordField login_pw;
	private JButton membership_btn, login_btn;

	public LoginFrame() {
		setTitle("로그인");
		setSize(280, 150);
		setResizable(false);
		setLocation(600, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		placeLoginPanel(panel);

		add(panel);
		setVisible(true);
	}

	public void placeLoginPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("아이디");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JLabel passLabel = new JLabel("비밀번호");
		passLabel.setBounds(10, 40, 80, 25);
		panel.add(passLabel);

		login_id = new JTextField(20);
		login_id.setBounds(100, 10, 160, 25);
		panel.add(login_id);

		login_pw = new JPasswordField(20);
		login_pw.setBounds(100, 40, 160, 25);
		panel.add(login_pw);

		membership_btn = new JButton("회원가입");
		membership_btn.setBounds(40, 80, 100, 25);
		panel.add(membership_btn);
		membership_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberShipFrame();
			}
		});

		login_btn = new JButton("로그인");
		login_btn.setBounds(160, 80, 100, 25);
		panel.add(login_btn);
		login_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});

	}

	public void isLoginCheck() {
		ResultSet rs = DBInstruction
				.getResultSet("select * from USER_TABLE where ID = '" + login_id.getText().toString() + "'");
		try {

			if (rs.next()) {
				if (rs.getString("pw").equals(login_pw.getText().toString())) {
					new MainFrame();
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "비밀번호를 확인해주세요.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "회원가입 후 이용해주세요.");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "로그인 에러.");
			dispose();
		}
	}

}
