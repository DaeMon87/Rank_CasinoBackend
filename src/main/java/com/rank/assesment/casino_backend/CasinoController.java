package com.rank.assesment.casino_backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rank.assesment.casino_backend.model.PlayerData;
import com.rank.assesment.casino_backend.model.PlayerDataDTO;
import com.rank.assesment.casino_backend.model.SupportRequest;
import com.rank.assesment.casino_backend.model.Transaction;
import com.rank.assesment.casino_backend.model.TransactionCommunication;
import com.rank.assesment.casino_backend.model.TransactionDTO;
import com.rank.assesment.casino_backend.model.TransactionType;
import com.rank.assesment.casino_backend.service.CasinoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CasinoController {

	@Autowired
	CasinoService casinoService;

	@GetMapping("/user")
	public List<PlayerDataDTO> UserDetail() {

		List<PlayerDataDTO> playerList = new ArrayList<PlayerDataDTO>();
        casinoService.getAllPlayers().forEach(player -> playerList.add(new PlayerDataDTO(player)));
        return playerList;
	}

	@GetMapping("/user/{id}")
	public PlayerDataDTO UserDetail(@PathVariable(value = "id") int id) {

		PlayerData pd = casinoService.getPlayerById(id);

		if (pd == null) {

			throw new PlayerNotFoundException("Player does not exist with id: '" + id + "'");
		}

		return new PlayerDataDTO(pd);
	}

	@GetMapping("/user/{id}/balance")
	public double UserBalance(@PathVariable(value = "id") int id) {

		PlayerData pd = casinoService.getPlayerById(id);

		if (pd == null) {

			throw new PlayerNotFoundException("Player does not exist with id: '" + id + "'");
		}

		return pd.getBalance();
	}

	@PostMapping(path = "/user/{id}/wager",
					consumes = MediaType.APPLICATION_JSON_VALUE, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public void Wager(@PathVariable(value = "id") int id, @RequestBody TransactionCommunication transaction) {

		PlayerData pd = casinoService.getPlayerById(id);

		if (pd == null) {

			throw new PlayerNotFoundException("Player does not exist with id: '" + id + "'");
		} 
		else if (pd.getBalance() < transaction.getChangeValue()) {

			throw new PlayerInsufficientFundsException("Not enough funds available");
		}

		if(pd.getId() == transaction.getId())
		{
			pd.ApplyChange(transaction, TransactionType.WAGER);
			casinoService.saveOrUpdatePlayer(pd);
		}
	}

	@PostMapping("/user/{id}/deposit")
	public void DepositWinnings(@PathVariable(value = "id") int id, @RequestBody TransactionCommunication transaction) {

		PlayerData pd = casinoService.getPlayerById(id);

		if (pd == null) {

			throw new PlayerNotFoundException("Player does not exist with id: '" + id + "'");
		}


		if(pd.getId() == transaction.getId())
		{
			pd.ApplyChange(transaction, TransactionType.DEPOSIT);
			casinoService.saveOrUpdatePlayer(pd);
		}
	}

	@PostMapping("/user/transaction")
	public List<TransactionDTO> PlayerTransactionRequest(@RequestBody SupportRequest supportRequest) {

		if(!supportRequest.getSecurityKey().equals("swordfish"))
		{
			throw new RuntimeException("Invalid Access Key");
		}

		PlayerData pd = casinoService.getPlayerByName(supportRequest.getUsername());

		if (pd == null) {

			throw new PlayerNotFoundException("Player does not exist with id");
		}

		if(!pd.getName().equals(supportRequest.getUsername()))
		{
			throw new PlayerNotFoundException("Player mismatch");
		}

		List<Transaction> tmpList = new ArrayList<Transaction>(pd.getTransactionlist());
		Collections.sort(tmpList, (o1, o2) -> o2.getTimestamp().compareTo(o1.getTimestamp()));
		
		List<TransactionDTO> returnList = new ArrayList<TransactionDTO>();
		tmpList.subList(0, Math.min(10, tmpList.size())).forEach(trans -> returnList.add(new TransactionDTO(trans)));

		return returnList;
	}

}