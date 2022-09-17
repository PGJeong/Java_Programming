import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class NorthPanel extends JPanel {
	NorthPanel() {
		setBackground(Color.lightGray);
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(new JLabel("수식입력"));
		add(new JTextField(15));
	}
}

@SuppressWarnings("serial")
class CenterPanel extends JPanel {
	CenterPanel() {
		setBackground(Color.white);
		setLayout(new GridLayout(4, 4, 5, 5));
		
		for(int i = 0; i < 10; i++) {
			add(new JButton(Integer.toString(i)));
		}
		
		add(new JButton("CE"));
		add(new JButton("계산"));
		
		JButton add = new JButton("+"); add.setBackground(Color.cyan); add(add);
		JButton sub = new JButton("-"); sub.setBackground(Color.cyan); add(sub);
		JButton mul = new JButton("x"); mul.setBackground(Color.cyan); add(mul);
		JButton div = new JButton("/"); div.setBackground(Color.cyan); add(div);
	}
}

@SuppressWarnings("serial")
class SouthPanel extends JPanel {
	SouthPanel() {
		setBackground(Color.YELLOW);
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.CENTER)); // JPanel이 디폴트로 FlowLayout이지만, 확실히 하기 위해
		
		add(new JLabel("계산 결과"));
		add(new JTextField(15));
	}
}

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("계산기 프레임");
		setSize(300, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}