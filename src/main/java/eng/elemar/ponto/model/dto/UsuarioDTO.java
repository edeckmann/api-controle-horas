package eng.elemar.ponto.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class UsuarioDTO {
    
    private Long id;
    private String nome;
    private CategoriaUsuarioDTO categoriaUsuario;
    private EmpresaDTO empresa;
    private NivelAcessoDTO nivelAcesso;
    private JornadaTrabalhoDTO jornadaTrabalho;
    private BigDecimal tolerancia;
    private LocalDate inicioJornada;
    private LocalDate finalJornada;
}
