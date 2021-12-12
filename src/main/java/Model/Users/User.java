package Model.Users;

import Exchange.Constants;
import Exchange.Exchange;
import Exchange.Transaction.Transaction;
import Exchange.Transaction.Transaction_type;
import Model.NFT.NFT;
import Model.NFT.NFT_State;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    protected User exchange;
    private String name;
    private Wallet wallet;
    private List<NFT> holdings;


    public User(User exchange, String name, double initial_money) {
        this.wallet = new Wallet(initial_money);
        this.name = name;
        this.exchange = exchange;
        this.holdings = new ArrayList<>();
    }

    public void add_holdings(NFT nft){
        this.holdings.add(nft);
    }

    public boolean place_sell_order(NFT nft, double selling_price){
        nft.place_for_selling(selling_price);
        Transaction transaction = new Transaction(nft, LocalDateTime.now(), Transaction_type.NFT_CREATED, selling_price);
        nft.addTransaction(transaction);
        System.out.println("NFT successfully listed for sale.");
        return true;
    }

    public Transaction buy_NFT(NFT nft, double buying_price){
        double commission =  nft.getCurrent_selling_price() * 0.10;

        double required_amount = buying_price + (nft.getCurrent_selling_price() * nft.getRoyalty()) + commission;

        if(buying_price < nft.getCurrent_selling_price()){
            System.out.println("Unable to buy NFT, buying price is lesser than selling price");
            return null;
        }
        if(required_amount > this.getWallet().checkBalance()){
            System.out.println("Unable to buy NFT, not enough balance to pay commission");
            return null;
        }

        Transaction transaction = new Transaction(nft, LocalDateTime.now(), Transaction_type.BUY_SELL, nft.getCurrent_selling_price(), buying_price, nft.getOwner(), this);


        User artist = nft.getCreated_by();
        this.getWallet().deduceMoney(buying_price);
        this.getWallet().deduceMoney(commission);
        this.getWallet().deduceMoney(nft.getCurrent_selling_price() * nft.getRoyalty());
        artist.getWallet().addMoney(nft.getCurrent_selling_price() * nft.getRoyalty());
        nft.getOwner().getWallet().addMoney(buying_price);
        nft.getOwner().getWallet().deduceMoney(commission);
        exchange.getWallet().addMoney(2 * commission);

        nft.setOwner(this);
        nft.set_nft_state(NFT_State.BOUGHT);
        nft.addTransaction(transaction);

        return transaction;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }
}
