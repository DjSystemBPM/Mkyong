// default package
// Generated 16/06/2017 05:54:03 PM by Hibernate Tools 5.2.3.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Auditlog.
 * @see .Auditlog
 * @author Hibernate Tools
 */
@Stateless
public class AuditlogHome {

	private static final Log log = LogFactory.getLog(AuditlogHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Auditlog transientInstance) {
		log.debug("persisting Auditlog instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Auditlog persistentInstance) {
		log.debug("removing Auditlog instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Auditlog merge(Auditlog detachedInstance) {
		log.debug("merging Auditlog instance");
		try {
			Auditlog result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Auditlog findById(Long id) {
		log.debug("getting Auditlog instance with id: " + id);
		try {
			Auditlog instance = entityManager.find(Auditlog.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
