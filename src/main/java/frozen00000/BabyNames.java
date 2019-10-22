package frozen00000;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class BabyNames {

	@ToString(exclude = "next")
	static class CounterNode {
		String name;
		long counter;
		CounterNode next;

		CounterNode(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) {
		Map<String, Integer> freq = Map.of(
				"John", 10,
				"Jon", 3,
				"Davis", 2,
				"Kari", 3,
				"Jonny", 11,
				"Carlton", 8,
				"Carleton", 2,
				"Jonahtan", 9,
				"Carrie", 5
		);

		String[][] alts = new String[][] {
				{"Jonahtan", "John"},
				{"Jon", "Jonny"},
				{"Jonny", "John"},
				{"Kari", "Carrie"},
				{"Carleton", "Carlton"}
		};

		Set<CounterNode> set = getMergedFreq(freq, alts);

		System.out.println(set.stream()
				.filter(n -> n.next == null)
				.map(n -> n.name + " - " + n.counter)
				.collect(Collectors.toList()));
	}

	private static Set<CounterNode> getMergedFreq(Map<String, Integer> freq, String[][] alts) {
		Map<String, CounterNode> map = new HashMap<>();
		for (String[] n : alts) {
			String n1 = n[0];
			String n2 = n[1];
			CounterNode counterNode1 = map.get(n1);
			CounterNode counterNode2 = map.get(n2);
			if (counterNode1 == null && counterNode2 == null) {
				CounterNode counterNode = new CounterNode(n1);
				map.put(n1, counterNode);
				map.put(n2, counterNode);
			} else if (counterNode1 != null && counterNode2 == null) {
				map.put(n2, counterNode1);
			} else if (counterNode1 == null) {
				map.put(n1, counterNode2);
			} else {
				counterNode2.next = Objects.requireNonNullElse(counterNode1.next, counterNode1);
			}
		}
		freq.forEach((n, c) -> {
			CounterNode counterNode = map.computeIfAbsent(n, CounterNode::new);
			if (counterNode.next != null) {
				counterNode = counterNode.next;
			}
			counterNode.counter += c;
		});
		return map.values().stream()
				.filter(n -> n.next == null)
				.collect(Collectors.toSet());
	}

}
