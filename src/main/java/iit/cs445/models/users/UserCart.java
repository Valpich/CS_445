package iit.cs445.models.users;


import iit.cs445.models.products.Product;
import iit.cs445.models.services.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserCart implements Serializable{

    private List<Product> productList;

    private List<Service> serviceList;

    private Integer listCount;

    public UserCart(){
        productList = new ArrayList<>();
        serviceList = new ArrayList<>();
        listCount = 0;
    }

    public void addProduct(Product product){
        productList.add(product);
        listCount++;
    }

    public void removeProduct(Product product){
        productList.remove(product);
        listCount--;
    }

    public void addService(Service service){
        serviceList.add(service);
        listCount++;
    }

    public void removeProduct(Service service){
        serviceList.remove(service);
        listCount--;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public Integer getListCount() {
        return listCount;
    }

    public void setListCount(Integer listCount) {
        this.listCount = listCount;
    }
}
