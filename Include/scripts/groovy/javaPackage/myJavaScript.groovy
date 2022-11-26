package javaPackage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class myJavaScript {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User go to (.*)")
	def user_go_to_site(String site) {
		WebUI.openBrowser(site)
		WebUI.maximizeWindow()
	}

	@When("User in 'select menu' page")
	def user_in_selectMenu_page() {
		System.out.println("User in 'select menu' page")
	}

	@And("User choose select value (.*)")
	def user_choose_select_value_another_root_option(String selectValue) {
		WebUI.click(findTestObject('Object Repository/01. Select Menu/05_button_selectValue'))
		WebUI.setText(findTestObject('Object Repository/01. Select Menu/17_inputText_selectValue'), selectValue)
		WebUI.click(findTestObject('Object Repository/01. Select Menu/04_select_menus'))
	}
	
	@And("User choose select one (.*)")
	def user_choose_select_one_other(String selectOne) {
		WebUI.click(findTestObject('Object Repository/01. Select Menu/06_button_selectOne'))
		WebUI.setText(findTestObject('Object Repository/01. Select Menu/18_inputText_selectOne'), selectOne)
		WebUI.click(findTestObject('Object Repository/01. Select Menu/07_selectMenu_selectOne'))
	}
	
	@And("User choose old style select menu (.*)")
	def user_choose_old_style_select_menu_aqua(String oldStyleSelectMenu) {
		WebUI.selectOptionByLabel(findTestObject('Object Repository/01. Select Menu/08_select_oldStyleSelectMenu'), oldStyleSelectMenu, false)
	}
	
	@And("User choose multi select drop down 'all color'")
	def user_choose_multi_select_drop_down_all_color() {
		WebUI.click(findTestObject('Object Repository/01. Select Menu/09_button_multiSelect_dropDown'))
		while(WebUI.verifyElementPresent(findTestObject('Object Repository/01. Select Menu/10_selectMenu_multiSelectDropDown'), 2, FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/01. Select Menu/11_option_color'))
		}
	}
	
	@Then('User success input all select menu')
	def user_success_input_all_select_menu() {
		System.out.println('User success input all select menu')
	}
	
}