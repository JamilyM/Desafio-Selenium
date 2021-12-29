package automacao;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class semPageObject {

	private static final String URL_LOGADO = "http://automationpractice.com/index.php?controller=my-account";
	private static final String URL_CADASTRO = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	private static final String URL_INICIO = "http://automationpractice.com/";

	@Test
	public void DeveAdicionarUsuario() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();

		browser.navigate().to(URL_CADASTRO);

		browser.findElement(By.id("email_create")).sendKeys("ooooo1ooo2o@gmail.com");
		browser.findElement(By.id("SubmitCreate")).click();

		String nome = "Jamily";
		String sobrenome = "Melo";
		String email = "jamilymelo@gmail.com";
		String senha = "12345";
		String seuDia = "11";
		String seuMes = "11";
		String seuAno = "1999";
		String company = "casa";
		String endereco = "minha casa, 31";
		String cidade = "Juárez";
		String pais = "New Mexico";
		String cep = "12345";
		String celular = "123456789";

//		if (browser.switchTo().alert().getText().equals(
//				"An account using this email address has already been registered. Please enter a valid password or request a new one.") == true) {
//			browser.findElement(By.id("email")).sendKeys(email);
//			browser.findElement(By.id("passwd")).sendKeys(senha);
//			browser.findElement(By.id("SubmitLogin")).click();
//		}

		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		if (browser.getPageSource().contains(
//				"An account using this email address has already been registered. Please enter a valid password or request a new one") == false) {

			browser.findElement(By.id("id_gender2")).click();
			browser.findElement(By.id("customer_firstname")).sendKeys(nome);
			browser.findElement(By.id("customer_lastname")).sendKeys(sobrenome);
			if (browser.findElement(By.id("email")) == null) {
				browser.findElement(By.id("email")).sendKeys(email);
			}
			browser.findElement(By.id("passwd")).sendKeys(senha);
			Select data = new Select(browser.findElement(By.id("days")));
			data.selectByValue(seuDia);
			Select mes = new Select(browser.findElement(By.id("months")));
			mes.selectByValue(seuMes);
			Select ano = new Select(browser.findElement(By.id("years")));
			ano.selectByValue(seuAno);
			if (browser.findElement(By.id("firstname")) == null) {
				browser.findElement(By.id("firstname")).sendKeys(nome);
			}
			if (browser.findElement(By.id("lastname")) == null) {
				browser.findElement(By.id("lastname")).sendKeys(sobrenome);
			}
			browser.findElement(By.id("company")).sendKeys(company);
			browser.findElement(By.id("address1")).sendKeys(endereco);
			browser.findElement(By.id("city")).sendKeys(cidade);
			Select state = new Select(browser.findElement(By.id("id_state")));
			state.selectByVisibleText(pais);
			browser.findElement(By.id("postcode")).sendKeys(cep);
			Select country = new Select(browser.findElement(By.id("id_country")));
			country.selectByVisibleText("United States");
			browser.findElement(By.id("phone_mobile")).sendKeys(celular);
			browser.findElement(By.id("submitAccount")).click();

			browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			
			//verficar se esta logado
			Assert.assertTrue(browser.getCurrentUrl().equals(URL_LOGADO));
			
			//volta para a pagina home			
			browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a/span/i")).click();
			
			//seleciona o produto no carrinho
			browser.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]")).click();
			
			// faz checkout
			browser.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
			
			//faz checkout do resumo
			browser.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
			
			//faz checkout do endereço
			browser.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
			
			//confirma o termo
			browser.findElement(By.id("cgv")).click();	
			
			//faz checkout do frete
			browser.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
			
			//faz chekout do pagamento - transferencia bancaria
			browser.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
			
			//confirma o pedido na parte pagamento
			browser.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
			
			//volta para encomendas
			browser.findElement(By.xpath("//*[@id=\"center_column\"]/p/a")).click();
			
			//verifica o valor do produto se é o mesmo proposto
			WebElement linhaDaTabela = browser.findElement(By.cssSelector("#order-list tbody tr:last-child"));
			WebElement Valor = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
			
			Assert.assertTrue(Valor.getText().equals("$30.98"));
			
			browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//volta para a conta
			browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a")).click();
			
			browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			browser.close();

	}
}
