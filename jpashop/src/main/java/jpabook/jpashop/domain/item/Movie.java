package jpabook.jpashop.domain.item;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("M")
@Getter @Setter
public class Movie extends Item {
	
	private String director;
	private String actor;
}
