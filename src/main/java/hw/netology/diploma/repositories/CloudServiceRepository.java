package hw.netology.diploma.repositories;

import hw.netology.diploma.models.Storage;
import hw.netology.diploma.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class CloudServiceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List getFilesByUser(String login) {
        String hql = "from Storage where user.login = :login";
        return entityManager.createQuery(hql).setParameter("login", login).getResultList();
    }

    public User getUserByLogin(String login) {
        String hql = "from Users where login = :login";
        return (User) entityManager.createQuery(hql).setParameter("login", login).getSingleResult();
    }

    public void saveFile(String filename, byte[] data) {
        User testUser = new User();
        Storage file = new Storage();
        file.setDate(LocalDate.now());
        file.setFileData(data);
        file.setUser(testUser);
        file.setRemoved(false);
        entityManager.persist(file);
        entityManager.flush();
    }
}
