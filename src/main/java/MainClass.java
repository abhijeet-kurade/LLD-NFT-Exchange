import Exchange.Exchange;

public class MainClass {
    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        exchange.create_artist("A", 1000);
        exchange.create_user("B", 4000);
        int nft1 = exchange.create_nft("A", "Art1", 0.05);
        exchange.place_sell_order("A", 1000, nft1);
        exchange.buy_nft("B", 3000, nft1);
        exchange.describe_nft(nft1);
        exchange.list_all_users();
    }
}
