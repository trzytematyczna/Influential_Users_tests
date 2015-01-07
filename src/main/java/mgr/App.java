package mgr;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
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
//		MessageJ ri = new MessageJ(91920, "sender", "2000-01-21 04:51:00", "msgid", "subject", "body", "folder");
//		Query query = session.createQuery("from EmployeeListJ where eid = :eid ");
		Query query = session.createQuery("select e.Email_idJ from EmployeeListJ e");
//		query.setParameter("eid", "18");
//		List<EmployeeListJ> email_list = query.list();
		List<Object> email_list = query.list();
		LinkedList<String[]> emails_count = new LinkedList<String[]>();
		
//		for(Object emp4 : email_list){
//			System.out.println("Mails::"+emp4);//Arrays.toString(emp4));
//			Query emails = session.createQuery("select count(*) from MessageJ where senderJ = :sender");
//			emails.setParameter("sender", emp4);
//			long count = (long) emails.uniqueResult();
//			String[] tab = {(String) emp4, Long.toString(count)};
//			System.out.println(count);
//		}
		
//		for(Object emp4 : email_list){
//			Query received = session.createQuery("select count(*) from MessageJ where midJ in ("
//					+ "select midJ from RecipientInfoJ where rvalueJ = :email )");
//			received.setParameter("email", emp4);
//			long count = (long) received.uniqueResult();
//			System.out.println(count);
//			
//		}
//		List<Object> recipients_list;
//		for(Object emp4 : email_list){
//			Query recipients = session.createQuery("select count(*) from MessageJ where midJ in ("
//					+ "select midJ from RecipientInfoJ where rvalueJ in ("
//					+ "select r.rvalueJ from RecipientInfoJ r where midJ in ("
//					+ "select midJ from MessageJ where senderJ = :email ) ) )");
//			recipients.setParameter("email", emp4);
////			recipients_list = recipients.list();
//			System.out.println((long) recipients.uniqueResult());
//		}
		
//		List<List> times = new 
//		for (Object emp4 : email_list){
//			Query timequery = session.createQuery("select m.date from MessageJ m where senderJ = :email");
//			timequery.setParameter("email", emp4);
//			times.add(timequery.list());
////			times.add(asd);
//		}
		
			Query timequery = session.createQuery("select m.dateJ from MessageJ m where senderJ in ("
					+ "select e.Email_idJ from EmployeeListJ e)");
			List<Object[]> times = timequery.list();
		for (Object arr : times){
//			System.out.println(arr);
		}
			

		
		
		query = session.createQuery("select count(*) from EmployeeListJ");
		long count = (Long) query.uniqueResult();
		System.out.println("count: "+ count);
		
//		session.save(ri);
		session.getTransaction().commit();
	}
}
