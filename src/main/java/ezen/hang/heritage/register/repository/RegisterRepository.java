package ezen.hang.heritage.register.repository;

import ezen.hang.heritage.register.entity.Register;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository <Register, Long> {
}
