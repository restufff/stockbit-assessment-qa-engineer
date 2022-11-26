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



class scriptNomorDua {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Users Go to web (.*)")
	def users_go_to_web(String web) {
		WebUI.openBrowser(web)
		WebUI.maximizeWindow()
	}

	@When("User in 'Book Store' page")
	def user_in_book_store_page() {
		System.out.println("User in 'Book Store' page")
	}

	@And("User search book (.*)")
	def user_search_book_qa_engineer(String book) {
		WebUI.setText(findTestObject('Object Repository/02. Books/01_inputText_books'), book)
		WebUI.click(findTestObject('Object Repository/02. Books/02_button_search'))
	}

	@Then("User see 'No rows found'")
	def user_see_no_rows_found() {
		String textSearchResult = WebUI.getText(findTestObject('Object Repository/02. Books/03_text_noRowsFound'))
		System.out.println(textSearchResult)
		if(WebUI.verifyMatch(textSearchResult, 'No rows found', false)) {
			KeywordUtil.markPassed('No rows found')
		} else {
			KeywordUtil.markFailedAndStop('Book Found')
		}
	}
}