package programa.entity;


import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produto {
	private int id;
	private String codigo;
	private String descricao;
	private Double preco;
	private int qtd;
	private LocalDate data;	
}
