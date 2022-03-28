package week5.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLeadTestngExcel extends ProjectSpecificMethodsExcel   
{
				
		
				@BeforeTest
				public void setData()
				{
					excelFilePath = "./testdata/tc001.xlsx";
				}
				@Test(dataProvider = "Dynamic_Data")
				public void	tc01(String username, String password, String companyName, String firstName, String lastName)
				{
					//Login
					driver.findElement(By.id("username")).sendKeys(username);
					driver.findElement(By.id("password")).sendKeys(password);
					driver.findElement(By.className("decorativeSubmit")).click();
					driver.findElement(By.linkText("CRM/SFA")).click();
					
					//Create Lead
					driver.findElement(By.linkText("Leads")).click();
					driver.findElement(By.linkText("Create Lead")).click();
					driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
					driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
					driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
					driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("aaa");
					driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("bbb");
					driver.findElement(By.id("createLeadForm_description")).sendKeys("ccc");
					driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("1234567890");
					driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abcdefghi@gmail.com");
					WebElement elementStateProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
					Select 	dd = new Select(elementStateProvince);
					dd.selectByVisibleText("New York");
					driver.findElement(By.className("smallSubmit")).click();		
					System.out.println(driver.getTitle());
				
				
				}
			

	}
