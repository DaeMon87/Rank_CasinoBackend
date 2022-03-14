package com.rank.assesment.casino_backend.repository;  

import com.rank.assesment.casino_backend.model.Transaction;
import org.springframework.data.repository.CrudRepository;  

public interface TransactionRepository extends CrudRepository<Transaction, Integer>  
{  
} 