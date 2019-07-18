package br.com.diogofco.gerenciadortarefas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tarefa {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    @NotNull(message = "O título é obrigatório")
    @Length(max = 50, min = 3, message = "O título deve conter entre 3 e 50 caracteres")
    private String titulo;

    @Column(length = 100, nullable = false)
    @Length(max = 100, message = "O título deve conter até 100 caracteres")
    private String descricao;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataExpiracao;

    @Column(nullable = false)
    private Boolean concluida = false;
}
