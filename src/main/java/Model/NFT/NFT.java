package Model.NFT;

import Exchange.Transaction.Transaction;
import Model.Users.Artist;
import Model.Users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NFT {
    private int nft_id;
    private User created_by;
    private User owner;
    private LocalDate creation_date;
    private String artwork;
    private double royalty;
    private NFT_State state_of_nft;
    private double current_selling_price;
    private List<Transaction> transactions;

    public NFT(User created_by, LocalDate creation_date, String artwork, double royalty, User owner) {
        int ids = GET_NFT_ID.getInstance().getNextNFTID();
        this.nft_id = ids;
        this.created_by = created_by;
        this.owner = owner;
        this.creation_date = creation_date;
        this.artwork = artwork;
        this.royalty = royalty;
        this.state_of_nft = NFT_State.CREATED;
        this.current_selling_price = 0;
        this.transactions = new ArrayList<>();
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getNft_id() {
        return nft_id;
    }

    public User getCreated_by() {
        return created_by;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public double getRoyalty() {
        return royalty;
    }

    public User getOwner() {
        return owner;
    }

    public String getArtwork() {
        return artwork;
    }

    public double getCurrent_selling_price() {
        return current_selling_price;
    }

    public void place_for_selling(double selling_price){
        set_nft_state(NFT_State.FOR_SELL);
        this.current_selling_price = selling_price;
    }

    public boolean set_nft_state(NFT_State state){
        this.state_of_nft = state;
        return true;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean addTransaction(Transaction transaction){
        this.transactions.add(transaction);
        return true;
    }
}
