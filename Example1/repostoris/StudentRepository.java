package com.example.Example1.repostoris;
import com.example.Example1.mode.Studen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository  extends JpaRepository<Studen,Integer> {
    List<Studen> findAllByOrderByIdAsc();
    Studen findByCode(String code);
    Studen findByPhone(String phone);
    Studen findByEmail(String email);
}
