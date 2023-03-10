package de.gothaer.schweineservice.adapter.repository.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_schweine")
public class SchweinEntity {

	@Id
	@Column(length = 36, nullable = false)
	private String id;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int gewicht;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		SchweinEntity that = (SchweinEntity) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
