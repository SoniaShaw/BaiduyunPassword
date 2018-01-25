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
		JFrame frame = new JFrame("百度网盘密码破解助手");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        // 添加面板
        frame.add(panel);
        /* 
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
	}
	public static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		JLabel urlLabel = new JLabel("网址:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
		urlLabel.setBounds(10,20,40,25);
        panel.add(urlLabel);
        /* 
         * 创建文本域用于用户输入
         */
        JTextField urlText = new JTextField(2000);
        urlText.setBounds(50,20,165,25);
        panel.add(urlText);
        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("初始密码:");
        passwordLabel.setBounds(10,50,60,25);
        panel.add(passwordLabel);
        JTextField pswText=new JTextField(2000);
        pswText.setBounds(70,50,40,25);
        panel.add(pswText);
        JButton start=new JButton("开始");
        start.setBounds(10, 80, 80, 25);
        panel.add(start);
        JLabel confirmpwdLabel=new JLabel("当前测试:");
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
