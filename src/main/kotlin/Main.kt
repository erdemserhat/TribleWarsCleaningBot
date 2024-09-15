package com.erdemserhat

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {


    val driver = BrowserConfiguration().startExplorerAndGetDriver()

    try {

        while (true){
            val coreController = WebsiteControllerService(driver)
            val controller = TribleWarsBotController(coreController)
            controller.goToMainPage()
            controller.goToWorld()
            controller.closeAdsPopUpIfExists()
            controller.goToAssemblyArea()
            delay(500)
            controller.goToCleaning()
            delay(500)
            //Fill
            controller.fillArmyAmountSingleSpear(30)
            controller.startWithBigCollectors()
            delay(250)

            controller.fillArmyAmountSingleSpear(30)
            controller.startWithBigCollectors()
            delay(250)

            controller.fillArmyAmountSingleSpear(45)
            controller.startWithCleverCollectors()
            delay(250)

            controller.fillArmyAmountSingleSpear(90)
            controller.startWithModestCollectors()
            delay(250)

            controller.fillArmyAmountSingleSpear(180)
            controller.startWithLazyCollectors()
            delay(5000)
            controller.waitForComplementation(1,1,30)

        }






    } finally {

    }
}



// you should this code in js compiler in explorer to lear the exact point of element to operate on it

// document.addEventListener('contextmenu', function(event) {
//  console.log('Sağ tıklama koordinatları - X:', event.clientX, 'Y:', event.clientY);
//  event.preventDefault(); // Sağ tıklama menüsünü engellemek isterseniz kullanabilirsiniz
//});
