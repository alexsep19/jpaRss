import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import jpaRss.Item;
import jpaRss.Mail;
import jpaRss.Url;
import rolo.Role;
import rolo.Urro;
import rolo.User;


public class testo {
	final static String sql_user = "Select u from "+User.class.getSimpleName()+" u where u.name=?1";

	public testo() {
		// TODO Auto-generated constructor stub
	}
	
	public void userism(){
    	EntityManager em = Persistence.createEntityManagerFactory("jRss").createEntityManager();
    	List<User> u = em.createQuery(sql_user).setParameter(1, "admin").getResultList();
    	if (u.isEmpty()) return;
    	for(Urro it: u.get(0).getUrros()){
    		System.out.println(it.getRole().getCode());
    	}
	}
	
	private void mailo(){
		EntityManager em = Persistence.createEntityManagerFactory("jRss").createEntityManager();
		try{
			  List<Mail> m = em.createQuery(new StringBuilder("select m from ").append(Mail.class.getSimpleName()).append(" m,").
					          append(Url.class.getSimpleName()).append(" u,").
					          append(Item.class.getSimpleName()).append(" i where u.isActive='Y' and i.isActive='Y' and i.mail=m and i.url=u and u.mail=m").
                            toString()).getResultList();

			  System.out.println(m.size());
			  for(Mail mit: m){
				 String mailTo = mit.getUrl();
				 System.out.println("mailTo = "+ mailTo);
				 for(Url uit: mit.getUrls()){
					for(Item iit: uit.getItems()) System.out.println(iit.getTitle());
//					LostFilmParser parser = new LostFilmParser(uit.getUrl(), titles);
//			        Feed feed = parser.readFeed();
//			        System.out.println(feed);
//			        for (FeedMessage message : feed.getMessages()) {
//			            System.out.println("title = "+message.getTitle()+ "; description = "+message.getDescription()+"; pubDate = "+message.getPubDate());
////			            sendMail(message.getTitle(), mailTo, message.getItem() + " "  + message.getDescription());
//	  	            }
//			        titles.clear();
				
			   }}
		  
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    public static void main(String[] a){
    	
    	testo o = new testo();
//    	o.userism();
    	o.mailo();
    	System.out.println(true);
    }
}
