package dev.kof.Comercio.domain.usuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name="usuario")
@Entity(name="usuario")
@EqualsAndHashCode(of="codUsuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codUsuario;

    private String login;

    private String senha;

    private String cargo;


}
