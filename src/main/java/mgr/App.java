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

		Query email_query = session.createQuery("select e.Email_idJ from EmployeeListJ e");
//		email_query.setMaxResults(2);
		List<Object> email_list = email_query.list();
		LinkedList<String[]> emails_count = new LinkedList<String[]>();

EmployeeInfoJ[] emp = new EmployeeInfoJ[4];
//sent emails count		
		for(Object emp4 : email_list){
//			System.out.println("Mails::"+emp4);//Arrays.toString(emp4));
			int eid = takeEid(session, emp4);
			long sentcount = takeSentCount(session, emp4);
			long recivedcount = takeReceivedCount(session, emp4);
			long recipientcount = takeRecipientCount(session, emp4);
			
			

			String[] tab = {(String) emp4, Long.toString(sentcount), Long.toString(recivedcount), Long.toString(recipientcount)};
			double rank = countProfileRank(sentcount, recivedcount);
			EmployeeInfoJ empl = new EmployeeInfoJ(eid, (String) emp4, sentcount, recivedcount, "asd", rank);
			session.save(empl);
			emails_count.add(tab);
		}

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
		
		session.getTransaction().commit();
		session.close();
	}

	private static long takeRecipientCount(Session session, Object emp4) {
		Query query = session.createQuery("select count(*) from RecipientInfoJ where rvalue in ("
				+ "select distinct rvalueJ from RecipientInfoJ where midJ in "
				+ "(select midJ from MessageJ m where senderJ = :email))");
		query.setParameter("email", emp4);
		long recipientcount = (long) query.uniqueResult();
		return recipientcount;
	}

	private static long takeReceivedCount(Session session, Object emp4) {
		Query query = session.createQuery("select count(*) from MessageJ where midJ in ("
				+ "select midJ from RecipientInfoJ where rvalueJ = :email )");
		query.setParameter("email", emp4);
		long recivedcount = (long) query.uniqueResult();
		return recivedcount;
	}

	private static long takeSentCount(Session session, Object emp4) {
		Query query = session.createQuery("select count(*) from MessageJ where senderJ = :sender");
		query.setParameter("sender", emp4);
		long sentcount = (long) query.uniqueResult();
		return sentcount;
	}

	private static int takeEid(Session session,Object emp4) {
		Query query = session.createQuery("select eidJ from EmployeeListJ where Email_idJ = :email");
		query.setParameter("email", emp4);
		int eid = (int) query.uniqueResult();		
		return eid;
	}

	private static double countProfileRank(long sentcount, long recivedcount) {
		
		return 0.05* sentcount + 0.07 * recivedcount;
	}

}
