import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
	private static List<Restaurant> restaurants = new ArrayList<>();

	public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getName().contains(restaurantName)) {
				return restaurant;
			}
		}

		throw new restaurantNotFoundException(restaurantName + " doesn't exist");
	}

	public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
		Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
		restaurants.add(newRestaurant);
		return newRestaurant;
	}

	public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
		Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
		restaurants.remove(restaurantToBeRemoved);
		return restaurantToBeRemoved;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public int getTotalCost(List<Item> items) {
		int total = 0;
		for (Item item : items) {
			total += item.getPrice();
		}

		return total;
	}
}
