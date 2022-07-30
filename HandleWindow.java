package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();

		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Thread.sleep(5000);

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		System.out.println("Number of opened windows: "+windows.size());
		String window1 = windows.get(0);
		String window2 = windows.get(1);
		String window3 = windows.get(2);
		String window4 = windows.get(3);
		driver.switchTo().window(window2).close();
		driver.switchTo().window(window3).close();
		driver.switchTo().window(window4).close();

		driver.switchTo().window(window1);

		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);



	}

}
