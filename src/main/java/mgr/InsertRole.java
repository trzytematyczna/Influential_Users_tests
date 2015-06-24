package mgr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

import sql.EmployeeListJ;

/**
 * Hello world!
 *
 */
public class InsertRole 
{
	
	public static void main(String[] args) throws ParseException {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();

		Query email_query = session.createQuery("select e.firstNameJ, e.lastNameJ from EmployeeListJ e");
//		email_query.setMaxResults(1);
		List<Object[]> email_list = email_query.list();
		
<<<<<<< HEAD
=======
//		LinkedList<String[]> emails_count = new LinkedList<String[]>();

		
>>>>>>> 378029ed2cf65940944a5b43687140a4c0668b5d
		String csvFile = "C://Users//MZ//Desktop//Erinaki//Enron_Employee_Status.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] employees = null;
		int i=181;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				
				employees = line.split(cvsSplitBy);
				boolean is = false;
				for(Object emp4[] : email_list){
					if((emp4[0].toString()).equals(employees[0]) && (emp4[1].toString()).equals(employees[1]) ){
						is = true;
//						Query updatequery = session.createQuery("update EmployeeListJ set role = :role where "
//								+ "firstNameJ = :first and lastNameJ = :last");
//						updatequery.setParameter("first", emp4[0]);
//						updatequery.setParameter("last", emp4[1]);
//						updatequery.setParameter("role", employees[2]);
//						int result = updatequery.executeUpdate();
////						System.out.println(result);
					}
				}
				if(!is){
					System.out.println(i+" "+employees[0]+" "+ employees[1]+" "+employees[2]);

//					if(!employees[1].equals("Gilberth-Smith") && !employees[1].equals("Arnold")){
//						System.out.println(i+" "+employees[0]+" "+ employees[1]+" "+employees[2]);
//						EmployeeListJ empl = new EmployeeListJ();
//						empl.setEidJ(i++);
//						empl.setFirstNameJ(employees[0]);
//						empl.setLastNameJ(employees[1]);
//						empl.setEmail_idJ(employees[0].toLowerCase()+"."+employees[1].toLowerCase()+"@enron.com");
//						empl.setRole(employees[2]);
//						session.save(empl);
//					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
<<<<<<< HEAD

=======
/*			System.out.println("Mails::"+emp4);//Arrays.toString(emp4));
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
		
//		Query query = session.createQuery("select count(*) from EmployeeListJ");
//		long count = (Long) query.uniqueResult();
//		System.out.println("count: "+ count);
		
		session.getTransaction().commit();
		session.close();
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


}
