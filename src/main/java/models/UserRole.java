package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class UserRole {
	private String user;
	private String role;

	public UserRole(String user, String role) {
		super();
		this.user = user;
		this.role = role;
	}
}
