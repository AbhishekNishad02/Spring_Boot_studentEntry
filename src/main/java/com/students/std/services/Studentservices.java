package com.students.std.services;

import com.students.std.Entity.StudentEntry;
import com.students.std.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Studentservices {

    @Autowired
    private StudentRepo studentRepo;

    public void saveEntry(StudentEntry studentEntry){
        studentRepo.save(studentEntry);
    }

    public List<StudentEntry> getAll(){
        return studentRepo.findAll();
    }

    public Optional<StudentEntry> findByRollNo(int rollNo){
        return studentRepo.findByRollNo(rollNo);
    }

    public boolean deleteByRollNo(int rollNo){
        Optional<StudentEntry> student = studentRepo.findByRollNo(rollNo);

        if(student.isPresent()){
            studentRepo.deleteByRollNo(rollNo);
            return true;
        }
        return false;
    }

    public StudentEntry updateByRollNo(int rollNo, StudentEntry newData){

        Optional<StudentEntry> optional = studentRepo.findByRollNo(rollNo);

        if(optional.isPresent()){

            StudentEntry old = optional.get();

            if(newData.getName() != null && !newData.getName().isEmpty()){
                old.setName(newData.getName());
            }

            if(newData.getMarks() > 0 && newData.getMarks() <= 100){
                old.setMarks(newData.getMarks());
            }

            return studentRepo.save(old);
        }

        return null;
    }
}
