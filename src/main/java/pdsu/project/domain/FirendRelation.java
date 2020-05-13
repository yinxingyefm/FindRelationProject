package pdsu.project.domain;

public class FirendRelation {
	private Integer id;
	private String per_num;
	private String fir_num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPer_num() {
		return per_num;
	}
	public void setPer_num(String per_num) {
		this.per_num = per_num;
	}
	public String getFir_num() {
		return fir_num;
	}
	@Override
	public String toString() {
		return "FirendRelation [id=" + id + ", per_num=" + per_num + ", fir_num=" + fir_num + "]";
	}
	public void setFir_num(String fir_num) {
		this.fir_num = fir_num;
	}

}
