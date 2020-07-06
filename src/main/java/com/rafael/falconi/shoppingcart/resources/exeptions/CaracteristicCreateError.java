package com.rafael.falconi.shoppingcart.resources.exeptions;

public class CaracteristicCreateError extends Exception {
	private static final long serialVersionUID = -7717691994704695707L;

	public static final String DESCRIPTION = "Bad information send";

	public CaracteristicCreateError() {
		super(DESCRIPTION);
	}

	public CaracteristicCreateError(String message) {
		super(DESCRIPTION+""+message);
	}

}
