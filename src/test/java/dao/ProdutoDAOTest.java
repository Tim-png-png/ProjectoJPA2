package dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import domain.Produto;

public class ProdutoDAOTest {
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	public void salvar() {
		Produto p1 = new Produto();
		p1.setDataDeValidade(LocalDate.of(2012, 12, 10));
		p1.setNome("Coca Cola 2LT");
		p1.setPreco(BigDecimal.valueOf(10.50));
		p1.setQuantidade(15);
		
		Produto p2 = new Produto(null,"Cola", 3, BigDecimal.valueOf(86.20),LocalDate.of(2012, 12, 19),null);
		
		produtoDAO.salvar(p1);
		produtoDAO.salvar(p2);
	}
	
	public void buscar() {
		Produto p = produtoDAO.buscar(2);
		System.out.println(p);
	}
		
	public void listar() {
		List<Produto> produtos = produtoDAO.listar();
		
		for(Produto p : produtos) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testar() {
		salvar();
		buscar();
		listar();	
	}
	
		
}
