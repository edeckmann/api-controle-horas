package eng.elemar.ponto.model.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

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
public class LocalidadeDTO {
    @EqualsAndHashCode
    @Embeddable
    public class LocalidadeId implements Serializable{
        private Long idMovimento;
        private Long idLocalidade;
        public int compareTo(Long id) {
            return 0;
        }
    }
    @EmbeddedId
    private LocalidadeId id;
    private String descricao;
}
