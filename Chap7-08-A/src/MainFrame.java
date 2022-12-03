import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
class RegistDialog extends JDialog {	
	public RegistDialog(JFrame frame, HashMap<String, Integer> map) {
		super(frame, "Regist", true);
		
		setSize(200, 200);
		setLocationRelativeTo(frame);
		setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("Name");
		JLabel l2 = new JLabel("Point");
		JTextField name = new JTextField(15);
		JTextField point = new JTextField(15);
		JButton btn = new JButton("Regist");
		
		add(l1); add(name);
		add(l2); add(point);
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(map.containsKey(name.getText())) { // ������ ��ϵ� �ο��� ���
					int tmp = map.get(name.getText()) + Integer.parseInt(point.getText());
					map.put(name.getText(), tmp);
				}
				else {
					map.put(name.getText(), Integer.parseInt(point.getText())); // �ؽøʿ� ����
				}
				
				setVisible(false);
			}
		});
	}
}

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JTextArea ta = new JTextArea();
	private JButton btn = new JButton("Regist");
	private HashMap<String, Integer> map = new HashMap<>(); // �ؽø� ����
	private RegistDialog dialog = new RegistDialog(this, map);
	
	public MainFrame() {
		setTitle("Chap7-08");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(btn, BorderLayout.NORTH);
		c.add(new JScrollPane(ta), BorderLayout.CENTER);
		
		ta.setEditable(false);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
				Set<String> keySet = map.keySet();
				Iterator<String> it = keySet.iterator();
				
				ta.setText("");
				while(it.hasNext()) {
					String key = it.next();
					ta.append(key + '\t' + map.get(key) + "P\n");
				}
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
