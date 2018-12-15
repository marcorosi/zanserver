package it.mr.zan.api;

class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5354003888145035930L;

	NotFoundException() {
		super("Entity not found");
	}
}