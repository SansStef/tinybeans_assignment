package models;

import play.mvc.*;

import play.db.jpa.Model;

import javax.persistence.*;

@Entity
@Table(name="payments")
public class Payment extends Model {
	
	@Column(name="amount")
	public double amount;

	@Column(name="charge_id")
	public String chargeId;

	@Column(name="sku")
    public int sku;

	@Column(name="stripe_token")    
    public String stripeToken;

	@Column(name="stripe_token_type")
    public String stripeTokenType;

	@Column(name="stripe_email")
	public String stripeEmail;
}