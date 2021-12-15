package co.misiontic.p53.planes_ms.repositories;

import co.misiontic.p53.planes_ms.models.Comentarios;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ComentariosRepository extends MongoRepository<Comentarios, String>{
    List<Comentarios> findByUsername (String username);
    List<Comentarios> findByCodigoPlan (String codigoPlan);
}
