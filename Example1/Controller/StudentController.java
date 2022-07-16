package com.example.Example1.Controller;
import com.example.Example1.mode.Studen;
import com.example.Example1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/studentdetall",method = RequestMethod.GET)
    public ResponseEntity<List<Studen>> listResponseEntity(){
        List<Studen> list = studentService.getAllStudent();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping(value = "/studentdetall/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Studen> getStudentByID(@PathVariable("id") int id){
        Studen u = studentService.getOneStudent(id);
        return new ResponseEntity<Studen>(u,HttpStatus.OK);
    }

    @RequestMapping(value = "/studentdetall/a/{code}",method = RequestMethod.GET)
    public ResponseEntity<Studen> getStudentByCode(@PathVariable("code")String code){
        Studen u = studentService.findStudentByCode(code);
        return new ResponseEntity(u,HttpStatus.OK);
    }

    @RequestMapping(value = "/studentdetall/ad/{phone}",method = RequestMethod.GET)
    public ResponseEntity<Studen> findStudentByPhone(@PathVariable("phone")String phone){
        Studen u = (Studen) studentService.findStudentByPhone(phone);
        return new ResponseEntity(u,HttpStatus.OK);
    }

    @RequestMapping(value = "/studentdetall/adu/{email}",method = RequestMethod.GET)
    public ResponseEntity<Studen> getStudentByEmail(@PathVariable("email")String email){
        Studen u = studentService.findStudentByEmail(email);
        return new ResponseEntity(u,HttpStatus.OK);
    }

    @RequestMapping(value = "/studentdetall/save", method = RequestMethod.POST)
    public ResponseEntity<Studen> saveStudent(@RequestBody Studen studen){
        studentService.saveStudent(studen);
        return ResponseEntity.ok(studen);
    }

        @RequestMapping(value = "/studentdetall/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Studen> updateStudent(@PathVariable("id")int id, @RequestBody Studen studen){

        Studen oldStuden = studentService.getOneStudent(id);
        if (oldStuden == null){
            return ResponseEntity.notFound().build();
        } else {
            oldStuden.setCode(studen.getCode());
            oldStuden.setName(studen.getName());
            oldStuden.setEmail(studen.getEmail());
            oldStuden.setPhone(studen.getPhone());
            oldStuden.setAddress(studen.getAddress());
            studentService.saveStudent(oldStuden);
            return ResponseEntity.ok(oldStuden);
        }
    }

    @RequestMapping(value = "/studentdetall/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Studen> deleteStudent(@PathVariable("id") int id){
        Optional<Studen> _olderStudent = studentService.findStudentById(id);
        if (_olderStudent == null){
            return ResponseEntity.notFound().build();
        } else {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }
    }

}
