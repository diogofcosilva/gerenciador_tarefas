package br.com.diogofco.gerenciadortarefas.servicos;

import br.com.diogofco.gerenciadortarefas.models.Usuario;
import br.com.diogofco.gerenciadortarefas.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServicoUsuario {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario encontrarPorEmail(String email) {
        return repositoryUsuario.findByEmail(email);
    }

    public void salvar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        repositoryUsuario.save(usuario);

    }
}
