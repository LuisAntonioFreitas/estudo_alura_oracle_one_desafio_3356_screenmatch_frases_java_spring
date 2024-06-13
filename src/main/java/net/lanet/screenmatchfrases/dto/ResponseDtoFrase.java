package net.lanet.screenmatchfrases.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.NoArgsConstructor;

@Hidden
@Data // @Getter @Setter @EqualsAndHashCode @ToString
@NoArgsConstructor //@AllArgsConstructor
public class ResponseDtoFrase {
    private String titulo;
    private String frase;
    private String personagem;
    private String poster;

    public ResponseDtoFrase(
            String titulo,
            String frase,
            String personagem,
            String poster) {
        this.titulo = titulo;
        this.frase = frase;
        this.personagem = personagem;
        this.poster = poster;
    }
}
