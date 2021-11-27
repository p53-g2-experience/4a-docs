package co.misiontic.p53.planes_ms.repositories;

import co.misiontic.p53.planes_ms.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository <Account, String> { }