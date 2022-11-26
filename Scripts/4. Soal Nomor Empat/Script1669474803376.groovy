import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import groovy.json.JsonBuilder as JsonBuilder
import groovy.json.JsonOutput as JsonOutput
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

TestData excelData = findTestData('Data Files/Test Data')

for(int i = 1; i <= excelData.getRowNumbers(); i++) {
	'Start Process'
	WS.comment('Start Process')

RequestObject objectRepo = findTestObject('Object Repository/API/GET',
	[
		('numberOfData') : excelData.getValue('Number Of Data', i)
	])

ResponseObject objectResp = WS.sendRequestAndVerify(objectRepo, FailureHandling.STOP_ON_FAILURE)

def jsonSlurper = new JsonSlurper()
def parsedJson_count = jsonSlurper.parseText(objectResp.getResponseText())
def expectedSize = parsedJson_count.size()

KeywordUtil.logInfo("Amount of Data: " + expectedSize)

CustomKeywords.'apiKeyword.apiValidation.verifyAmountOfData'(expectedSize, excelData.getValue('Number Of Data', i).toInteger())

CustomKeywords.'apiKeyword.apiValidation.verifyAPIResponse'(objectResp)

'End Process'
WS.comment('End Process')
}
