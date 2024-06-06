package net.lanet.screenmatchfrases.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.lanet.screenmatchfrases.dto.FraseDtoResponse;
import net.lanet.screenmatchfrases.entity.Frase;
import org.springframework.beans.BeanUtils;

@Data // @Getter @Setter @EqualsAndHashCode @ToString
@NoArgsConstructor //@AllArgsConstructor
public class FraseView {
    private String titulo;
    private String frase;
    private String personagem;
    private String poster;

    public FraseView(FraseDtoResponse model) { BeanUtils.copyProperties(model, this); }
}
