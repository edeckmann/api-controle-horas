package eng.elemar.ponto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private TipoEndereco tipoEndereco;
    @ManyToOne
    private TipoLogradouro tipoLogradouro;
    private String logradouro;
    private int numero;
    private String bairro;
    @ManyToOne
    private Municipio municipio;
    private String cep;
    @ManyToOne
    private Empresa empresa;
}
