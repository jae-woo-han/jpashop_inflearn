package jpabook.jpashop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
	
	/*
	 * @PersistenceContext private EntityManager em;
	 */
	//@Autowired  //스프링 부트 jpa data 쓰면 @Autowired로 대체 가능  -> 롬복 ArgsConstructor 어노테이션 쓸 수 있다.
	private final EntityManager em;
	
	
	
	public void save(Member member) {
		em.persist(member);
	}
	
	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}
	
	public List<Member> findAll(){
		return em.createQuery("select m from Member m",Member.class)
				.getResultList();
	}
	
	public List<Member> findByName(String name){
		return em.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name", name)
				.getResultList();
	}
}
