// package programa.dao;
// import java.math.BigDecimal;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import programa.entity.Produto;


// public class ProdutoJDBCDAO implements ProdutoDAO {

// 	public ProdutoJDBCDAO() { }
	
// 	public void save(Produto entity) {
// 		Connection con = null;
// 		try {
// 			con = ConnectionFactory.getConnection();
// 			String insert_sql = "insert into produtos (id, codigo, descricao, preco, qtd, data) values (?, ?, ?, ?, ?, ?)";
// 			String update_sql = "update produtos set codigo = ?, descricao = ?, preco = ?, qtd = ?, data = ? where id = ?";
// 			PreparedStatement pst;
// 			if (entity.getId() == 0) {
// 				pst = con.prepareStatement(insert_sql);
// 			} else {
// 				pst = con.prepareStatement(update_sql);
// 				pst.setInt(6, entity.getId());
// 			}
// 			pst.setString(1, entity.getCodigo());
// 			pst.setString(2, entity.getDescricao());
// 			pst.setDouble(3, entity.getPreco());
// 			pst.setInt(4, entity.getQtd());
// 			pst.setDate(5, java.sql.Date.valueOf(entity.getData()));
// 			pst.executeUpdate();
// 		} catch (SQLException e) {
// 			throw new DAOException("Operação não realizada com sucesso.", e);
// 		} finally {
// 			try {
// 				if (con != null)
// 					con.close();
// 			} catch (SQLException e) {
// 				throw new DAOException("Não foi possível fechar a conexão.",e);
// 			}
// 		}
// 	}

// 	public void delete(int id) {
// 		Connection con = null;
// 		try {
// 			con = ConnectionFactory.getConnection();
// 			String sql = "delete from produtos where id = ?";
// 			PreparedStatement pst = con.prepareStatement(sql);
// 			pst.setInt(1, id);
// 			pst.executeUpdate();
// 		} catch (SQLException e) {
// 			throw new DAOException("Operação não realizada com sucesso.", e);
// 		} finally {
// 			try {
// 				if (con != null)
// 					con.close();
// 			} catch (SQLException e) {
// 				throw new DAOException("Não foi possível fechar a conexão.",e);
// 			}
// 		}
// 	}

// 	public Produto find(int id) {
// 		Connection con = null;
// 		Produto pr = null;
// 		try {
// 			con = ConnectionFactory.getConnection();
// 			String sql = "select id, codigo, descricao, preco, qtd, data from produtos where id = ?";
// 			PreparedStatement pst = con.prepareStatement(sql);
// 			pst.setInt(1, id);
// 			ResultSet rs = pst.executeQuery();
// 			if (rs.next()) {
// 				pr = map(rs);
// 			}
// 		} catch (SQLException e) {
// 			throw new DAOException("Operação não realizada com sucesso.", e);
// 		} finally {
// 			try {
// 				if (con != null)
// 					con.close();
// 			} catch (SQLException e) {
// 				throw new DAOException("Não foi possível fechar a conexão.",e);
// 			}
// 		}
// 		return pr;
// 	}
// 	private Produto map(ResultSet rs) throws SQLException {
// 		Produto pr = new Produto();
// 		pr.setId(rs.getInt("id"));
// 		pr.setCodigo(rs.getString("codigo"));
// 		pr.setDescricao(rs.getString("descricao"));
// 		pr.setPreco(rs.getDouble("preco"));
// 		pr.setQtd(rs.getInt("qtd"));
// 		pr.setData(rs.getDate("data").toLocalDate());

// 		return pr;
// 	}




// 	public Produto findCod(String cod) {
// 		Connection con = null;
// 		Produto pr = null;
// 		try {
// 			con = ConnectionFactory.getConnection();
// 			String sql = "select id, codigo, descricao, preco, qtd, data from produtos where codigo = ?";
// 			PreparedStatement pst = con.prepareStatement(sql);
// 			pst.setString(1, cod);
// 			ResultSet rs = pst.executeQuery();
// 			if (rs.next()) {
// 				pr = map(rs);
// 			}
// 		} catch (SQLException e) {
// 			throw new DAOException("Operação não realizada com sucesso.", e);
// 		} finally {
// 			try {
// 				if (con != null)
// 					con.close();
// 			} catch (SQLException e) {
// 				throw new DAOException("Não foi possível fechar a conexão.",e);
// 			}
// 		}
// 		return pr;
// 	}


// 	// public List<Produto> findDesc(String desc) {
// 	// 	Connection con = null;
// 	// 	Produto pr = null;
// 	// 	try {
// 	// 		con = ConnectionFactory.getConnection();
// 	// 		String sql = "select id, codigo, descricao, preco, qtd, data from produtos where descricao = ?";
// 	// 		PreparedStatement pst = con.prepareStatement(sql);
// 	// 		pst.setString(1, desc);
// 	// 		ResultSet rs = pst.executeQuery();
// 	// 		if (rs.next()) {
// 	// 			pr = map(rs);
// 	// 		}
// 	// 	} catch (SQLException e) {
// 	// 		throw new DAOException("Operação não realizada com sucesso.", e);
// 	// 	} finally {
// 	// 		try {
// 	// 			if (con != null)
// 	// 				con.close();
// 	// 		} catch (SQLException e) {
// 	// 			throw new DAOException("Não foi possível fechar a conexão.",e);
// 	// 		}
// 	// 	}
// 	// 	return pr;
// 	// }


// 	public List<Produto> findLeq(double preco) {
// 		throw new UnsupportedOperationException("Unimplemented method 'findLeq'");
// 	}


// 	public List<Produto> findInterval(LocalDate data1, LocalDate data2) {
// 		throw new UnsupportedOperationException("Unimplemented method 'findInterval'");
// 	}
	
// }
