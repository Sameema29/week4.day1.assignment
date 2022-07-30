package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[4]")).click();
		
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img[1]")).click();
		Set<String> windows1 = driver.getWindowHandles();
		List<String> windowsList1 = new ArrayList<String>(windows1);
		String window1 = windowsList1.get(0);
		String window2 = windowsList1.get(1);
		System.out.println("Window1: "+window1);
		System.out.println("Window2: "+window2);
		driver.switchTo().window(window2);
		driver.findElement(By.xpath("//a[@class='linktext'][1]")).click();
		driver.switchTo().window(window1);
		
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img[1]")).click();
		Set<String> windows2 = driver.getWindowHandles();
		List<String> windowsList2 = new ArrayList<String>(windows2);
		String window3 = windowsList2.get(0);
		String window4 = windowsList2.get(1);
		System.out.println("Window3: "+window3);
		System.out.println("Window4: "+window4);
		driver.switchTo().window(window4);
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a)[5]")).click();
		driver.switchTo().window(window3);
		driver.findElement(By.xpath("//span[text()='To Contact']/following::a[2]")).click();
		
		driver.switchTo().alert().accept();
		String expectedTitle = "View Contact | opentaps CRM";
		String actualTitle = driver.getTitle();
		if(actualTitle.contains(expectedTitle))
		{
			System.out.println("Title Verified Successfully. "+actualTitle);
		}
		else
			System.out.println("Title of the page is not expected. "+actualTitle);

	}

}
