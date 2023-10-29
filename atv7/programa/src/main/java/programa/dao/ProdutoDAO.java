package programa.dao;

import java.time.LocalDate;
import java.util.List;

import programa.entity.Produto;


public interface ProdutoDAO {
	
	public void save(Produto entity);
	public void delete(int id);
	public Produto find(int id);
	public Produto findCod(String cod);
	public List<Produto> findDesc(String desc);
	public List<Produto> findLeq(double preco);
	public List<Produto> findInterval(LocalDate data1, LocalDate data2);
}
