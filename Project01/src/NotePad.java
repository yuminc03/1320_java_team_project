import java.awt.Event;
//AWT ���� ��ҿ� ���� �߻� �� �پ��� ������ �̺�Ʈ�� ó���ϱ����� �������̽� �� Ŭ������ ����
import java.awt.Image;
//�̹����� ����� �����ϱ����� Ŭ������ ������.
import java.awt.Toolkit;
//�� Ŭ������ Abstract Window Toolkit�� ��� ���� ������ �߻� ���� Ŭ�����̴�. Ŭ������ ���� ToolkitŬ������ �پ��� ������Ʈ�� Ư�� ���� ��Ŷ ������ ���ε��ϴ� �� �����.
import java.awt.event.*;
import java.io.*;
// java.io ��Ű���� ���� �� ��� Ŭ������ ���Ϸ� �����´�. �̸� ���� Java ���α׷��� �ش� Ŭ������ �ش� �޼ҵ带 ����Ͽ� �Ϻ� �½�ũ�� ���� �� �� �ִ�.
import javax.swing.*;
//������ �� ��� �÷������� �����ϰ� �۵��ϴ� "�淮"(��� Java ���) ���� ��� ��Ʈ�� ����

public class NotePad extends JFrame implements ActionListener {
	// ��� ���� ����
	JTextArea ta; // ������ �� �ִ� ���� �� �Է¶�
	JMenuBar menubar; // �޴���
	// menuBar : �������� �޴��� �����ϴ� ���ҷ� ������ ������ �����׸�
	// JMenu, JmenuItem ���� �̿��ؼ� �޴��� �����Ͽ� setJMenuBar()�޼ҵ带 �̿��ؼ� ��� �� �� �ִ�.
	JMenu fileMenu, editMenu; // ���� �޴�, ���� �޴�
	JMenuItem newItem, openItem, saveItem, exitItem;// �޴�������
	JMenuItem copyItem, cutItem, pasteItem, allItem, dateItem;

	// ������ ����
	public NotePad() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X Ŭ�� => ����
		setTitle("==�޸���==");// ����
		ta = new JTextArea();// ta ����
		JScrollPane scroll = new JScrollPane(ta);// ��ũ�ѿ� ta �� �ִ´�.
		add(scroll);// ��ũ���� �������� �߾ӿ� ���δ�.
		// getContentPane().add(scroll); // JDK 1.4�� ����� �ڵ�
		menubar = new JMenuBar();// �޴��� ����
		setJMenuBar(menubar);// �޴��ٸ� ���δ�.
		fileMenu = new JMenu("����(F)");

		Toolkit toolkit = Toolkit.getDefaultToolkit();// ������ �ֱ�
		Image img = toolkit.getImage("pig.png");
		setIconImage(img);

		fileMenu.setMnemonic('F');// Alt + F
		menubar.add(fileMenu);// �޴��ٿ� ���� �޴� ���̱�
		newItem = new JMenuItem("���� �����");// newItem�� ���θ���� ���
		openItem = new JMenuItem("����");// openItem�� ���� ���
		saveItem = new JMenuItem("����");// saveItem�� ���� ���
		exitItem = new JMenuItem("������");// exitItem�� ������ ���

		newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));// Ctrl + N ����Ű ������

		openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));// Ctrl + O

		saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));// Ctrl + S

		fileMenu.add(newItem);// filMenu�� newItem�� ����(JMenu�� JMenuItem����)
		fileMenu.add(openItem);// filMenu�� openItem�� ����
		fileMenu.add(saveItem);// filMenu�� saveItem ����
		fileMenu.add(exitItem);// filMenu�� exitItem�� ����
		newItem.addActionListener(this); // ������ ���̱�, newItem�� ActionListener(��ư��� �߰�)����ϱ�
		// �͸�(=����)Ŭ����(Anonymous Class)
		// ���� Ŭ������ �������� �ʰ� �ϳ��� Ŭ���������� �������̽��� �������� ������
		// �� �������̽��� �´� �޼ҵ带 �������̵� ���ִ� ���
		openItem.addActionListener(this);// openItem�� ActionListener(��ư��� �߰�)����ϱ�
		saveItem.addActionListener(this);// saveItem�� ActionListener(��ư��� �߰�)����ϱ�
		exitItem.addActionListener(this);// exitItem�� ActionListener(��ư��� �߰�)����ϱ�
		editMenu = new JMenu("����(E)");// ���� �޴� ����

		editMenu.setMnemonic('E');// �޴��� �ٷ� ���� Ű�� �߰���
		menubar.add(editMenu);// �޴��ٿ� ���� �޴� ���̱�
		copyItem = new JMenuItem("����");// copyItem�� ���� ���
		cutItem = new JMenuItem("�߶󳻱�");// cutItem�� �߶󳻱� ���
		pasteItem = new JMenuItem("�ٿ��ֱ�");// pasteItem�� �ٿ��ֱ� ���
		allItem = new JMenuItem("��� ����");// allItem�� ��� ���� ���
		dateItem = new JMenuItem("��¥/�ð�");// dateItem�� ��¥/�ð� ��Ÿ���� ���

		copyItem.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK));// Ctrl + C, ����Ű ������
		pasteItem.setAccelerator(KeyStroke.getKeyStroke('V', Event.CTRL_MASK));// Ctrl + V
		allItem.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK));// Ctrl + A
		dateItem.setAccelerator(KeyStroke.getKeyStroke("F5"));

		editMenu.add(copyItem);// editMenu�� copyItem�� ����
		editMenu.add(pasteItem);// editMenu�� pasteItem�� ����
		editMenu.add(allItem);// editMenu�� allItem�� ����
		editMenu.add(dateItem);// editMenu�� dateItem�� ����
		copyItem.addActionListener(this); // ������ ���̱�

		pasteItem.addActionListener(this);// pasteItem�� ActionListener(��ư��� �߰�)����ϱ�
		allItem.addActionListener(this);// allItem�� ActionListener(��ư��� �߰�)����ϱ�
		dateItem.addActionListener(this);// dateItem�� ActionListener(��ư��� �߰�)����ϱ�
		setBounds(400, 400, 400, 300);// ũ�� ����(x ��ǥ, y ��ǥ, ����, ����)
		setVisible(true);// ���̱�
	}// ������

	// �̺�Ʈ ó��
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// getSource() = �޼ҵ带 ����ؼ� �̺�Ʈ�����ʸ� ����� ���𰡸� ������ ��
		// �� �̺�Ʈ�� ����Ǵ� Ư�� �����̳��� ��� �Ӽ��� ������ �� �ִ�.
		if (obj == exitItem) {
			// System.exit(0); // ���α׷� ����
		}
		if (obj == openItem) {
			openFile(); // ���� ���� �޼ҵ� ȣ��
		} // if
		if (obj == saveItem) {
			saveFile(); // ���� ���� �޼ҵ� ȣ��
		} // if
		if (obj == copyItem) { // �����ϱ� ���ý�
			ta.copy();
			copyItem.setEnabled(false);
			cutItem.setEnabled(false);
			// setEnabled : ��Ʈ���� Ȱ��ȭ �Ǵ� ��Ȱ��ȭ�Ѵ�, �� ����� Open Agent�� ����ϴ� ��쿡�� ������
		} // if
		if (obj == cutItem) {
			ta.cut();
			copyItem.setEnabled(false);
			cutItem.setEnabled(false);
		} // if

		if (obj == allItem) {
			ta.selectAll(); // ��� ����
		} // if
		if (obj == dateItem) {
			java.util.Date date = new java.util.Date();
			ta.append(date.toLocaleString());// ������ ��¥/�ð� �߰�
		} // if
	}// actionPerformed

	private void openFile() { // ���� ����
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(this);// ���� ��ȭ����
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			// JFileChooser :�������� ���Ͽ���, ����� ������ ������ Dialog �� ����Ҽ� �ִ�.
			// "����"��ư�̳� "����"��ư�� Ŭ���ϰԵǸ� APPROVE_OPTION�� ��ȯ

			System.out.println(file.getName() + "���õ�");
			// �� �κ��� I/O ���� �� ����^^
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
				// BufferedReader / BufferedWriter�� ���� �Է� ��Ʈ�����κ��� ���ڸ� �о� ���̰ų�
				// ���� ��� ��Ʈ������ ���ڸ� ������ �� ���۸��� �����ν� ����, ���� �迭, ���ڿ� ����
				// ���� ���� ȿ�������� ó���� �� �ֵ��� ���ش�.

				String text = "";
				while ((text = br.readLine()) != null) {
					ta.append(text + "\r\n");// �ٹٲ�( Win : \r\n, Unix : \n )
					// append : ���ڿ��� ����
				} // while
				br.close();
			} catch (Exception e) {// ������ ����� ���
				e.printStackTrace();// ���� �޽��� �ڼ��� ���
			} // catch
		} // if
	}// openFile

	private void saveFile() { // ���� ����
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(this);// ���� ��ȭ����
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// JFileChooser :�������� ���Ͽ���, ����� ������ ������ Dialog �� ����Ҽ� �ִ�.
			File file = chooser.getSelectedFile();
			System.out.println(file.getName() + "���õ�");// file�� �̸��� "���õ�"���� ����
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(file));
				bw.write(ta.getText());// ta ���� �о ���Ͽ� ����
				bw.flush();// ��� ����
				// bw.close();// �ݱ�
			} catch (Exception e) {
				e.printStackTrace();// ���� �޽��� �ڼ��� ���
			} // catch
		} // if
	}// saveFile

	public static void main(String[] args) {
		new NotePad();
	}// main
}// end