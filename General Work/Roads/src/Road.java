public class Road {
	private String name;
	private Classification classification;
	private Settlement sourceSettlement;
	private Settlement destinationSettlement;

	public Road(String nm, Classification classifier, Settlement source,
			Settlement destination) {
		name = nm;
		classification = classifier;
		sourceSettlement = source;
		source.add(this);
		destinationSettlement = destination;
		destination.add(this);

	}

	public String getName() {
		return name;
	}

	public Classification getClassification() {
		return classification;
	}

	public Settlement getSouceSettlement() {
		return sourceSettlement;
	}

	public Settlement getDestinationSettlement() {
		return destinationSettlement;
	}

	public String toString() {
		return "Road[name=" + name + ", classification=" + classification
				+ ", sourceSettlement=" + sourceSettlement.getName()
				+ ", destinationSettlement=" + destinationSettlement.getName()
				+ "]";
	}
}
