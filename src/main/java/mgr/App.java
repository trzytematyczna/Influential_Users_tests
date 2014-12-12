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
//		ReferenceInfoJ ri = new ReferenceInfoJ();
// 
//		ri.setRfidJ(new Integer(91919));
//		ri.setMidJ(new Integer(91919));
//		ri.setReferenceJ(new String("reference"));
		
//		EmployeeListJ ri = new EmployeeListJ(91919, "first", "last", "email");
		
//		System.out.println(ri.getMidJ()+ri.getReferenceJ()+ri.getRfidJ());
//		RecipientInfoJ ri = new RecipientInfoJ(9991920, 91919, "TO", "rvalue", null);
		MessageJ ri = new MessageJ(91919, "sender", "2000-01-21 04:51:00", "msgid", "subject", "body", "folder");
		
		session.save(ri);
		session.getTransaction().commit();
	}
}
