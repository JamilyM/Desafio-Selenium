package pageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CadastroTest {

	private CadastroPage cadastro;

	@Before
	public void beforeEach() {
		this.cadastro = new CadastroPage();
	}

	@After
	public void afterEach() {
		this.cadastro.fechar();
	}

	@Test
	public void cadastrarNovoUsuario() {

		cadastro.verificarEmailExistente();

		cadastro.preencheFormularioDeCadastro();

		Assert.assertTrue(cadastro.verificarSeLogou());

		cadastro.voltaparaHome();

		cadastro.selecionaProdutoCarrinho();
		
		cadastro.fazCheckout();
		
		cadastro.fazCheckoutResumo();
		
		cadastro.fazCheckoutEndereco();
		
		cadastro.aceitaTermo();
		
		cadastro.fazerCheckOutFrete();
		
		cadastro.formaPagamento();
		
		cadastro.confirmarPedidoPagamento();
		
		cadastro.voltaEncomendas();
		
		cadastro.verificarValorDoProduto();
		
		cadastro.voltaConta();
		
		//cadastro.fechar();
	}
}
