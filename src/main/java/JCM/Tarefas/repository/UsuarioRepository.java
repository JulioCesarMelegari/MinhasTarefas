package JCM.Tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import JCM.Tarefas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
