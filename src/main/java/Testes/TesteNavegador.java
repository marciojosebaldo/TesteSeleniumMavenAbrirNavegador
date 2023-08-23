package Testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TesteNavegador {
    private WebDriver driver;

    @BeforeMethod
    public void iniciar() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Aluno\\Desktop\\TesteSelenium\\Driver\\edge\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    // Encerrar o teste
    // Foi deixado comentado para evitar
    @AfterMethod
    public void finalizar() {
        //driver.quit();
    }


    @Test
    public void AbrirNavegadorAbrirSite() {
        driver.get("http://grupoassociativogasp.com.br/gestor_site/login");

        driver.findElement(By.id("cd_usuario")).sendKeys("Marcio");
        driver.findElement(By.id("ds_senha")).sendKeys("senha");

        WebElement botaoLogin = driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[4]/label/button"));
        botaoLogin.click();
    }

    @Test
    public void AbrirNavegadorAcessarAVA() {
        driver.get("https://ava.fiep.digital/theme/badiumview/controller.php?_key=badiumview.factory.theme.fiep.app.login.index&_operation=apppage");

        driver.findElement(By.className("form-control")).sendKeys("cpf");
        driver.findElement(By.xpath("//*[@id=\"form-login\"]/div/div[2]/div/input")).sendKeys("senha");

        WebElement botaoEstouDeAcordo = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div/div[4]/label/input"));
        botaoEstouDeAcordo.click();

        WebElement botaoAcessar = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div/div[5]/button"));
        botaoAcessar.click();

        WebElement msg = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div/div[1]"));
        boolean testeMsg = msg.isDisplayed();

        Assert.assertTrue(testeMsg);
    }
}