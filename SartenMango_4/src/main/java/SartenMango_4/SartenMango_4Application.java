package SartenMango_4;


import SartenMango_4.interfaces.InterfaceOrder;
import SartenMango_4.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import SartenMango_4.interfaces.InterfaceCookware;


@Component
@SpringBootApplication

/**
**
*/
public class SartenMango_4Application implements CommandLineRunner {
	@Autowired
	private InterfaceCookware interfaceSupplements;
	@Autowired
	private InterfaceUser interfaceUser;
	@Autowired
	private InterfaceOrder interfaceOrder;
	public static void main(String[] args) {
		SpringApplication.run(SartenMango_4Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		interfaceSupplements.deleteAll();
		interfaceUser.deleteAll();
		interfaceOrder.deleteAll();
	}

}