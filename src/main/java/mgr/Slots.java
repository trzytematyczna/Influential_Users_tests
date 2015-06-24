package mgr;

import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;

import sql.CountsSlotsJ;

/**
 * Hello world!
 *
 */
public class Slots 
{
	
	public static void main(String[] args) throws ParseException {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();

<<<<<<< HEAD
		Query email_query = session.createQuery("select e.email from EmployeeInfoJ e where eid>151 and profilerank>0");
=======
		Query email_query = session.createQuery("select e.Email_idJ from EmployeeListJ e");
>>>>>>> 378029ed2cf65940944a5b43687140a4c0668b5d
//		email_query.setMaxResults(1);
		List<Object> email_list = email_query.list();
		LinkedList<String[]> emails_count = new LinkedList<String[]>();
		String[] years= {"1999","2000","2001","2002"};
		String[] months = {"-01%","-02%","-03%","-04%","-05%","-06%","-07%","-08%",
				"-09%","-10%","-11%","-12%"};
		
		for(Object emp4 : email_list){
			System.out.println("Mails::"+emp4);
			for(String y : years){
				for(String m : months){
					Object dateval = y+m;
					int eid = takeEid(session, emp4);
<<<<<<< HEAD
//					long eid = (long)emp4;
=======
>>>>>>> 378029ed2cf65940944a5b43687140a4c0668b5d
					long sentcount = takeSentCount(session, emp4, dateval);
					long recivedcount = takeReceivedCount(session, emp4, dateval);
					long recipientcount = takeRecipientCount(session, emp4, dateval);	
					long friendscount = takeFriendsCount(session, emp4, dateval);
					long mailToFriends = takeToFriendsEmailCount(session, emp4, dateval);
					long mailFromFriends = takeFromFriendsEmailCount(session, emp4, dateval);
					System.out.println(eid+" "+emp4+" "+sentcount+" "+recivedcount+" "+recipientcount+" "+
							friendscount+" "+mailFromFriends+" "+mailToFriends);
					CountsSlotsJ empl = new CountsSlotsJ(eid, (String) emp4, sentcount, recivedcount, recipientcount,
							friendscount, mailFromFriends, mailToFriends, dateval.toString().substring(0, dateval.toString().length()-1));
					session.save(empl);
				}
			}
		}

		Query query = session.createQuery("select count(*) from EmployeeListJ");
		long count = (Long) query.uniqueResult();
		System.out.println("count: "+ count);
		
		session.getTransaction().commit();
		session.close();
	}
//	private static List<String> takeFriendsList(Session session, Object emp4) {
//		Query query = session.createQuery("select sender from SenderRecipientDatesJ where rvalue = :email "
//				+ "and sender in (select rvalue from SenderRecipientDatesJ where sender = :email )");
//		query.setParameter("email", emp4);
//		List<String> friends = query.list();
//		return friends;
//	}
	private static long takeFriendsCount(Session session, Object emp4, Object dateval) {
		Query query = session.createQuery("select count(sender) from SenderRecipientDatesJ where rvalue = :email "
				+ "and sender in (select rvalue from SenderRecipientDatesJ where sender = :email  and date like '"+dateval
				+ "' ) and date like '"+dateval+"'");
		query.setParameter("email", emp4);
		long res = (long) query.uniqueResult();
		return res;
	}
	private static long takeToFriendsEmailCount(Session session, Object emp4, Object dateval){
		Query query = session.createQuery("select count(distinct m.midJ) from MessageJ m inner join m.recipients r "//on m.id=r.id"
				+ " where m.senderJ = :email and r.rvalueJ in ("
				+ "select sender from SenderRecipientDatesJ where "
				+ "rvalue = :email "
				+ "and sender in ("
				+ "select rvalue from SenderRecipientDatesJ where sender = :email and  date like '"+dateval+"')"
				+ "and  date like '"+dateval+"')" 
				+ "and  date like '"+dateval+"'");
//		Query query = session.createQuery("select count(*) from MessageJ where senderJ = :email and midJ in ("
//				+ " select message from RecipientInfoJ where rvalueJ in ("
//				+ "select sender from SenderRecipientDatesJ where rvalue = :email "
//				+ "and sender in (select rvalue from SenderRecipientDatesJ where sender = :email )))");
		query.setParameter("email", emp4);		
		long res = (long) query.uniqueResult();
		return res;
	}
	
	private static long takeFromFriendsEmailCount(Session session, Object emp4, Object dateval){
		Query query = session.createQuery("select count(distinct m.midJ) from MessageJ m inner join m.recipients r "//on m.id=r.id"
				+ " where r.rvalueJ = :email and m.senderJ in ("
				+ "select sender from SenderRecipientDatesJ where "
				+ "rvalue = :email "
				+ "and sender in ("
				+ "select rvalue from SenderRecipientDatesJ where sender = :email and  date like '"+dateval+"')"
						+ "and  date like '"+dateval+"')"
						+"and  date like '"+dateval+"'");
//		Query query = session.createQuery("select count(*) from MessageJ where senderJ = :email and midJ in ("
//				+ " select message from RecipientInfoJ where rvalueJ in ("
//				+ "select sender from SenderRecipientDatesJ where rvalue = :email "
//				+ "and sender in (select rvalue from SenderRecipientDatesJ where sender = :email )))");
		query.setParameter("email", emp4);		
		long res = (long) query.uniqueResult();
		return res;
	}

	private static List<String> takeRecipientsList(Session session, Object emp4, Object dateval) {
//		Query recipients = session.createQuery("select distinct rvalueJ from RecipientInfoJ where message in "
//				+ "(select midJ from MessageJ m where senderJ = :email)");
		Query recipients = session.createQuery("select rvalue from SenderRecipientDatesJ where sender = :email "
				+ "and  date like '"+dateval+"'");
		recipients.setParameter("email", emp4);
		List<String> recipientsL = recipients.list();
		for(String s : recipientsL){
			System.out.println(emp4+" "+s);
		}
		return recipientsL;
	}
	
//	private static int recipientCount(List<String> recipients){
//		return recipients.size();		
//	}
	private static long takeRecipientCount(Session session, Object emp4, Object dateval) {
		Query query = session.createQuery("select count(distinct rvalue) from SenderRecipientDatesJ "
				+ "where sender = :email and date like '"+dateval+"'");
		query.setParameter("email", emp4);
		long recipientcount = (long) query.uniqueResult();
		return recipientcount;
	}

//	private static long takeRecipientCount(Session session, Object emp4) {
//		Query query = session.createQuery("select count(*) from RecipientInfoJ where rvalue in ("
//				+ "select distinct rvalueJ from RecipientInfoJ where message in "
//				+ "(select midJ from MessageJ m where senderJ = :email))");
//		query.setParameter("email", emp4);
//		long recipientcount = (long) query.uniqueResult();
//		return recipientcount;
//	}

	private static long takeReceivedCount(Session session, Object emp4, Object dateval) {
		Query query = session.createQuery("select count(*) from MessageJ where midJ in ("
				+ "select message from RecipientInfoJ where rvalueJ = :email ) and date like '"+dateval+"'");
		query.setParameter("email", emp4);
		long recivedcount = (long) query.uniqueResult();
		return recivedcount;
	}

	private static long takeSentCount(Session session, Object emp4, Object dateval) {
		Query query = session.createQuery("select count(*) from MessageJ where senderJ = :sender "
				+ "and date like '"+dateval+"'");
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


}
