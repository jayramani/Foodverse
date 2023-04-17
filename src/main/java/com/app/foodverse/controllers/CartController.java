package com.app.foodverse.controllers;

import com.app.foodverse.dao.CartRepository;
import com.app.foodverse.models.Cart;
import com.app.foodverse.models.Dishes;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@RestController
public class CartController {

    Cart cart = new Cart(new CartRepository());

    @GetMapping("/api/cart/showCart")
    List<Dishes> showCart() throws SQLException {
        return cart.showCart();
    }
    @GetMapping("/api/cart/add/{id}")
    public List<Dishes> storeDishId(@PathVariable("id") int id) throws SQLException {
        return cart.storeDishId(id);
    }

    @GetMapping("/api/cart/remove/{id}")
    public List<Dishes> removeDish(@PathVariable("id") int id){
        return cart.removeDish(id);
    }

    @GetMapping("/validation/{cname}/{cnum}/{exp}/{cvv}")
    public String validatePayment(@PathVariable("cname") String cname, @PathVariable("cnum") String cnum, @PathVariable("exp") String exp,@PathVariable("cvv") String cvv){
        return cart.validatePayment(cname,cnum,exp,cvv);
    }

}
