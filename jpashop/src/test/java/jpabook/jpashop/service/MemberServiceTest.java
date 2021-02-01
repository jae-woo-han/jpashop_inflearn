package jpabook.jpashop.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberServiceTest {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("han");

		// when
		Long saveId = memberService.join(member);

		// then
		assertEquals(member, memberRepository.findOne(saveId));
	}

	@Test
	void 중복_회원_예외() {
		// given
		Member member1 = new Member();
		member1.setName("han");

		Member member2 = new Member();
		member2.setName("han");

		// when
		memberService.join(member1);

		assertThrows(IllegalStateException.class, () -> {
			memberService.join(member2);
		});
		

		// assertEquals("이미 존재하는 회원", err.getMessage());

		// then
		// fail("예외가 발생해야 한다");

	}

}
