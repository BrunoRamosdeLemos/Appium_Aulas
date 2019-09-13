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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class MultDevices {
	private static AndroidDriver<MobileElement> driver;
  
  @Parameters({"deviceName_","UDID_","URL_","systemPort_"})
  @BeforeMethod
  public void beforeMethod(String deviceName_, String UDID_, String URL_, String systemPort_) throws MalformedURLException, InterruptedException {
	  DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName",deviceName_);
		cap.setCapability("platformName","Android");
		cap.setCapability("udid", UDID_);
		cap.setCapability("systemPort", systemPort_);
		cap.setCapability("appPackage","com.google.android.calendar");
		cap.setCapability("appActivity", "com.android.calendar.LaunchActivity");
		cap.setCapability("automationName", "UiAutomator2");
	  
		driver = new AndroidDriver<MobileElement>(new URL("http://" + URL_), cap);
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		Thread.sleep(10000);
		System.out.println("App iniciou\n Começando testes...\n");
  }
  
  
  @Test(priority = 0)
  public void criarEventoTest() {
		System.out.println("teste 1...\n");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calendar:id/right_arrow_touch"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calendar:id/right_arrow"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calendar:id/done_button"))).click();
		System.out.println("fim ...\n");
	  
  }

}
