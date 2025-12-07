package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        Member a = new Member(Grade.BASIC, 1L, "홍길동");

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        memberService.join(a);
        Member member = memberService.findMember(1L);
        System.out.println("member.getName() = " + member.getName());
    }
}
