package com.rank.assesment.casino_backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rank.assesment.casino_backend.model.PlayerData;
import com.rank.assesment.casino_backend.repository.PlayerDataRepository;
import com.rank.assesment.casino_backend.repository.TransactionRepository;

@Service
public class CasinoService {

    @Autowired
    PlayerDataRepository playerDataRepository;

    @Autowired
    TransactionRepository transactionRepository;

    // getting all student records
    public List<PlayerData> getAllPlayers() {

        List<PlayerData> playerList = new ArrayList<PlayerData>();
        playerDataRepository.findAll().forEach(player -> playerList.add(player));
        return playerList;
    }

    // getting a specific record
    public PlayerData getPlayerById(Integer id) {

        Optional<PlayerData> requestedPlayer = playerDataRepository.findById(id);
        if(requestedPlayer.isPresent()) {

            return requestedPlayer.get();    
        }
        else {
            return null;
        } 
    }

    public PlayerData getPlayerByName(String name) {

        List<PlayerData> requestedPlayer = playerDataRepository.findByName(name);
        if(requestedPlayer.size() == 1) {

            return requestedPlayer.get(0);    
        }
        else {
            return null;
        } 
    }

    public void saveOrUpdatePlayer(PlayerData student) {

        playerDataRepository.save(student);
    }

    // deleting a specific record
    public void deletePlayer(int id) {
        
        playerDataRepository.deleteById(id);
    }
}
