package co.misiontic.p53.planes_ms.controllers;

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
    Reservas userReservas(@PathVariable String username){

        /*List<Reservas> reservas = reservasRepository.findByUsername(username);*/
        return reservasRepository.
                findById(username).orElseThrow(() -> new DisponibilidadReservaException("No se encontro reserva para el usuario: " + username));
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


}