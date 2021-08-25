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
public class EmpresaDTO {
    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;  
}
