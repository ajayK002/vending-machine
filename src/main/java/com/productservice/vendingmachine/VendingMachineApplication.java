package com.productservice.vendingmachine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class VendingMachineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VendingMachineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		Map<String, Integer> productCodePricemap = new HashMap<>();
		productCodePricemap.put("coke",40);
		productCodePricemap.put("pepsi",40);
		productCodePricemap.put("lays",20);
		productCodePricemap.put("water bottle",15);

		Map<String, Queue<String>> productCodeItemMap = new HashMap<>();
		Queue<String> productItems = new LinkedList<>();
		productItems.add("1");
		productItems.add("2");
		productItems.add("3");
		productCodeItemMap.put("coke",productItems);
		productCodeItemMap.put("pepsi",productItems);
		productCodeItemMap.put("lays",productItems);
		productCodeItemMap.put("water bottle",productItems);

		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setProductCodePriceMap(productCodePricemap);
		vendingMachine.setProductCodeItemMap(productCodeItemMap);

		ReadyState readyState = new ReadyState(vendingMachine);

		System.out.println("welcome to the vending machine");
		Boolean bool = true;
		while(bool){
			System.out.println("Please select one : ");
			System.out.println("Press 1 to buy or 2 to exit");
			int press = scanner.nextInt();
			scanner.nextLine();     /*when you enter an integer followed by pressing Enter,
					the nextInt() method reads the integer but leaves the newline character (Enter key press)
					in the input stream. Then, when nextLine() is called, it reads this newline character,
					considering it as an empty line, and moves on. So use nextLine() before using nextLine()
					again to read a line.
					*/

			if(press == 1){
				System.out.println();
				System.out.println("Please enter a product you want to buy");
				for (String s : productCodeItemMap.keySet()){
					System.out.println(s);
				}

				String productCode = scanner.nextLine();

				System.out.println("Please insert money");
				int money = scanner.nextInt();

				readyState.collectCash(money);
				readyState.dispenseChange(productCode);

			} else if (press == 2) {
				System.out.println("Thank you for coming.");
			}else {
				System.out.println("Please select correct value.");
			}
		}
	}
}
