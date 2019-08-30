package appium.java.aulas;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class Aula3 {
  
	public AndroidDriver<MobileElement> driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	public String device = "http://127.0.0.1:4723/wd/hub";

	  @BeforeSuite
	  public void setup() throws MalformedURLException {
			cap.setCapability("deviceName","emulator-5554");
			cap.setCapability("platformName","Android");
			cap.setCapability("appPackage","com.google.android.youtube");
			cap.setCapability("appActivity", "com.google.android.youtube.HomeActivity");
			cap.setCapability("automationName", "UiAutomator2");
			
			driver = new AndroidDriver<MobileElement>(new URL(device),cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("App iniciou\n Começando testes...\n");
		}
	
	@Test(priority =0)
  public void testeBuscarProjetoHefesto() {
		System.out.println("teste 1 ..");
		MobileElement pesquisa = (MobileElement) driver.findElementByAccessibilityId("Search");
		pesquisa.click();
		MobileElement texto = (MobileElement) driver.findElementById("com.google.android.youtube:id/search_edit_text");
		texto.sendKeys("Projeto Hefesto");
		MobileElement lupa = (MobileElement) driver.findElementById("com.google.android.youtube:id/search_type_icon");
		lupa.click();		
  }

	@Test(priority = 1 )
	  public void testeOrdenarbuscarProjetoHefesto() {
			System.out.println("teste 2  ..");
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.youtube:id/menu_filter_results"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.youtube:id/spinner_0"))).click();
			
			MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]");
			el6.click();
			MobileElement el7 = (MobileElement) driver.findElementById("com.google.android.youtube:id/apply");
			el7.click();

	  }
	@Test(priority = 2)
	public void testeCompartilharVideoPorEmail() {
		System.out.println("teste 3  ..");

		MobileElement el8 = (MobileElement) driver.findElementById("com.google.android.youtube:id/channel_name");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("Menu");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]"));
		el10.click();
		
	}

	@Test(priority = 3)
	public void testeDefinirDestinatarioAssunto() {

		System.out.println("teste 4  ..");
		MobileElement el6 = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.google.android.youtube:id/title') and @text='Gmail']"));
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.google.android.gm:id/to");
		el7.sendKeys("br-leandro@hotmail.com");
		MobileElement el8 = (MobileElement) driver.findElementById("com.google.android.gm:id/subject");
		el8.clear();
		el8.sendKeys("Olá, assista essa aula, pode ajudar com suas dúvidas..");
		
	}
	@Test(priority = 4)
	public void testeEnviarEmail() {

		System.out.println("teste 5  ..");
		MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("Send");
		el9.click();
	}
}
