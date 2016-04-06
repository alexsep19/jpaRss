package jpaRss;

import java.io.Serializable;

import javax.persistence.*;

import rolo.User;

import java.util.List;


/**
 * The persistent class for the mails database table.
 * 
 */
@Entity
@Table(name="mails",schema = "RSS")
//@NamedQuery(name="Mail.findAll", query="SELECT m FROM Mail m")
public class Mail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mail_seq_gen")
	@SequenceGenerator(name = "mail_seq_gen", sequenceName = "rss.mails_id_seq",allocationSize=1)
	private Integer id;
	private String name;
	private String url;
	@OneToMany(mappedBy="mail", cascade=CascadeType.REMOVE)
	private List<Item> items;
	@OneToMany(mappedBy="mail", cascade=CascadeType.REMOVE)
	private List<Url> urls;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	public Mail() {
	}

	//------- mine -----------
//	@Transient
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


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		item.setMail(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setMail(null);

		return item;
	}


	//bi-directional many-to-one association to Url
	public List<Url> getUrls() {
		return this.urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	public Url addUrl(Url url) {
		getUrls().add(url);
		url.setMail(this);

		return url;
	}

	public Url removeUrl(Url url) {
		getUrls().remove(url);
		url.setMail(null);

		return url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}