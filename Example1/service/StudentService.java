package com.example.Example1.service;

import com.example.Example1.mode.Studen;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Studen> getAllStudent();
    void saveStudent(Studen user);
    void deleteStudent(int id);
    Optional<Studen> findStudentById(int id);
    Studen findStudentByCode(String Code);
    Studen findStudentByEmail(String Email);
    Studen findStudentByPhone(String phone);
    Studen getOneStudent(int id);

}
