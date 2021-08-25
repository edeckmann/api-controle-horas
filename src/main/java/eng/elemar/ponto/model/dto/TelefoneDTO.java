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
public class TelefoneDTO {
    
    private Long id;
    private TipoTelefoneDTO tipoTelefone;
    private String ddi;
    private String ddd;
    private String telefone;
    private EmpresaDTO empresa;
}
