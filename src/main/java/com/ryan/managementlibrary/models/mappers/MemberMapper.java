package com.ryan.managementlibrary.models.mappers;

import com.ryan.managementlibrary.models.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member();
        member.setMemberId(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setPhoneNumber(rs.getString("phone_number"));
        member.setAddress(rs.getString("address"));
        return member;
    }
}
