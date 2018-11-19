package services;

import models.Product;
import java.util.*;

import com.stripe.model.Charge;
import com.stripe.exception.StripeException;
import com.stripe.Stripe;

public class StripeService {
	
	public static Charge chargeCard(String stripeToken, String stripeTokenType, String stripeEmail, Product product){

		Stripe.apiKey = "sk_test_X3gPtSfbW8zhbbgQbOG4sME8";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("amount", (int) (product.price * 100));
		params.put("currency", "usd");
		params.put("description", "Charge " + stripeEmail + " for "+product.productName);
		params.put("source", stripeToken);

		try{

			Charge charge = Charge.create(params);
			//System.out.println(charge);
			return charge;
		}
		catch(StripeException e){
			e.printStackTrace();

			return null;
		}

	}


}