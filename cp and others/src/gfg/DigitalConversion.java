package gfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class DigitalConversion {

	/**
	 * @param args
	 */
	static class Merchant {
		String name;
		String startdate;
		String startMonth;
		String startYear;
		String endDate;
		String endMonth;
		String endYear;
		int finalStartDate;
		int finalEndDate;

		public Merchant() {
			// TODO Auto-generated constructor stub
		}

		public Merchant(String name, String startdate, String startMonth,
				String startYear, String endDate, String endMonth,
				String endYear) {
			super();
			this.name = name;
			this.startdate = startdate.length() == 2 ? startdate : "0"
					+ startdate;
			this.startMonth = getNumMonth(startMonth);
			this.startYear = startYear;
			this.endDate = endDate.length() == 2 ? endDate : "0" + endDate;
			;
			this.endMonth = getNumMonth(endMonth);
			;
			this.endYear = endYear;
			;
			this.finalStartDate = Integer.parseInt(this.startYear
					+ this.startMonth + this.startdate);
			this.finalEndDate = Integer.parseInt(this.endYear + this.endMonth
					+ this.endDate);
		}

	}

	static class Enrollment {
		int custId;
		ArrayList<Merchant> mlist = new ArrayList<>();

		public Enrollment() {
			// TODO Auto-generated constructor stub
		}

		public Enrollment(int custId, ArrayList<Merchant> mlist) {
			super();
			this.custId = custId;
			this.mlist = mlist;
		}

	}

	static class Result {
		double total;
		double online;

		public Result() {
			// TODO Auto-generated constructor stub
		}

		public Result(double total, double online) {
			super();
			this.total = total;
			this.online = online;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		HashMap<Integer, Enrollment> enHMap = new HashMap<Integer, Enrollment>();
		for (int i = 0; i < n; i++) {
			String s1 = in.nextLine();
			String sarr[] = s1.split("\\s+");
			// System.out.println(sarr[0]);
			// System.out.println(maskToCustid(sarr[0]));
			int custId = Integer.parseInt(maskToCustid(sarr[0]));
			String merchant = sarr[1];
			String mode = sarr[3];
			if (!mode.equals("Online")) {
				continue;
			}
			String sdate = sarr[4];
			String edate = sarr[5];
			String sdatearr[] = sdate.split("-");
			String edatearr[] = edate.split("-");
			String ssdate = sdatearr[0];
			String ssMonth = sdatearr[1];
			String ssYear = sdatearr[2];
			String eedate = edatearr[0];
			String eeMonth = edatearr[1];
			String eeYear = edatearr[2];

			Merchant mch = new Merchant(merchant, ssdate, ssMonth, ssYear,
					eedate, eeMonth, eeYear);
			// Enrollment en = new Enrollment(custId, mlist)
			if (!enHMap.containsKey(custId)) {
				ArrayList<Merchant> mlist = new ArrayList<>();
				mlist.add(mch);
				Enrollment en = new Enrollment(custId, mlist);
				enHMap.put(custId, en);
			} else {
				enHMap.get(custId).mlist.add(mch);
			}

		}

		int m = in.nextInt();
		in.nextLine();
		TreeMap<Integer, Result> shareMap = new TreeMap<Integer, Result>();
		for (Integer key : enHMap.keySet()) {
			shareMap.put(key, new Result(0.0, 0.0));
		}

		for (int i = 0; i < m; i++) {
			String s2 = in.nextLine();
			String s2arr[] = s2.split("\\s+");
			int custId = Integer.parseInt(s2arr[0]);
			String merchant = s2arr[1];
			String date = s2arr[2];
			String darr[] = date.split("-");
			String ddate = darr[0].length() == 2 ? darr[0] : "0" + darr[0];
			String dMonth = getNumMonth(darr[1]);
			String dYear = darr[2];
			int fdate = Integer.parseInt(dYear + dMonth + ddate);
			double amnt = Double.parseDouble(s2arr[3]);

			if (enHMap.containsKey(custId)) {
				ArrayList<Merchant> mlist = enHMap.get(custId).mlist;
				for (int j = 0; j < mlist.size(); j++) {
					if (mlist.get(j).name.equals(merchant)) {
						Merchant merch = mlist.get(j);
						if (CompareDate(merch, fdate)) {
							shareMap.get(custId).online += amnt;
							break;
						}
					}
				}
				shareMap.get(custId).total += amnt;

			}
		}

		for (Integer key : shareMap.keySet()) {
			// System.out.println(shareMap.get(key).online);
			// System.out.println(shareMap.get(key).total);
			// System.out.println(key + " "
			// + (shareMap.get(key).online / shareMap.get(key).total));
			double val = Math.round((shareMap.get(key).online / shareMap
					.get(key).total) * 100);
			int res = (int) val;
			String cid = String.valueOf(key);
			if (String.valueOf(key).length() == 1) {
				cid = "00000" + String.valueOf(key);
			} else if (String.valueOf(key).length() == 2) {
				cid = "0000" + String.valueOf(key);
			} else if (String.valueOf(key).length() == 3) {
				cid = "000" + String.valueOf(key);
			} else if (String.valueOf(key).length() == 4) {
				cid = "00" + String.valueOf(key);
			} else if (String.valueOf(key).length() == 5) {
				cid = "0" + String.valueOf(key);
			}

			System.out.println(cid + " " + res);
		}

	}

	public static boolean CompareDate(Merchant merch, int fdate) {
		// System.out.println(merch.finalStartDate+" "+merch.finalEndDate+" "+fdate+" "+(fdate
		// >= merch.finalStartDate && fdate <= merch.finalEndDate));
		if (fdate >= merch.finalStartDate && fdate <= merch.finalEndDate)
			return true;
		return false;

	}

	public static String getNumMonth(String mth) {

		if (mth.equals("Jan")) {
			return "01";
		} else if (mth.equals("Feb")) {
			return "02";
		} else if (mth.equals("Mar")) {
			return "03";
		} else if (mth.equals("Apr")) {
			return "04";
		} else if (mth.equals("May")) {
			return "05";
		} else if (mth.equals("Jun")) {
			return "06";
		} else if (mth.equals("Jul")) {
			return "07";
		} else if (mth.equals("Aug")) {
			return "08";
		} else if (mth.equals("Sep")) {
			return "09";
		} else if (mth.equals("Oct")) {
			return "10";
		} else if (mth.equals("Nov")) {
			return "11";
		} else {
			return "12";
		}

	}

	static public String maskToCustid(String maskId) {

		char[] custId = new char[6];
		char[] mask = maskId.toCharArray();

		for (int i = 0; i < mask.length; i++) {
			char d;
			if (mask[i] == '6') {
				d = '0';
			} else if (mask[i] == '8') {
				d = '1';
			} else if (mask[i] == '9') {
				d = '2';
			} else if (mask[i] == '1') {
				d = '3';
			} else if (mask[i] == '0') {
				d = '4';
			} else if (mask[i] == '2') {
				d = '5';
			} else if (mask[i] == '4') {
				d = '6';
			} else if (mask[i] == '3') {
				d = '7';
			} else if (mask[i] == '5') {
				d = '8';
			} else {
				d = '9';
			}

			if (i == 3) {
				custId[0] = d;
			} else if (i == 4) {
				custId[1] = d;
			} else if (i == 1) {
				custId[2] = d;
			} else if (i == 5) {
				custId[3] = d;
			} else if (i == 0) {
				custId[4] = d;
			} else {
				custId[5] = d;
			}
		}

		// System.out.println(custId.toString());
		String b = new String(custId);
		return b;
	}

}
