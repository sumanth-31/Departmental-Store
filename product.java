import java.io.Serializable;

public class product implements Serializable{
    int pno,quan=0;
    String name;
    float price;
    void create_product(int pno1,float price1,int quan1,String name1 )
    {
        pno=pno1;
        price=price1;
        quan=quan1;
        name=name1;
    }

}
