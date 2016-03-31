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
@Table(name="urls",schema = "RSS")
//@NamedQuery(name="Url.findAll", query="SELECT u FROM Url u")
public class Url implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_seq_gen")
	@SequenceGenerator(name = "url_seq_gen", sequenceName = "rss.urls_id_seq",allocationSize=1)
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date lastpub;
	@Temporal(TemporalType.DATE)
	private Date laststart;
	private String schedule;
	private String url;
    @Column(name="IS_ACTIVE")
	private String isActive;

	@OneToMany(mappedBy="url", cascade=CascadeType.REMOVE)
	private List<Item> items;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mails_id")
	private Mail mail;

	public Url() {
	}
	//------- mine -----------
	public Integer getVersion() {
		return 1;
	}
	public String toString(){
        return id==null?"0":String.valueOf(id);
       }

  //------------------------


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getLastpub() {
		return this.lastpub;
	}

	public void setLastpub(Date lastpub) {
		this.lastpub = lastpub;
	}


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
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	//bi-directional many-to-one association to Item
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
	public Mail getMail() {
		return this.mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

}