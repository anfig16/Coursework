/* Andrea Figueroa
 * COSC 2336-01
 * Instructor: Jiangjiang Liu
 * Programming Assignment 10
 * Due: 11/1/2023
 * Modified Listing 27.3 to test out MyHashMap class 
 * that uses open addressing and linear probing
 */
public class TestMyHashMapAndreaFigueroa {
  public static void main(String[] args) {
    // Create a map
    MyMap<String, Integer> map = new MyHashMap<>();
    map.put("Lewis", 29);
    map.put("Cook", 29);
    map.put("Anderson", 31);
    map.put("Smith", 65);

    System.out.println("Entries in map: " + map);

    System.out.println("The age for " + "Lewis is " +
      map.get("Lewis"));

    System.out.println("Is Smith in the map? " + 
      map.containsKey("Smith"));
    System.out.println("Is age 33 in the map? " + 
      map.containsValue(33));

    map.remove("Smith");
    System.out.println("Entries in map after removing Smith: " + map);

    map.clear();
    System.out.println("Entries after clearing map: " + map);
  }
}