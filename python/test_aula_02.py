from appium import webdriver
from appium.webdriver.common.mobileby import MobileBy
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

import pytest 

URL = "http://127.0.0.1:4723/wd/hub"
DESIRE_CAPABILITY  = {
    "deviceName": "emulator-5554",
    "platformName": "Android",
    "appPackage": "com.google.android.calculator",
    "appActivity": "com.android.calculator2.Calculator",
    "automationName": "UiAutomator2"
}
driver = webdriver.Remote(URL, DESIRE_CAPABILITY )
driver.implicitly_wait(5000)
THRESHOLD = 0.0001


def test_soma_int():
    el2 = driver.find_element_by_id("com.google.android.calculator:id/digit_2")
    el2.click()
    el3 = driver.find_element_by_id("com.google.android.calculator:id/digit_3")
    el3.click()
    el4 = driver.find_element_by_id("com.google.android.calculator:id/digit_4")
    el4.click()
    
    plus = driver.find_element_by_accessibility_id("plus")
    plus.click()
    
    el9 = driver.find_element_by_id("com.google.android.calculator:id/digit_9")
    el9.click()
    el8 = driver.find_element_by_id("com.google.android.calculator:id/digit_8")
    el8.click()
    el5 = driver.find_element_by_id("com.google.android.calculator:id/digit_5")
    el5.click()
    
    equals = driver.find_element_by_accessibility_id("equals")
    equals.click()
    
    result = driver.find_element_by_id("com.google.android.calculator:id/result_final")
    
    assert 1219 == int(result.text)


def test_soma_decimal():
    el2 = driver.find_element_by_id("com.google.android.calculator:id/digit_2")
    el2.click()

    el3 = driver.find_element_by_id("com.google.android.calculator:id/digit_3")
    el3.click()
    
    el4 = driver.find_element_by_id("com.google.android.calculator:id/digit_4")
    el4.click()
    
    point = driver.find_element_by_id("com.google.android.calculator:id/dec_point")
    point.click()
    
    el3.click()
    el4.click()
    

    plus = driver.find_element_by_accessibility_id("plus")
    plus.click()


    el9 = driver.find_element_by_id("com.google.android.calculator:id/digit_9")
    el9.click()

    el8 = driver.find_element_by_id("com.google.android.calculator:id/digit_8")
    el8.click()

    el5 = driver.find_element_by_id("com.google.android.calculator:id/digit_5")
    el5.click()

    point.click()

    el5.click()
    el4.click()

    equals = driver.find_element_by_accessibility_id("equals")
    equals.click()

    result = driver.find_element_by_id("com.google.android.calculator:id/result_final")
    assert 1219.88 == pytest.approx(float(result.text),THRESHOLD)


def test_mult_int():
    el2 = driver.find_element_by_id("com.google.android.calculator:id/digit_2")
    el2.click()
    el3 = driver.find_element_by_id("com.google.android.calculator:id/digit_3")
    el3.click()
    el4 = driver.find_element_by_id("com.google.android.calculator:id/digit_4")
    el4.click()

    multiply = driver.find_element_by_accessibility_id("multiply")
    multiply.click()
    
    el9 = driver.find_element_by_id("com.google.android.calculator:id/digit_9")
    el9.click()
    el8 = driver.find_element_by_id("com.google.android.calculator:id/digit_8")
    el8.click()
    el4.click()
    
    multiply.click()
    
    el3.click()
    el2.click()
    el4.click()

    equals = driver.find_element_by_accessibility_id("equals")
    equals.click()
    
    result = driver.find_element_by_id("com.google.android.calculator:id/result_final")
    
    assert 74602944 == int(result.text)

def test_mult_dec():
    #valor 1 = 234.34
    el2 = driver.find_element_by_id("com.google.android.calculator:id/digit_2")
    el2.click()
    el3 = driver.find_element_by_id("com.google.android.calculator:id/digit_3")
    el3.click()
    el4 = driver.find_element_by_id("com.google.android.calculator:id/digit_4")
    el4.click()

    point = driver.find_element_by_id("com.google.android.calculator:id/dec_point")
    point.click()

    el3.click()
    el4.click()

    multiply = driver.find_element_by_accessibility_id("multiply")
    multiply.click()
    
    #valor 2 = 984.12
    el9 = driver.find_element_by_id("com.google.android.calculator:id/digit_9")
    el9.click()
    el8 = driver.find_element_by_id("com.google.android.calculator:id/digit_8")
    el8.click()
    el4.click()
    
    point = driver.find_element_by_id("com.google.android.calculator:id/dec_point")
    point.click()

    el1 = driver.find_element_by_id("com.google.android.calculator:id/digit_1")
    el1.click()
    el2.click()
    

    multiply.click()
    
    #valor 3 = 324;76
    el3.click()
    el2.click()
    el4.click()

    point.click()

    el7 = driver.find_element_by_id("com.google.android.calculator:id/digit_7")
    el7.click()
    el6 = driver.find_element_by_id("com.google.android.calculator:id/digit_6")
    el6.click()
    
    #valor result
    equals = driver.find_element_by_accessibility_id("equals")
    equals.click()
    
    result = driver.find_element_by_id("com.google.android.calculator:id/result_final")
    
    assert 74895722.776608‬ == pytest.approx(float(result.text),THRESHOLD)
