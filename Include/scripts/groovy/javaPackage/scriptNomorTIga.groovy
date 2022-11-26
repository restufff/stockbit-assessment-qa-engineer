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



class scriptNomorTIga {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Users go into (.*)")
	def users_go_to_web(String web) {
		WebUI.openBrowser(web)
		WebUI.maximizeWindow()
	}

	@When("Users in 'Book Store' page")
	def users_in_book_store_page() {
		System.out.println("User in 'Book Store' page")
	}

	@And("Users search book 'Git Pocket Guide' (.*)")
	def user_search_book_git_pcoket_guide(String book) {
		WebUI.setText(findTestObject('Object Repository/02. Books/01_inputText_books'), book)
		WebUI.click(findTestObject('Object Repository/02. Books/02_button_search'))
	}

	@And("User click book 'Git Pocket Guide'")
	def user_click_book_git_pocket_guide() {
		WebUI.click(findTestObject('Object Repository/02. Books/04_button_titleBook'))
	}

	@Then("User see 'Git Pocket Guide'")
	def user_see_git_pocket_guide() {
		String textIsbn = WebUI.getText(findTestObject('Object Repository/02. Books/05_text_isbn'))
		String textTitle = WebUI.getText(findTestObject('Object Repository/02. Books/06_text_title'))
		String textSubTitle = WebUI.getText(findTestObject('Object Repository/02. Books/07_text_subTitle'))
		String textAuthor = WebUI.getText(findTestObject('Object Repository/02. Books/08_text_author'))
		String textPublisher = WebUI.getText(findTestObject('Object Repository/02. Books/09_text_publisher'))
		String textTotalPages = WebUI.getText(findTestObject('Object Repository/02. Books/10_text_totalPages'))
		String textDescription = WebUI.getText(findTestObject('Object Repository/02. Books/11_text_description'))
		String textWebsite = WebUI.getText(findTestObject('Object Repository/02. Books/12_text_website'))

		KeywordUtil.logInfo("Book Information:")
		KeywordUtil.logInfo("ISBN		: "+textIsbn)
		KeywordUtil.logInfo("Title		: "+textTitle)
		KeywordUtil.logInfo("Sub Title	: "+textSubTitle)
		KeywordUtil.logInfo("Author		: "+textAuthor)
		KeywordUtil.logInfo("Publisher	: "+textPublisher)
		KeywordUtil.logInfo("Total Pages: "+textTotalPages)
		KeywordUtil.logInfo("Description: "+textDescription)
		KeywordUtil.logInfo("Website	: "+textWebsite)
	}
}