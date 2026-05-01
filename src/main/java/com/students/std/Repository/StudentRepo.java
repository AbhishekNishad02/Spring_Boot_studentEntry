package com.students.std.Repository;

import com.students.std.Entity.StudentEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepo extends MongoRepository<StudentEntry, ObjectId> {

    Optional<StudentEntry> findByRollNo(int rollNo);

    long deleteByRollNo(int rollNo);
}
