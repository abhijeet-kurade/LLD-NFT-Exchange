package Exchange.Transaction;

import Model.NFT.NFT;
import Model.Users.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
    NFT nft;
    LocalDateTime date_of_transaction;
    Transaction_type transaction_type;
    double selling_price;
    double buying_price;
    User seller;
    User buyer;

    public Transaction(NFT nft, LocalDateTime date_of_transaction, Transaction_type transaction_type, double selling_price) {
        this.nft = nft;
        this.date_of_transaction = date_of_transaction;
        this.transaction_type = transaction_type;
        this.selling_price = selling_price;
    }


    public Transaction(NFT nft, LocalDateTime date_of_transaction, Transaction_type transaction_type, double selling_price, double buying_price, User seller, User buyer) {
        this.nft = nft;
        this.date_of_transaction = date_of_transaction;
        this.transaction_type = transaction_type;
        this.selling_price = selling_price;
        this.buying_price = buying_price;
        this.seller = seller;
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public LocalDateTime getDate_of_transaction() {
        return date_of_transaction;
    }

    public Transaction_type getTransaction_type() {
        return transaction_type;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public double getBuying_price() {
        return buying_price;
    }
}
