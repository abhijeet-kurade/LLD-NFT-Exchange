package Model.NFT;

public class GET_NFT_ID {
    private int current_id = 0;
    private static  GET_NFT_ID obj;

    private GET_NFT_ID() {
    }
    public static GET_NFT_ID getInstance(){
        if(obj == null){
            obj = new GET_NFT_ID();
            obj.current_id = 0;
        }
        return obj;
    }

    public int getNextNFTID(){
        this.current_id += 1;
        return this.current_id;
    }
}
