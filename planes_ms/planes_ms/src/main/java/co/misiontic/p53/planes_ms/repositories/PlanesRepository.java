package co.misiontic.p53.planes_ms.repositories;

import co.misiontic.p53.planes_ms.models.Planes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanesRepository extends MongoRepository <Planes, String> { }
