package com.rank.assesment.casino_backend.model;

public enum TransactionType {
    
	NONE{
		public void ApplyChange(PlayerData player, double changeValue)
		{
			// No action Placeholder
		}
	},
	WAGER{
		public void ApplyChange(PlayerData player, double changeValue)
		{
			if (player.getFreeGameCount() > 0) {

				player.setFreeGameCount(player.getFreeGameCount() - 1);
			}
			else {
				
				player.setBalance(player.getBalance() - changeValue);
			}
			
		}
	},
	DEPOSIT{
		public void ApplyChange(PlayerData player, double changeValue)
		{
			player.setBalance(player.getBalance() + changeValue);
		}
	};

	public abstract void ApplyChange(PlayerData player, double changeValue);
}
