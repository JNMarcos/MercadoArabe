package br.ufrpe.teste;

import br.ufrpe.negocio.Fachada;
import br.ufrpe.negocio.classes_basicas.Contato;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.classes_basicas.Xp;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.QuantidadeMaximaItensUltrapassadaException;
import br.ufrpe.negocio.exceptions_negocio.SenhaForaPadroesException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;


public class Teste {

	public static void main(String[] args) {
	
		Fachada fachada = new Fachada();
		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		Vendedor vendedor = new Vendedor();
		Contato contato = new Contato();
		Xp xp = new Xp();
		
		//cadastrando vendedor
		//dados da pessoa
		vendedor.setNome("Michael Sipser");
		vendedor.setDataNascimento(25, 06, 2015);
		vendedor.setNomeUsuario("m.spsr");
		vendedor.setSenha("s1ps3r");
		
		//dados do vendedor em si
		vendedor.setCpf("123.456.678-19");
			contato.setEmail("m.sipser@gmail.com");
			contato.setTelefone("81 1234-5678");
			contato.setLogradouro("Rua tals");
			contato.setBairro("Dois irmaos");
			contato.setCidade("Recife");
			contato.setEstado("Pernambuco");
		vendedor.setContato(contato);
		vendedor.setXp(xp);
		vendedor.setDataCadastro();
		
		//salvando vendedor
		try {
			fachada.cadastrarVendedor(vendedor);
			fachada.salvarVendedor();
		} catch(SenhaForaPadroesException e) {
			e.getMessage();
		} catch(NomeUsuarioForaPadroesException e) {
			e.getMessage();
		} catch(CpfJaCadastradoException e) {
			e.getMessage();
		} catch(NomeUsuarioJaCadastradoException e) {
			e.getMessage();
		}
		
		//cadastrando produtos do vendedor
		produto1.setNome("Introdução a teoria da computação");
		produto1.setCategoria("Livros");
		produto1.setDescricao("Livro sobre teoria da computação");
		produto1.setPreco(50.10);
		produto1.setEstado(false);
		produto1.setVendedor(vendedor);
		produto1.setItensNoEstoque(0);
		try {
			produto1.setQuantidade(1);
		} catch(QuantidadeMaximaItensUltrapassadaException e) {
			e.getMessage();
		}
		
		//salvando produto
		try {
			fachada.cadastrarProduto(produto1, vendedor);
			fachada.salvarProduto();
			xp.adicionarPontosPorCadastrarProduto();
		} catch(ProdutoJaCadastradoException e) {
			e.getMessage();
		}
		
		//cadastrando outro produto
		produto2.setNome("Java, como programar");
		produto2.setCategoria("Livros");
		produto2.setDescricao("Livro JAVA");
		produto2.setPreco(60.20);
		produto2.setEstado(false);
		produto2.setVendedor(vendedor);
		produto2.setItensNoEstoque(0);
		try {
			produto2.setQuantidade(1);
		} catch(QuantidadeMaximaItensUltrapassadaException e) {
			e.getMessage();
		}
		
		//salvando produto
		try {
			fachada.cadastrarProduto(produto2, vendedor);
			fachada.salvarProduto();
			xp.adicionarPontosPorCadastrarProduto();
		} catch(ProdutoJaCadastradoException e) {
			e.getMessage();
		}
		
		//checando log in do vendedor
		try {
			fachada.verificarLoginVendedor("qualquer", "123"); 		//errado
		} catch(NaoEncontradoVendedorException e) {
			e.getMessage();
		} catch(SenhaIncorretaException e) {
			e.getMessage();
		}
		
		
	}
}
