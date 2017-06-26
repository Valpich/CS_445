package iit.cs445.models.users;


import iit.cs445.models.products.Product;
import iit.cs445.models.services.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

    private List<Product> productList;

    private List<Service> serviceList;

    public Cart() {
        productList = new ArrayList<>();
        serviceList = new ArrayList<>();
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void remove(Product product) {
        productList.remove(product);
    }

    public void add(Service service) {
        serviceList.add(service);
    }

    public void remove(Service service) {
        serviceList.remove(service);
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
        return productList.size()+serviceList.size();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productList=" + productList +
                ", serviceList=" + serviceList +
                '}';
    }
}
