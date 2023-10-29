package programa.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import programa.entity.Produto;

@Repository
public class ProdutoListDAO implements ProdutoDAO {

	private List<Produto> produtos;

	private static int idProximo = 1;

	public ProdutoListDAO() {
		this.produtos = new ArrayList<Produto>();
	}

	public void save(Produto entity) {
		// Inserir um produto se o id do objeto for 0.
		if (entity.getId() == 0) {
			entity.setId(idProximo++);
			produtos.add(entity);
			// Alterar um produto se o id não for 0.
		} else {
			int posicaoNaLista = findIndex(entity.getId());
			produtos.set(posicaoNaLista, entity);
		}
	}

	public void delete(int id) {
		produtos.remove(find(id));
	}

	public Produto find(int id) {
		for (Produto pr : this.produtos) {
			if (pr.getId() == id) {
				return pr;
			}
		}
		return null;
	}

	private int findIndex(int id) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public List<Produto> find() {
		return this.produtos;
	}

	public List<Produto> findDesc(String str) {
		List<Produto> resultado = new ArrayList<Produto>();
		for (Produto pr : this.produtos) {
			if (pr.getDescricao().contains(str)) {
				resultado.add(pr);
			}
		}
		return resultado;
	}

	public Produto findCod(String cod) {

		for (Produto pr : this.produtos) {
			if (pr.getCodigo().equals(cod)) {
				return pr;
			}
		}
		return null;
	}

	public List<Produto> findInterval(LocalDate data1, LocalDate data2) {

		List<Produto> resultado = new ArrayList<Produto>();
		for (Produto pr : this.produtos) {
			if (pr.getData() != null && pr.getData().isAfter(data1) && pr.getData().isBefore(data2)) {
				resultado.add(pr);
			}
		}
		return resultado;
	}

	public List<Produto> findLeq(double prc) {
		List<Produto> resultado = new ArrayList<Produto>();
		for (Produto pr : this.produtos) {
			if (pr.getPreco() <= prc) {
				resultado.add(pr);
			}
		}
		return resultado;
	}
}
