import java.awt.Color;
//ColorŬ������ �⺻ sRGB ���� �������� ������ ĸ��ȭ�ϰų����� �ĺ��Ǵ� ���� ���� ������ ������ ĸ��ȭ�ϴ� �� ���
import java.awt.FlowLayout;//FlowLayout�� �ҷ���.
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
//Swing ���� Font Ŭ������ ����ü �� ��Ʈ�� �����ϱ� ���ؼ��� ���
import java.awt.event.ActionEvent;//���� ��� ���� ��ġ�� �߻������� ��Ÿ���� �ǹ� ���� �̺�Ʈ.
import java.awt.event.ActionListener;
//��ư �Ǵ� �޴� �׸��� Ŭ�� �� ������ Java ActionListener�� �˸���. ActionEvent�� ���� ����
import javax.swing.ImageIcon;
//ImageIcon�� ���� ���� �̹���, �� �������� �̹�����ü�� ���� ��
import javax.swing.JButton;
//JButton Ŭ������ �÷��� �������� �������ִ� ���̺��� ������ ���߸� �ۼ��ϴ� �� ����
import javax.swing.JFrame;
//java.awt.Frame Ŭ������ ����ϴ� �����̳� ����. JFrame�� GUI�� ����� ���� ���̺�, ��ư, �ؽ�Ʈ �ʵ�� ���� ���� ��Ұ� �߰��Ǵ� �⺻ âó�� �۵���
import javax.swing.JLabel;
//JLabel�� java Swing Ŭ�����̴�. JLabel�� ª�� ���ڿ� �Ǵ� �̹��� �������� ǥ���ϴ� �� �����.
import javax.swing.JPanel;
//Java Swing ��Ű���� �Ϻ��� JPanel�� ���� ��� �׷�(��, ��ư ��.)�� ������ ���ִ� �����̳��̴�.
import javax.swing.JTextField;
//JTextField Ŭ������ ��ü�� �� �� �ؽ�Ʈ�� ���� �� ���ִ� �ؽ�Ʈ ���� ����̴�.
import javax.swing.border.EtchedBorder;
//�׵θ��� Ȩ�� �Ŀ��ִ� ���� Border�� �ҷ���.

class outMoney {
	int a1 = 0, gu;// a1 = ������ �ݾ�,����ݾ�, gu = ���԰� ������ ����
	String memo = "";// ����, ���� ����

