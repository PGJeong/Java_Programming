import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*; // FileNameExtensionFilter Ŭ���� ����� ���� import

@SuppressWarnings("serial")
public class MainFrame extends JFrame {	
	private String imgPath;
	
	class MyPanel extends JPanel { // ����Ŭ����. �̹����� ����� Panel
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // JPanel�� ������ paintComponent() ȣ��. �׷��� ������ ��� ����� ������ �������� ĥ�ϱ�
			
			if(imgPath != null) {
				Image img = new ImageIcon(imgPath).getImage();
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this); // �̹����� �г��� ũ�⿡ �� ������ �׸���
			}
		}
	}
	
	public MainFrame() {
		setTitle("Chap14-02");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MyPanel panel = new MyPanel();
		setContentPane(panel);
		
		JMenuBar mb = new JMenuBar(); // (�޴� �����) 1. �޴��� �����
		
		JMenu menu = new JMenu("File"); // 2. �޴� �����, �޴��ٿ� ���̱�
		mb.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Open"); // 3. �޴��������� �����, �޴��� ���̱�
		menu.add(menuItem);
		
		setJMenuBar(mb); // 4. �޴��ٸ� �����ӿ� ���̱�
		
		menuItem.addActionListener(new ActionListener() { // �޴� ������ Ŭ�� �� Action �̺�Ʈ �߻�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(); // (���Ͽ��� ���̾�α� �����) 1. JFileChooser ����
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg"); // 2. ���� ���� ����. JPG Ȯ���ڸ� ���͸�
				chooser.setFileFilter(filter); // 3. JFileChooser�� ���� ���� ����
				
				int ret = chooser.showOpenDialog(null); // 4. ���� ���� ���̾�α� ���
				
				if(ret == JFileChooser.APPROVE_OPTION) { // ���� ��ư�� ���� ���
					imgPath = chooser.getSelectedFile().getPath(); // 5. ����ڰ� ������ ���� ��� �˾Ƴ���
					panel.getParent().repaint(); // JFrame�� Content Pane�� panel �ٽ� �׸���
				}
				else {
					imgPath = null;
				}
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
