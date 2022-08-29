package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Produto;
import util.JPAUtil;

public class ProdutoDAO {
	public void salvar(Produto produto) {
		EntityManager sessao = JPAUtil.getEntityManeger();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(produto);
		transacao.commit();
		
		sessao.close();
	}
	
	public Produto buscar(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManeger();
		Produto produto = sessao.find(Produto.class, codigo);
		return produto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		String jpql = "select p from Produto p order by codigo";
		EntityManager sessao = JPAUtil.getEntityManeger();
		Query consulta = sessao.createQuery(jpql);
		List<Produto> resultado = consulta.getResultList();
		return resultado;
	}
	
	public void excluir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManeger();
		EntityTransaction transaction = sessao.getTransaction();
		transaction.begin();
		Produto produto = sessao.find(Produto.class, codigo);
		sessao.remove(produto);
		
		transaction.commit();
		sessao.close();
		
	}
	
	public void editar(Produto produto) {
		EntityManager sessao = JPAUtil.getEntityManeger();
		EntityTransaction transaction = sessao.getTransaction();
		transaction.begin();
		
		sessao.merge(produto);
		
		
		transaction.commit();
		sessao.close();
	}
	
}
