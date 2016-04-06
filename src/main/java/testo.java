import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
	
    public static void main(String[] a){
    	
    	testo o = new testo();
    	o.userism();
    	System.out.println(true);
    }
}
