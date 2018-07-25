public class Settlement {
	private String name;
	private int population;
	private SettlementType kind;
	private Road[] roads;
	private int numRoads;

	/**
	 * Represents he maximum number of roads that can be connected to a
	 * settlment object
	 */
	public static final int MAX_ROADS = 100;

	public Settlement(String nm, SettlementType k) {
		name = nm;
		kind = k;
		roads = new Road[MAX_ROADS];
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int size) {
		population = size;
	}

	public SettlementType getKind() {
		return kind;
	}

	public void setKind(SettlementType kindof) {
		kind = kindof;
	}

	public void add(Road road) {
		if (numRoads < MAX_ROADS) {
			roads[numRoads] = road;
			numRoads++;
		} else {
			// Should report an error. We'll look at exceptions later
		}
	}

	public String toString() {
		return "The type of settlement is called " + name
				+ " and has a population of " + population
				+ ". The type of settlement is a " + kind;
	}
}
