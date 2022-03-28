package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLeadTestngExcel extends ProjectSpecificMethodsExcel  
{
		@BeforeTest
		public void setData()
		{
			excelFilePath = "./testdata/tc002.xlsx";
		}
		@Test(dataProvider = "Dynamic_Data")
		public void tc002(String username, String password, String phone) throws InterruptedException
		{
			
			//Login
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			//Find a lead			
			driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
			driver.findElement(By.xpath("//input[@name = 'phoneNumber']")).sendKeys(phone);
			driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
			Thread.sleep(3000);
			
			//click on First Resulting Lead
			
			WebElement text = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
			String deleteLeadId = text.getText();
			System.out.println(deleteLeadId);
			text.click();
			
			//Deleting the lead
			
			driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
			
			//Searching with the id of the deleted lead
			driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
			driver.findElement(By.xpath("//label[contains(text(),'Lead ID:')]/following::input[@name = 'id']")).sendKeys(deleteLeadId);
			driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
			Thread.sleep(1000);
			
			//Displaying the result 
			
			WebElement result = driver.findElement(By.xpath("//div[@class = 'x-toolbar x-small-editor']//div"));	
			String resultText = result.getText();
			System.out.println(resultText);
			
	
	
	}
    
}

