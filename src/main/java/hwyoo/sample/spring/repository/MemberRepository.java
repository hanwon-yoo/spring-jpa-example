package hwyoo.sample.spring.repository;

import hwyoo.sample.spring.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hanwon.yoo on 2018. 7. 25..
 */
public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByNameAndAgeLessThan(String name, int age);
}
