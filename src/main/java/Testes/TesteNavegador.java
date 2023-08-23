package Testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TesteNavegador {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void iniciar() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Aluno\\Desktop\\TesteSelenium\\Driver\\edge\\msedgedriver.exe");
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Encerrar o teste
    @AfterMethod
    public void finalizar() {
        driver.quit();
    }

    // Abrir o navegador e abrir o site
    @Test
    public void AbrirNavegadorAbrirGoogle() {
        driver.get("https://www.google.com.br/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
    }
}