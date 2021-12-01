package co.misiontic.p53.planes_ms.repositories;

import co.misiontic.p53.planes_ms.models.Reservas;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReservasRepository extends MongoRepository<Reservas, String>{
        List<Reservas> findByUsername (String username);
        List<Reservas> findByCodigoPlan (String codigoPlan);
    }

