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

import sql.ProfileRankJ;

/**
 * Hello world!
 *
 */
public class ProfileRankExperiments 
{
	private static double wp = 1;
	private static double wa = 1;
//	private static double ap = 0.03;  // sent 
//	private static double pc = 0.07; //received
//	private static double pf = 0.05; // recipients
//	private static double paf = 0.07; //friends
//	private static double pmpf = 0.06; //
		
	public static void main(String[] args) throws ParseException {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
<<<<<<< HEAD
		int i=4;
//		go(session, ++i, wp, wa, 0.1, 0.1, 0.1, 0.1, 0.1); //gen 3
//		go(session, ++i, wp, wa, 0.03, 0.03, 0.04, 0.1, 0.9);
//		go(session, ++i, wp, wa, 0.1, 0.1, 0.02, 0.03, 0.01);
//		go(session, ++i, wp, wa, 0.1, 0.1, 0.09, 0.03, 0.01);
//		go(session, ++i, wp, wa, 0.09, 0.04, 0.03, 0.08, 0.08); //gen 4
		go(session, ++i, wp, wa, 0.09, 0.01, 0.01, 0.1, 0.01); //gen 5		
//		go(session, ++i, wp, wa, 0.01, 0.01, 0.1, 0.05, 0.01);//gen 6
//		go(session, ++i, wp, wa, 0.01, 0.01, 0.1, 0.1, 0.05);//gen 7
//		go(session, ++i, wp, wa, 0.09, 0.09, 0.01, 0.05, 0.08);//gen 8
//		go(session, ++i, wp, wa, 0.04, 0.09, 0.01, 0.01, 0.01);//gen 9 
//		go(session, ++i, wp, wa, 0.01, 0.01, 0.01, 0.1, 0.1); //gen 10
		
//		go(session, ++i, wp, wa, 0.03, 0.07, 0.05, 0.07, 0.06);
//		go(session, ++i, wp, wa, 0.00, 0.00, 0.1, 0.00, 0.00);
//		go(session, ++i, wp, wa, 0.04, 0.08, 0.05, 0.09, 0.07);
//		go(session, ++i, wp, wa, 0.09, 0.05, 0.05, 0.09, 0.06);
//		go(session, ++i, wp, wa, 0.08, 0.08, 0.05, 0.1, 0.06);
//		go(session, ++i, wp, wa, 0.04, 0.09, 0.05, 0.09, 0.05);
//		go(session, ++i, wp, wa, 0.07, 0.06, 0.05, 0.1, 0.06);
//		go(session, ++i, wp, wa, 0.08, 0.04, 0.05, 0.04, 0.06);
//		go(session, ++i, wp, wa, 0.04, 0.08, 0.05, 0.04, 0.06);
=======
		int i=3;
		go(session, ++i, wp, wa, 0.04, 0.08, 0.05, 0.09, 0.07);
		go(session, ++i, wp, wa, 0.09, 0.05, 0.05, 0.09, 0.06);
		go(session, ++i, wp, wa, 0.08, 0.08, 0.05, 0.1, 0.06);
		go(session, ++i, wp, wa, 0.04, 0.09, 0.05, 0.09, 0.05);
		go(session, ++i, wp, wa, 0.07, 0.06, 0.05, 0.1, 0.06);
		go(session, ++i, wp, wa, 0.08, 0.04, 0.05, 0.04, 0.06);
		go(session, ++i, wp, wa, 0.04, 0.08, 0.05, 0.04, 0.06);
>>>>>>> 378029ed2cf65940944a5b43687140a4c0668b5d
//		LinkedList<String[]> emails_count = new LinkedList<String[]>();

/*		for(Object emp4 : email_list){
			System.out.println("Mails::"+emp4);//Arrays.toString(emp4));
			int eid = takeEid(session, emp4);
			long sentcount = takeSentCount(session, emp4);
			long recivedcount = takeReceivedCount(session, emp4);
//			List<String> recipientslist = takeRecipientsList(session, emp4); 
			long recipientcount = takeRecipientCount(session, emp4);
//			long recipientcount = recipientCount(recipientslist);
//			List<String> friendslist = takeFriendsList(session, emp4);
			long friendscount = takeFriendsCount(session, emp4);
			long mailToFriends = takeToFriendsEmailCount(session, emp4);
			long mailFromFriends = takeFromFriendsEmailCount(session, emp4);
			double rank = countProfileRank(sentcount, recivedcount, recipientcount,
					friendscount, mailFromFriends, mailToFriends);
			System.out.println(eid+" "+emp4+" "+sentcount+" "+recivedcount+" "+recipientcount+" "+
					friendscount+" "+mailFromFriends+" "+mailToFriends+" "+rank);
			EmployeeInfoJ empl = new EmployeeInfoJ(eid, (String) emp4, sentcount, recivedcount, recipientcount,
					friendscount, mailFromFriends, mailToFriends, rank);
			session.save(empl);
//			emails_count.add(tab);
		}
*/

<<<<<<< HEAD
=======
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
>>>>>>> 378029ed2cf65940944a5b43687140a4c0668b5d
		
		Query query1 = session.createQuery("select count(*) from EmployeeListJ");
		long count = (Long) query1.uniqueResult();
		System.out.println("count: "+ count);
		
		session.getTransaction().commit();
		session.close();
	}
	
