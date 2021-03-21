import java.awt.Color;
//ColorŬ������ �⺻ sRGB ���� �������� ������ ĸ��ȭ�ϰų����� �ĺ��Ǵ� ���� ���� ������ ������ ĸ��ȭ�ϴ� �� ���
import java.awt.FlowLayout;//FlowLayout�� �ҷ���.
import java.awt.Font;
//Swing ���� Font Ŭ������ ����ü �� ��Ʈ�� �����ϱ� ���ؼ��� ���
import java.awt.Image;
//�̹����� ����� �����ϱ����� Ŭ������ ������.
import java.awt.Toolkit;
//�� Ŭ������ Abstract Window Toolkit�� ��� ���� ������ �߻� ���� Ŭ�����̴�. Ŭ������ ���� ToolkitŬ������ �پ��� ������Ʈ�� Ư�� ���� ��Ŷ ������ ���ε��ϴ� �� �����.
import java.awt.event.ActionEvent;
//���� ��� ���� ��ġ�� �߻������� ��Ÿ���� �ǹ� ���� �̺�Ʈ. 
import java.awt.event.ActionListener;
//��ư �Ǵ� �޴� �׸��� Ŭ�� �� ������ Java ActionListener�� �˸���. ActionEvent�� ���� ����

import javax.swing.ImageIcon;
//ImageIcon�� ���� ���� �̹���, �� �������� �̹�����ü�� ���� ��
import javax.swing.JButton;
//JButton Ŭ������ �÷��� �������� �������ִ� ���̺��� ������ ���߸� �ۼ��ϴ� �� ����
import javax.swing.JFrame;
//java.awt.Frame Ŭ������ ����ϴ� �����̳� ����. JFrame�� GUI�� ����� ���� ���̺�, ��ư, �ؽ�Ʈ �ʵ�� ���� ���� ��Ұ� �߰��Ǵ� �⺻ âó�� �۵���.
import javax.swing.JLabel;
//JLabel�� java Swing Ŭ�����̴�. JLabel�� ª�� ���ڿ� �Ǵ� �̹��� �������� ǥ���ϴ� �� �����.
import javax.swing.JPanel;
//Java Swing ��Ű���� �Ϻ��� JPanel�� ���� ��� �׷�(��, ��ư ��.)�� ������ ���ִ� �����̳��̴�.
import javax.swing.JTextField;
//JTextField Ŭ������ ��ü�� �� �� �ؽ�Ʈ�� ���� �� ���ִ� �ؽ�Ʈ ���� ����̴�.
import javax.swing.border.EtchedBorder;
//�׵θ��� Ȩ�� �Ŀ��ִ� ���� Border�� �ҷ���.

class getMoney {
	int a1 = 0, gu;// a1 = ������ �ݾ�,����ݾ�, gu = ���԰� ������ ����
	String memo = "";// ����, ���� ����

