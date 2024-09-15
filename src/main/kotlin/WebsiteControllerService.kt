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


    fun clickViaCoordinates(xCoordinate: Int, yCoordinate: Int) {
        val actions = Actions(driver)
        actions.moveByOffset(xCoordinate, yCoordinate).click().perform()

    }

    fun getWait() = wait


}