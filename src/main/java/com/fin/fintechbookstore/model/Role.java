package com.fin.fintechbookstore.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "role")
@EqualsAndHashCode
public class Role
implements GrantedAuthority
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

	@Override
	public String getAuthority() {
		return name;
	}

}
