package other;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the urldb database table.
 * 
 */
@Entity
@Table(name="urldb", schema = "ROLO")
public class Urldb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urldb_seq_gen")
	@SequenceGenerator(name = "urldb_seq_gen", sequenceName = "other.urldb_id_seq",allocationSize=1)
	private Integer id;
	private String name;
	private String url;

	public Urldb() {
	}

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

}