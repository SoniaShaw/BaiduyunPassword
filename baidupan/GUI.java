package baidupan;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("�ٶ����������ƽ�����");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        // ������
        frame.add(panel);
        /* 
         * �����û�����ķ����������������
         */
        placeComponents(panel);

        // ���ý���ɼ�
        frame.setVisible(true);
	}
	public static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		JLabel urlLabel = new JLabel("��ַ:");
        /* ������������������λ�á�
         * setBounds(x, y, width, height)
         * x �� y ָ�����Ͻǵ���λ�ã��� width �� height ָ���µĴ�С��
         */
		urlLabel.setBounds(10,20,40,25);
        panel.add(urlLabel);
        /* 
         * �����ı��������û�����
         */
        JTextField urlText = new JTextField(2000);
        urlText.setBounds(50,20,165,25);
        panel.add(urlText);
        // ����������ı���
        JLabel passwordLabel = new JLabel("��ʼ����:");
        passwordLabel.setBounds(10,50,60,25);
        panel.add(passwordLabel);
        JTextField pswText=new JTextField(2000);
        pswText.setBounds(70,50,40,25);
        panel.add(pswText);
        JButton start=new JButton("��ʼ");
        start.setBounds(10, 80, 80, 25);
        panel.add(start);
        JLabel confirmpwdLabel=new JLabel("��ǰ����:");
        confirmpwdLabel.setBounds(10, 110, 60, 25);
        panel.add(confirmpwdLabel);
        JTextField confirmpswText=new JTextField(2000);
        confirmpswText.setBounds(70,110,40,25);
        panel.add(confirmpswText);
        start.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		String pwd=pswText.getText();
        		String url=urlText.getText();
        		new Selenium();
        		try {
					Selenium.init(url,pwd,confirmpswText);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
	}
}
