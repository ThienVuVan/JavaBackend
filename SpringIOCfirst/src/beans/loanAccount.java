package beans;

import org.springframework.stereotype.Component;

public class loanAccount implements BankAcount {

	@Override
	public void log() {
		System.out.println("loan");
	}

}
