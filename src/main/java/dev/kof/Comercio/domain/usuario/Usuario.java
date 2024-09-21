package dev.kof.Comercio.domain.usuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name="usuario", uniqueConstraints = {@UniqueConstraint(columnNames={"login"})})
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

    public Usuario (RequestUsuario requestUsuario){
        this.login = requestUsuario.login();
        this.senha = requestUsuario.senha();
        this.cargo = requestUsuario.cargo();
    }
}
