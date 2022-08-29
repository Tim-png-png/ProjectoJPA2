package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import domain.Categoria;
import domain.Produto;
import lombok.Data;

@SuppressWarnings("serial")
@Named
@ViewScoped
@Data
public class ProdutoBean implements Serializable {
		private Produto produto;
		private ProdutoDAO produtoDAO;
		private List<Produto> produtos;
		
		private List<Categoria> categorias;
		private CategoriaDAO categoriaDAO;
		
		@PostConstruct
		public void iniciar() {
			categoriaDAO = new CategoriaDAO();
	
			produtoDAO = new ProdutoDAO();
			
			limpar();
			
			listar();
		}
		
		public void limpar() {
			produto = new Produto();
			categorias = categoriaDAO.listar();	
			produtos = produtoDAO.listar();
		}
	
		public void salvar() {
			produtoDAO.salvar(produto);
			limpar();
			Messages.addGlobalInfo("Produto salvo com sucesso");
		}
		
		public void listar() {
			produtos = produtoDAO.listar();
		}
		
		public void seleccionar(Produto produtoSelecccionado) {
			produto = produtoSelecccionado;
		}
		
		public void excluir() {
			produtoDAO.excluir(produto.getCodigo());
			limpar();
			Messages.addGlobalInfo("Produto excluído com sucesso");
		}
		
		public void editar() {
			produtoDAO.editar(produto);
			
			limpar();
			Messages.addGlobalInfo("Produto editado com sucesso: ");
		}
		
}
