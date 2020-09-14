package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public void add(User user) {
        /*
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        System.out.println("Contact saved with id: " + user.getId());

         */
        //entityManager.getTransaction().begin();
        ///entityManager.merge(user);
        entityManager.persist(user);

        //entityManager.getTransaction().commit();
        //entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        /*
        User mergedUSer = entityManager.merge(user);
        entityManager.remove(mergedUSer);
        System.out.println("Contact with id: " + mergedUSer.getId() + " deleted successfully");

         */
        //entityManager.getTransaction().begin();
        entityManager.remove(user);
        //entityManager.getTransaction().commit();
    }

    @Override
    public void edit(User user) {
        /*
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        System.out.println("Contact saved with id: " + user.getId());

         */
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();

    }

    @Override
    public User getById(int id) {
        /*
        TypedQuery<User> query = entityManager.createNamedQuery("User.findById", User.class);
        query.setParameter("id", id);
        return query.getSingleResult().stream().findAny().orElse(null)
        */

        return entityManager.find(User.class, id);

    }
}
