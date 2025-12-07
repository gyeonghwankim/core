package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Grade grade = Grade.VIP;
        long id = 1L;
        String name = "길동";
        Member member = new Member(grade, id, name);
        memberRepository.save(member);

        Order order = orderService.createOrder(id, "캔커피", 2000);
        System.out.println("order = " + order);

    }
}
