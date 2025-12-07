package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = AppConfig.memberService();

    @Test
    void join() {
        //given
        Grade grade = Grade.VIP;
        Long id = 2L;
        String name = "철수";

        Member joinMember = new Member(grade, id, name);

        //when
        memberService.join(joinMember);
        Member findMember = memberService.findMember(id);

        //then
        assertThat(findMember).isEqualTo(joinMember);
    }

    @Test
    void findMember() {
    }
}