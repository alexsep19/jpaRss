package jpaRss;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the urls database table.
 * 
 */
@Entity
@Table(name="urls",schema = "GWT")
//@NamedQuery(name="Url.findAll", query="SELECT u FROM Url u")
public class Url implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date lastpub;
	private Date laststart;
	private String schedule;
	private String url;
	private List<Item> items;
	private Mail mail;

	public Url() {
	}
	//------- mine -----------
	public Integer getVersion() {
		return 1;
	}

  //------------------------


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	public Date getLastpub() {
		return this.lastpub;
	}

	public void setLastpub(Date lastpub) {
		this.lastpub = lastpub;
	}


	@Temporal(TemporalType.DATE)
	public Date getLaststart() {
		return this.laststart;
	}

	public void setLaststart(Date laststart) {
		this.laststart = laststart;
	}


	public String getSchedule() {
		return this.schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}


	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="url")
	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setUrl(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setUrl(null);

		return item;
	}


	//bi-directional many-to-one association to Mail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mails_id")
	public Mail getMail() {
		return this.mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

}