package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import DB.DBConnection;
import DB.DBInstruction;

public class MemberShipFrame extends JFrame {

	private JTextField membership_id;
	private JPasswordField membership_pw;
	private JButton membership_btn;

	public MemberShipFrame() {
		setTitle("회원가입");
		setSize(300, 180);
		setResizable(false);
		setLocation(600, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		placeMemberShipPanel(panel);

		add(panel);
		setVisible(true);
	}

	public void placeMemberShipPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("아이디");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JLabel passLabel = new JLabel("비밀번호");
		passLabel.setBounds(10, 40, 80, 25);
		panel.add(passLabel);

		membership_id = new JTextField(20);
		membership_id.setBounds(100, 10, 160, 25);
		panel.add(membership_id);

		membership_pw = new JPasswordField(20);
		membership_pw.setBounds(100, 40, 160, 25);
		panel.add(membership_pw);

		membership_btn = new JButton("회원 등록");
		membership_btn.setBounds(10, 80, 280, 25);
		panel.add(membership_btn);
		membership_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				addMember();
			}
		});

	}

	private void addMember() {
		ResultSet rs = DBInstruction
				.getResultSet("Select * from USER_TABLE where ID = '" + membership_id.getText() + "'");
		try {
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "이미 등록된 회원입니다.");
			} else {
				DBInstruction.execute("insert into USER_TABLE values ('" + membership_id.getText().toString() + "', '"
						+ membership_pw.getText().toString() + "' )");
				JOptionPane.showMessageDialog(null, "회원가입 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispose();
	}

}
