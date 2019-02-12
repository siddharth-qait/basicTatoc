package Practice1;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class tatoc {

	public static void main(String[] args) throws InterruptedException {
		String str1 = "", str2 = "";
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/driver/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.xpath("//a[contains(text(),'Basic Course')]")).click();

		if (driver.getTitle().contains("Grid Gate - Basic Course - T.A.T.O.C"))
			System.out.println("On correct page 1");
		else
			System.out.println("Not a correct page");

		driver.findElement(By.cssSelector("div[class='redbox']")).click();
		driver.navigate().back();
		driver.findElement(By.cssSelector("div[class='greenbox']")).click();

		if (driver.getTitle().contains("Frame Dungeon - Basic Course - T.A.T.O.C"))
			System.out.println("On correct page 2");
		else
			System.out.println("Not a correct page");

		Thread.sleep(5000);

		driver.switchTo().frame("main");
		str1 = (driver.findElement(By.xpath("//center//div[text()='Box 1']")).getAttribute("class"));
		System.out.println(str1);
		driver.switchTo().frame("child");
		str2 = (driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class"));
		System.out.println(str2);
		// Thread.sleep(5000);

		// driver.switchTo().parentFrame();
		//Thread.sleep(5000);

		while (!str1.equals(str2)) {
			/*
			 * driver.switchTo().frame("child"); str2 =
			 * (driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class"))
			 * ; System.out.println("value of " + str1 + "   " + str2); Thread.sleep(5000);
			 * driver.switchTo().parentFrame();
			 * driver.findElement(By.xpath("//a[text()='Repaint Box 2']")).click();
			 */

			driver.switchTo().parentFrame();
			driver.findElement(By.xpath("//a[text()='Repaint Box 2']")).click();
			// Thread.sleep(5000);
			driver.switchTo().frame("child");
			str2 = (driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class"));
			System.out.println("value of " + str1 + "   " + str2);
			//Thread.sleep(5000);

		}

		// Thread.sleep(10000);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[text()='Proceed']")).click();
		
		Thread.sleep(5000);

		if (driver.getTitle().contains("Drag - Basic Course - T.A.T.O.C"))
			System.out.println("On correct page 3");
		else
			System.out.println("Not a correct page");

		System.out.println("On Third Page");


		driver.switchTo().defaultContent();

		WebElement From = driver.findElement(By.xpath("//*[@id='dragbox']"));

		WebElement To = driver.findElement(By.xpath("//div[@id='dropbox']"));

		Actions act = new Actions(driver);

		Thread.sleep(10000);

		act.dragAndDrop(From, To).build().perform();

		//Thread.sleep(10000);

		driver.findElement(By.xpath("//a[text()='Proceed']")).click();
		
		if (driver.getTitle().contains("Windows - Basic Course - T.A.T.O.C"))
			System.out.println("On correct page 4");
		else
			System.out.println("Not a correct page");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Launch Popup Window']")).click();
		System.out.println("Done");
		ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		
		Thread.sleep(5000);
		System.out.println("ok");
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		System.out.println("ok");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#name")).sendKeys("Siddharth");
		Thread.sleep(5000);
				
		driver.findElement(By.cssSelector("#submit")).click();
		Thread.sleep(5000);
		driver.switchTo().window(tab2.get(0));
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Proceed']"));

		// driver.close();

	}

}
