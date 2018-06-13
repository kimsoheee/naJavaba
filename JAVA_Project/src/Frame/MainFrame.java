package Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{


	public MainFrame() {
        setTitle("메인화면");
        setSize(1000, 700);
        setResizable(false);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
       
        add(panel);
        setVisible(true);
	}
}
