package org.example.springcloud.repository;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import org.example.springcloud.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends FirestoreReactiveRepository<User> {
}
