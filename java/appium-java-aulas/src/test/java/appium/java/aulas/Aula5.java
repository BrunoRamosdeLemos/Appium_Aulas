package appium.java.aulas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Aula5 {
	public AndroidDriver<MobileElement> driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	public String device = "http://127.0.0.1:4723/wd/hub";

	  @BeforeTest
	  public void setup() throws MalformedURLException {
			cap.setCapability("deviceName","8CQX1SAPW");
			cap.setCapability("platformName","Android");
			cap.setCapability("appPackage","com.google.android.GoogleCamera");
			cap.setCapability("appActivity", "com.android.camera.CameraLauncher");
			cap.setCapability("automationName", "UiAutomator2");
			
			driver = new AndroidDriver<MobileElement>(new URL(device),cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("App iniciou\n Começando testes...\n");
		}
  @Test(priority = 0)
  public void abrirTirarSelfieCameraTest() {
	  MobileElement el1 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
	  el1.click();
	  MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Alternar para a câmera frontal");
	  el2.click();
	  MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Tirar foto");
	  el3.click();
  }

  @Test(priority = 1)
  public void aplicarfiltroCameraTest() {
	  MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Galeria de fotos");
	  el5.click();
	  MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("Editar");
	  el6.click();
	  MobileElement el7 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"filtro West\"]/android.widget.FrameLayout/android.widget.ImageView");
	  el7.click();
	  MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("Salvar edições");
	  el9.click();
  }
  @Test(priority = 2)
  public void compartilharCameraTest() {
	  MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Compartilhar");
	  el4.click();
	  MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'com.google.android.apps.photos:id/text') and @text='Gmail']");
	  el5.click();
	  MobileElement el6 = (MobileElement) driver.findElementById("com.google.android.gm:id/to");
	  el6.sendKeys("br-leandro@hotmail.com");
	  MobileElement el7 = (MobileElement) driver.findElementById("com.google.android.gm:id/subject");
	  el7.sendKeys("teste selfie appium");
	  MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("Enviar");
	  el8.click();

  }

}
