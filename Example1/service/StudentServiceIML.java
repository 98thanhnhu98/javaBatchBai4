package com.example.Example1.service;

import com.example.Example1.mode.Studen;
import com.example.Example1.repostoris.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIML implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Studen> getAllStudent() {
        return studentRepository.findAllByOrderByIdAsc();
    }

    @Override
    public void saveStudent(Studen user) {
        studentRepository.save(user);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById( id);
    }

    @Override
    public Optional<Studen> findStudentById(int id) {
        return studentRepository.findById( id);
    }

    @Override
    public Studen findStudentByCode(String Code) {
        return studentRepository.findByCode(Code);
    }

    @Override
    public Studen findStudentByEmail(String Email) {
        return studentRepository.findByEmail(Email);
    }

    @Override
    public Studen findStudentByPhone(String phone) {
        return studentRepository.findByPhone(phone);
    }
    @Override
    public Studen getOneStudent(int id) {
        return studentRepository.findById(id).get();
    }
}
