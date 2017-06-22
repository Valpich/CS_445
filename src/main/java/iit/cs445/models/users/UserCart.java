package iit.cs445.models.users;


import iit.cs445.models.products.Product;
import iit.cs445.models.services.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserCart implements Serializable{

    private List<Product> productList;

    private List<Service> serviceList;

    public UserCart(){
        productList = new ArrayList<>();
        serviceList = new ArrayList<>();
    }
}
