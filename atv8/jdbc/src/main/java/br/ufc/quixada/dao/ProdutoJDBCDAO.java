package br.ufc.quixada.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.entity.Produto;


public class ProdutoJDBCDAO implements ProdutoDAO {

	public ProdutoJDBCDAO() { }
	
	
	public void save(Produto entity) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into produtos (codigo, descricao, preco, qtd, data) values (?, ?, ?, ?, ?)";
			String update_sql = "update produtos set codigo = ?, descricao = ?, preco = ?, qtd = ?, data = ? where id = ?";
			PreparedStatement pst;
			if (entity.getId() == null) {
				pst = con.prepareStatement(insert_sql);
			} else {
				pst = con.prepareStatement(update_sql);
				pst.setInt(6, entity.getId());
			}
			pst.setString(1, entity.getCodigo());
			pst.setString(2, entity.getDescricao());
			pst.setDouble(3, entity.getPreco());
			pst.setInt(4, entity.getQtd());
			pst.setDate(5, java.sql.Date.valueOf(entity.getData()));
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
	}

	public void delete(int id) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from produtos where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
	}

	public Produto find(int id) {
		Connection con = null;
		Produto pr = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select id, codigo, descricao, preco, qtd, data from produtos where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				pr = map(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return pr;
	}
	private Produto map(ResultSet rs) throws SQLException {
		Produto pr = new Produto();
		pr.setId(rs.getInt("id"));
		pr.setCodigo(rs.getString("codigo"));
		pr.setDescricao(rs.getString("descricao"));
		pr.setPreco(rs.getDouble("preco"));
		pr.setQtd(rs.getInt("qtd"));
		pr.setData(rs.getDate("data").toLocalDate());

		return pr;
	}




	public Produto findCod(String cod) {
		Connection con = null;
		Produto pr = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select id, codigo, descricao, preco, qtd, data from produtos where codigo = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cod);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				pr = map(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return pr;
	}

	public List<Produto> find() {
		Connection con = null;
		List<Produto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from Produtos";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Produto>();
			while (rs.next()) {
				Produto cl = map(rs);
				result.add(cl);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	public List<Produto> findDesc(String desc) {
		Connection con = null;
		List<Produto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select id, codigo, descricao, preco, qtd, data from produtos where descricao like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, '%' + desc + '%');
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Produto>();
			while (rs.next()) {
				Produto cl = map(rs);
				result.add(cl);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}


	public List<Produto> findLeq(double preco) {
		Connection con = null;
		List<Produto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select id, codigo, descricao, preco, qtd, data from produtos where preco <= ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, preco);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Produto>();
			while (rs.next()) {
				Produto cl = map(rs);
				result.add(cl);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}


	public List<Produto> findInterval(LocalDate data1, LocalDate data2) {
		Connection con = null;
		List<Produto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select id, codigo, descricao, preco, qtd, data from produtos where data >= ? and data <= ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDate(1, java.sql.Date.valueOf(data1));
			pst.setDate(2, java.sql.Date.valueOf(data2));
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Produto>();
			while (rs.next()) {
				Produto cl = map(rs);
				result.add(cl);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}


	
	
}