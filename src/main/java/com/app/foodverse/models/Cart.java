package com.app.foodverse.models;
import com.app.foodverse.dao.ICartRepository;
import java.util.regex.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private ICartRepository cartRepository = null;

    List<Dishes> cartItems = new ArrayList<>();

    public Cart(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Dishes getDishById(int id) throws SQLException {
        if(id<=0){
            return null;
        }else {
            Dishes dishes = this.cartRepository.getDishById(id);
            return dishes;
        }
    }

    public List<Dishes> storeDishId(int id) throws SQLException {

        if(id<=0){
            return null;
        }else {
            boolean flag = false;
            if (cartItems.size() == 0) {
                cartItems.add(getDishById(id));
                flag = true;

            } else {
                for (Dishes d : cartItems) {
                    if (d.getDishId() == id) {
                        flag = true;
                        break;
                    }
                }
            }
            if (cartItems.size() > 0 && flag == false) {
                cartItems.add(getDishById(id));
            }
        }
        return cartItems;
    }
    public List<Dishes> showCart() {
        if(cartItems.size()==0){
            return null;
        }
        return cartItems;
    }

    public List<Dishes> removeDish(int id) {

        if(cartItems.size()==0){
            return null;
        }else {
            int i = 0;
            if (cartItems.size() > 0) {
                for (Dishes eachItem : cartItems) {
                    if (eachItem.getDishId() == id) {
                        cartItems.remove(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        return cartItems;
    }

    public String validatePayment(String cname, String cnum, String exp, String cvv) {
        String message = null;

        String nameRegex = "^(?![ .]+$)[a-zA-Z .]*$";
        String numberRegex = "^4[0-9]{12}(?:[0-9]{3})?$";
        String expRegex = "(?:0[1-9]|1[0-2])/[0-9]{2}";
        String cvvRegex = "^[0-9]{3,4}$";

        Pattern p1 = Pattern.compile(nameRegex);
        Pattern p2 = Pattern.compile(numberRegex);
        Pattern p3 = Pattern.compile(expRegex);
        Pattern p4 = Pattern.compile(cvvRegex);

        Matcher m1 = p1.matcher(cname);
        Matcher m2 = p2.matcher(cnum);
        Matcher m3 = p3.matcher(exp);
        Matcher m4 = p4.matcher(cvv);


        if(cname.equals("") || cnum.equals("") || exp.equals("") || cvv.equals("")) {
            message = "Each field required!!";
        }
        else{
            if(!m1.matches()){
                message = "Name should not contain numbers";
            }else if(!m2.matches()){
                message = "Enter correct card number";
            }else if (!m3.matches()) {
                message = "Date must be in MM/YY format";
            }else if(!m4.matches()){
                message = "Enter correct CVV";
            }else{
                message = "Payment Success!!";
            }
        }
        return message;
    }
}
