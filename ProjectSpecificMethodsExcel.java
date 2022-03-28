package week5.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

		public class ProjectSpecificMethodsExcel  
		{
			public ChromeDriver driver;
			public String excelFilePath;
					
			@BeforeMethod
			public void beforeMethod()
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			
				//Launch URL
			
				driver.get("http://leaftaps.com/opentaps/control/main");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
			}
			
			@AfterMethod
			public void afterMethod()
			{
				driver.close();
			}
			
			@DataProvider(name = "Dynamic_Data")
			public String[][] testData() throws IOException
			{
				String[][] data = ReadExcel.getData(excelFilePath);
				return data;
				
			}
			

			
		
		}


