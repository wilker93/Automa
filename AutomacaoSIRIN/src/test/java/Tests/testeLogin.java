package Tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.audienciaPage;
import pages.detalharAudienciaPage;
import pages.inicialPage;
import pages.loginPage;
import suport.Web;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)

public class testeLogin {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createFirefox();

        }

        @Test
        public void testeLogin()        {
            new loginPage(navegador).digitarMatricula("C891055");
            new loginPage(navegador).digitarSenha("senha");
            new loginPage(navegador).clicarEntrar();
            new inicialPage(navegador).validarLogin();
        }

        @Test
        public void testeIncluirAudiencia() {
            new loginPage(navegador).digitarMatricula("C891055");
            new loginPage(navegador).digitarSenha("senha");
            new loginPage(navegador).clicarEntrar();
            new inicialPage(navegador).clicarAudiencia();
            new audienciaPage(navegador).clicarIncluirAudiencia();
            new audienciaPage(navegador).clicarIncluirAudienciaEx();
            new audienciaPage(navegador).incluirTipoSolicitante("DF", "Deputado");
            new audienciaPage(navegador).informarSolicitante("ERIKA KOKAY");
            new audienciaPage(navegador).incluirInformacoes("30062019","Telefone","GEREP","58520 - Usuario SUREL 1");

    }
        @Test
        public void testeAgendarAudiencia() {
            new loginPage(navegador).digitarMatricula("C891055");
            new loginPage(navegador).digitarSenha("senha");
            new loginPage(navegador).clicarEntrar();
            new inicialPage(navegador).clicarAudiencia();
            new audienciaPage(navegador).clicarIncluirAudiencia();
            new audienciaPage(navegador).clicarIncluirAudienciaEx();
            new audienciaPage(navegador).incluirTipoSolicitante("DF", "Deputado");
            new audienciaPage(navegador).informarSolicitante("ERIKA KOKAY");
            new audienciaPage(navegador).incluirInformacoes("30062019","Telefone","GEREP","58520 - Usuario SUREL 1");
            new detalharAudienciaPage(navegador).clicarDetalharAudiencia();
            new detalharAudienciaPage(navegador).clicarEditarGeral();
            new detalharAudienciaPage(navegador).editarCamposGeral("Teste");
    }

 //       @After
    public void tearDown(){

        navegador.quit();
        }

    }
