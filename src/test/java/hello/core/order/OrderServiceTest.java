package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {

    MemberRepository memberRepository = AppConfig.memberRepository();
    OrderService orderService = AppConfig.orderService();

    @Test
    void createOrder() {
        //given
        Grade grade = Grade.VIP;
        long id = 1L;
        String name = "길동";
        Member member = new Member(grade, id, name);
        memberRepository.save(member);

        //when
        Order order = orderService.createOrder(id, "캔커피", 2000);

        //then
        assertThat(order).isNotNull();
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}