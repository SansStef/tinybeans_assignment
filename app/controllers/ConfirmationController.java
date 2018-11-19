package controllers;

import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the confirmation page after payment is confirmed success.
 */
public class ConfirmationController extends Controller {

    public static void confirmation(String orderId, String paymentId) {

    	render(orderId, paymentId);

    }

    public static void failure(){
    	render();
    }

}
