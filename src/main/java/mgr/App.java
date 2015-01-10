package mgr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws ParseException {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
/*		ReferenceInfoJ ri = new ReferenceInfoJ();
 
		ri.setRfidJ(new Integer(91919));
		ri.setMidJ(new Integer(91919));
		ri.setReferenceJ(new String("reference"));
		
		EmployeeListJ ri = new EmployeeListJ(91919, "first", "last", "email");
		
		System.out.println(ri.getMidJ()+ri.getReferenceJ()+ri.getRfidJ());
		RecipientInfoJ ri = new RecipientInfoJ(9991920, 91919, "TO", "rvalue", null);
		MessageJ ri = new MessageJ(91920, "sender", "2000-01-21 04:51:00", "msgid", "subject", "body", "folder");
		Query query = session.createQuery("from EmployeeListJ where eid = :eid ");
		query.setParameter("eid", "18");
		List<EmployeeListJ> email_list = query.list();
*/
		Query email_query = session.createQuery("select e.Email_idJ from EmployeeListJ e");
//		email_query.setMaxResults(2);
		List<Object> email_list = email_query.list();
		LinkedList<String[]> emails_count = new LinkedList<String[]>();

EmployeeInfoJ[] emp = new EmployeeInfoJ[4];
long i=1;
//sent emails count		
		for(Object emp4 : email_list){
//			System.out.println("Mails::"+emp4);//Arrays.toString(emp4));
			Query query = session.createQuery("select count(*) from MessageJ where senderJ = :sender");
			query.setParameter("sender", emp4);
			long sentcount = (long) query.uniqueResult();
			
			query = session.createQuery("select eidJ from EmployeeListJ where Email_idJ = :email");
			query.setParameter("email", emp4);
			int eid = (int) query.uniqueResult();
			
			query = session.createQuery("select count(*) from MessageJ where midJ in ("
			+ "select midJ from RecipientInfoJ where rvalueJ = :email )");
			query.setParameter("email", emp4);
			long recivedcount = (long) query.uniqueResult();

			query = session.createQuery("select count(*) from RecipientInfoJ where rvalue in (select distinct rvalueJ from RecipientInfoJ where midJ in "
			+ "(select midJ from MessageJ m where senderJ = :email))");
			query.setParameter("email", emp4);
			long recipientcount = (long) query.uniqueResult();
			String[] tab = {(String) emp4, Long.toString(sentcount), Long.toString(recivedcount), Long.toString(recipientcount)};
			double rank = countProfileRank(sentcount, recivedcount);
			EmployeeInfoJ empl = new EmployeeInfoJ(eid, (String) emp4, sentcount, recivedcount, "asd", rank);
			session.save(empl);
//			session.getTransaction().commit();
			emails_count.add(tab);
		}
//		int i=0;
//		for(Object elem : email_list){
//			email_list.get(0)
//			EmployeeInfoJ emp = new EmployeeInfoJ(i++, elem[0], elem[1], recived, latest, profile)
//			emp.setEmail("lokesh@mail.com");
//			emp.setFirstName("lokesh");
//			emp.setLastName("gupta");
//			
//			//Save the employee in database
//			session.save(emp);
//			session.getTransaction().commit();
//		}

//received emails count		
//		for(Object emp4 : email_list){
//			Query received = session.createQuery("select count(*) from MessageJ where midJ in ("
//					+ "select midJ from RecipientInfoJ where rvalueJ = :email )");
//			received.setParameter("email", emp4);
//			long count = (long) received.uniqueResult();
//			System.out.println(count);
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

	

//recipients count not work 
//		for(Object emp4 : email_list){
////			Object emp5 = email_list.get(0);
//			Query recipients1 = session.createQuery("select distinct count(rvalueJ) from RecipientInfoJ where midJ in "
//					+ "(select midJ from MessageJ m where senderJ = :email)");
////			recipients.setMaxResults(1);
//			recipients1.setParameter("email", emp4);
//			System.out.println(emp4+""+recipients1.uniqueResult());
//			List<String> recipientsL = recipients1.list();
//			for(String s : recipientsL){
//						System.out.println(emp4+" "+s);
//				
//			}
//		}
		
//recipients list
//		LinkedList<String[]> recipients_list = new LinkedList<String[]>();
//		for(Object emp4 : email_list){
//			Query recipients = session.createQuery("select distinct rvalueJ from RecipientInfoJ where midJ in "
//					+ "(select midJ from MessageJ m where senderJ = :email)");
//			recipients.setParameter("email", emp4);
//			List<String> recipientsL = recipients.list();
//			for(String s : recipientsL){
//				System.out.println(emp4+" "+s);
//				
//			}
//		}
//	
//		
		
//last mail value
/*
		LinkedList<String[]> lastest_list = new LinkedList<String[]>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(Object emp4 : email_list){
			Query timequery = session.createQuery("select senderJ, m.dateJ from MessageJ m where senderJ = :email");
//			timequery.setMaxResults(5);
			timequery.setParameter("email", emp4);
			List<Object[]> times = timequery.list();
			
			Date latest = format.parse("1880-10-10 10:10:10");
			Date prev = format.parse("1880-10-10 10:10:10");
			
			for (Object[] arr : times){
//			System.out.println(arr[0]+""+arr[1]);
				Date date = format.parse((String) arr[1]);
				 if (prev.compareTo(date) <= 0) {
					 latest=date;
				 }
				 prev = date;
			}
			String [] tab = {(String) emp4, format.format(latest)};
			lastest_list.add(tab);
//			System.out.println(Arrays.l );
//			System.out.println("Newest: "+latest);
//			System.out.println(times.size());
		}
*/
		
		Query query = session.createQuery("select count(*) from EmployeeListJ");
		long count = (Long) query.uniqueResult();
		System.out.println("count: "+ count);
		
//		session.save(ri);
		session.getTransaction().commit();
		session.close();
	}

	private static double countProfileRank(long sentcount, long recivedcount) {
		
		return 0.05* sentcount + 0.07 * recivedcount;
	}

}
