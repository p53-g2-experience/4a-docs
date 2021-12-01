package co.misiontic.p53.planes_ms.controllers;

import co.misiontic.p53.planes_ms.models.Planes;
import co.misiontic.p53.planes_ms.exceptions.PlanesNotFoundException;
import co.misiontic.p53.planes_ms.repositories.PlanesRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanesController {
    private final PlanesRepository planesRepository;

    public PlanesController(PlanesRepository planesRepository) {

        this.planesRepository = planesRepository;
    }

    @PostMapping("/planes")
    Planes newPlanes(@RequestBody Planes planes){
        return planesRepository.save(planes);
    }

    @GetMapping("/planes/{codigoPlan}")
    Planes getPlanes(@PathVariable String codigoPlan) {

        return planesRepository.
        findById(codigoPlan).orElseThrow(() -> new PlanesNotFoundException("No se encontro el código del plan: " + codigoPlan));


    }

}


