package net.lanet.screenmatchfrases.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tab_frases")
@Data // @Getter @Setter @EqualsAndHashCode @ToString
@NoArgsConstructor @AllArgsConstructor
public class Frase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private Long id;
    @Column(name="titulo", nullable = false)
    private String titulo;
    @Column(name="frase", nullable = false)
    private String frase;
    @Column(name="personagem")
    private String personagem;
    @Column(name="poster")
    private String poster;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFrase() {
        return frase;
    }

    public String getPersonagem() {
        return personagem;
    }

    public String getPoster() {
        return poster;
    }
}
