package repositories;

import org.hibernate.Session;
import org.revuesHibernate.utils.SessionHibernate;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class MysqlRepository<T> {

    /**
     * récupère la session courante
     * @return Session
     */
    public Session getCurrentSession() {
        return SessionHibernate.currentSession();
    }

    /**
     * récupère un seul champ avec l'id en paramètre
     * @param id
     * @param type
     * @return T
     */
    public T get(int id, Class<T> type) {
        return getCurrentSession().get(type, id);
    }

    /**
     * récupère tous les champs de la table
     * @param type
     * @return List<T>
     */
    public List<T> getAll(Class<T> type) {
        // Evite les injections SQL dans la requète
        // On récupère le builder pour construire la requète
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();

        // On commence à construire la requète en indiquant la classe cible
        CriteriaQuery query = criteriaBuilder.createQuery(type);
        Root<T> root = query.from(type);

        // On continue la construction de la requète avec le FROM
        CriteriaQuery<T> all = query.select(root);

        // On récupère la requète
        TypedQuery<T> allQuery = getCurrentSession().createQuery(all);
        // et on l'éxecute
        return allQuery.getResultList();
    }

    /**
     * enregistre un objet en base
     * @param object
     */
    public void save(T object) {
        System.out.println("Object " + object.getClass().toString());
        Session session = getCurrentSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }

    /**
     * supprime un élement de la table
     * @param object
     */
    public void delete(T object) {
        Session session = getCurrentSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }

    /**
     * modifie un objet
     * @param object
     */
    public void update(T object) {
        Session session = getCurrentSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }
}
