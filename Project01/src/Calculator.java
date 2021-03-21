import java.awt.BorderLayout;
//�����̳ʸ� North, South, East, West, Center ��� 5���� �������� ������, 
//�� ������ �ϳ��� ������Ʈ���� ��ġ�� �� �ֵ��� �Ѵ�. 
//�׷��� �� ������ ���� ���� ������Ʈ�� ��ġ�ϸ�, �������� �߰��� ������Ʈ�� ���̰� �ȴ�.
import java.awt.Color;
//Color�� ���� ǥ���ϱ� ���� ���Ǵ� Ŭ�����ν�, 
//���ϴ� ���� RGB���� �˰� ������ �� ���� ǥ���� �� �ִ� ��ü�� �����Ͽ� ����� �� �ִ�. 
import java.awt.Font;//java���� �Է��� ���ڿ� ȿ���� �� �� Ȱ���Ѵ�
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
//���ϴ� ��� ���� ������ ���̾ƿ��� 
//�ۼ��� �� ����Ѵ�. ������ �����ǰ� ���� ���̾ƿ��� ������ �� ���� ������ �����ϴ�
import java.awt.event.ActionEvent;//AWTEvent�� Ȯ��
import java.awt.event.ActionListener;//�׼� �̺�Ʈ�� �ޱ����� ������ �������̽�
import java.awt.event.InputEvent;
//ComponentEvent�� Ȯ��, ��� ������Ʈ ���� �Է� �̺�Ʈ�� ��Ʈ �̺�Ʈ Ŭ����
import javax.swing.JButton;
//JButton Ŭ������ �÷��� �������� �������ִ� ���� ������ ���߸� �ۼ��ϴ� �� ���
import javax.swing.JFrame;
//�������� �����ϱ� ���� �ʿ���
import javax.swing.JLabel;
//java Swing Ŭ����, JLabel�� ª�� ���ڿ� �Ǵ� �̹��� �������� ǥ���ϴ� �� ���
import javax.swing.JMenu;
//���� ���� JFrame�� JMenuBar�װͰ� JMenus�� ��������
//������ ���� ��Ŀ���� �����ϰ� �ͱ� JMenu������ space��ư�� ������ MenuItems�� ǥ��
import javax.swing.JMenuBar;
//�ϳ� �̻��� JMenu ��ü�� �����ϸ�, JMenu ��ü�� ���õǸ� �ϳ� �̻��� JMenuItems�� ǥ��
import javax.swing.JMenuItem;
//����ڰ� "��ư"�� �����ϸ� �޴� �׸�� ���õ� �۾��� ����
import javax.swing.JPanel;
//���� ��� �׷��� ������ ���ִ� �����̳�, JPanel�� �ֿ� �ӹ��� ������Ʈ�� �����ϴ� ��
import javax.swing.KeyStroke;
//Ű���� �Ǵ� ������ �Է� ��ġ������ Ű ������ ��Ÿ���ϴ�

