package Exchange;

import Exchange.Transaction.Transaction;
import Model.NFT.NFT;
import Model.NFT.NFT_State;
import Model.Users.Artist;
import Model.Users.User;
import Model.Users.Wallet;

import java.util.HashMap;
import java.util.List;

public class Exchange {

    User exchange;

    HashMap<String, User> users;  // name -> user
    HashMap<Integer, NFT> allNFTs; // id -> nft

    public Exchange() {
        this.users = new HashMap<>();
        this.allNFTs = new HashMap<>();
        this.exchange = new User(null, "Exchange", 0);
        this.users.put(this.exchange.getName(), this.exchange);
    }



    public Artist create_artist(String name, double initial_money){
        if(this.users.get(name) != null) return null;
        Artist artist = new Artist(this.exchange, name, initial_money);
        this.users.put(artist.getName(), artist);
        return artist;
    }

    public User create_user(String name, double initial_money){
        if(this.users.get(name) != null) return null;
        User user = new User(this.exchange, name, initial_money);
        this.users.put(user.getName(), user);
        return user;
    }

    public int create_nft(String artist_id, String artwork, double royalty){
        if(this.users.get(artist_id) == null ) return -1;
        Artist artist = (Artist) this.users.get(artist_id);
        NFT nft = artist.create_NFT(artwork, royalty);
        if(nft == null) return -1;
        this.allNFTs.put(nft.getNft_id(), nft);
        //System.out.println(this.allNFTs);
        return nft.getNft_id();
    }

    public boolean place_sell_order(String usr, double selling_price, int nft_id){
        User user = this.users.get(usr);
        NFT nft = this.allNFTs.get(nft_id);
        user.place_sell_order(nft, selling_price);
        return true;
    }
    public boolean buy_nft( String buyer_id, double buying_price, int nft_id){
        NFT nft = this.allNFTs.get(nft_id);
        User user = this.users.get(buyer_id);
        Transaction transaction = user.buy_NFT(nft, buying_price);
        System.out.println("NFT successfully bought.");
        System.out.println();
        return true;
    }
    public void list_all_nft(){
        for(int id : this.allNFTs.keySet()){
            NFT nft = this.allNFTs.get(id);
            System.out.println(id +" "+ nft.getCreated_by().getName() +" "+
                    nft.getArtwork()+" "+nft.getCurrent_selling_price());
        }
    }
    public void list_all_users(){
        for(String usr : this.users.keySet()){
            User u = this.users.get(usr);
            System.out.println(u.getName() + " "+ u.getWallet().checkBalance());
        }
        System.out.println();
        System.out.println();
    }
    public void describe_nft(int nft_id){
        NFT nft = this.allNFTs.get(nft_id);
        List<Transaction> transactions = nft.getTransactions();
        for(Transaction transaction : transactions){
            System.out.println(nft.getCreation_date() + " "+nft.getCreated_by().getName() + " " +
                    nft.getArtwork() +" "
                    + transaction.getDate_of_transaction() + " "
                    + (transaction.getBuyer() != null ? transaction.getBuyer().getName() : "NA") + " " +
                    transaction.getSelling_price() + " "+transaction.getBuying_price());
        }
        System.out.println();
        System.out.println();
    }
}
