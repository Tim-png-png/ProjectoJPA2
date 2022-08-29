package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.CategoriaDAO;
import domain.Categoria;
import lombok.Data;

@SuppressWarnings("serial")
@Named
@ViewScoped
@Data
public class CategoriaBean implements Serializable {
		private Categoria categoria;
		private CategoriaDAO categoriaDAO;
		private List<Categoria> categorias;
		
		
		@PostConstruct
		public void iniciar() {
			categoriaDAO = new CategoriaDAO();
			categoria = new Categoria();
			listar();
		}
	
		public void salvar() {
			categoriaDAO.salvar(categoria);
			categoria = new Categoria();
			listar();
			Messages.addGlobalInfo("Categoria salva com sucesso: ");
		}
		
		public void listar() {
			categorias = categoriaDAO.listar();
		}
}
