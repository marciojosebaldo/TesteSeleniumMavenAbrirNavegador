package Testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.edge.EdgeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TesteNavegador {
    private WebDriver driver;

    // Instanciar as variáveis de teste
    // Precisa fazer o download do driver do navegador
    // Escolha um ou outro
    @BeforeMethod
    public void iniciar() {
        // Navegador Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aluno\\Desktop\\TesteSelenium\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();

        // Navegador Edge
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
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get("https://www.google.com.br/");
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }
}