package pages;

import com.google.errorprone.annotations.Var;
import org.apache.poi.ss.formula.functions.Na;
import org.apache.poi.util.SystemOutLogger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.Web;

import static org.junit.Assert.assertEquals;

public class audienciaPage {
    private WebDriver navegador;

    public audienciaPage(WebDriver navegador) {
        this.navegador = navegador;
    }


    public audienciaPage clicarIncluirAudiencia() {
        Actions action = new Actions(navegador);
        WebElement we = navegador.findElement(By.xpath("//button[@class=\"btn-floating btn-large\"]"));
        action.moveToElement(we).build().perform();

        return new audienciaPage(navegador);

    }

    public audienciaPage clicarIncluirAudienciaEx() {
        WebDriverWait wait = new WebDriverWait(navegador, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"btn-floating tooltipped  light-green accent-4\"]")));

        navegador.findElement(By.xpath("//a[@class=\"btn-floating tooltipped  light-green accent-4\"]")).click();

        return new audienciaPage(navegador);
    }


    public audienciaPage incluirTipoSolicitante(String ufSol,String tipoSol) {

          navegador.findElement(By.xpath("//div[@class = \"input-field col s9\"]")).click();
          navegador.findElement(By.xpath("//div[@class = \"input-field col s9\"]/div/ul/li/span[text()=\""+tipoSol+"\"]")).click();
          navegador.findElement(By.xpath("//div[@class = \"input-field col s3\"]")).click();
          navegador.findElement(By.xpath("//div[@class = \"input-field col s3\"]/div/ul/li/span[text()=\""+ufSol+"\"]")).click();

        return this;
    }

    public audienciaPage informarSolicitante(String nomeSolicitante) {

        navegador.findElement(By.id("solicitante_no")).sendKeys(nomeSolicitante);
        navegador.findElement(By.xpath("//div[@class=\"col s2\"]/button[@class=\"svg-btn grey-text text-darken-1\"]/i")).click();
        navegador.findElement(By.xpath("//div[@class=\"sugest-list\"]/ul[@id=\"solicitantes-sugestlist\"]/li")).click();
        navegador.findElement(By.xpath("//div[@class=\"col s6\"]/button/i")).click();


        WebElement mensagemSuss = navegador.findElement(By.xpath("//div[@role]"));
        String mensagem = mensagemSuss.getText();
        assertEquals(mensagem, mensagem);

        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemSuss));

        return this;
    }

    public audienciaPage incluirInformacoes(String dataRecebimento, String meioReceb, String acompanhamento, String respSurel){

       WebElement digitaData = navegador.findElement(By.id("datepicker-g5dt_solicitacao"));
       digitaData.sendKeys(dataRecebimento,Keys.ENTER, Keys.TAB);

       navegador.findElement(By.id("meio_recebimento")).click();
       navegador.findElement(By.xpath("//div[@id=\"meio_recebimento\"]/div")).click();
       navegador.findElement(By.xpath("//div[@id=\"meio_recebimento\"]/div/ul/li/span[text()=\""+meioReceb+"\"]")).click();

       navegador.findElement(By.id("acompanhamento")).click();
       navegador.findElement(By.xpath("//div[@id=\"acompanhamento\"]/div")).click();
       navegador.findElement(By.xpath("//div[@id=\"acompanhamento\"]/div/ul/li/span[text()=\""+acompanhamento+"\"]")).click();

       navegador.findElement(By.id("responsavel_surel")).click();
       navegador.findElement(By.xpath("//div[@id=\"responsavel_surel\"]/div/ul/li/span[text()=\""+respSurel+"\"]")).click();

       WebElement acharBotao = navegador.findElement(By.xpath("//i[@class=\"large material-icons\"]"));
       acharBotao.click();


        return this;
    }
    public audienciaPage gravarAudiencia(){

    }


}



