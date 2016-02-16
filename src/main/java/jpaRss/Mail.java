package jpaRss;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the mails database table.
 * 
 */
@Entity
@Table(name="mails",schema = "GWT")
//@NamedQuery(name="Mail.findAll", query="SELECT m FROM Mail m")
public class Mail implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String url;
	private List<Item> items;
	private List<Url> urls;

	public Mail() {
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mail_seq_gen")
	@SequenceGenerator(name = "mail_seq_gen", sequenceName = "gwt.mails_id_seq",allocationSize=1)

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
	@OneToMany(mappedBy="mail", cascade=CascadeType.REMOVE)
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
	@OneToMany(mappedBy="mail", cascade=CascadeType.REMOVE)
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

}