package eng.elemar.ponto.model.dto;
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
public class EnderecoDTO {
    private Long id;
    private TipoEnderecoDTO tipoEndereco;
    private TipoLogradouroDTO tipoLogradouro;
    private String logradouro;
    private int numero;
    private String bairro;
    private MunicipioDTO municipio;
    private String cep;
    private EmpresaDTO empresa;
}
