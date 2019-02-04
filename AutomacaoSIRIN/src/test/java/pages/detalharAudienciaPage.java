package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class detalharAudienciaPage {

    private WebDriver navegador;

    public detalharAudienciaPage(WebDriver navegador) {
        this.navegador = navegador;
    }


    public detalharAudienciaPage clicarDetalharAudiencia() {
        WebDriverWait wait = new WebDriverWait(navegador, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title=\"Detalhar\"]/i")));

        navegador.findElement(By.xpath("//button[@title=\"Detalhar\"]/i")).click();

        return this;
    }

    public detalharAudienciaPage clicarEditarGeral() {
        navegador.findElement(By.xpath("//button[@class=\"right\"]/i[@class=\"material-icons\"]")).click();



        return this;
    }
    public detalharAudienciaPage editarCamposGeral(String palavrasChave) {

        navegador.findElement(By.id("de_solicitacao")).sendKeys(palavrasChave);


        return this;
    }
}