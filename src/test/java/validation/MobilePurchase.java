package validation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchase {
	static WebDriver driver;
	static long Start;
	@BeforeClass
	public static void launch(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
	@AfterClass
	public static void close() {
		driver.quit();
	}
	@Before
	public void startTime() {
		
	  long Start = System.currentTimeMillis();
	  System.out.println("Start time"+Start);
	}
	@After
	public void endTime() {
		long End = System.currentTimeMillis();
		System.out.println("End time"+(Start-End));
		
	}
	@Test
	public void method1() throws Exception {
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("mi 11i",Keys.ENTER);
		 driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		 WebElement phone = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		 phone.click();
		 System.out.println(phone.getText());
		 
		 
		 File f= new File(".//target//navin.xls");
		FileOutputStream file = new FileOutputStream(f);

		HSSFWorkbook w =new HSSFWorkbook ();
		HSSFSheet s= w.createSheet("sparrow");
		String phonename = phone.getText();
		 HSSFRow row = s.createRow(0);
		 HSSFCell c = row.createCell(0);
    	 c.setCellValue(phonename);
    	 
    	 w.write(file);
    	 w.close();
    	 
		
		
		
		
	}
	@Test
	public void method2() {
		  String barca = driver.getWindowHandle();
		   Set<String> madrid = driver.getWindowHandles();
		   for (String rm : madrid) {
			   if(!rm.equals(barca)) {
				   driver.switchTo().window(rm);
	    
	}}
		
		
	}
	@Test
	public void method3() throws Exception {
		TakesScreenshot tk = (TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(".//target//cage");
		FileUtils.copyFile(source, des);
	}
	
	
	
	
	
	
}
