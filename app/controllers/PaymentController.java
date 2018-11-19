package controllers;

import play.mvc.*;
import models.Product;
import models.Payment;
import java.util.*;

import services.PaymentService;
import services.StripeService;

import com.stripe.model.Charge;

/**
 * This controller contains an action to handle HTTP requests
 * to the Payment page.
 */
public class PaymentController extends Controller {

    public static void payment(int product) {

    	List<Product> products = Product.find("bySku", product).fetch();

		if(products.size() > 0){
    		Product p = products.get(0);
        	// System.out.println(p.productName);
        	render(p);
			
		}
		//Go back to selection screen if no product was passed
        else{
        	ProductSelectionController.selection();
        }

    }

	public static void makePayment(String stripeToken, String stripeTokenType, String stripeEmail, int sku) {

		// System.out.println(stripeToken);
		// System.out.println(stripeTokenType);
		// System.out.println(stripeEmail);
		// System.out.println(sku);

		List<Product> products = Product.find("bySku", sku).fetch();

		if(products.size() > 0){
    		Product product = products.get(0);
		
			Charge charge = StripeService.chargeCard(stripeToken, stripeTokenType, stripeEmail, product);
			
			boolean success = "succeeded".equals(charge.getStatus());

			if(success){
				Payment payment = PaymentService.createPayment(stripeToken, stripeTokenType, stripeEmail, charge, product);

	        	ConfirmationController.confirmation(String.valueOf(payment.id), payment.chargeId);
			}
	       	else{
	       		ConfirmationController.failure();
	       	}
		}
		//Product not found
        else{
        	ConfirmationController.failure();
        }


       	
    }
}
