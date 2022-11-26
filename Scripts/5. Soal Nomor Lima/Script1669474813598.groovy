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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

RequestObject objectRepo = findTestObject('Object Repository/API/Punk API')

ResponseObject objectResp = WS.sendRequest(objectRepo, FailureHandling.OPTIONAL)

def jsonSlurper = new JsonSlurper()
def parsedJson_count = jsonSlurper.parseText(objectResp.getResponseText())
def expectedSize = parsedJson_count.size()
def nameSize = parsedJson_count.name

KeywordUtil.logInfo("Amount of Data: " + expectedSize)

System.out.println(nameSize)

KeywordUtil.logInfo('Nama: '+nameSize) 

String jsonSchema =
"""
{
  "\$schema": "http://json-schema.org/draft-04/schema#",
  "type": "array",
  "items": {
    "type": "object",
    "properties": {
      "id": {
        "type": "integer"
      },
      "name": {
        "type": "string"
      },
      "tagline": {
        "type": "string"
      },
      "first_brewed": {
        "type": "string"
      },
      "description": {
        "type": "string"
      },
      "image_url": {
        "type": "string"
      },
      "abv": {
        "type": [
          "number",
          "integer"
        ]
      },
      "ibu": {
        "type": [
          "integer",
          "number",
          "null"
        ]
      },
      "target_fg": {
        "type": "integer",
        "enum": [
          1010,
          1007,
          1012,
          1027,
          1005,
          1017,
          1020,
          1013,
          1025,
          1014,
          1030,
          1000
        ]
      },
      "target_og": {
        "type": [
          "integer",
          "number"
        ]
      },
      "ebc": {
        "type": [
          "integer",
          "null"
        ]
      },
      "srm": {
        "type": [
          "integer",
          "number",
          "null"
        ]
      },
      "ph": {
        "type": [
          "number",
          "null",
          "integer"
        ]
      },
      "attenuation_level": {
        "type": [
          "integer",
          "number"
        ]
      },
      "volume": {
        "type": "object",
        "properties": {
          "value": {
            "type": "integer",
            "enum": [
              20
            ]
          },
          "unit": {
            "type": "string",
            "enum": [
              "litres"
            ]
          }
        },
        "required": [
          "value",
          "unit"
        ]
      },
      "boil_volume": {
        "type": "object",
        "properties": {
          "value": {
            "type": "integer",
            "enum": [
              25
            ]
          },
          "unit": {
            "type": "string",
            "enum": [
              "litres"
            ]
          }
        },
        "required": [
          "value",
          "unit"
        ]
      },
      "method": {
        "type": "object",
        "properties": {
          "mash_temp": {
            "type": "array",
            "items": {
              "type": "object",
              "properties": {
                "temp": {
                  "type": "object",
                  "properties": {
                    "value": {
                      "type": "integer",
                      "enum": [
                        64,
                        69,
                        60,
                        65,
                        72,
                        78,
                        66,
                        67,
                        68
                      ]
                    },
                    "unit": {
                      "type": "string",
                      "enum": [
                        "celsius"
                      ]
                    }
                  },
                  "required": [
                    "value",
                    "unit"
                  ]
                },
                "duration": {
                  "type": [
                    "integer",
                    "null"
                  ]
                }
              },
              "required": [
                "temp",
                "duration"
              ]
            }
          },
          "fermentation": {
            "type": "object",
            "properties": {
              "temp": {
                "type": "object",
                "properties": {
                  "value": {
                    "type": "integer",
                    "enum": [
                      19,
                      18,
                      21,
                      9,
                      10,
                      22,
                      11,
                      17,
                      20
                    ]
                  },
                  "unit": {
                    "type": "string",
                    "enum": [
                      "celsius"
                    ]
                  }
                },
                "required": [
                  "value",
                  "unit"
                ]
              }
            },
            "required": [
              "temp"
            ]
          },
          "twist": {
            "type": [
              "null",
              "string"
            ]
          }
        },
        "required": [
          "mash_temp",
          "fermentation",
          "twist"
        ]
      },
      "ingredients": {
        "type": "object",
        "properties": {
          "malt": {
            "type": "array",
            "items": {
              "type": "object",
              "properties": {
                "name": {
                  "type": "string",
                  "enum": [
                    "Maris Otter Extra Pale",
                    "Caramalt",
                    "Munich",
                    "Propino Pale Malt",
                    "Wheat Malt",
                    "Propino Pale Malt for kettle souring",
                    "Acidulated Malt for kettle souring",
                    "Extra Pale",
                    "Dark Crystal",
                    "Lager Malt",
                    "Wheat",
                    "Chocolate",
                    "Carafa Special Malt Type 3",
                    "Acidulated Malt",
                    "Flaked Oats",
                    "Crystal",
                    "Peated Malt",
                    "Amber",
                    "Brown",
                    "Crystal 150",
                    "Pale Ale",
                    "Smoked Weyermann",
                    "Carafa Special Malt Type 1",
                    "Dark Crystal 350-400",
                    "Pale Ale - Tipple",
                    "Extra Pale - Spring Blend",
                    "Roasted Barley",
                    "Smoked Malt"
                  ]
                },
                "amount": {
                  "type": "object",
                  "properties": {
                    "value": {
                      "type": [
                        "number",
                        "integer"
                      ]
                    },
                    "unit": {
                      "type": "string",
                      "enum": [
                        "kilograms"
                      ]
                    }
                  },
                  "required": [
                    "value",
                    "unit"
                  ]
                }
              },
              "required": [
                "name",
                "amount"
              ]
            }
          },
          "hops": {
            "type": "array",
            "items": {
              "type": "object",
              "properties": {
                "name": {
                  "type": "string",
                  "enum": [
                    "Fuggles",
                    "First Gold",
                    "Cascade",
                    "Amarillo",
                    "Simcoe",
                    "Motueka",
                    "Bramling Cross",
                    "Centennial",
                    "Saaz",
                    "Nelson Sauvin",
                    "Peppercorns",
                    "Tomahawk",
                    "Magnum",
                    "Hersbrucker",
                    "Honey",
                    "Lactose",
                    "Citra",
                    "Columbus Extract",
                    "Columbus",
                    "Willamette",
                    "Galena",
                    "Hop Extract",
                    "Chinook",
                    "Mt.Hood",
                    "Challenger",
                    "Waimea",
                    "Ahtanum",
                    "Crystal",
                    "Sorachi Ace"
                  ]
                },
                "amount": {
                  "type": "object",
                  "properties": {
                    "value": {
                      "type": [
                        "integer",
                        "number"
                      ]
                    },
                    "unit": {
                      "type": "string",
                      "enum": [
                        "grams"
                      ]
                    }
                  },
                  "required": [
                    "value",
                    "unit"
                  ]
                },
                "add": {
                  "type": "string",
                  "enum": [
                    "start",
                    "middle",
                    "end",
                    "dry hop"
                  ]
                },
                "attribute": {
                  "type": "string",
                  "enum": [
                    "bitter",
                    "flavour",
                    "aroma",
                    "Flavour"
                  ]
                }
              },
              "required": [
                "name",
                "amount",
                "add",
                "attribute"
              ]
            }
          },
          "yeast": {
            "type": "string",
            "enum": [
              "Wyeast 1056 - American Ale™",
              "Wyeast 2007 - Pilsen Lager™",
              "Wyeast 3711 - French Saison™",
              "Wyeast 3522 - Belgian Ardennes™",
              "Saflager S189",
              "Wyeast 1272 - American Ale II™",
              "Wyeast 3333 - German Wheat™",
              "Wyeast 3638 - Bavarian Wheat™"
            ]
          }
        },
        "required": [
          "malt",
          "hops",
          "yeast"
        ]
      },
      "food_pairing": {
        "type": "array",
        "items": {
          "type": "string"
        }
      },
      "brewers_tips": {
        "type": "string"
      },
      "contributed_by": {
        "type": "string",
        "enum": [
          "Sam Mason <samjbmason>",
          "Ali Skinner <AliSkinner>"
        ]
      }
    },
    "required": [
      "id",
      "name",
      "tagline",
      "first_brewed",
      "description",
      "image_url",
      "abv",
      "ibu",
      "target_fg",
      "target_og",
      "ebc",
      "srm",
      "ph",
      "attenuation_level",
      "volume",
      "boil_volume",
      "method",
      "ingredients",
      "food_pairing",
      "brewers_tips",
      "contributed_by"
    ]
  }
}
"""

boolean successful = WS.validateJsonAgainstSchema(objectResp,jsonSchema)

KeywordUtil.logInfo('JsonSchema: '+successful)