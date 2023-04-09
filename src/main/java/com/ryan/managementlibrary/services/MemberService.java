package com.ryan.managementlibrary.services;

import com.ryan.managementlibrary.models.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAll();
    Member create(Member member);
    Member findById(Integer id);
    void update(Member member, Integer id);
    void delete(Integer id);
}
