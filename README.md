# 실전!스프링 부트와 JPA활용 공부
> * Entity에는 Setter 배제(변경포인트 때문에 유지보수 어려움 있을 수 있다)
> * 모든 연관관계는 지연로딩
> * @ManyToOne, 연관관계 주인(mappedBy)는 웬만하면 외래키 가지는 Entity
> * Collection은 필드에서 초기화(null에서 안전)
> * redis등을 쓸 때 Entity말고 DTO를 통해서 조회(영속성 관련하여 꼬일 수 있음)
> * OSIV
>   - 최초 데이터베이스 커넥션 시작부터 API 응답이 끝날 때 까지 영속성 컨텍스트와 DB 커넥션을 유지
>   - 데이터베이스 커넥션을 너무 오래잡는 문제 발생(커넥션 부족 가능성)
