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

import sql.EmployeeInfoJ;
import sql.RolesJ;

/**
 * Hello world!
 *
 */
public class RolesCount 
{
	
	public static void main(String[] args) throws ParseException {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();

		Query query_pr = session.createQuery("select eid, email from EmployeeInfoJ order by profilerank desc");
		query_pr.setMaxResults(10);
		List<Object[]> topProfile = query_pr.list();

		for(Object[] emp4 : topProfile){
//			System.out.println("tops::"+emp4[0].toString());//Arrays.toString(emp4));
			Query recipients= session.createQuery("select count(*), role from EmployeeListJ e where Email_idJ in "
					+ "(select rvalue from SenderRecipientJ where sender = '"+emp4[1].toString()
					+ "') group by e.role");
			Query senders= session.createQuery("select count(*), role from EmployeeListJ e where Email_idJ in "
					+ "(select sender from SenderRecipientJ where rvalue = '"+emp4[1].toString()
					+ "') group by e.role");
			Query friends= session.createQuery("select count(*), role from EmployeeListJ e where Email_idJ in "
					+ "(select sender from SenderRecipientJ where rvalue = '"+emp4[1].toString()
					+ "' and sender in (select rvalue from SenderRecipientJ where sender = '"+emp4[1].toString()+"')"
					+ ") group by e.role");
			List<Object[]> recipientsRes = recipients.list();
			List<Object[]> sendersRes = senders.list();
			List<Object[]> friendsRes = friends.list();
			
			RolesJ rec = saveRole(Integer.parseInt(emp4[0].toString()), emp4[1].toString(), session, recipientsRes, "recipients");
			RolesJ sen = saveRole(Integer.parseInt(emp4[0].toString()), emp4[1].toString(), session, sendersRes, "senders");
			RolesJ fri = saveRole(Integer.parseInt(emp4[0].toString()), emp4[1].toString(), session, friendsRes, "friends");
			session.save(rec);
			session.save(sen);
			session.save(fri);
		}


		
		Query query = session.createQuery("select count(*) from EmployeeListJ");
		long count = (Long) query.uniqueResult();
		System.out.println("count: "+ count);
		
		session.getTransaction().commit();
		session.close();
	}
	private static RolesJ saveRole(int eid, String email, Session session, List<Object[]> recipientsRes, String wot) {
		int ceo = 0, pres= 0, vpres= 0, dir= 0, mng= 0, trad= 0, law= 0, empl= 0, na = 0;
		for(Object[] res : recipientsRes){
			String val = res[0].toString();
			switch(res[1].toString()){
				case "CEO": ceo = Integer.parseInt(val);
							break;
				case "President": pres = Integer.parseInt(val);
							break;
				case "Vice President": vpres = Integer.parseInt(val);
							break;
				case "Director": dir = Integer.parseInt(val);
							break;
				case "Manager": mng = Integer.parseInt(val);
							break;
				case "Trader": trad = Integer.parseInt(val);
							break;
				case "In House Lawyer": law = Integer.parseInt(val);
							break;
				case "Employee": empl = Integer.parseInt(val);
							break;
				case "N/A": na = Integer.parseInt(val);
							break;
			}
		}
//		System.out.println(eid+" "+email+wot+" CEO: "+ceo+" Pres: "+pres+" VPres: "+vpres+" Dir: "+dir+
//				" Man: "+mng+" Trad: "+trad+" Law: "+law+"Empl: "+empl+" NA:"+na);
		return new RolesJ(eid, email, ceo, pres, vpres, dir, mng, law, empl, trad, na, wot);
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
