package br.com.diogofco.gerenciadortarefas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private String titulo;

    @Column(length = 100, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Date dataExpiracao;

    @Column(nullable = false)
    private Boolean concluida = false;
}
