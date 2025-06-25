package org.example.springcloud.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document(collectionName = "users")
public class User {

    @DocumentId
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Timestamp createdAt;

}
