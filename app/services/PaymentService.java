package services;

import models.Payment;
import models.Product;

import play.db.*;
import play.db.jpa.JPA;
import javax.persistence.*;

import com.stripe.model.Charge;

public class PaymentService {
	
	public static Payment createPayment(String stripeToken, String stripeTokenType, String stripeEmail, Charge charge, Product product){
		Payment payment = new Payment();

		payment.amount = product.price;
		payment.sku = product.sku;
		payment.stripeToken = stripeToken;
		payment.stripeTokenType = stripeTokenType;
		payment.stripeEmail = stripeEmail;
		payment.chargeId = charge.getId();


		EntityManager em = JPA.em();
		em.persist(payment);

		return payment;
	}

}