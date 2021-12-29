package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CadastroPage extends PageObject{

	private static final String URL_LOGADO = "http://automationpractice.com/index.php?controller=my-account";
	private static final String URL_CADASTRO = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";


	public CadastroPage() {
		super(null);
		this.browser.navigate().to(URL_CADASTRO);
	}

	public void fechar() {
		this.browser.quit();
	}

	public void verificarEmailExistente() {
		String email;
		email = "koktopdj2soihed@gmail.com";
		browser.findElement(By.id("email_create")).sendKeys(email);
		browser.findElement(By.id("SubmitCreate")).click();
	}

	public void preencheFormularioDeCadastro() {

		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String nome = "Jamily";
		String sobrenome = "Melo";
		String email = "jamilymelo5858@gmail.com";
		String senha = "12345";
		String seuDia = "11";
		String seuMes = "11";
		String seuAno = "1999";
		String company = "casa";
		String endereco = "minha casa, 31";
		String cidade = "JuÃ¡rez";
		String pais = "New Mexico";
		String cep = "12345";
		String celular = "123456789";
		
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
		
	}

	public boolean verificarSeLogou() {
		return browser.getCurrentUrl().equals(URL_LOGADO);
	}

	public void voltaparaHome() {
		browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a/span/i")).click();
	}

	public void selecionaProdutoCarrinho() {
		browser.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]")).click();
	}

	public void fazCheckout() {
		browser.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
	}
	
	public void fazCheckoutResumo() {
		browser.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
	}

	public void fazCheckoutEndereco() {
		browser.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
	}
	
	public void aceitaTermo() {
		browser.findElement(By.id("cgv")).click();	
	}

	public void fazerCheckOutFrete() {
		browser.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
	}
	
	public void formaPagamento() {
		//transferencia bancaria
		browser.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
	}

	public void confirmarPedidoPagamento() {
		browser.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
	}

	public void voltaEncomendas() {
		browser.findElement(By.xpath("//*[@id=\"center_column\"]/p/a")).click();
	}
	
	public boolean verificarValorDoProduto() {
		WebElement linhaDaTabela = browser.findElement(By.cssSelector("#order-list tbody tr:last-child"));
		WebElement Valor = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return Valor.getText().equals("$30.98");
	}
	
	public void voltaConta() {
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a")).click();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
