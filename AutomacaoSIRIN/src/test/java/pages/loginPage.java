package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    private WebDriver navegador;
    public loginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public inicialPage digitarMatricula(String matricula){
        navegador.findElement(By.name("matricula")).sendKeys(matricula);

        return new inicialPage(navegador);

    }
    public inicialPage digitarSenha(String senha){
        navegador.findElement(By.name("senha")).sendKeys(senha);

        return new inicialPage(navegador);

    }
    public inicialPage clicarEntrar(){
        navegador.findElement(By.xpath("//button")).click();


        return new inicialPage(navegador);

    }

}