	public getMoney() {
		// ���� - getMoney : ������� ���� �Է��Ѵ�

//      JFrame f1;
//      JLabel l1, l2, l3
//      JTextField t1;//�ؽ�Ʈ�ʵ� t1
//      JPanel titleP getP, priceP, buttonP;//JPanel = ������Ʈ ���� ������
//       //getP = ���� �ݾ�, priceP = ���� ���� ����, buttonP = �����ϱ� ��ư
//      JButton b1;//��ư b1
		JFrame f1 = new JFrame();// '����' ȭ��
		JPanel titleP = new JPanel();// ������ ���� �г�
		JPanel getP = new JPanel();// ���� ������ ���� �г�
		JPanel ImageP = new JPanel();// �̹����� ���� �г�
		JPanel priceP = new JPanel();// ���Գ����� ���� �г�

		f1.setBackground(new Color(255, 204, 0));// f1�� ���� ����
		getP.setBackground(new Color(255, 204, 0));// getP�� ���� ����
		titleP.setBackground(new Color(255, 204, 0));// titleP�� ���� ����
		priceP.setBackground(new Color(255, 204, 0));// priceP�� ���� ����
		ImageP.setBackground(new Color(255, 204, 0));// ImageP�� ���� ����

		Toolkit toolkit = Toolkit.getDefaultToolkit();// ������ �߰�
		Image img = toolkit.getImage("pig.png");
		f1.setIconImage(img);

		// FlowLayout = ������Ʈ���� ���ʿ��� ���������� �߰���
		// �⺻������ ��� ����,
		// container�� ũ�Ⱑ ���� => componentũ��� �����ǰ� ��ġ�� ����
		f1.setLayout(new FlowLayout());
		// FlowLayout = ������Ʈ���� ���ʿ��� ���������� �߰���
		// �⺻������ ��� ����,
		// container�� ũ�Ⱑ ���� => componentũ��� �����ǰ� ��ġ�� ����

		EtchedBorder border = new EtchedBorder();
		// EhchedBorder = ������Ʈ ���� Ȩ�� �Ŀ��ִ� ����� ǥ���� ��ü
		JLabel l1 = new JLabel("===========���� �Է�===========");
		// JLabel l1�� "====���� �Է�===="�� ������
		l1.setFont(new Font("����", Font.PLAIN, 16));// l1�� �۲� / ũ��
		l1.setBorder(border);// Border = ��輱

		// ���� ���� ����, �ݾ� �Է��� ���� �гλ���
		JLabel l2 = new JLabel("���� �Է�:>> ");// JLabel l2�� "���� �Է�:>>"�� ������
		l2.setFont(new Font("����", Font.PLAIN, 17));// l2�� �۲� / ũ��
		JTextField t1 = new JTextField(15);// ũ�� 15�� JTextField t1�� ����
		t1.setForeground(new Color(0, 0, 204));// t1 �ؽ�Ʈ �ڽ� �� ���ڻ�
		JLabel l3 = new JLabel("���� ī�װ�:>> ");// JLabel l3�� "���� ī�װ�:>> "�� ������
		l3.setFont(new Font("����", Font.PLAIN, 17));// l3�� �۲� / ũ��
		JTextField t2 = new JTextField(15);// ũ�� 15�� JTextField t2�� ����
		t2.setForeground(new Color(0, 0, 204));// t2 �ؽ�Ʈ �ڽ� �� ���ڻ�
		l2.setBackground(new Color(153, 204, 204));// l2�� ����
		titleP.add(l1);// titleP�� l1(����)�� ����

		priceP.add(l2);// priceP�� l2(���� �Է�:>>)����
		priceP.add(t1);// priceP�� t1(JTextField)����
		getP.add(l3);// getP�� l3(���� ī�װ�:>>)����
		getP.add(t2);// getP�� t2(JTextField)����

		ImageIcon image = new ImageIcon("newget.jpg");// ���� �ֱ�
		// java project�ȿ��ִ� �̹����� �ҷ��´�(���� Ž������ �ڹ� ������Ʈ�ȿ� �̹����� �����صд�)
		JLabel labelImage = new JLabel(image);// Label�� �̿��Ͽ� image�� �����

		JPanel buttonP = new JPanel();// ������ ���� �гλ���
		JButton b1 = new JButton("�����ϱ�");// JButton b1�� "�����ϱ�" ���� ����
		buttonP.add(b1);// buttonP�� b1(�����ϱ� ��ư)�� ����
		buttonP.setBackground(new Color(255, 204, 0));// buttonP�� ����
		b1.setBackground(new Color(255, 255, 204));// ��ư b1�� ����

		ImageP.add(labelImage);// ImageP�� labelImage����

		f1.add(titleP);// f1�� titleP����
		f1.add(priceP);// f1�� priceP����
		f1.add(getP);// f1�� getP����
		f1.add(buttonP);// f1�� buttonP����
		f1.add(ImageP);// frame1�� ImageP����

		// b1�� ��� �߰�
		b1.addActionListener(new ActionListener() {

			// b1�� Ŭ���ϸ� ���𰡸� �϶�� ����(����� ���� �� ����)
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();// '���Գ��� ����' ȭ�� JFrame (frame)
				JPanel panel = new JPanel();// '���Գ��� ����' ȭ���� JPanel (panel)
				JLabel label = new JLabel("����Ǿ����ϴ�.");
				// JLabel label�� "����Ǿ����ϴ�."�� ������

				panel.add(label);// paenl�� label(����Ǿ����ϴ�.) ����
				frame.add(panel);// frame�� panel ����
				panel.setBackground(new Color(255, 204, 102));// panel�� ��� ���� ����
				//panel.setBackground(new Color(180, 183, 233));// panel�� ��� ���� ����

				frame.setTitle("��������");// frame�� ���� : ��������
				label.setFont(new Font("����", Font.PLAIN, 44));// label�� ��Ʈ ����( �۲�, ũ��)
				frame.setSize(400, 115);// frame�� ũ�� : 400 X 115
				frame.setVisible(true);// frame�� ���̰� ����
				frame.setResizable(false);// frame�� ũ�� ���� �Ұ��� �ϰ� ��
				frame.setLocationRelativeTo(null);// ��� ����
				frame.setResizable(false);// â �ø��� �Ұ��� �ϰ� �� �� �ִ°�

				gu = 1;// gu�� 1�� ����(1�̸� ����, 2�̸� ����� ������)
				a1 = Integer.parseInt(t1.getText().trim());
				// a1�� t1(���� �ݾ� )�� �ؽ�Ʈ�� ������ ������ ���� �� intŸ������ �ٲپ� ����.
				memo = t2.getText().trim();
				// memo�� t2(������ ����)�� �ؽ�Ʈ�� �����ͼ� ������ ���� �� ����
				VectorData.vd.add(new BookTest_1(a1, memo, gu));
				// BookTest_1�� �ڷᰡ �����Ǿ� vectorData(�ڷᱸ��)�� ��.
			}
		});
		f1.setTitle("==����==");// ������ ���� : ����
		f1.setSize(350, 340);// ������ ũ�� ����
		f1.setVisible(true);// ������ ���̱�
		f1.setResizable(false);// �������� ũ�⸦ �ٲ� �� ����
		f1.setLocationRelativeTo(null);// ��� ����
		f1.setResizable(false);// â �ø��� �Ұ��� �ϰ� �� �� �ִ°�
		f1.getContentPane().setBackground(new Color(255, 204, 0));// frame1�� ���� ������
		// f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X��ư ������ ����

	}// end of getMoneyTest()

}// end of class

public class getMoneyTest {

	public static void main(String[] args) {
		new getMoney();

	}
}
