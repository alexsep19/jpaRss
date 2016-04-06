package rolo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the state database table.
 * 
 */
@Entity
@Table(schema = "ROLO")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_seq_gen")
	@SequenceGenerator(name = "state_seq_gen", sequenceName = "rolo.state_id_seq",allocationSize=1)
	private Integer id;
	private String name;
	private String value;

	public State() {
	}
	//------- mine -----------
	public Integer getVersion() {
		return 1;
	}
	public String toString(){
        return id==null?"0":String.valueOf(id);
	}
    //--------------------------

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}