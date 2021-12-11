package Model.Users;

import Exchange.Transaction.Transaction;
import Exchange.Transaction.Transaction_type;
import Model.NFT.NFT;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Artist extends User{

    public Artist(String name, double initial_money) {
        super(name, initial_money);
    }

    public NFT create_NFT(String artwork, double royalty){
        
        NFT nft = new NFT(this, LocalDate.now(), artwork, royalty, this);
        Transaction transaction = new Transaction(nft, LocalDateTime.now(), Transaction_type.NFT_CREATED, 0);
        nft.addTransaction(transaction);
        super.add_holdings(nft);
        this.getWallet().deduceMoney(100);
        System.out.println("NFT created successfully.");
        return nft;
    }
}
