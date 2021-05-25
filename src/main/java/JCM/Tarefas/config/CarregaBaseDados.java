package JCM.Tarefas.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import JCM.Tarefas.model.Tarefa;
import JCM.Tarefas.model.TarefaCategoria;
import JCM.Tarefas.model.TarefaStatus;
import JCM.Tarefas.model.Usuario;
import JCM.Tarefas.repository.TarefaCategoriaRepository;
import JCM.Tarefas.repository.TarefaRepository;
import JCM.Tarefas.repository.UsuarioRepository;

@Configuration
@Profile("prod")
public class CarregaBaseDados {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TarefaCategoriaRepository categoriaRepository;
	
	@Autowired
	private TarefaRepository tarefaRepository;

	
	@Bean
	CommandLineRunner executar() {

		return args -> {
			Usuario usuario = new Usuario();
			usuario.setNome("Julio Cesar");
			usuario.setSenha("1234");
			usuarioRepository.save(usuario);
			
			TarefaCategoria categoria = new TarefaCategoria();
			categoria.setNome("Leitura");
			categoriaRepository.save(categoria);
			
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("Macunaima");
			tarefa.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa.setStatus(TarefaStatus.ABERTO);
			tarefa.setVisivel(true);
			tarefa.setCategoria(categoria);
			tarefa.setUsuario(usuario);
			tarefaRepository.save(tarefa);
			//-------Usuario 2---------
			Usuario usuario2 = new Usuario();
			usuario2.setNome("Suelen Bianchi");
			usuario2.setSenha("1234s4");
			usuarioRepository.save(usuario2);

			TarefaCategoria categoria2 = new TarefaCategoria();
			categoria2.setNome("Estudo");
			categoriaRepository.save(categoria2);
			
			Tarefa tarefa2 = new Tarefa();
			tarefa2.setDescricao("Mecanica quantica");
			tarefa2.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa2.setStatus(TarefaStatus.CONCLUIDA);
			tarefa2.setVisivel(true);
			tarefa2.setCategoria(categoria2);
			tarefa2.setUsuario(usuario2);
			tarefaRepository.save(tarefa2);
			
			//-------Usuario 3---------
			Usuario usuario3 = new Usuario();
			usuario3.setNome("Daniel Alberto");
			usuario3.setSenha("1jsu");
			usuarioRepository.save(usuario3);

			TarefaCategoria categoria3 = new TarefaCategoria();
			categoria3.setNome("Leitura");
			categoriaRepository.save(categoria3);
			
			Tarefa tarefa3 = new Tarefa();
			tarefa3.setDescricao("O Pequeno Principe");
			tarefa3.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa3.setStatus(TarefaStatus.EM_ANDAMENTO);
			tarefa3.setVisivel(true);
			tarefa3.setCategoria(categoria3);
			tarefa3.setUsuario(usuario3);
			tarefaRepository.save(tarefa3);
			
			//-------Usuario 4---------
			Usuario usuario4 = new Usuario();
			usuario4.setNome("Carlos Eduardo");
			usuario4.setSenha("carl68");
			usuarioRepository.save(usuario4);

			TarefaCategoria categoria4 = new TarefaCategoria();
			categoria4.setNome("Estudo");
			categoriaRepository.save(categoria4);
			
			Tarefa tarefa4 = new Tarefa();
			tarefa4.setDescricao("Mecanica dos Fluidos");
			tarefa4.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa4.setStatus(TarefaStatus.EM_ANDAMENTO);
			tarefa4.setVisivel(true);
			tarefa4.setCategoria(categoria4);
			tarefa4.setUsuario(usuario4);
			tarefaRepository.save(tarefa4);
			
		};
	}

}
