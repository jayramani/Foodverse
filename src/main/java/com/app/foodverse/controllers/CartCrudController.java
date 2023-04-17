package com.app.foodverse.controllers;

import com.app.foodverse.models.Dishes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CartCrudController {
    CartController cartController = new CartController();

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") int id, Model model) throws SQLException {
        List<Dishes> cartAddList = cartController.storeDishId(id);
        model.addAttribute("cartAddList", cartAddList);
        return "/customer/index";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable("id") int id, Model model) throws SQLException {
        List<Dishes> cartList = cartController.removeDish(id);
        model.addAttribute("cartList", cartList);
        return "/customer/cart";
    }

    @GetMapping("/showcart")
    public String showCart(Model model) throws SQLException {
        List<Dishes> cartList = cartController.showCart();
        model.addAttribute("cartList", cartList);
        return "/customer/cart";
    }

    @RequestMapping(path = "/validation", method = RequestMethod.POST)
    public String validatePayment(@RequestParam("cname") String cname, @RequestParam("cnum") String cnum,
                                  @RequestParam("exp") String exp, @RequestParam("cvv") String cvv, Model model)
            throws SQLException {
        String message = cartController.validatePayment(cname, cnum, exp, cvv);
        model.addAttribute("message", message);
        return "/customer/payment";
    }

    @GetMapping(path = "/payment")
    public String makePayment(Model model) throws SQLException {
        return "/customer/payment";
    }
}
