import org.openqa.selenium.chrome.ChromeDriver

waiting {
    timeout = 2
}

environments {
    chrome {
        driver = {
            System.setProperty('webdriver.chrome.driver',"C:\\chromedriver\\chromedriver.exe")
            new ChromeDriver()
        }
    }
}