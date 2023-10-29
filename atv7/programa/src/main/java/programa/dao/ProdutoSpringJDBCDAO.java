package programa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import programa.entity.Produto;

@Repository
@Primary
@Slf4j
public class ProdutoSpringJDBCDAO implements ProdutoDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public ProdutoSpringJDBCDAO() {
	}

	public void save(Produto entity) {
		String insert_sql = "insert into produtos (id, codigo, descricao, preco, qtd, data) values (:id, :codigo, :descricao, :preco, :qtd, :data)";
		String update_sql = "update produtos set id = :id, codigo = :codigo, descricao = :descricao, preco = :preco, qtd = :qtd, data = :data where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", entity.getId())
				.addValue("codigo", entity.getCodigo())
				.addValue("descricao", entity.getDescricao())
				.addValue("preco", entity.getPreco())
				.addValue("qtd", entity.getQtd())
				.addValue("data", entity.getData());
		if (entity.getId() == null) {
			jdbcTemplate.update(insert_sql, params);
		} else {
			params.addValue("id", entity.getId());
			jdbcTemplate.update(update_sql, params);
		}
	}

	public void delete(int id) {
		String sql = "delete from produtos where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", id);
		jdbcTemplate.update(sql, params);
	}

	public Produto find(int id) {
		Produto produto = null;
		try {
			String sql = "select id, cpf, nome, fone, renda from produtos where id = :id";
			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("id", id);
			produto = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> map(rs));
		} catch (EmptyResultDataAccessException e) {
			log.debug(e.getMessage());
		}
		return produto;
	}

	private Produto map(ResultSet rs) throws SQLException {
		Produto cl = new Produto();
		cl.setId(rs.getInt("id"));
		cl.setCodigo(rs.getString("codigo"));
		cl.setDescricao(rs.getString("descricao"));
		cl.setPreco(rs.getDouble("preco"));
		cl.setQtd(rs.getInt("qtd"));
		cl.setData(rs.getObject("data", LocalDate.class));
		return cl;
	}

	public List<Produto> find() {
		String sql = "select id, codigo, descricao, preco, qtd, data from produtos where id = ?";
		return jdbcTemplate.query(sql, (rs, rowNum) -> map(rs));
	}

	public Produto findCod(String cod) {
		Produto produto = null;
		try {
			String sql = "select id, codigo, descricao, preco, qtd, data from produtos where codigo = :codigo";
			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("codigo", cod);
			produto = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> map(rs));
		} catch (EmptyResultDataAccessException e) {
			log.debug(e.getMessage());
		}
		return produto;
	}

	

	public List<Produto> findDesc(String str) {
		String sql = "select id, codigo, descricao, preco, qtd, data from produtos where upper(nome) like :descricao";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("descricao", "%" + str.toUpperCase() + "%");
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> map(rs));
	}

	public List<Produto> findLeq(double preco) {
		String sql = "select id, codigo, descricao, preco, qtd, data from produtos where renda <= :renda";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("renda", preco);
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> map(rs));
	}

	public List<Produto> findInterval(LocalDate data1, LocalDate data2) {
		String sql = "select id, codigo, descricao, preco, qtd, data from produtos where data >= :data1 and data <= :data2";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("data1", data1)
				.addValue("data2", data2);				

		return jdbcTemplate.query(sql, params, (rs, rowNum) -> map(rs));
	}




}