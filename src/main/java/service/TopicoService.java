package service;

import com.example.forohub.model.Topico;
import com.example.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    // Método para registrar un nuevo tópico
    public Topico crearTopico(Topico topico) {
        // Verificación de tópicos duplicados
        Optional<Topico> existingTopico = topicoRepository.findAll()
                .stream()
                .filter(t -> t.getTitulo().equals(topico.getTitulo()) && t.getMensaje().equals(topico.getMensaje()))
                .findFirst();

        if (existingTopico.isPresent()) {
            throw new IllegalArgumentException("Tópico duplicado");
        }

        // Guardar el tópico en la base de datos
        return topicoRepository.save(topico);
    }

    // Método para listar todos los tópicos
    public Iterable<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    // Método para obtener un tópico por ID
    public Optional<Topico> obtenerTopico(Long id) {
        return topicoRepository.findById(id);
    }

    // Método para actualizar un tópico
    public Optional<Topico> actualizarTopico(Long id, Topico topico) {
        if (!topicoRepository.existsById(id)) {
            return Optional.empty();
        }

        topico.setId(id);
        return Optional.of(topicoRepository.save(topico));
    }

    // Método para eliminar un tópico
    public boolean eliminarTopico(Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

