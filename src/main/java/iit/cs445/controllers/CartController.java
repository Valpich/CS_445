package iit.cs445.controllers;

import iit.cs445.models.orders.Order;
import iit.cs445.models.orders.OrderStatus;
import iit.cs445.models.products.Product;
import iit.cs445.models.services.Service;
import iit.cs445.models.users.Address;
import iit.cs445.models.users.Cart;
import iit.cs445.models.users.OrderAddress;
import iit.cs445.models.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class CartController {

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String list() {
        return "cart/list";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public String list(HttpServletRequest request, @RequestParam("id")Optional<Long> idOptional) {
        if(idOptional.isPresent()) {
            Long id = idOptional.get();
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            for (int i = 0; i < cart.getProductList().size(); i++) {
                Product p = cart.getProductList().get(i);
                if (id.equals(p.getId())) {
                    cart.getProductList().remove(p);
                    break;
                }
            }
            for (int i = 0; i < cart.getServiceList().size(); i++) {
                Service s = cart.getServiceList().get(i);
                if (id.equals(s.getId())) {
                    cart.getServiceList().remove(s);
                    break;
                }
            }
        }
        return "redirect:/cart";
    }

    @RequestMapping(value = "/cart/checkout", method = RequestMethod.GET)
    public String checkoutGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart.getListCount() <= 0) {
            return "cart/list";
        }
        request.setAttribute("totalItem", cart.getListCount());
        Float total = 0F;
        for (Product p : cart.getProductList())
            total += p.getPrice();
        for (Service s : cart.getServiceList())
            total += s.getPrice();
        request.setAttribute("total", total);
        return "cart/checkout";
    }

    @RequestMapping(value = "/cart/checkout", method = RequestMethod.POST)
    public String checkoutPost(HttpServletRequest request, @RequestParam("optradio") Long idAddress,
                               @RequestParam("firstName") Optional<String> firstNameOptional,
                               @RequestParam("lastName") Optional<String> lastNameOptional,
                               @RequestParam("phoneNumber") Optional<String> phoneNumberOptional,
                               @RequestParam("streetAddress") Optional<String> streetAddressOptional,
                               @RequestParam("city") Optional<String> cityOptional,
                               @RequestParam("zipCode") Optional<String> zipCodeOptional,
                               @RequestParam("state") Optional<String> stateOptional,
                               @RequestParam("country") Optional<String> countryOptional,
                               @RequestParam("cardHolderName") Optional<String> cardHolderNameOptional,
                               @RequestParam("cardNumber") Optional<String> cardNumberOptional,
                               @RequestParam("expiryMonth") Optional<String> expiryMonthOptional,
                               @RequestParam("expiryYear") Optional<String> expiryYearOptional,
                               @RequestParam("cvv") Optional<String> cvvOptional) {
        boolean valid = cardIsValid(cardHolderNameOptional, cardNumberOptional, expiryMonthOptional, expiryYearOptional, cvvOptional);
        if (!valid) return "cart/checkout";
        Logger.getLogger(CartController.class.getName()).log(Level.INFO, "Card is valid.");
        Address address;
        if (idAddress <= 0) {
            address = new Address();
            buildAddress(address, firstNameOptional, lastNameOptional, phoneNumberOptional, streetAddressOptional, cityOptional, zipCodeOptional, stateOptional, countryOptional);
        } else {
            address = new Address().findById(idAddress);
        }
        Logger.getLogger(CartController.class.getName()).log(Level.INFO, "Address is: " + address);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (address.getId() == null) {
            address.saveNew();
        }
        user.getAddresses().add(address);
        if (!saveCart(request, address.getId())) return "cart/list";
        session.setAttribute("cart", new Cart());
        return "redirect:/order/list";
    }

    private boolean cardIsValid(@RequestParam("cardHolderName") Optional<String> cardHolderNameOptional, @RequestParam("cardNumber") Optional<String> cardNumberOptional, @RequestParam("expiryMonth") Optional<String> expiryMonthOptional, @RequestParam("expiryYear") Optional<String> expiryYearOptional, @RequestParam("cvv") Optional<String> cvvOptional) {
        if (!(cardHolderNameOptional.isPresent() && cardNumberOptional.isPresent() && expiryMonthOptional.isPresent() && expiryYearOptional.isPresent() && cvvOptional.isPresent()))
            return false;
        if (cardHolderNameOptional.get().isEmpty() || cardNumberOptional.get().isEmpty() || expiryMonthOptional.get().isEmpty() || expiryYearOptional.get().isEmpty() || cvvOptional.get().isEmpty())
            return false;
        return true;
    }

    private void buildAddress(final Address address, @RequestParam("firstName") Optional<String> firstNameOptional, @RequestParam("lastName") Optional<String> lastNameOptional, @RequestParam("phoneNumber") Optional<String> phoneNumberOptional, @RequestParam("streetAddress") Optional<String> streetAddressOptional, @RequestParam("city") Optional<String> cityOptional, @RequestParam("zipCode") Optional<String> zipCodeOptional, @RequestParam("state") Optional<String> stateOptional, @RequestParam("country") Optional<String> countryOptional) {
        if (firstNameOptional.isPresent()) {
            address.setFirstName(firstNameOptional.get());
        }
        if (lastNameOptional.isPresent()) {
            address.setLastName(lastNameOptional.get());
        }
        if (phoneNumberOptional.isPresent()) {
            address.setPhoneNumber(phoneNumberOptional.get());
        }
        if (streetAddressOptional.isPresent()) {
            address.setStreetAddress(streetAddressOptional.get());
        }
        if (cityOptional.isPresent()) {
            address.setCity(cityOptional.get());
        }
        if (zipCodeOptional.isPresent()) {
            address.setZipCode(zipCodeOptional.get());
        }
        if (stateOptional.isPresent()) {
            address.setState(stateOptional.get());
        }
        if (countryOptional.isPresent()) {
            address.setCountry(countryOptional.get());
        }
    }

    private boolean saveCart(HttpServletRequest request, Long billingAddress) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart.getListCount() <= 0) {
            return false;
        }
        Order order = new Order();
        order.setOrderAddress(new OrderAddress().clone(new Address().findById(billingAddress)));
        order.setStatus(OrderStatus.PROCESSING);
        order.setOrderedProducts(cart.getProductList());
        Logger.getLogger(CartController.class.getName()).log(Level.INFO, "Product list is  " + cart.getProductList());
        order.setOrderedServices(cart.getServiceList());
        User user = (User) request.getSession().getAttribute("user");
        order.setUser(user);
        order.saveNew();
        user = user.findById(user.getId());
        Logger.getLogger(CartController.class.getName()).log(Level.INFO, "UserOrder is  " + user.getOrders());
        return true;
    }
}
