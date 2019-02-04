package suport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createFirefox() {
        // Abrindo o navegador
        System.setProperty("webdriver.gecko.driver", "/home/globalweb/Documentos/chromedriver_linux64/geckodriver");
        WebDriver navegador = new FirefoxDriver();
        navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // Navegando para a página do SIRIN!
        navegador.get("http://192.168.1.115:8000");

        return navegador;
    }
}



