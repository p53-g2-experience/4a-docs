package co.misiontic.p53.planes_ms.controllers;

import java.util.List;

import co.misiontic.p53.planes_ms.exceptions.PlanesNotFoundException;
import co.misiontic.p53.planes_ms.exceptions.DisponibilidadReservaException;
import co.misiontic.p53.planes_ms.models.Planes;
import co.misiontic.p53.planes_ms.models.Reservas;
import co.misiontic.p53.planes_ms.repositories.PlanesRepository;
import co.misiontic.p53.planes_ms.repositories.ReservasRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservasController {
    private final PlanesRepository planesRepository;
    private final ReservasRepository reservasRepository;

    public ReservasController(PlanesRepository planesRepository, ReservasRepository reservasRepository) {
        this.planesRepository = planesRepository;
        this.reservasRepository = reservasRepository;
    }

    @PostMapping("/reservas")
    Reservas newReservas(@RequestBody Reservas reservas){
        Planes planes = planesRepository.findById(reservas.getCodigoPlan()).orElse(null);

        if (planes == null)
            throw new PlanesNotFoundException("No se encontro una reserva con el plan: " + reservas.getCodigoPlan());

        if(planes.getValorPlan() > reservas.getValorReserva ())
            throw new DisponibilidadReservaException("El valor del pago es inferior al valor del plan");

        return reservasRepository.save(reservas);
    }

    @GetMapping("/reservas/{username}")
    List<Reservas> userReservas(@PathVariable String username) {
/*     Reservas userReservas(@PathVariable String username)  */
          return reservasRepository.findByUsername(username);
    }

    @GetMapping("/reservas/consulta/{codigoPlan}")
    List<Reservas> planReservas(@PathVariable String codigoPlan){
       List<Reservas> reservas = reservasRepository.findByCodigoPlan(codigoPlan);
        /*return reservasRepository.
                findById(codigoPlan).orElseThrow(() -> new DisponibilidadReservaException("No se encontro reserva para el plan: " + codigoPlan));
       */
       if (reservas.isEmpty()) {
           throw new DisponibilidadReservaException("No se encontro reserva para el plan: " + codigoPlan);
        }

       return reservas;
    }

    //Actualizar reserva por usuario 
    @PutMapping("/reservas/{username}")
    Reservas replacePlan(@RequestBody Reservas newReserva, @PathVariable String username) {
      return reservasRepository.findById(username)

        .map(olderReserva -> {

          olderReserva.setCantidadIntegrantes(newReserva.getCantidadIntegrantes()); 
          olderReserva.setFechaInicio(newReserva.getFechaInicio()); 
          olderReserva.setFechaFin(newReserva.getFechaFin());           

          return reservasRepository.save(olderReserva);
        })
        .orElseThrow(() -> new DisponibilidadReservaException("No se ha encontrado ninguna reserva con el usuario:" + username));
    }

    //Eliminar comentario por usuario    
    @DeleteMapping("/reservas/{username}")
    void deleteReservas(@PathVariable String username) {
        reservasRepository.deleteById(username);
    }    

    //Obtener todos los usuarios   
    @GetMapping("/reservas")
        List<Reservas> all() {
      return reservasRepository.findAll();
    }


}
