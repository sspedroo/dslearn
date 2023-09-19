package com.devsuperior.dslearn.domain.user.model;

import com.devsuperior.dslearn.domain.notification.model.Notification;
import com.devsuperior.dslearn.domain.role.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "tb_user")
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) //os dados relacionados são carregados imediatamente junto com a entidade principal. Isso significa que, quando você busca a entidade principal, o JPA/Hibernate carregará automaticamente os dados relacionados sem a necessidade de uma consulta adicional ao banco de dados.
    @JoinTable(name = "tb_user_role", //: Esta parte está configurando a tabela de junção que será usada para armazenar a relação muitos-para-muitos entre User e Role. Especifica o nome da tabela de junção, que é "tb_user_role"
    joinColumns = @JoinColumn(name = "user_id"), // indica que a coluna "user_id" da tabela de junção será usada como chave estrangeira para a entidade User.
    inverseJoinColumns = @JoinColumn(name = "role_id")) // indica que a coluna "role_id" da tabela de junção será usada como chave estrangeira para a entidade Role.
    private Set<Role> roles = new HashSet<>();

    @ManyToOne()
    @JoinColumn(name = "notification_id")
    private Notification notifications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
