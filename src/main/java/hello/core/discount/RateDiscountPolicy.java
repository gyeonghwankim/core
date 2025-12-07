package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int rateDiscountAmount = 10;

    @Override
    public int calculate(int price, Member member) {
        Grade grade = member.getGrade();

        return switch (grade) {
            case Grade.VIP -> price * rateDiscountAmount / 100;
            default -> 0;
        };
    }
}
