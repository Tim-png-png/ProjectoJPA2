package domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(length = 45, nullable = false, unique = true)
	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;

	@Column(nullable = false)
	@NotNull(message = "O campo quantidade é obrigatório")
	@Min(value = 0, message = "O valor mínimo para quantidade é 0")
	@Max(value = 150, message = "O valor máximo para quantidade é 150")
	private Integer quantidade;

	@Column(nullable = false, precision = 5, scale = 2)
	@NotNull(message = "O campo preço é obrigatório")
	@DecimalMin(value = "0.05", message = "O valor mínimo para preço é 0.05")	
	@DecimalMax(value = "350.50", message = "O valor máximo para preço é 350.50")
	private BigDecimal preco;

	@Column
	@Future(message = "Não pode registar produto expirado ou que expira hoje")
	private LocalDate dataDeValidade;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Categoria categoria;
}
