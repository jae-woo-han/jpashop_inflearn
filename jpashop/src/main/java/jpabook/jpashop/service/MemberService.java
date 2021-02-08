package jpabook.jpashop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
//@AllArgsConstructor 필드에 값을 넣어주는 생성자 만들어주는 lombok 어노테이션
@RequiredArgsConstructor //final 있는 필드만 가지고 생성자 만들어준다.
public class MemberService {
	
	private final MemberRepository memberRepository;//컴파일 시점 체크위해서 final 쓰기
	
	//@Autowired //최신버전 스프링에서는 생성자가 하나만 있으면 @Autowired 없어도 자동으로 해준다
	/*
	 * public MemberService(MemberRepository memberRepository) {
	 * this.memberRepository = memberRepository; }
	 */
	
	//회원가입
	//전체 설정에 readOnly를 걸고, 쓰기메소드에만 개별로 걸어서 해제(readonly기본은 false)
	@Transactional
	public Long join(Member member) {
		validateDuplicateMember(member);
		
		memberRepository.save(member);
		return member.getId();
	}
	private void validateDuplicateMember(Member member) {
		//중복이면 예외 발생
		List<Member> findMembers = memberRepository.findByName(member.getName());
		if(!findMembers.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원");
		}
	}
	
	//회원 전체 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Member findOne(Long memberId) {
		return memberRepository.findOne(memberId);
	}
	
	@Transactional
	public void update(Long id, String name) {
		Member member = memberRepository.findOne(id);
		member.setName(name);
	}
}
