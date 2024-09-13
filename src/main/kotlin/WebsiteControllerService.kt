package com.erdemserhat

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class WebsiteControllerService(private val driver: WebDriver) {
    private val wait = WebDriverWait(driver, Duration.ofSeconds(20))

    fun goToLink(theLink: String) {
        driver.get(theLink)

    }

    fun goToWorld(){
        val spanElement: WebElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.className("world_button_active"))
        )

        spanElement.click()
    }

    private fun clickViaCoordinates(xCoordinate:Int,yCoordinate:Int){
        val actions = Actions(driver)
        actions.moveByOffset(xCoordinate, yCoordinate).click().perform()

    }

    fun goToAssemblyArea(){
        clickViaCoordinates(755,447)


    }
    fun goToCleaning(){
        clickViaCoordinates(593 ,240)

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









}