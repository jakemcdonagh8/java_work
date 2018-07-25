public class Application {

	public static void main(String[] args) {
		Settlement aberystwyth = new Settlement("Aberystwyth", SettlementType.TOWN);
		aberystwyth.setPopulation(20000);
		
		Settlement bowStreet = new Settlement("Bow Street",	SettlementType.VILLAGE);
		bowStreet.setPopulation(2000);
		
		Settlement borth = new Settlement("Borth", SettlementType.VILLAGE);
		borth.setPopulation(1500);
		
		Settlement llanbadarn = new Settlement("Llanbadarn", SettlementType.VILLAGE);
		llanbadarn.setPopulation(3000);
		
		Settlement penparcau = new Settlement("Penparcau", SettlementType.VILLAGE);
		penparcau.setPopulation(3100);

		Road A44 = new Road("A44", Classification.A, aberystwyth, llanbadarn);

		Road A487BowStreet = new Road("A487", Classification.A, aberystwyth,
				bowStreet);

		Road A487Penparcau = new Road("A487", Classification.A, aberystwyth,
				penparcau);

		Road Hoelybont = new Road("Hoel-Y-Bont", Classification.U, llanbadarn,
				penparcau);

		Road B4353 = new Road("B4353", Classification.B, bowStreet, borth);

		System.out.println("The following settlements are:");

		System.out.println(aberystwyth.toString());
		System.out.println(penparcau.toString());
		System.out.println(llanbadarn.toString());
		System.out.println(bowStreet.toString());
		System.out.println(borth.toString());

		System.out.println("The following roads are:");

		System.out.println(A44.toString());
		System.out.println(A487BowStreet.toString());
		System.out.println(A487Penparcau.toString());
		System.out.println(Hoelybont.toString());
		System.out.println(B4353.toString());
	}

}
