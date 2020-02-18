package aaa;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("working");
		
		System.setProperty("webdriver.chrome.driver", "E:\\Downloads\\New folder\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		
		System.out.println("My first change for push");
		

	}

}
