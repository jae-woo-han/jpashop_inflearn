package jpabook.jpashop.domain.item;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter @Setter
public class Book extends Item {
	
	private String author;
	private String isbn;
}
