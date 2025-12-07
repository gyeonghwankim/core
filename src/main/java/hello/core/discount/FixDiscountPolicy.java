package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000;

    @Override
    public int calculate(int price, Member member) {
        Grade grade = member.getGrade();

        return switch (grade) {
            case Grade.VIP -> discountFixAmount;
            default -> 0;
        };
    }
}
