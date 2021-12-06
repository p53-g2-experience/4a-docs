package co.misiontic.p53.planes_ms.controllers;

import java.util.List;

import co.misiontic.p53.planes_ms.exceptions.ComentariosException;
import co.misiontic.p53.planes_ms.exceptions.PlanesNotFoundException;
import co.misiontic.p53.planes_ms.models.Planes;
import co.misiontic.p53.planes_ms.models.Comentarios;
import co.misiontic.p53.planes_ms.repositories.PlanesRepository;
import co.misiontic.p53.planes_ms.repositories.ComentariosRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComentariosController {

    private final PlanesRepository planesRepository;
    private final ComentariosRepository comentariosRepository;

    public ComentariosController(PlanesRepository planesRepository, ComentariosRepository comentariosRepository) {
        this.planesRepository = planesRepository;
        this.comentariosRepository = comentariosRepository;
    }

    // Revisar la logica de este comentario
    @PostMapping("/comentarios")
    Comentarios newComentarios(@RequestBody Comentarios comentarios){
        Planes planes = planesRepository.findById(comentarios.getCodigoPlan()).orElse(null);
        if (planes == null)
            throw new PlanesNotFoundException("No se encontraron comentarios sobre el plan: " + comentarios.getCodigoPlan());
        return comentariosRepository.save(comentarios);
    }

    @GetMapping("/comentarios/{username}")
    Comentarios userComentarios(@PathVariable String username){
        return comentariosRepository.
                findById(username).orElseThrow(() -> new ComentariosException("No se encontro reserva para el usuario: " + username));
    }

    //Actualizar comentario por usuario 
    @PutMapping("/comentarios/{username}")
    Comentarios replacePlan(@RequestBody Comentarios newComentario, @PathVariable String username) {
      return comentariosRepository.findById(username)

        .map(olderComentario -> {

          olderComentario.setCalificacion(newComentario.getCalificacion()); 
          olderComentario.setOpinion(newComentario.getOpinion()); 

          return comentariosRepository.save(olderComentario);
        })
        .orElseThrow(() -> new ComentariosException("No se ha encontrado ningún comentario. Por favor escribe uno:" + username));
    }

    //Eliminar comentario por usuario    
    @DeleteMapping("/comentarios/{username}")
    void deleteComentarios(@PathVariable String username) {
        comentariosRepository.deleteById(username);
    }    

    //Obtener todos los usuarios   
    @GetMapping("/comentarios")
        List<Comentarios> all() {
      return comentariosRepository.findAll();
    }

}



