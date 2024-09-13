package com.erdemserhat

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun main() = runBlocking {


    val driver = BrowserConfiguration().startExplorerAndGetDriver()

    try {
        val controller = WebsiteControllerService(driver)

        controller.goToLink("https://www.klanlar.org/")
        controller.closeAdsPopUpIfExists()
        controller.goToAssemblyArea()
        delay(500)
        controller.goToCleaning()
        delay(500)
        controller.fillArmyAmount(
            army = Army(
                sword = 12,
                axe = 12,
                heavy = 12,
                light = 12,
                spear = 12,
                knight = 12
            )
        )


    } finally {

    }
}



// you should this code in js compiler in explorer to lear the exact point of element to operate on it


// document.addEventListener('contextmenu', function(event) {
//  console.log('Sağ tıklama koordinatları - X:', event.clientX, 'Y:', event.clientY);
//  event.preventDefault(); // Sağ tıklama menüsünü engellemek isterseniz kullanabilirsiniz
//});
