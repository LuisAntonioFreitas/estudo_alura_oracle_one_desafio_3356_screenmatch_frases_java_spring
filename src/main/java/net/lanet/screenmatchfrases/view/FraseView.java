package net.lanet.screenmatchfrases.view;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.lanet.screenmatchfrases.dto.ResponseDtoFrase;
import org.springframework.beans.BeanUtils;

@Data // @Getter @Setter @EqualsAndHashCode @ToString
@NoArgsConstructor //@AllArgsConstructor
public class FraseView {
    private String titulo;
    private String frase;
    private String personagem;
    private String poster;

    public FraseView(ResponseDtoFrase model) { BeanUtils.copyProperties(model, this); }
}
