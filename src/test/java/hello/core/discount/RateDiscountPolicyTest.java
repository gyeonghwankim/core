package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void VIP는_정률_할인을_받는다() {
        //given
        Member member = new Member(Grade.VIP, 3L, "영희");

        //when
        int discount = discountPolicy.calculate(20000, member);

        //then
        Assertions.assertThat(discount).isEqualTo(2000);
    }

    @Test
    void VIP가_아니면_정률_할인을_못받는다() {
        //given
        Member member = new Member(Grade.BASIC, 4L, "경환");

        //when
        int discount = discountPolicy.calculate(20000, member);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}