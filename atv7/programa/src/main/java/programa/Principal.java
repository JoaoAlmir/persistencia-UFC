package programa;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import lombok.extern.slf4j.Slf4j;
import programa.dao.ProdutoDAO;
import programa.entity.Produto;

@SpringBootApplication
@Slf4j
public class Principal implements CommandLineRunner {
	@Autowired
	private ProdutoDAO baseProdutos;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Principal.class);
		builder.headless(false).run(args);
	}

	@Override
	public void run(String... args) {
		String menu = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por Cod\n3 - Remover por Cod\n4 - Exibir por Cod\n5 - Exibir por id\n6 - Exibir todos\n7 - Exibir todos que contem determinado nome\n8 - Sair";
		char opcao = '0';
		do {
			try {
				Produto pd;
				String cod;
				opcao = JOptionPane.showInputDialog(menu).charAt(0);
				switch (opcao) {
					case '1': // Inserir
						pd = new Produto();
						obterProduto(pd);
						baseProdutos.save(pd);
						break;
					case '2': // Atualizar por Cod
						cod = JOptionPane.showInputDialog("Digite o Cod do produto a ser alterado");
						pd = baseProdutos.findCod(cod);
						if (pd != null) {
							obterProduto(pd);
							baseProdutos.save(pd);
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível atualizar, pois o produto não foi encontrado.");
						}
						break;
					case '3': // Remover por Cod
						cod = JOptionPane.showInputDialog("Cod");
						pd = baseProdutos.findCod(cod);
						if (pd != null) {
							baseProdutos.delete(pd.getId());
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível remover, pois o produto não foi encontrado.");
						}
						break;
					case '4': // Exibir por Cod
						cod = JOptionPane.showInputDialog("Cod");
						pd = baseProdutos.findCod(cod);
						listaProduto(pd);
						break;
					case '5': // Exibir por id
						int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
						pd = baseProdutos.find(id);
						listaProduto(pd);
						break;
					case '6': // Exibir todos que contem determinada descricao
						String nome = JOptionPane.showInputDialog("Nome");
						listaProdutos(baseProdutos.findDesc(nome));
						break;
					case '7': // Exibir todos os precos menores ou iguais ao valor
						double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
						listaProdutos(baseProdutos.findLeq(valor));
						break;
					case '8': // Exibir intervalo entre datas
						LocalDate data1 = LocalDate.parse(JOptionPane.showInputDialog("data1"));
						LocalDate data2 = LocalDate.parse(JOptionPane.showInputDialog("data2"));
						listaProdutos(baseProdutos.findInterval(data1,data2));
						break;
					case '9': // Sair
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
				}
			} catch (NumberFormatException e) {
				log.error("Erro: {}", e.getMessage(), e);
				JOptionPane.showMessageDialog(null, "Entrada inválida: " + e.getMessage());

			} catch (Exception e) {
				log.error("Erro: {}", e.getMessage(), e);
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			}
		} while (opcao != '8');
	}

	public static void obterProduto(Produto cl) {
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Id", cl.getId()));
		String codigo = JOptionPane.showInputDialog("Código", cl.getCodigo());
		String descricao = JOptionPane.showInputDialog("Descrição", cl.getDescricao());
		Double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço", cl.getPreco()));
		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade", cl.getQtd()));
		cl.setId(id);
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
		for (Produto pd : produtos) {
			listagem.append(pd).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum produto encontrado" : listagem);
	}

	public static void listaProduto(Produto pd) {
		JOptionPane.showMessageDialog(null, pd == null ? "Nenhum produto encontrado" : pd);
	}
}