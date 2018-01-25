package baidupan;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//WebDriver driver = new HtmlUnitDriver();//
		HtmlUnitDriver driver = new HtmlUnitDriver(true);
		driver.get("https://pan.baidu.com/share/init?surl=ge5gCiJ");
		Thread.sleep(1000);
		driver.findElement(By.id("dtQNPK")).sendKeys("zx1g");
		driver.findElement(By.xpath("//span[text()='提取文件']")).click();
		Thread.sleep(1000);
		System.out.println(driver.getPageSource());
		driver.findElement(By.xpath("//h2[@class='file-name']"));
		//System.out.println(driver.findElement(By.xpath("//div[@class='ctime']")).getText());
//		PhantomJS driver = new PhantomJSDriver();
//		driver.get("http://www.baidu.com");
//		driver.findElement(By.id("kw")).sendKeys("周笔畅");
//		driver.findElement(By.id("su")).click();
//		System.out.println(driver.getPageSource());
//		driver.close();
//		String s="1234";
//		System.out.println(s.contains("1234"));
	}

}
