package controllers;

import play.mvc.*;
import play.db.*;
import java.util.*;

import play.db.jpa.JPA;

import models.*;

import javax.persistence.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the product selection page.
 */
public class ProductSelectionController extends Controller {

    public static void selection() {
	    List<Product> products = Product.all().fetch();
        render(products);
    }

}