	public outMoney() {// ����

		JFrame frame1 = new JFrame();// '����' ȭ�� ������
		JPanel titleP = new JPanel();// ������ ���� �г�, titleP
		JPanel placeP = new JPanel();// ����� �ݾ� ������ �Է��ϴ� ������ ���� JPanel placeP
		JPanel ImageP = new JPanel();// �̹����� ���� �г�
		JPanel outP = new JPanel();// ����� �ݾ��� �Է��ϴ� ������ ���� JPanel outP
		frame1.setBackground(new Color(255, 204, 0));// f1�� ���� ����
		titleP.setBackground(new Color(255, 204, 0));// titleP�� ���� ����
		placeP.setBackground(new Color(255, 204, 0));// placeP�� ���� ����
		outP.setBackground(new Color(255, 204, 0));// outP�� ���� ����
		ImageP.setBackground(new Color(255, 204, 0));// ImageP�� ���� ����
		Toolkit toolkit = Toolkit.getDefaultToolkit();//������ �ֱ�
	      Image img = toolkit.getImage("pig.png");
	      frame1.setIconImage(img);


		// FlowLayout = ������Ʈ���� ���ʿ��� ���������� �߰���
		// �⺻������ ��� ����,
		// container�� ũ�Ⱑ ���� => componentũ��� �����ǰ� ��ġ�� ����
		frame1.setLayout(new FlowLayout());
		// FlowLayout = ������Ʈ���� ���ʿ��� ���������� �߰���
		// �⺻������ ��� ����,
		// container�� ũ�Ⱑ ���� => componentũ��� �����ǰ� ��ġ�� ����

		EtchedBorder border = new EtchedBorder();
		// EhchedBorder = ������Ʈ ���� Ȩ�� �Ŀ��ִ� ����� ǥ���� ��ü
		JLabel l1 = new JLabel("===========���� �Է�===========");
		// JLabel l1�� "====���� �Է�===="�� ������
		l1.setFont(new Font("����", Font.PLAIN, 16));// l1 �۲� / ũ��
		l1.setBorder(border);// Border = ��輱, l1�� EtchedBorder�� ������

		JLabel l2 = new JLabel("���� �Է�:>> ");
		// JLabel l2�� "���� �Է�:>>"�� ������
		JTextField t1 = new JTextField(15);// ũ�� 15�� JTextField t1�� ����
		l2.setFont(new Font("����", Font.PLAIN, 17));// l2�� �۲� / ũ��
		t1.setForeground(new Color(0, 0, 204)); // t1�� �ؽ�Ʈ �ڽ��� ���ڻ�

		JLabel l3 = new JLabel("���� ī�װ�:>> ");
		// JLabel l3�� "���� ī�װ�:>>"�� ������
		l3.setFont(new Font("����", Font.PLAIN, 17));// l3 �۲� / ũ��
		JTextField t2 = new JTextField(15);// ũ�� 15�� JTextField t2�� ����
		t2.setForeground(new Color(0, 0, 204));// t2�� �ؽ�Ʈ �ڽ� �� ���ڻ�

		ImageIcon image = new ImageIcon("newout.jpg");// ���� �ֱ�
		// java project�ȿ��ִ� �̹����� �ҷ��´�(���� Ž������ �ڹ� ������Ʈ�ȿ� �̹����� �����صд�)
		JLabel labelImage = new JLabel(image);// Label�� �̿��Ͽ� image�� �����

		// ������ ���� �гλ���
		JPanel buttonP = new JPanel();// ��ư�� ����JPanel buttonP����
		JButton b1 = new JButton("�����ϱ�");// JButton b1�� "�����ϱ�" ���� ����
		buttonP.add(b1);// buttonP�� b1(�����ϱ� ��ư)�� ����
		buttonP.setBackground(new Color(255, 204, 0));// buttonP�� ����
		b1.setBackground(new Color(255, 255, 204));// b1�� ����

		titleP.add(l1);// titleP�� l1(====���� �Է�====)�� ����

		outP.add(l2);// outP�� l2(���� �Է�:>> )����
		outP.add(t1);// outP�� t1(JTextField) ����

		placeP.add(l3);// placeP�� l3����
		placeP.add(t2);// placeP�� t2����

		buttonP.add(b1);// buttonP�� b1����
		ImageP.add(labelImage);// ImageP�� labelImage����

		frame1.add(titleP);// frame1�� titleP����
		frame1.add(outP);// frame1�� outP����
		frame1.add(placeP);// frame1�� placeP����
		frame1.add(buttonP);// frame1�� buttonP����
		frame1.add(ImageP);// frame1�� ImageP����

		// b1�� ��� �߰�
		b1.addActionListener(new ActionListener() {
			// b1�� Ŭ���ϸ� ���𰡸� �϶�� ����(����� ���� �� ����)

			@Override
			public void actionPerformed(ActionEvent e) {// ��ư�� ������ ���� ��
				JFrame frame = new JFrame();// '���⳻�� ����' ȭ�� JFrame (frame)
				JPanel panel = new JPanel();// '���⳻�� ����' ȭ���� JPanel (panel)
				JLabel label = new JLabel("����Ǿ����ϴ�.");
				// JLabel label�� "����Ǿ����ϴ�."�� ������

				panel.add(label);// paenl�� label(����Ǿ����ϴ�.) ����
				frame.add(panel);// frame�� panel ����
				panel.setBackground(new Color(255, 204, 102));// panel�� ��� ���� ����

				frame.setTitle("��������");// frame�� ���� : ��������
				label.setFont(new Font("����", Font.PLAIN, 44));// label�� ��Ʈ ����( �۲�, ũ��)

				frame.setSize(400, 115);// frame�� ũ�� : 400 X 115
				frame.setVisible(true);// frame�� ���̰� ����
				frame.setResizable(false);// frame�� ũ�� ���� �Ұ��� �ϰ� ��

				gu = 2;// gu�� 2�� ����(1�̸� ����, 2�̸� ����� ������)
				a1 = Integer.parseInt(t1.getText().trim());
				// a1�� t1(���� �ݾ� )�� �ؽ�Ʈ�� ������ ������ ���� �� intŸ������ �ٲپ� ����.

				memo = t2.getText().trim();
				// memo�� t2(������ ����)�� �ؽ�Ʈ�� �����ͼ� ������ ���� �� ����.

				frame.setLocationRelativeTo(null);// ��� ����
				frame.setResizable(false);// â �ø��� �Ұ��� �ϰ� �� �� �ִ°�
				VectorData.vd.add(new BookTest_1(a1, memo, gu));
				//// BookTest_1�� �ڷᰡ �����Ǿ� vectorData(�ڷᱸ��)�� ��.

			}

		});
		frame1.setTitle("==����==");// ������ ���� : ����
		frame1.setSize(350, 340);// ������ ũ�� ����
		frame1.setVisible(true);// ������ ���̱�
		frame1.setResizable(false);// �������� ũ�⸦ �ٲ� �� ����
		frame1.setLocationRelativeTo(null);// ��� ����
		frame1.setResizable(false);// â �ø��� �Ұ��� �ϰ� �� �� �ִ°�
		frame1.getContentPane().setBackground(new Color(255, 204, 0));// frame1�� ���� ������
		// frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X��ư ������ ����

	}// end of method
}// end of class

public class outMoneyTest {

	public static void main(String[] args) {
		new outMoney();
	}
}
