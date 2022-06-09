package com.fastfood.fastfood.repositories.user;

import com.fastfood.fastfood.entities.user.VerificationCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationCodeRepository extends CrudRepository<VerificationCode, String> {

}
