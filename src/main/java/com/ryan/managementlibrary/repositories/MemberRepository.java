package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    List<Member> getAll() throws Exception;
    Member create (Member member) throws Exception;
    Optional<Member> findById (Integer id) throws Exception;
    void update(Member member, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
