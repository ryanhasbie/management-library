package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Member;
import com.ryan.managementlibrary.models.mappers.MemberMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class MemberRepositoryImpl implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public MemberRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Member> getAll() throws Exception {
        try {
             String sqlGetAll = "SELECT * FROM t_member";
            return jdbcTemplate.query(sqlGetAll, new MemberMapper());
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Member create(Member member) throws Exception {
        try {
            String sqlInsert = "INSERT iNTO t_member(name, phone_number, address) VALUES(?,?,?)";
            int result = jdbcTemplate.update(sqlInsert, member.getName(), member.getPhoneNumber(), member.getAddress());
            if (result <= 0) {
                throw new Exception("Failed create user!");
            }
            return member;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Member> findById(Integer id) throws Exception {
        try {
            String sqlFindById = "SELECT * FROM t_member WHERE member_id = ?";
            Member member = jdbcTemplate.queryForObject(sqlFindById, new MemberMapper(), new Object[]{id});
            return Optional.ofNullable(member);
        } catch (DataAccessException e) {
            throw new Exception("Id User Not Found!");
        }
    }

    @Override
    public void update(Member member, Integer id) throws Exception {
        try {
            String sqlUpdate = "UPDATE t_member SET name = ?, phone_number = ?, address = ? WHERE member_id = ?";
            jdbcTemplate.update(sqlUpdate, member.getName(), member.getPhoneNumber(), member.getAddress(), id);
        } catch (DataAccessException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            String sqlDelete = "DELETE FROM t_member WHERE member_id = ?";
            jdbcTemplate.update(sqlDelete, id);
        } catch (DataAccessException e) {
            throw new Exception(e.getMessage());
        }
    }
}
