package Testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    @AfterMethod
    public void finalizar() {
        driver.quit();
    }

    // Abrir o navegador e abrir o site
    @Test
    public void AbrirNavegadorAbrirGoogle() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://grupoassociativogasp.com.br/gestor_site/login");

        driver.findElement(By.id("cd_usuario")).sendKeys("Marcio");
        driver.findElement(By.id("ds_senha")).sendKeys("senha");

        WebElement botaoLogin = driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[4]/label/button"));
        botaoLogin.click();
    }
}