package br.com.diogofco.gerenciadortarefas.repository;

import br.com.diogofco.gerenciadortarefas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

}
