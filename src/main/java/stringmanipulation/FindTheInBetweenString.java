package stringmanipulation;

public class FindTheInBetweenString {

	public static void main(String[] args) {
		
		String st = "chirag, k submitted a bill negotiation on 03/21/2024 @ 02:29:15 AM for $500.00 and is Approved. No offer document was included";
		int index1 = st.indexOf("negotiation on");
		int indexOfDate = index1 + 15;
		String dateText = st.substring(indexOfDate,indexOfDate+10);
		System.out.println(dateText);
		
		String st2 = "Credit Card Payment made by chirag k\r\n"
				+ "Payment received for PRE750838 via Credit Card with amount $206.00 and txn#: txn_3Owke2Drl8bqoi002z9D5o0j";
		int index2 = st2.indexOf("txn#");
		System.out.println(st2.substring(index2+6, st2.length()));

	}

}
