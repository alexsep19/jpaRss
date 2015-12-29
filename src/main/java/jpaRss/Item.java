package jpaRss;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="items",schema = "GWT")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private Mail mail;
	private Url url;
	private String isActive;
	
	public Item() {
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


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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


	//bi-directional many-to-one association to Url
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="urls_id")
	public Url getUrl() {
		return this.url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}
	
    @Column(name="IS_ACTIVE")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}