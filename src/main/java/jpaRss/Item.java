package jpaRss;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="items",schema = "RSS")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_gen")
	@SequenceGenerator(name = "item_seq_gen", sequenceName = "rss.items_id_seq",allocationSize=1)
	private Integer id;
	private String title;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mails_id")
	private Mail mail;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="urls_id")
	private Url url;
    @Column(name="IS_ACTIVE")
	private String isActive;
	
	public Item() {
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


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//bi-directional many-to-one association to Mail
	public Mail getMail() {
		return this.mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}


	//bi-directional many-to-one association to Url
	public Url getUrl() {
		return this.url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}