@SuppressWarnings("serial") // Warnning ����
public class Calculator extends JFrame implements ActionListener {
	// JFrame�� ����ϰ�, ActionListener�� ��� �޴´�
	// Listener �������̽� - �ϳ� �Ǵ� 2�� �̻��� �̺�Ʈ ó���� ���� �޼ҵ带 ������ �������̽�
	// event = GUI ������Ʈ���� �߻��Ǵ� ��� ����
	// extends�� Ŭ������ Ȯ���ϴ� ��, implements�� �������̽��� �����ϴ� ��
	// java������ ���߻���� �������� �ʾƼ� �������̽��� ������
	JPanel jpButton, jpResult;
	// �г� �ʱ�ȭ panel = ������ �ȿ��� �� �ٸ� �������� ���� �� �ְ� �ϴ� ��
	// JPanel = ����
	JMenuBar jmb; // �޴��� �ʱ�ȭ, JMenuBar = (Menu�� �ø� Ʋ)
	// menuBar : �������� �޴��� �����ϴ� ���ҷ� ������ ������ �����׸�
	// - JMenu, JmenuItem ���� �̿��ؼ� �޴��� �����Ͽ�
	// setJMenuBar()�޼ҵ带 �̿��ؼ� ��� �� �� �ִ�.
	JMenu jmEdit, jmHelp; // �޴� �ʱ�ȭ, JMenu = ������ �� ���갡 �����ϴ� ���
	JMenuItem mCopy, mPaste, mHelp, mInfo; // �޴� ������ �ʱ�ȭ
	// JMenuItem = �ٷ� �������� ����Ǵ� ���
	JLabel jlbResult1, jlbResult2; // �� �ʱ�ȭ label = ���ڸ� ǥ���ϴ� ������ ��
	JButton[] jbButton = null; // ��ư�迭 �ʱ�ȭ
	String result = "";// StringŸ�� result����
	String result1 = "";// StringŸ�� result1����
	// ��) 3 + 5 = 8
	// result1 = 3 + , result = 3
	String result2 = "";// StringŸ�� result2����,
	String number[] = { " ", " ", " " };// �迭 number�� " "�� 3�� ����
	String[] numStr = { "��", "CE", "C", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "0", "00", ".",
			"=" }; // ��ư�� �� ��

