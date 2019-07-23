package br.com.diogofco.gerenciadortarefas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull(message = "O e-mail é obrigatório")
    @Length(min = 5, max = 100, message = "O e-mail deve conter entre 5 e 100 caracteres.")
    private String email;

    @Column(nullable = false, length = 100)
    @NotNull(message = "A senha é obrigatória")
    private String senha;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Tarefa> tarefas;
}
