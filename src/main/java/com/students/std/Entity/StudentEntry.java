package com.students.std.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "stdEntry")
    @Data
    @NoArgsConstructor
public class StudentEntry {

    @Id
    private ObjectId id;

    private String name;

    @Indexed(unique = true)
    private int rollNo;

    private int marks;
    private LocalDateTime date;

   
}
