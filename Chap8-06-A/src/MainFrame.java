import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.io.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JTextArea ta = new JTextArea();
	private File file1;
	private File file2;
	private File dest = new File("appended.txt");
	
	public MainFrame() {
		setTitle("Chap8-06");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.add(new JScrollPane(ta));
		ta.setEditable(false);
		
		JFileChooser chooser = new JFileChooser(); // JFileChooser ��ü ����
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt"); // ���� ���� ����
		chooser.setFileFilter(filter); // ���� ���� ����
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // ���ϸ� ���� �����ϵ��� ����
		int ret;
		
		ret = chooser.showOpenDialog(null); // ���� ���� ���̾�α� ��� - ù ��° ���� ����
		if(ret == JFileChooser.APPROVE_OPTION) {
			file1 = chooser.getSelectedFile(); // ���õ� ���� ����
			ta.append("1��° ���� ��� : " + file1.getPath() + '\n');
		}
		else {
			JOptionPane.showMessageDialog(null, "����! �ݵ�� ������ �����ؾ� �մϴ�", "����", JOptionPane.ERROR_MESSAGE);
			System.exit(0); // ������ �������� ���� ��� ��������
		}
		
		ret = chooser.showOpenDialog(null); // ���� ���� ���̾�α� ��� - �� ��° ���� ����
		if(ret == JFileChooser.APPROVE_OPTION) {
			file2 = chooser.getSelectedFile(); // ���õ� ���� ����
			ta.append("2��° ���� ��� : " + file2.getPath() + '\n');
		}
		else {
			JOptionPane.showMessageDialog(null, "����! �ݵ�� ������ �����ؾ� �մϴ�", "����", JOptionPane.ERROR_MESSAGE);
			System.exit(0); // ������ �������� ���� ��� ��������
		}
		
		
		try {
			FileReader fin1 = new FileReader(file1); // ���� �Է� ��Ʈ��(���� ��Ʈ��) ����
			FileReader fin2 = new FileReader(file2); // ���� �Է� ��Ʈ��(���� ��Ʈ��) ����
			FileWriter fout = new FileWriter(dest, true); // ���� ��� ��Ʈ��(���� ��Ʈ��) ����, �Ű����� append�� true�� ����
			
			char buf[] = new char[1024]; // 1KB ���� ����
			
			while(true) {
				int n = fin1.read(buf); // ���ڸ� �о� buf �迭�� �����ϰ� ���� ���� ����
				fout.write(buf, 0, n); // buf[0]���� n�� ����
				
				if(n < buf.length)
					break; // ���� ũ�⺸�� �۰� ���� ��� = ������ ��(EOF)�� ����
			}
			
			while(true) {
				int n = fin2.read(buf);
				fout.write(buf, 0, n);
				
				if(n < buf.length)
					break;
			}
			
			ta.append(dest.getPath() + "�� �����Ͽ����ϴ�\n");
			
			fin1.close(); // �Է� ��Ʈ�� �ݱ�, ���� �ý��� �ڿ� ����
			fin2.close();
			fout.close(); // ��� ��Ʈ�� �ݱ�, ���� �ý��� �ڿ� ����
		}
		catch(FileNotFoundException e) {
			ta.append("FileNotFoundException\n");
			System.exit(0);
		}
		catch(IOException e) {
			ta.append("IOException\n");
			System.exit(0);
		}
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
