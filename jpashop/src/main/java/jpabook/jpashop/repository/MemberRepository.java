package jpabook.jpashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jpabook.jpashop.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
		//메서드 이름으로 JPQL 쿼리 실행
		List<Member> findByName(String name);
}
