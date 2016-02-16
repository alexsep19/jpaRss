package jpaRss;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@Table(schema = "GWT")
//@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String grp;
	private String item;
	private String mess;
	private Date update;

	public Log() {
	}
	//------- mine -----------
	public Integer getVersion() {
		return 1;
	}
	public String toString(){
        return id==null?"0":String.valueOf(id);
       }

   //------------------------


	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq_gen")
	@SequenceGenerator(name = "log_seq_gen", sequenceName = "gwt.log_id_seq",allocationSize=1)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getGrp() {
		return this.grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}


	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}


	public String getMess() {
		return this.mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}


	@Temporal(TemporalType.DATE)
	public Date getUpdate() {
		return this.update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

}