package com.example.demo.Repo;

import com.example.demo.JavaClasses.TaxFunctions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TaxFunctionsRepo extends JpaRepository<TaxFunctions,Integer> {

}
