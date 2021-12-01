package co.misiontic.p53.planes_ms.controllers;

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

    @PostMapping("/comentarios")
    Comentarios newComentarios(@RequestBody Comentarios comentarios){
        Planes planes = planesRepository.findById(comentarios.getCodigoPlan()).orElse(null);

        if (planes == null)
            throw new PlanesNotFoundException("No se encontro un comentario para el plan: " + comentarios.getCodigoPlan());

        return comentariosRepository.save(comentarios);
    }

    @GetMapping("/comentarios/{username}")
    Comentarios userComentarios(@PathVariable String username){
        return comentariosRepository.
                findById(username).orElseThrow(() -> new ComentariosException("No se encontro reserva para el usuario: " + username));
    }
}
