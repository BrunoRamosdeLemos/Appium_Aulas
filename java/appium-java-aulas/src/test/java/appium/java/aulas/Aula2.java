package appium.java.aulas;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class Aula2 {
	
	AppiumDriver<MobileElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	String device = "http://127.0.0.1:4723/wd/hub";
	
	final double THRESHOLD = .0001;
	
	@BeforeSuite
	public void setup() throws MalformedURLException {
		cap.setCapability("deviceName","emulator-5554");
		cap.setCapability("platformName","Android");
		cap.setCapability("appPackage","com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability("automationName", "UiAutomator2");
		
		driver = new AppiumDriver<MobileElement>(new URL(device),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("App iniciou\n Começando testes...\n");
	}
	
  @Test
  public void testSomaInt() {
		MobileElement el2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
		el2.click();
		MobileElement el3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
		el3.click();
		MobileElement el4 = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
		el4.click();
		
		MobileElement plus = driver.findElementByAccessibilityId("plus");
		plus.click();

		MobileElement el9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
		el9.click();
		MobileElement el8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
		el8.click();
		MobileElement el5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		el5.click();
		
		MobileElement equals = driver.findElementByAccessibilityId("equals");
		equals.click();

		MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		
		Assert.assertTrue(Integer.valueOf(result.getText()).equals(1219));
	}
  @Test
  public void testSomaDecimal() {
		MobileElement el2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
		el2.click();
		MobileElement el3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
		el3.click();
		MobileElement el4 = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
		el4.click();
		
		MobileElement point = driver.findElement(By.id("com.google.android.calculator:id/dec_point"));
		point.click();
		
		el3.click();
		el4.click();
		
		MobileElement plus = driver.findElementByAccessibilityId("plus");
		plus.click();

		MobileElement el9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
		el9.click();
		MobileElement el8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
		el8.click();
		MobileElement el5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		el5.click();
		
		point.click();
		
		el5.click();
		el4.click();
		
		MobileElement equals = driver.findElementByAccessibilityId("equals");
		equals.click();

		MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		
		Assert.assertTrue(
				Math.abs(Float.valueOf(result.getText()) - 1219.88) < THRESHOLD
				);
	}
  
  @Test
  public void testMulSoma() {
		MobileElement el2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
		el2.click();
		MobileElement el3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
		el3.click();
		MobileElement el4 = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
		el4.click();
		
		MobileElement multiply = driver.findElementByAccessibilityId("multiply");
		multiply.click();
		
		MobileElement el9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
		el9.click();
		MobileElement el8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
		el8.click();
		el4.click();
		
		multiply.click();
		
		el3.click();
		el2.click();
		el4.click();
		
		MobileElement equals = driver.findElementByAccessibilityId("equals");
		equals.click();

		MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		
		Assert.assertTrue(Integer.valueOf(result.getText()).equals(74602944));
		
  } 
  
  @Test
  public void testMulDecimal() {
	  
		MobileElement el2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
		el2.click();
		MobileElement el3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
		el3.click();
		MobileElement el4 = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
		el4.click();
		
		MobileElement point = driver.findElement(By.id("com.google.android.calculator:id/dec_point"));
		point.click();
		
		el3.click();
		el4.click();
		
		MobileElement multiply = driver.findElementByAccessibilityId("multiply");
		multiply.click();
		
		MobileElement el9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
		el9.click();
		MobileElement el8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
		el8.click();
		el4.click();
		
		point.click();
		
		MobileElement el1 = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
		el1.click();
		el2.click();
		
		multiply.click();
		
		el3.click();
		el2.click();
		el4.click();
		
		point.click();
		
		MobileElement el7 = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
		el7.click();
		MobileElement el6 = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
		el6.click();
		
		MobileElement equals = driver.findElementByAccessibilityId("equals");
		equals.click();
		
		MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		
		Assert.assertTrue(Math.abs(Double.valueOf(result.getText())- 74895722.776608) < THRESHOLD);
		
  }
}



