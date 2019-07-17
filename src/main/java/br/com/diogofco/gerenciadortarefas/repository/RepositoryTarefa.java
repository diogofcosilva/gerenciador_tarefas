package br.com.diogofco.gerenciadortarefas.repository;

import br.com.diogofco.gerenciadortarefas.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTarefa extends JpaRepository<Tarefa, Long> {
}
