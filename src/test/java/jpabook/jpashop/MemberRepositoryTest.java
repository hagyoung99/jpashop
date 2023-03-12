package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.assertj.core.api.*;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith junit 5 버전부터는 아래의 어노테이션으로 변경됨
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional  //트랜잭션을 사용해야 오류가 안난다. JPA 에서 모든 데이터 수정은 트랜잭션 내에서 실행되어야한다.
    //트랜잭션 어노테이션이 테스트에 있으면 데이터 저장 후 다시 롤백해 초기 상태로 되돌린다.
    //@Rollback(false)    //롤백을 안하고 싶으면 해당 어노테이션을 설정하면 된다.
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);//같은 트랜잭션 내에서 식별자가 같으면 영속성이 관리가 되기 때문에 동일한 객체라고 나온다.
    }
}