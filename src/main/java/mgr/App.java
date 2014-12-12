package mgr;

import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		ReferenceInfoJ ri = new ReferenceInfoJ();
 
		ri.setRfidJ(new Integer(91919));
		ri.setMidJ(new Integer(91919));
		ri.setReferenceJ(new String("reference"));
		
		System.out.println(ri.getMidJ()+ri.getReferenceJ()+ri.getRfidJ());
		session.save(ri);
		session.getTransaction().commit();
	}
}
