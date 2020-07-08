package com.rafael.falconi.shoppingcart.resources.exeptions;

public class CaracteristicDontFound extends Exception {

	private static final long serialVersionUID = -7717691994704695707L;

	public static final String DESCRIPTION = "Caracteristic don't found";

	public CaracteristicDontFound() {
		super(DESCRIPTION);
	}

	public CaracteristicDontFound(String message ) {
		super(DESCRIPTION + " " +message);
	}
}
