package com.ryan.managementlibrary.services;

import com.ryan.managementlibrary.models.Member;
import com.ryan.managementlibrary.repositories.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAll() {
        try {
            List<Member> members = memberRepository.getAll();
            if (members.isEmpty()) {
                throw new Exception("User not found!");
            }
            return members;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Member create(Member member) {
        try {
            return memberRepository.create(member);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Member findById(Integer id) {
        try {
            Optional<Member> result = memberRepository.findById(id);
            if (result.isEmpty()) {
                throw new Exception("User not found...");
            }
            return result.get();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Member member, Integer id) {
        try {
            memberRepository.update(member, id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            memberRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
