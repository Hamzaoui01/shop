package hamzaoui.com.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class AppUser {
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppUser(Long id, String username, String password, boolean actived, Collection<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.roles = roles;
	}
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String username;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	private boolean actived;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles=new ArrayList<AppRole>();
}
