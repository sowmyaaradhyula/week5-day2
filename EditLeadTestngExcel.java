package week5.day2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLeadTestngExcel extends ProjectSpecificMethodsExcel
{
	
		@BeforeTest
		public void setData()
		{
			excelFilePath = "./testdata/tc004.xlsx";
		}
		@Test(dataProvider = "Dynamic_Data")
		public void tc04(String username, String password, String phone) throws InterruptedException  
		{
				
				//Login
				driver.findElement(By.id("username")).sendKeys(username);
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.className("decorativeSubmit")).click();
				driver.findElement(By.linkText("CRM/SFA")).click();
			
				driver.findElement(By.linkText("Leads")).click();
				driver.findElement(By.linkText("Find Leads")).click();
				driver.findElement(By.xpath("//span[text()='Phone']")).click();
				driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phone);
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
				driver.findElement(By.linkText("Edit")).click();
				driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
				driver.findElement(By.name("submitButton")).click();
				
		}
}
