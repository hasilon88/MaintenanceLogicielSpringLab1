package edu.mv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mv.models.RocketDTO;
import edu.mv.persistence.PersistenceService;
import edu.mv.persistence.RocketNotFoundException;

@Service
public class RocketService {

    @Autowired
    PersistenceService persistenceService;

    public void putRocket(RocketDTO Rocket) {
        persistenceService.save(Rocket);
    }

    public RocketDTO getRocket(int id) throws RocketNotFoundException {
        return persistenceService.retrieve(id);
    }
}
