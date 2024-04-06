package Cricbuzz.repository;

import Cricbuzz.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>{
    Admin findByUsernameAndPassword(String username, String password);
//    @Query(value = "SELECT * FROM Admin WHERE username = :empCode", nativeQuery = true)
    Admin findByEmpCodeAndOrgId(@Param("username") String username);


}
