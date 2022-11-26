package apiKeyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper

import internal.GlobalVariable

public class apiValidation {

	@Keyword
	def verifyAPIResponse (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		if (jsonResp.id != null) {
			KeywordUtil.logInfo("API Pass")
		}
		else {
			KeywordUtil.markFailed("API Failed 400")
		}
	}

	@Keyword
	def verifyAmountOfData (Integer actualAmountOfData, Integer expectedAmountOfData) {
		if (actualAmountOfData == expectedAmountOfData) {
			KeywordUtil.markPassed('Passed, Amount of Data is '+expectedAmountOfData+'. Expected with Amount Of Data')
		} else {
			KeywordUtil.markFailedAndStop('Failed, Amount of Data is '+expectedAmountOfData+'. Not Expected with Amount Of Data')
		}
	}
}
