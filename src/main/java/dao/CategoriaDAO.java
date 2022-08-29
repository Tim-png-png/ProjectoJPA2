package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Categoria;
import util.JPAUtil;

public class CategoriaDAO {
	public void salvar(Categoria categoria) {
		EntityManager sessao = JPAUtil.getEntityManeger();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(categoria);
		transacao.commit();
		
		sessao.close();
	}
	
	public Categoria buscar(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManeger();
		Categoria categoria = sessao.find(Categoria.class, codigo);
		return categoria;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listar() {
		String jpql = "select c from Categoria c order by nome";
		EntityManager sessao = JPAUtil.getEntityManeger();
		Query consulta = sessao.createQuery(jpql);
		List<Categoria> resultado = consulta.getResultList();
		return resultado;
	}
}
