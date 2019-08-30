package appium.java.aulas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Aula4 {
	
	public AndroidDriver<MobileElement> driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	public String device = "http://127.0.0.1:4723/wd/hub";

  @BeforeTest
  public void setup() throws MalformedURLException {
		cap.setCapability("deviceName","emulator-5554");
		cap.setCapability("platformName","Android");
		cap.setCapability("appPackage","com.mobeta.android.demodslv");
		cap.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		cap.setCapability("automationName", "UiAutomator2");
		
		driver = new AndroidDriver<MobileElement>(new URL(device),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("App iniciou\n Começando testes...\n");
	}
  
  @Test
  public void movimentsDragAndDrop() {
	  MobileElement el1 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");
	  el1.click();
	  MobileElement el2 = (MobileElement) driver.findElementById("android:id/button1");
	  el2.click();
	  MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView[1]");
	  el3.click();

	  
	  WebElement ele1 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(2);
	  WebElement ele2 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(7);
	  
	  Actions action = new Actions(driver);
	  action.dragAndDrop(ele1, ele2).perform();
  }
  

  @Test
  public void movimentsScroll() {
	  MobileElement ele1 =  driver.findElementsById("com.mobeta.android.demodslv:id/text").get(3);
	  Actions action = new Actions(driver);
	  action.clickAndHold(ele1).moveByOffset(10, 5000).perform();
  }

}
