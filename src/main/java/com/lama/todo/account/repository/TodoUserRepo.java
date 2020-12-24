package com.lama.todo.account.repository;

import com.lama.todo.account.entity.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoUserRepo extends JpaRepository<TodoUser, Integer> {

    TodoUser findByUserId(String userId);

}
