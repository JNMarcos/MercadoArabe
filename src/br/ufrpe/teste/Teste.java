package br.ufrpe.teste;

import java.util.ArrayList;

import br.ufrpe.negocio.cadastros.CadastroProduto;
import br.ufrpe.negocio.cadastros.CadastroVendedor;
import br.ufrpe.negocio.classes_basicas.Contato;
import br.ufrpe.negocio.classes_basicas.Produto;
import br.ufrpe.negocio.classes_basicas.Vendedor;
import br.ufrpe.negocio.classes_basicas.Xp;
import br.ufrpe.negocio.exceptions_negocio.CpfJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.NaoEncontradoVendedorException;
import br.ufrpe.negocio.exceptions_negocio.NomeUsuarioJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.ProdutoJaCadastradoException;
import br.ufrpe.negocio.exceptions_negocio.QuantidadeMaximaItensUltrapassadaException;
import br.ufrpe.negocio.exceptions_negocio.SenhaIncorretaException;

public class Teste {

	public static void main(String[] args) {
		
		//vendedor 1
		Vendedor v1 = new Vendedor();
		Contato c1 = new Contato();
		Produto p1 = new Produto();
		Produto p2 = new Produto();
		Xp xp1 = new Xp();
		ArrayList<Produto> arrP = new ArrayList<Produto>();
		
		v1.setNome("Carlos olimpio");
		v1.setDataNascimento(02, 04, 1994);
		v1.setCpf("123.456.789-90");
		v1.setNomeUsuario("olimpio123");
		v1.setSenha("123olimpio");
		c1.setEmail("123olimpio@gmail.com");
		c1.setTelefone("99999-0000");
		c1.setLogradouro("Rua rural");
		c1.setBairro("dois irmão");
		c1.setCidade("Recife");
		c1.setEstado("Pernambuco");
		
		//produtos
		
		try {
			p1.setNome("Lumia 925");
			p1.setDescricao("Celular da nokia. Fora de linha");
			p1.setCategoria("Celulares");
			p1.setPreco(500.0);
			p1.setQuantidade(1);
			p1.setEstado(false);
			p1.setItensNoEstoque(0);
			arrP.add(p1);
			p2.setNome("Dell series");
			p2.setDescricao("Notebook dell");
			p2.setCategoria("Informática");
			p2.setPreco(1500.0);
			p2.setQuantidade(1);
			p2.setEstado(false);
			p2.setItensNoEstoque(0);
			arrP.add(p2);
		} catch(QuantidadeMaximaItensUltrapassadaException e) {
			e.getMessage();
		}
		
		v1.setXp(xp1); // senti nessecidade de criar esse metodo na classe vendedor.
		v1.setProdutos(arrP); // vendedor com sua respectiva lista de produtos
		
		//Registrando produtos
		CadastroProduto cad = new CadastroProduto();
		
		try {
			cad.cadastrarProduto(p1);
			cad.cadastrarProduto(p2);
		} catch(ProdutoJaCadastradoException e) {
			e.getMessage();
		} finally {
			cad.salvarProduto();
		}
		
		//registando vendedor
		CadastroVendedor cadV = new CadastroVendedor();
		
		try {
			cadV.verificarLogin(v1.getNomeUsuario(), v1.getSenha());
			cadV.cadastrarVendedor(v1);
		} catch(NomeUsuarioJaCadastradoException e) {
			e.getMessage();
		} catch(SenhaIncorretaException e) {
			e.getMessage();
		} catch(CpfJaCadastradoException e) {
			e.getMessage();
		} catch(NaoEncontradoVendedorException e) {
			e.getMessage();
		} finally {
			cadV.salvarVendedor();
			v1.setDataCadastro(); //fim cadastro
		}
		
	}
}