	private static void go(Session session, int gen, double  wp, double wa, double ap, double pc, double pf, double paf, double pmpf){
<<<<<<< HEAD
//		Query query = session.createQuery("select i.eid, i.email, i.sent_email,i.received_email,"
//				+ "i.recipient_count,i.friends_count,i.mailFromFriends,i.mailToFriends, i.date from CountsSlotsJ i"
//				+ " where i.eid>151");
		Query query = session.createQuery("select i.eid, i.email, i.sent_email,i.received_email,"
				+ "i.recipient_count,i.friends_count,i.mailFromFriends,i.mailToFriends from EmployeeInfoJ i");
//		query.setMaxResults(1);
		List<Object[]> list = query.list();
		int i=1;
		for(Object[] entry:list){
			System.out.println(i+++" "+Long.parseLong(entry[0].toString()));
=======
		Query query = session.createQuery("select i.eid, i.email, i.sent_email,i.received_email,"
				+ "i.recipient_count,i.friends_count,i.mailFromFriends,i.mailToFriends from EmployeeInfoJ i");
//		email_query.setMaxResults(1);
		List<Object[]> list = query.list();
		for(Object[] entry:list){
			System.out.println(Long.parseLong(entry[0].toString()));
>>>>>>> 378029ed2cf65940944a5b43687140a4c0668b5d
			double rank = countProfileRank(Long.parseLong(entry[2].toString()), Long.parseLong(entry[3].toString()),
					Long.parseLong(entry[4].toString()), Long.parseLong(entry[5].toString()),
					Long.parseLong(entry[6].toString()), Long.parseLong(entry[7].toString()),
					wp, wa, ap, pc, pf, paf, pmpf);
			ProfileRankJ prank = new ProfileRankJ(Integer.parseInt(entry[0].toString()), rank, gen, wp, wa, ap, pc, pf, paf, pmpf);
<<<<<<< HEAD
			
			session.save(prank);
			System.out.println(rank);
//		Query up = session.createQuery("update CountsSlotsJ i set i.profilerank = :profilerank where i.eid = :eid and i.date = :date");
//		up.setParameter("date", entry[8]);
//		up.setParameter("profilerank", rank);
//		up.setParameter("eid", entry[0]);
//		up.executeUpdate();
=======
			session.save(prank);
>>>>>>> 378029ed2cf65940944a5b43687140a4c0668b5d
		}

	}
	private static List<String> takeFriendsList(Session session, Object emp4) {
		Query query = session.createQuery("select sender from SenderRecipientJ where rvalue = :email "
				+ "and sender in (select rvalue from SenderRecipientJ where sender = :email )");
		query.setParameter("email", emp4);
		List<String> friends = query.list();
		return friends;
	}
	private static long takeFriendsCount(Session session, Object emp4) {
//		System.out.println(emp4);
		Query query = session.createQuery("select count(sender) from SenderRecipientJ where rvalue = :email "
				+ "and sender in (select rvalue from SenderRecipientJ where sender = :email )");
		query.setParameter("email", emp4);
		long res = (long) query.uniqueResult();
		return res;
	}
	private static long takeToFriendsEmailCount(Session session, Object emp4){
		Query query = session.createQuery("select count(distinct m.midJ) from MessageJ m inner join m.recipients r "//on m.id=r.id"
				+ " where m.senderJ = :email and r.rvalueJ in ("
				+ "select sender from SenderRecipientJ where rvalue = :email "
				+ "and sender in (select rvalue from SenderRecipientJ where sender = :email ))");
//		Query query = session.createQuery("select count(*) from MessageJ where senderJ = :email and midJ in ("
//				+ " select message from RecipientInfoJ where rvalueJ in ("
//				+ "select sender from SenderRecipientJ where rvalue = :email "
//				+ "and sender in (select rvalue from SenderRecipientJ where sender = :email )))");
		query.setParameter("email", emp4);		
		long res = (long) query.uniqueResult();
		return res;
	}
	
	private static long takeFromFriendsEmailCount(Session session, Object emp4){
		Query query = session.createQuery("select count(distinct m.midJ) from MessageJ m inner join m.recipients r "//on m.id=r.id"
				+ " where r.rvalueJ = :email and m.senderJ in ("
				+ "select sender from SenderRecipientJ where rvalue = :email "
				+ "and sender in (select rvalue from SenderRecipientJ where sender = :email ))");
//		Query query = session.createQuery("select count(*) from MessageJ where senderJ = :email and midJ in ("
//				+ " select message from RecipientInfoJ where rvalueJ in ("
//				+ "select sender from SenderRecipientJ where rvalue = :email "
//				+ "and sender in (select rvalue from SenderRecipientJ where sender = :email )))");
		query.setParameter("email", emp4);		
		long res = (long) query.uniqueResult();
		return res;
	}

	private static List<String> takeRecipientsList(Session session, Object emp4) {
//		Query recipients = session.createQuery("select distinct rvalueJ from RecipientInfoJ where message in "
//				+ "(select midJ from MessageJ m where senderJ = :email)");
		Query recipients = session.createQuery("select rvalue from SenderRecipientJ where sender = :email)");
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
	private static long takeRecipientCount(Session session, Object emp4) {
		Query query = session.createQuery("select count(distinct rvalue) from SenderRecipientJ "
				+ "where sender = :email)");
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

	private static long takeReceivedCount(Session session, Object emp4) {
		Query query = session.createQuery("select count(*) from MessageJ where midJ in ("
				+ "select message from RecipientInfoJ where rvalueJ = :email )");
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

	private static double countProfileRank(long sentcount, long recivedcount, long recipientcount, 
			long friendscount, long mailFromFriends, long mailToFriends,
			double  wp, double wa, double ap, double pc, double pf, double paf, double pmpf) {
		double rank;
		if (friendscount == 0) {
			rank = wp * ((double)(pc * recivedcount)+ (double)(pf*recipientcount) + (double)(paf*friendscount))+
					wa * ((double)ap*sentcount); 
		}
		else{
			rank = wp * ((double)(pc * recivedcount)+ (double)(pf*recipientcount) + (double)(paf*friendscount)+
				(double)(pmpf*((double)(mailToFriends+mailFromFriends)/friendscount)))+wa * ((double)ap*sentcount);
		}
		return rank; 
	}

}
