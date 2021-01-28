package jpabook.jpashop.domain.item;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("A")
@Getter @Setter
public class Album extends Item {
	
	private String artist;
	private String etc;
}
