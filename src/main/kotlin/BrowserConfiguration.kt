package com.erdemserhat

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

class BrowserConfiguration {

    //Specify the profile path which will be used in operations...
    //// THIS VALUE IS MUST BE SET IN EVERY DEVICE SPECIFICALLY !!  ////
    private val profilePath =
        "C:/Users/erdem/AppData/Roaming/Mozilla/Firefox/Profiles/iimklnsg.default-release"

    private val options = FirefoxOptions()

    fun startExplorerAndGetDriver():WebDriver{
        options.addArguments("--profile")
        options.addArguments(profilePath)
        val driver: WebDriver = FirefoxDriver(options)
        return driver
    }



}