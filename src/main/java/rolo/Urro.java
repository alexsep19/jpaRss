package rolo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the urro database table.
 * 
 */
@Entity
@Table(schema = "ROLO")
@NamedQuery(name="Urro.findAll", query="SELECT u FROM Urro u")
public class Urro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urro_seq_gen")
	@SequenceGenerator(name = "urro_seq_gen", sequenceName = "rolo.urro_id_seq",allocationSize=1)
	private Integer id;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.EAGER)
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;

	//------- mine -----------
	public Integer getVersion() {
		return 1;
	}
	public String toString(){
        return id==null?"0":String.valueOf(id);
	}
    //--------------------------

	public Urro() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}