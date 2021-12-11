package co.misiontic.p53.planes_ms.controllers;

import java.util.List;

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

    
    @GetMapping("/planes")
    List<Planes> all() {
      return planesRepository.findAll();
    }

    @GetMapping("/planes/{codigoPlan}")
    Planes getPlanes(@PathVariable String codigoPlan) {

        return planesRepository.
        findById(codigoPlan).orElseThrow(() -> new PlanesNotFoundException("No se encontro el código del plan: " + codigoPlan));
    }

    @DeleteMapping("/planes/{codigoPlan}")
    void deletePlanes(@PathVariable String codigoPlan) {
        planesRepository.deleteById(codigoPlan);
    }

    @PutMapping("/planes/{codigoPlan}")
    Planes replacePlan(@RequestBody Planes newPlan2, @PathVariable String codigoPlan) {
      
      return planesRepository.findById(codigoPlan)
        .map(olderPlan -> {

          olderPlan.setPlan_title(newPlan2.getPlan_title());
          olderPlan.setPlan_region(newPlan2.getPlan_region());
          olderPlan.setPlan_city(newPlan2.getPlan_city());
          olderPlan.setPlan_address(newPlan2.getPlan_address());
          olderPlan.setPlan_category(newPlan2.getPlan_category());
          olderPlan.setValorPlan(newPlan2.getValorPlan());
          olderPlan.setPlan_start_date(newPlan2.getPlan_start_date());
          olderPlan.setPlan_end_date(newPlan2.getPlan_end_date());
          olderPlan.setPlan_image_path(newPlan2.getPlan_image_path());
          olderPlan.setPlan_image2_path(newPlan2.getPlan_image2_path());
          olderPlan.setPlan_description(newPlan2.getPlan_description());
          olderPlan.setPlan_requirements(newPlan2.getPlan_requirements());         
          olderPlan.setPlan_availability(newPlan2.getPlan_availability());                     
          
          return planesRepository.save(olderPlan);
        })
        .orElseThrow(() -> new PlanesNotFoundException("No se encontro el código del plan: " + codigoPlan));
       // .orElseGet(() -> {
     //     newEmployee.setId(id);
   //       return repository.save(newEmployee);
 //       });
    }

}


