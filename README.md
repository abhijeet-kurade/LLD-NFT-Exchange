# LLD-NFT-Exchange

Problem Statement

Design an NFT exchange (Non Fungible Token Exchange) that orchestrates the sale and purchase of
NFT, using crypto currency (flipcoin) as a payment option.
An artist is considered to be a person who owns the NFT initially and creates NFT in the exchange.
The NFT artist may or may not charge a royalty on selling price for every transaction made on the
NFT, by specifying the royalty amount at the time of creation of the NFT.
Users (including artists) can come and buy/sell the NFTs on the exchange. The exchange charges a
fixed commission of 10% of the selling price (even if the buying price is higher) from both buyer as
well as seller for every transaction made on the NFT (buyer pays 10%, seller pays 10% as well). This
is deducted from their wallet, when a buy order is executed, without any explicit mention. The buyer
cannot buy NFT at less than the quoted selling price.
The NFT can be sold multiple times, post listing i.e once the NFT is bought by a user, ownership of
NFT will be transferred to the buyer. The buyer may choose to sell the same NFT again.
Capabilities expected from this system :
1. create_artist ( name, initial_money) -> This will create an artist, who can create, buy or sell
NFT.
a. ( Money can be added at the time of artist creation only )
2. create_user(name, initial_money) -> This will create a user, who can buy or sell NFT.
a. ( Money can be added at the time of user creation)
3. create_NFT(art_work, artist , royalty_in_percent) -> This will create an NFT on the exchange.
4. place_sell_order(nft_id, selling_price) -> this will list the NFT for sale on the exchange.
5. buy _NFT(nft_id, buyer_Id, buying_price) -> This will try to place the NFT purchase order, and
the order will be successful subject to conditions mentioned in the subsequent sections.
6. list_all_NFT() -> this will list all the NFTs registered with exchange.If item is not put up for sale,
selling price will not be applicable
a.
NFT ID Artist Art Selling Price
7. list_all_users() -> this should list all users along with their flipcoin balance. This should also
display the flip coin amount present with the exchange.
a.
User Id Flip coin balance
8. describe_NFT( nft_id) -> this should list the chain of possession of the NFT since creation with
the following details.
a.
NFT
Creation
date
Artist Art Date of
Transaction
Owner Selling
Price
Buying
Price
Following constraints need to be taken care while performing a transaction of the NFT during / post
registration
1. The exchange charges a creation fee for each new NFT ( say 100 flipcoins ), which needs to be
paid to the exchange, by the artist
2. The royalty should be debited from the buyer and credit to the artist, and not from the seller.
3. Exchange commission on selling price should be charged equally from both the buyer and
seller.
4. Buy orders cannot be placed if respective users don't have sufficient balance
