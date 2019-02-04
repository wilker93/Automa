package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class inicialPage {
    private WebDriver navegador;

    public inicialPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public audienciaPage validarLogin() {
        WebDriverWait wait = new WebDriverWait(navegador, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"col s9 m7 main-menu\"]/ul/li/button[@title=\"Home\"]")));
        navegador.findElement(By.xpath("//div[@class=\"col s9 m7 main-menu\"]/ul/li/button[@title=\"Home\"]")).click();

        return new audienciaPage(navegador);

    }

    public audienciaPage clicarAudiencia() {
        WebDriverWait wait = new WebDriverWait(navegador, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"AUDIÊNCIAS\"]")));
        navegador.findElement(By.xpath("//button[text()=\"AUDIÊNCIAS\"]")).click();

        return new audienciaPage(navegador);

    }
}

