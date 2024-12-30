package hw.netology.diploma.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CloudServiceRepository {

    @PersistenceContext
    private EntityManager entityManager;

}
