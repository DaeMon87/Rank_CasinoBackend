package com.rank.assesment.casino_backend.repository;  

import java.util.List;

import com.rank.assesment.casino_backend.model.PlayerData;
import org.springframework.data.repository.CrudRepository;  

public interface PlayerDataRepository extends CrudRepository<PlayerData, Integer>  
{  
    List<PlayerData> findByName(String name);
} 
