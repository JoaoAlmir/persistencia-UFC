package br.ufc.quixada;

import java.util.List;

import javax.swing.JOptionPane;

import br.ufc.quixada.dao.ProdutoDAO;
import br.ufc.quixada.dao.ProdutoJDBCDAO;
import br.ufc.quixada.entity.Produto;
import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		ProdutoDAO baseProdutos = new ProdutoJDBCDAO();
		String menu = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por codigo\n3 - Remover por codigo\n4 - Exibir por codigo\n5 - Exibir por id\n6 - Exibir todos os produtos\n7 - Exibir descriçao contida\n8 - Exibir preços menor ou igual\n"
				+ //
				"9 - Sair";
		char opcao = '0';
		do {
			try {
				Produto pdt;
				String cod;
				opcao = JOptionPane.showInputDialog(menu).charAt(0);
				switch (opcao) {
					case '1': // Inserir
						pdt = new Produto();
						obterProduto(pdt);
						baseProdutos.save(pdt);
						break;
					case '2': // Atualizar por Cod
						cod = JOptionPane.showInputDialog("Digite o codigo do produto a ser alterado");
						pdt = baseProdutos.findCod(cod);
						obterProduto(pdt);
						baseProdutos.save(pdt);
						break;
					case '3': // Remover por Cod
						cod = JOptionPane.showInputDialog("Codigo");
						pdt = baseProdutos.findCod(cod);
						if (pdt != null) {
							baseProdutos.delete(pdt.getId());
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível remover, pois o produto não encontrado.");
						}
						break;
					case '4': // Exibir por Codigo
						cod = JOptionPane.showInputDialog("Codigo");
						pdt = baseProdutos.findCod(cod);
						listaProduto(pdt);
						break;
					case '5': // Exibir por id
						int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
						pdt = baseProdutos.find(id);
						listaProduto(pdt);
						break;
					case '6': // Exibir todos
						listaProdutos(baseProdutos.find());
						break;
					case '7': // Exibir todos que contem determinado descricao
						String desc = JOptionPane.showInputDialog("Descricao");
						listaProdutos(baseProdutos.findDesc(desc));
						break;
					case '8': // Exibir todos menor ou igual a preço
						Double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço"));
						listaProdutos(baseProdutos.findLeq(preco));
						break;
					// case '9': // Exibir intervalo de datas
					// 	LocalDate data1 = LocalDate.parse(JOptionPane.showInputDialog("Data1"));
					// 	LocalDate data2 = LocalDate.parse(JOptionPane.showInputDialog("Data2"));
					// 	listaProdutos(baseProdutos.findInterval(data1, data2));
					// 	break;
					case '9': // Sair
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			}
		} while (opcao != '8');
	}

	public static void obterProduto(Produto cl) {
		String codigo = JOptionPane.showInputDialog("Código", cl.getCodigo());
		String descricao = JOptionPane.showInputDialog("Descrição", cl.getDescricao());
		Double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço", cl.getPreco()));
		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade", cl.getQtd()));
		cl.setCodigo(codigo);
		cl.setDescricao(descricao);
		cl.setPreco(preco);
		cl.setQtd(qtd);
		if (cl.getData() == null) {
			cl.setData(LocalDate.now());
		}
	}

	public static void listaProdutos(List<Produto> produtos) {
		StringBuilder listagem = new StringBuilder();
		for (Produto cl : produtos) {
			listagem.append(cl).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum produto encontrado" : listagem);
	}

	public static void listaProduto(Produto cl) {
		JOptionPane.showMessageDialog(null, cl == null ? "Nenhum produto encontrado" : cl);
	}

}
