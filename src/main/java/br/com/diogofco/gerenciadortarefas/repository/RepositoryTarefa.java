package br.com.diogofco.gerenciadortarefas.repository;

import br.com.diogofco.gerenciadortarefas.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryTarefa extends JpaRepository<Tarefa, Long> {

    @Query("SELECT t FROM Tarefa t WHERE t.usuario.email = :emailUsuario")
    List<Tarefa> getTarefasPorUsuario(@Param("emailUsuario") String email);
}
