package com.corejava.streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		List<Fruit> fruits=TestData.getAllFruits();
		//Displaying the fruit names of low calories fruits i.e. calories < 100 sorted in descending order of calories
		List<Fruit> finalfruit = fruits.stream()
								.filter(fruit -> fruit.getCalories() < 100)
								.sorted(Comparator.comparing(Fruit::getCalories).reversed())
								.collect (Collectors.toList());
		System.out.println(finalfruit);
		
		
		//Displaying color wise list of fruits
		Map<String,List<Fruit>> colorWiseFruits = fruits.stream()
												.collect(Collectors.groupingBy(Fruit::getColor)); 
		System.out.println(colorWiseFruits);
		
		
		//Displaying only RED color fruits sorted as per their price in ascending order
		List<Fruit> colorfruit = fruits.stream()
				.filter(fruit -> fruit.getColor().equals("Red"))
				.sorted(Comparator.comparing(Fruit::getPrice))
				.collect (Collectors.toList());
		System.out.println(colorfruit);
		
		
		List<News> news=TestData.getAllNews();
		//Find out the newsId which has received maximum comments
		Integer newsId = news.stream()
				.collect(Collectors.groupingBy(News::getNewsId,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey(); 
		System.out.println(newsId);
		
		//Find out how many times the word 'budget' arrived in user comments of all news. Assume that ‘budget’ word has arrived only once in a given user comment
		Long wordCount = news.stream().filter(news1 -> news1.getComment().contains("budget")).count();
		System.out.println(wordCount);
		
		
		//Displaying commentByUser wise number of comments
		Map<String,Long> commentByUser = news.stream()
				.collect(Collectors.groupingBy(News::getCommentByUser,Collectors.counting())); 
		System.out.println(commentByUser);
		
		
		List<Transaction> transaction=TestData.getAllTransactions();
		//Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> tran = transaction.stream()
				.filter(transactions -> transactions.getYear()==2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect (Collectors.toList());
		System.out.println(tran);

		//What are all the unique cities where the traders work?
		List<String> uniqueCities=transaction.stream()
									.map(Transaction::getTrader)
									.map(Trader::getCity)
									.distinct()
									.collect(Collectors.toList());
		System.out.println(uniqueCities);
		
		//Find all traders from Pune and sort them by name.
		List<Trader> name=transaction.stream()
						.filter(city->city.getTrader().getCity().equals("Pune"))
						.map(Transaction::getTrader)
						.sorted(Comparator.comparing(Trader::getName))
						.collect(Collectors.toList());
		System.out.println(name);
		
		//Return a string of all traders’ names sorted alphabetically
		String namesort=transaction.stream()
				.map(Transaction::getTrader)
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList()).toString();
		System.out.println(namesort);
		
		
		//Are any traders based in Indore?
		Optional<Trader> indoreTraders = transaction.stream()
				.filter(city -> city.getTrader().getCity() == "Indore")
				.map(Transaction::getTrader)	
				.findAny();
		System.out.println(indoreTraders);
		
		//Print all transactions’ values from the traders living in Delhi
				Optional<Transaction> delhiTraders =transaction
						.stream()
						.filter(cityName->cityName.getTrader().getCity().equalsIgnoreCase("delhi"))
						.findAny();
			System.out.println(delhiTraders.isPresent());

			//What’s the highest value of all the transactions?
			Integer  highestTransaction = transaction.stream()
								.collect(Collectors.groupingBy(value->value.getValue(),Collectors.counting()))
								.entrySet()
								.stream()
								.max(Map.Entry.comparingByKey()).get().getKey();;
		System.out.println("Transaction with Highest Value :"+highestTransaction);
		

		//What’s the lowest value of all the transactions?
		Integer  lowestTransaction = transaction.stream()
							.collect(Collectors.groupingBy(value->value.getValue(),Collectors.counting()))
							.entrySet()
							.stream()
							.min(Map.Entry.comparingByKey()).get().getKey();;
		System.out.println("Transaction with lowest Value :"+lowestTransaction);
		 
		
		//Find out which user has posted maximum comments.
		String postname = news.stream()
				.collect(Collectors.groupingBy(News::getPostedByUser,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey(); 
		System.out.println(postname);
		
	}

}