	public Calculator() {// �޼��� Calculator
		super("==����=="); // Ÿ��Ʋ �� (������ ��� �̸�)
		getContentPane().setLayout(new BorderLayout()); // ��ü ���̾ƿ��� BorderLayout
		setLocationRelativeTo(null);// ��� ����
		// �⺻������ ������Ʈ���� Ʋ ���·� ����, BorderLayout�� ������Ʈ�� �߰��� ���� .add(������Ʈ, ��ġ)
		// ��ġ������ ���ϸ� �⺻������ center�� ��ġ��
		// getContentPane() = �������� contentPane ������Ʈ�� ������.
		// contentPane : �Ϲ����� ������Ʈ���� ���� �� �ִ� �г�
		// - ������ ��ü�� getContentPane()�޼ҵ带 �̿��ؼ� ���� �� �ִ�.

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("pig.png");
		setIconImage(img);

		/** �޴��� ���� */
		// �� �����ϴ� �ּ��� /*�Ϲ����� �ڵ� �ּ��Դϴ�. �̵��� �Ϲ������� ���� �����ϱ� ���� �ڵ� ���� ���� ���
		// /**�� �����ϴ� �ּ��� javadoc�� ����. �̵��� �޼ҵ�� Ŭ���� ���� ���
		// javadoc = Java �ҽ��� ����ȭ�� �ϴ� ���
		// ���� Ŭ������ �޼ҵ忡 �ּ����� ����� ������ javadoc ��ɾ
		// �Ǵ� �̸� �̿��� ���� ��(maven �� site phrase��)�� ����Ͽ� ����ȭ�� �� �ִ�.
		// Java ���α׷��� ����� ��� �� ��� ���� ���̰� ����, �׵��� �������� ó����

		jmb = new JMenuBar();// jmb = �޴���

		// jmEdit = new JMenu("����(E)");
		// jmHelp = new JMenu("����(H)");

		// mCopy = new JMenuItem("����");
		// mPaste = new JMenuItem("�ٿ��ֱ�");
		// mHelp = new JMenuItem("���� ����");
		// mInfo = new JMenuItem("���� ����");

		// jmEdit.add(mCopy); // jmEdit��� �޴��� mCopy��� �޴������� �߰�
		// jmEdit.add(mPaste); // jmEdit��� �޴��� mPaste��� �޴������� �߰�
		// jmHelp.add(mHelp); // jmHelp��� �޴��� mHelp��� �޴������� �߰�
		// jmHelp.add(mInfo); // jmHelp��� �޴��� mInfo��� �޴������� �߰�

		// jmb.add(jmEdit); // jmb��� �޴��ٿ� jmEdit��� �޴� �߰�
		// jmb.add(jmHelp); // jmb��� �޴��ٿ� jmHelp��� �޴� �߰�

		// setJMenuBar(jmb); // jmb�޴��� �߰�
		/** �޴��� �� */

		/** ���̺� ���� */
		jpResult = new JPanel(new GridLayout(2, 1));
		// jpResult��� �гο� GrideLayout�� ����
		// GrideLayout = ���̺� ������ ���̾ƿ�
		// �μ��� ���� ������ ���� 1������ �����ǰ� ���� ��� �߰��ȴ�.
		// ���� ���, (2,0)�̸� ���� 2������ �����ϰ� ���� ���Ѵ�� �þ �� �ִ�
		jpResult.setBackground(Color.WHITE); // jpResult��� �гο� ��� �������
		jlbResult1 = new JLabel("", JLabel.RIGHT); // jlbResult1��� �� ���� ���̺�, ��������
		jlbResult2 = new JLabel("0", JLabel.RIGHT); // jlbResult2��� �⺻�� 0�� ���̺�, ��������
		jlbResult2.setFont(new Font("����", Font.BOLD, 20)); // jlbResult2 ���̺� ��Ʈ�� ����, ���ϰ�, ũ��20 ����

		jpResult.add(jlbResult1); // jpResult �гο� jlbResult1 ���̺� �߰�
		jpResult.add(jlbResult2); // jpResult �гο� jlbResult2 ���̺� �߰�
		/** ���̺� �� */

		/** ��ư ���� */
		jpButton = new JPanel(new GridLayout(5, 4, 5, 5)); // jpButton��� �г�,
		// GridLayout����, 5 x 4, ������ ���μ��� 5��, 5�� 4��(���� ��ư)
		jpButton.setBackground(Color.WHITE); // jpButton �г� ����� ���
		jbButton = new JButton[numStr.length]; // jbButton ��ư �迭 �ʱ�ȭ
		// numStr�迭 ũ�⸸ŭ �ʱ�ȭ

		// jbButton�� ǥ���� ���� ����
		for (int i = 0; i < numStr.length; i++) {// i�� 0���� numStr.length���� ���Ѵ�
			jbButton[i] = new JButton(numStr[i]);
			// ��ư �迭 jbButton[i]�� numStr�� i��° ���ڿ��� ����
			jbButton[i].setFont(new Font("����", Font.BOLD, 20));
			// jbButton[i]�� ��Ʈ ����(����, ���ϰ�, ũ��:20)
			jpButton.add(jbButton[i]);
			// JPanel jpButton�� jbButton[i]�� �߰��Ѵ�
			jbButton[i].addActionListener(this);
			// jbButton[i]�� ��ü �ڽ��� ActionListener�� �߰�
		} // end of for

		/** ��ư �� ���� */
		for (int j = 0; j < numStr.length; j++) {
			if (j < 3) {// j�� 3���� ���� ��
				jbButton[j].setForeground(Color.RED);// 1,2,3��° ��ư = ������
			} else if (j == 3 || j == 7 || j == 11 || j == 15 || j == 19) {
				jbButton[j].setForeground(Color.BLUE);// 4,8,12,16,20��° ��ư = �Ķ���
			}
			jbButton[j].setBackground(Color.LIGHT_GRAY);// ��ư jbButton�� ������
		} // end of for
		jbButton[0].setForeground(Color.RED);// ������� �������� ��
		// setForeground = ����� ����
		/** ��ư �� �� */

		/** ��ư ����Ű ���� */
		// jmEdit.setMnemonic('E');
		// setMnemonic=����Ű�� ����
		// jmHelp.setMnemonic('H');

		// mCopy.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		// ����Ű �����Լ� ���, ����Ű�� �����Ѵ�. //CTRL + C
		// mPaste.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));
		// CTRL + V
		// mHelp.setAccelerator(KeyStroke.getKeyStroke('H', InputEvent.CTRL_MASK));
		// CTRL + H
		// mInfo.setAccelerator(KeyStroke.getKeyStroke('I', InputEvent.CTRL_MASK));
		// CTRL + I
		/** ��ư ����Ű �� */

		// mCopy.addActionListener(this);
		// addActionListener=�޺��ڽ����� �������� �������� �� �߻��ϴ� �̺�Ʈ�� �ޱ����� ������ ������ �߰�
		// mPaste.addActionListener(this);
		// mHelp.addActionListener(this);
		// mInfo.addActionListener(this);
		// /** ��ư �� */

		getContentPane().add("North", jpResult);
		// panel jpResult�� ���ʿ� ����
		// contentPane = �Ϲ����� ������Ʈ���� ���� �� �ִ� �г�
		// �⺻������ BorderLayout ��ġ�����ڸ� ���� ����
		// - ������ ��ü�� getContentPane()�޼ҵ带 �̿��ؼ� ���� �� �ִ�.
		// getContentPane() = �������� contentPane ������Ʈ�� �����ݴϴ�.
		// (������ ���ڰ� ��Ÿ���� �κ����� ����)
		getContentPane().add("Center", jpButton);
		// panel jpButton�� ��� ����
		setSize(350, 450);// ũ�� 300 * 400
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);// ������ ũ�� ���� �Ұ�
		setVisible(true);// �������� ���̰� ��
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �������� ������ ���α׷� ����
	}// end of Calculator()�޼���

	/** ��ư �̺�Ʈ ���� */
	// ��ư�� ������ ���۵�
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String txtButton = e.getActionCommand();
		// getActionCommand = action ����� ��Ÿ���� String�� �����մϴ�.

		// *���⼭ txtButton�� ���� ��ư*
		if (txtButton.equals("1") || txtButton.equals("2") || txtButton.equals("3") || txtButton.equals("4")
				|| txtButton.equals("5") || txtButton.equals("6") || txtButton.equals("7") || txtButton.equals("8")
				|| txtButton.equals("9")) {// txtButton�� 1�̰ų� 2�̰ų� ... 9�̸�
			if (result2.equals("0")) {// result2�� 0�̸�, result2�� �ƹ��͵� ���� ����
				result2 = "";
			} // end of inner if
			result2 += txtButton;// result2�� txtButton������
			jlbResult2.setText(result2);// jlbResult2�� ǥ�õǴ� �ؽ�Ʈ�� result2�� �Ѵ�
			// setText = �ؽ�Ʈ�ڽ� ���� ���ڿ��� �̸�����, text�� �� ����
			// ǥ�õǴ� �ؽ�Ʈ�� ������ �ؽ�Ʈ�� ����
			// setText(String t)
		} else if (txtButton.equals("��")) {// txtButton�� ���̸�
			int len = jlbResult2.getText().length();
			// getText() = text�� ������
			// len�� jlbResult2�� ���̸�ŭ �����ϰ� ����
			if (len == 1) {// len�� 1�� ������(���ڿ� ����)
				result2 = "";// result2�� ���� ����
				jlbResult2.setText("0");// jlbResult2�� ǥ�õǴ� �ؽ�Ʈ�� 0���� ��
			} else {
				if (!"".equals(result2)) {// result2�� ������ �ƴϸ�
					result2 = result2.substring(0, len - 1);
					// substring = ���ڿ����� ���ϴ� �κ��� ������
					// substring(������ġ,����ġ)
					// result�� 0��°���� len-1���� �ڸ��� �� ���� ���ڿ��� ����
					jlbResult2.setText(result2);
					// jlbResult2�� ǥ�õǴ� �ؽ�Ʈ�� result2�� �Ѵ�
				} // end of if
			} // end of else
		} else if (txtButton.equals("CE")) {// txtButton�� CE��
			result2 = "";// result2�� ��������
			result = "";// result�� ��������
			jlbResult2.setText("0");// jlbResult2�� 0�� ǥ�õȴ�
			number[0] = "0";// number[0]�� 0����
		} else if (txtButton.equals("C")) {// txtButton�� C�̸�
			result = "";// result�� ��������
			result1 = "";// result1�� ��������
			result2 = "";// result2�� ��������
			jlbResult1.setText("");// jlbResult1�� ����ǥ��
			jlbResult2.setText("0");// jlbResult2�� 0ǥ��
			number[0] = " ";// number[0]�� �������
			number[1] = " ";// number[1]�� �������
			number[2] = " ";// number[2]�� �������
		} else if (txtButton.equals("0") || txtButton.equals("00")) {
			// txtButton�� 0�̰ų� 00�̸�
			if (!("".equals(result2))) {// result2�� ������ �ƴҰ��
				if (!"0".equals(result2)) {// result2�� 0�� �ƴҰ��
					result2 += txtButton;// result2�� txtButton�� ������
					jlbResult2.setText(result2);
					// jlbResult2�� ǥ�õǴ� �ؽ�Ʈ�� result2�� �Ѵ�
				} // end of inner if
			} else { // end of outer if
				result2 = "0";
			}
		} else if (txtButton.equals(".")) {// txtButton�� .�̸�
			if ("".equals(result2)) {// result2�� �����̸�
				result2 = "0" + txtButton;
				// result2�� 0�� txtButton�� �����Ͽ� ����
			} else {
				if (result2.indexOf(".") == -1) {
					// indexOf = �ش� ���ڰ��ִ� ��ġ�� �˷��ݴϴ�.(������� -1��ȯ)
					// result2�� . ��ġ�� �˷���, -1�� �������(.�� �������)
					result2 += txtButton;// result2�� txtButton�� ������
				}
			} // end of else
			jlbResult2.setText(result2);
			// jlbResult2�� ǥ�õǴ� �ؽ�Ʈ�� result2�� �Ѵ�, ��� ȭ�鿡 ��´�
		} else if (txtButton.equals("=")) {// txtButton�� =�� �� //end of else if(.)
			if (!"".equals(result2)) {
				number[2] = result2;// number[2]�� result2�� ����
			}
			if ("".equals(result1)) {// result1�� �ƹ��͵� ������
				if (!number[1].equals(" ")) {
					result = Cal();// result�� ���޼ҵ� Cal()����
					if ("0���� ���� �� �����ϴ�.".equals(result)) {
						// result�� 0���� ���� �� �����ϴ�.�̸�
						result = "";
						result1 = "";
						result2 = "";
						number[0] = " ";
						number[1] = " ";
						number[2] = " ";
					} else {
						number[0] = result;// number[0]�� result�� ����
						jlbResult2.setText(result);
						// jlbResult2�� ǥ�õǴ� �ؽ�Ʈ�� result�� �Ѵ�
					}
				} // end of outer if
				jlbResult1.setText(result1);
				// jlbResult1�� ǥ�õǴ� �ؽ�Ʈ�� result1�� �Ѵ�
			} else {
				if (" ".equals(number[2])) {// number[2]�� " "�̸�
					number[2] = result2;// number[2]�� result2�� ����
				}
				result = number[0];// result�� number[0]�� ����

				if ("0���� ���� �� �����ϴ�.".equals(result)) {
					jlbResult2.setText(result);
					// jlbResult2�� ǥ�õǴ� �ؽ�Ʈ�� result�� �Ѵ�
					result = "";
					result1 = "";
					result2 = "";
					number[0] = " ";
					number[1] = " ";
					number[2] = " ";
				} else {
					result = Cal();

					if (!"0���� ���� �� �����ϴ�.".equals(result)) {
						result1 = "";
						number[0] = result;
						jlbResult2.setText(result);
						jlbResult1.setText(result1);
						result2 = "";
					} else {
						jlbResult2.setText("0���� ���� �� �����ϴ�.");
						jlbResult1.setText("");
						result = "";
						result1 = "";
						result2 = "";
						number[0] = " ";
						number[1] = " ";
						number[2] = " ";
					}
					System.out.println("?");
				} // end of inner else
			} // end of outer else
		} else if (txtButton.equals("/") || txtButton.equals("*") || txtButton.equals("-") || txtButton.equals("+")) {
			// txtButton�� /�̰ų� *�̰ų� -�̰ų� +�� ��
			if ("".equals(result1)) {// result1�� ������ ��
				if ("".equals(result2)) {// result2�� ������ ��
					if ("".equals(result)) {// result�� ������ ��
						result1 = "0" + txtButton;
						// result1�� 0�� txtButton�� �����Ͽ� ����
						number[0] = "0";
						// number[0]�� 0�� ����
					} else {
						result1 = result + txtButton;
						// result1�� result�� txtButton�� �����Ͽ� ����
					}
				} else {
					if (!"".equals(result)) {// result�� ������ �ƴϸ�
						result1 = result + txtButton;
						// result1�� result�� txtButtton�� �����Ͽ� ����
					}
					result1 = result2 + txtButton;
					number[0] = result2;
				}
				number[1] = txtButton;
			} else { // end of outer if
				if ("".equals(result2)) {
					result1 = result1.substring(0, result1.length() - 1) + txtButton;
					// result1�� result1�� 0��° ���� result1�� ����-1���� �߶� ����, txtButton�� �����Ͽ� ����
					number[1] = txtButton;
				} else {
					result1 += result2 + txtButton;
					number[2] = result2;
					result = Cal();
					number[1] = txtButton;
					jlbResult2.setText(result);
					number[0] = result;
				}
			} // end of outer else
			if (number[1].equals("/") && (number[2].equals(" 0") || number[2].equals("0"))) {
				// number[1]�� "/"�̰� number[2]�� " 0"�ų�, number[2]�� 0�� ��
			} else {
				result2 = "";
				jlbResult1.setText(result1);
			}

		} // end of else if
	}// end of actionPerformed

	/** ��ư �̺�Ʈ �� */

	/** ��� �޼ҵ� ���� */
	public String Cal() {
		String num = "";
		String testNum1 = "";
		String testNum2 = "";

		if (number[0].indexOf(".") != -1) {// == -1 => �Ҽ����� ������
			// indexOf = �ش� ���ڰ��ִ� ��ġ�� �˷��ݴϴ�.(������� -1��ȯ)
			// �Է��� ���� �Ҽ����� ������
			int index1 = number[0].indexOf(".");
			// index1�� number[0]�� .��ġ�� �����Ѵ�
			testNum1 = number[0].substring(index1, number[0].length());
			// substring = ���ڿ����� ���ϴ� �κ��� ������
			// substring(������ġ,����ġ)
			// testNum1�� number[0]�� index1(number[0]�� .��ġ)���� number[0]���� ���� �����Ͽ� ����
			// testNum1 = �Ҽ��� �޺κ��� ������ ����
			if (testNum1.replaceAll("0", "").equals(".")) {
				// replaceAll = Ư�� ���ڿ��� ���ϴ� ���ڿ��� ġȯ�ϴ� �޼ҵ�
				// ���� ���ڰ��� ã�����ڿ� , �������� ��ȯ�� ���ڿ�
				// testNum1�� 0�� �������� �ٲٰ� .�� �ִ� �� Ȯ��(0�� ������)
				number[0] = number[0].substring(0, index1);
				// number[0]�� number[0]�� 0���� index1�� ���� ���� �����Ͽ� ����
			}
		} // end of outer if

		if (number[2].indexOf(".") != -1) {
			int index2 = number[2].indexOf(".");
			testNum2 = number[2].substring(index2, number[2].length());

			if (testNum2.replaceAll("0", "").equals(".")) {
				// replaceAll�޼ҵ�� ���Խİ� ��ü ���ڿ��� ��ġ�ϴ� ��� ���� �������� ��ü ���ڿ��� ��ȯ�Ѵ�.
				// replaceAll(���ڿ� ���Խ�, ���ڿ� ��ü)
				number[2] = number[2].substring(0, index2);
			}
		}
		if (number[1].equals("*")) {// number[1]�� *�� ������
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				// number[0]�̳� number[2]�� �Ҽ����� ������(number[0]�̳� number[2]�� �Ҽ��̸� doubleŸ������ ��ȯ)
				num = (Double.parseDouble(number[0]) * Double.parseDouble(number[2])) + "";
				// parseDouble = ���ڷ� �� ���ڿ��� ���ڷ� ��ȯ��. (double Ÿ������ ��ȯ)
			} else {
				if ("".equals(number[2])) {
					num = result2;
				} else {
					if (!"".equals(result)) {
						number[0] = result;
					}
					num = (Long.parseLong(number[0]) * Long.parseLong(number[2])) + "";
					// Long.parseLong(String) = ���ڿ��� long������ ��ȯ�Ѵ�.
					// num�� long������ ��ȯ�� number[0]�� long������ ��ȯ�� number[2]�� ���Ͽ�, ""�� ���̰� ����
					// number[0]�̳� number[2]�� �����̸� long������ ��ȯ
					result = num;
					number[0] = result;
				} // end of inner else
			} // end of outer else
		} else if (number[1].equals("+")) {
			// number[1]�� +�� ������
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) + Double.parseDouble(number[2])) + "";
			} else {
				if ("".equals(number[2])) {
					num = result2;
				} else {
					if (!"".equals(result)) {
						number[0] = result;
					}
					num = (Long.parseLong(number[0]) + Long.parseLong(number[2])) + "";
					result = num;
					number[0] = result;
				}
			}
		} else if (number[1].equals("-")) {
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) - Double.parseDouble(number[2])) + "";
			} else {
				if ("".equals(number[2])) {
					num = result2;
				} else {
					if (!"".equals(result)) {
						number[0] = result;
					}
					num = (Long.parseLong(number[0]) - Long.parseLong(number[2])) + "";
					result = num;
					number[0] = result;
				}
			}
		} else if (number[1].equals("/")) {
			number[2].trim();
			// trim() = ������ ������ �ش�
			// number[2]�� ������ ������ �ش� (���� ���鸸) ��) " �� �� " -> "�� ��"
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) / Double.parseDouble(number[2])) + "";
			} else {
				if (number[2].equals("0")) {
					num = "0���� ���� �� �����ϴ�.";
					result2 = "";
				} else {
					if ("".equals(number[2])) {
						num = result2;
					} else {
						if (!"".equals(result)) {
							number[0] = result;
						}
						num = (Double.parseDouble(number[0]) / Double.parseDouble(number[2])) + "";

						if (num.indexOf(".") != -1) {
							// num�� �Ҽ����� ������
							int index3 = num.indexOf(".");
							// index3�� num���� .�� ��ġ�� ����
							String testNum3 = num.substring(index3, num.length());
							// testNum3�� index3���� num�� ���̱��� �����Ͽ� �����Ѵ�
							if (testNum3.replaceAll("0", "").equals(".")) {
								num = num.substring(0, index3);
								// num�� 0��° �ڸ����� index3���� �ڸ����� �����Ͽ� num�� �����Ѵ�
							}
						}
						result = num;
						number[0] = result;
					} // end of inner else
				} // end of second outer else
			} // end of outer else
		} // end of outer else if
		return num;
	}// end of cal()

	/** ��� �޼ҵ� �� */

	public static void main(String[] args) {
		new Calculator();
	}
}// end of Calculator class
