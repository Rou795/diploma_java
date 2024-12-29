package hw.netology.diploma.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CloudServiceRepository {

    @PersistenceContext
    private EntityManager entityManager;

}
