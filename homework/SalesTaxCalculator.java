package salestax;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesTaxCalculator {

	public static final double generalSalesTax = 0.10;
	public static final double importSalesTax = 0.05;
	public static final DecimalFormat df = new DecimalFormat("0.00");
	static List<String> taxExemptItems = new ArrayList<String>();
	static {
		taxExemptItems.add("book");
		taxExemptItems.add("books");
		taxExemptItems.add("chocolate");
		taxExemptItems.add("chocolates");
		taxExemptItems.add("pill");
		taxExemptItems.add("pills");
	}

	public static void main(String[] args) {
		SalesTaxCalculator taxCalculator = new SalesTaxCalculator();		

		
		List<String> itemList = new ArrayList<String>();
		itemList.add("1 book at 12.49");
		itemList.add("1 music CD at 14.99");
		itemList.add("1 chocolate bar at 0.85");
		taxCalculator.calculateTax(itemList);

		itemList = new ArrayList<String>();
		itemList.add("1 imported box of chocolates at 10.00");
		itemList.add("1 imported bottle of perfume at 47.5");
		taxCalculator.calculateTax(itemList);

		itemList = new ArrayList<String>();
		itemList.add("1 imported bottle of perfume at 27.99");
		itemList.add("1 bottle of perfume at 18.99");
		itemList.add("1 packet of headache pills at 9.75");
		itemList.add("1 box of imported chocolates at 11.25");
		taxCalculator.calculateTax(itemList);

	}

	private void calculateTax(List<String> inputItemList) {
		double totalSalesTax = 0;
		double total = 0;
		System.out.println("\nOutput:");
		for (String inputItem : inputItemList) {
			if (inputItem != null) {
				List<String> itemDesc = new ArrayList<String>();
				itemDesc = Arrays.asList(inputItem.split(" "));

				int size = itemDesc.size();
				
				int quantity = Integer.parseInt(itemDesc.get(0));
				

				double price = Double.parseDouble(itemDesc.get(size - 1));
					

				boolean isImported = false;
				boolean isTaxExempt = false;

			
				double salesTax = 0;
				double finalPrice = 0;

				for (String str : itemDesc) {
					if (taxExemptItems.contains(str)) {
						isTaxExempt = true;
					}
				}

			
				if (!isTaxExempt) {
					salesTax = roundOff(generalSalesTax * price);
				
					finalPrice = price + salesTax;
				} else {
					finalPrice = price;
				}

				for (String str : itemDesc) {
					if (str.contains("imported")) {
						isImported = true;
					}
				}

				if (isImported) {
					salesTax += roundOff(importSalesTax * price);
				
					finalPrice = price + salesTax;
				}

				totalSalesTax += salesTax;
				total += finalPrice;
				

				List<String> outputDesc = itemDesc.subList(0, itemDesc.size() - 2);
				String outputItemDesc = "";
				for (String str : outputDesc) {
					outputItemDesc += str + " ";
				}

				System.out.println(outputItemDesc + ":" + df.format(finalPrice));

			}
		}
		System.out.println("Sales Taxes: " + df.format(totalSalesTax));
		System.out.println("Total:" + df.format(total));
	}

	public static double roundOff(double value) {
		double roundOffValue = (double) Math.round(value * 20) / 20;

		if (roundOffValue < value) {
			roundOffValue = (double) Math.round((value + 0.05) * 20) / 20;
		}

		return roundOffValue;
	}

}
