package com.students.std.controller;

import com.students.std.Entity.StudentEntry;
import com.students.std.services.Studentservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class studentcontroler {

    @Autowired
    private Studentservices studentservices;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<StudentEntry> all = studentservices.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createentery(@RequestBody StudentEntry myentery) {
        try {
            myentery.setDate(LocalDateTime.now());
            studentservices.saveEntry(myentery);
            return new ResponseEntity<>(myentery, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/roll/{rollNo}")
    public ResponseEntity<?> getByRollNo(@PathVariable int rollNo){

        Optional<StudentEntry> student = studentservices.findByRollNo(rollNo);

        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/roll/{rollNo}")
    public ResponseEntity<?> delete(@PathVariable int rollNo){

        boolean deleted = studentservices.deleteByRollNo(rollNo);

        if(deleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/roll/{rollNo}")
    public ResponseEntity<?> update(@PathVariable int rollNo,
                                    @RequestBody StudentEntry newentery){

        StudentEntry updated = studentservices.updateByRollNo(rollNo, newentery);

        if(updated != null){
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
