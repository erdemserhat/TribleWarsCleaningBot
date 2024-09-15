package com.erdemserhat

import kotlinx.coroutines.delay
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions

class TribleWarsBotController(
    private val websiteControllerService: WebsiteControllerService
) {
    private val wait = websiteControllerService.getWait()

    fun goToWorld(){
        val xCoordinate = 0
        val yCoordinate = 0
        websiteControllerService.clickViaCoordinates(xCoordinate,yCoordinate)
    }

    fun goToAssemblyArea(){
        val xCoordinate = 0
        val yCoordinate = 0
        websiteControllerService.clickViaCoordinates(xCoordinate,yCoordinate)


    }
    fun goToCleaning(){
        val xCoordinate = 0
        val yCoordinate = 0
        websiteControllerService.clickViaCoordinates(xCoordinate,yCoordinate)

    }

    fun fillArmyAmount(army:Army){
        val inputFieldSpear: WebElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='spear']")))
        val inputFieldSword: WebElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='sword']")))
        val inputFieldAxe: WebElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='axe']")))
        val inputFieldLight: WebElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='light']")))
        val inputFieldHeavy: WebElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='heavy']")))
        val inputFieldKnight: WebElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='knight']")))

        inputFieldSpear.sendKeys(army.spear.toString())
        inputFieldSword.sendKeys(army.sword.toString())
        inputFieldAxe.sendKeys(army.axe.toString())
        inputFieldLight.sendKeys(army.light.toString())
        inputFieldHeavy.sendKeys(army.heavy.toString())
        inputFieldKnight.sendKeys(army.knight.toString())

    }
    fun fillArmyAmountSingleSpear(sword:Int){
        val inputFieldSpear: WebElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='spear']")))

        inputFieldSpear.sendKeys(sword.toString())

    }

    fun closeAdsPopUpIfExists(){
        val closeButton: WebElement? = try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.popup_box_close.tooltip-delayed")))
        } catch (e: Exception) {
            null
        }

        closeButton?.click()
    }

    fun login(){

        //username text field
        val usernameTF = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("user"))
        )
        val passwordTF = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("password"))
        )

        //password text field
        usernameTF.sendKeys("exampleUserName")
        passwordTF.sendKeys("examplePassword")


        //Wait the button visibility
        val button: WebElement = wait.until(
            ExpectedConditions.elementToBeClickable(By.className("btn-login"))
        )

        button.click()


    }

    fun goToMainPage(){
        websiteControllerService.goToLink("https://www.klanlar.org/")
    }




    fun startWithBigCollectors(){
        val xCoordinate = 0
        val yCoordinate = 0
        websiteControllerService.clickViaCoordinates(xCoordinate,yCoordinate)
    }

    fun startWithCleverCollectors(){
        val xCoordinate = 0
        val yCoordinate = 0
        websiteControllerService.clickViaCoordinates(xCoordinate,yCoordinate)
    }

    fun startWithModestCollectors(){
        val xCoordinate = 0
        val yCoordinate = 0
        websiteControllerService.clickViaCoordinates(xCoordinate,yCoordinate)
    }

    fun startWithLazyCollectors(){
        val xCoordinate = 0
        val yCoordinate = 0
        websiteControllerService.clickViaCoordinates(xCoordinate,yCoordinate)
    }

    suspend fun waitForComplementation(hour:Int,minute:Int,second:Int){
        val totalMillis = hour*60*60*1000 + minute*60*1000 + second*1000
        delay(totalMillis.toLong())

    }

}