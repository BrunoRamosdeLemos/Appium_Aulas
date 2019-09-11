package appium.java.aulas;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class Aula6 {
	public AndroidDriver<MobileElement> driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	public String device = "http://127.0.0.1:4723/wd/hub";
	
	  @BeforeTest
	  public void setup() throws MalformedURLException {
			cap.setCapability("deviceName","emulator-5554");
			cap.setCapability("platformName","Android");
			cap.setCapability("appPackage","com.google.android.calendar");
			cap.setCapability("appActivity", "com.android.calendar.LaunchActivity");
			cap.setCapability("automationName", "UiAutomator2");
			
			driver = new AndroidDriver<MobileElement>(new URL(device),cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.hideKeyboard();
			

			MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calendar:id/right_arrow_touch");
			el1.click();
			MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("next page");
			el2.click();
			MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.calendar:id/done_button");
			el3.click();
			
			System.out.println("App iniciou\n Começando testes...\n");
		}
	  
	  @Test(priority = 0)
	  public void criarEventoTest() {
			System.out.println("teste 1...\n");
			//criando evento
			MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Jump to Today");
			el4.click();
			MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Create new event and more");
			el5.click();
			MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("Create new event and more");
			el6.click();
			MobileElement el7 = (MobileElement) driver.findElementById("com.google.android.calendar:id/title_edit_text");
			el7.sendKeys("Concluir exercício de Appium hoje!!");
			
			//adicionando localização
			MobileElement el14 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Location\"]/android.widget.LinearLayout");
			el14.click();
			MobileElement el15 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
			el15.click();
			//pesquisa est
			MobileElement el18 = (MobileElement) driver.findElementById("com.google.android.calendar:id/search_field");
			el18.sendKeys("est uea");
			MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.Button[1]/android.widget.LinearLayout");
			el19.click();
			
			
			//notificação 2 horas antes
			MobileElement el_4 = (MobileElement) driver.findElementById("com.google.android.calendar:id/icon");
			el_4.click();
			MobileElement el_5 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Calendar Notifications\"]/android.widget.LinearLayout/android.widget.Button/android.widget.LinearLayout/android.widget.TextView");
			el_5.click();
			MobileElement el_6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView");
			el_6.click();
			MobileElement el_7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.RadioButton");
			el_7.click();
			MobileElement e_l8 = (MobileElement) driver.findElementById("com.google.android.calendar:id/interval");
			e_l8.clear();
			e_l8.sendKeys("2");
			MobileElement el9 = (MobileElement) driver.findElementById("com.google.android.calendar:id/done");
			el9.click();

			//salva evento
			MobileElement el20 = (MobileElement) driver.findElementById("com.google.android.calendar:id/save");
			el20.click();

		  
	  }
	  @Test(priority = 1)
	  public void ScreenshotTest() throws InterruptedException, IOException{
			System.out.println("teste 2...\n");
			Thread.sleep(2000);
			SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			Date date = new Date();
			String filename = sdf.format(date);
			File des = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(des,new File(System.getProperty("user.dir") +"//Screenshot//" + filename + ".png"));
		  
	  }

}
