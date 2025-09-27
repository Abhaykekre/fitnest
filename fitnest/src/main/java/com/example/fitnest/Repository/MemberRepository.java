package com.example.fitnest.Repository;

import com.example.fitnest.Model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}
