package org.example.springcloud.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Document(collectionName = "users")
public class User {

    @DocumentId
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Timestamp createdAt;

    public User(String username, String firstName, String lastName, String email, int age, Timestamp createdAt) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", createdAt=" + createdAt +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private int age;
        private Timestamp createdAt;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public User build() {
            return new User(username, firstName, lastName, email, age, createdAt);
        }
    }

}
