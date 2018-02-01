package segps.onttam.fuzzification;

import java.util.TreeMap;

public class FuzzyScaleCreator {
	public static void main(String[] args) {
		getMeasureChartPoints(0, 14885, 10);
		// getMeasureChartPoints(0, 100, 10);
	}

	private static void getMeasureChartPoints(double min, double max, double x) {
		double p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14;
		// determine number of points

		// create main points
		p1 = min;
		p13 = max;
		p7 = (min + max) / 2;

		// create midpoints
		p4 = (p1 + p7) / 2;
		p10 = (p7 + p13) / 2;
		double p25 = (p1 + p4) / 2;
		double p55 = (p4 + p7) / 2;
		double p85 = (p7 + p10) / 2;
		double p115 = (p10 + p13) / 2;

		// create max points
		p3 = p25 + ((0.5 * x / 100) * p25);
		p6 = p55 + ((0.5 * x / 100) * p55);
		p9 = p85 + ((0.5 * x / 100) * p85);
		p12 = p115 + ((0.5 * x / 100) * p115);

		// create overlapping points
		p2 = p3 - ((x / 100) * p3);
		p5 = p6 - ((x / 100) * p6);
		p8 = p9 - ((x / 100) * p9);
		p11 = p12 - ((x / 100) * p12);

		// calculate last point
		TreeMap<String, Double> data = new TreeMap<String, Double>();
		data.put("p1", p1);
		data.put("p2", p2);
		data.put("p3", p3);
		data.put("p4", p4);
		data.put("p5", p5);
		data.put("p6", p6);
		data.put("p7", p7);
		data.put("p8", p8);
		data.put("p9", p9);
		data.put("p10", p10);
		data.put("p11", p11);
		data.put("p12", p12);
		data.put("p13", p13);
		double std = getStdDev(data);
		p14 = p13 + std;
		data.put("p14", p14);

		for (String point : data.keySet()) {
			System.out.println(point + ": " + data.get(point));
		}

	}

	private static void getWeightChartPoints(double min, double max, double x) {
		double p1, p2, p3, p4, p5, p6, p7, p8;
		// determine number of points

		// create main points
		p1 = min;
		p7 = max;
		p4 = (min + max) / 2;

		// create midpoints
		double p25 = (p1 + p4) / 2;
		double p55 = (p4 + p7) / 2;

		// create max points
		p3 = p25 + ((0.5 * x / 100) * p25);
		p6 = p55 + ((0.5 * x / 100) * p55);

		// create overlapping points
		p2 = p3 - ((x / 100) * p3);
		p5 = p6 - ((x / 100) * p6);

		// calculate last point
		TreeMap<String, Double> data = new TreeMap<String, Double>();
		data.put("p1", p1);
		data.put("p2", p2);
		data.put("p3", p3);
		data.put("p4", p4);
		data.put("p5", p5);
		data.put("p6", p6);
		data.put("p7", p7);
		double std = getStdDev(data);
		p8 = p7 + std;
		data.put("p8", p8);

		for (String point : data.keySet()) {
			System.out.println(point + ": " + data.get(point));
		}
	}

	static double getMean(TreeMap<String, Double> data) {
		double sum = 0.0;
		for (String point : data.keySet()) {
			double a = data.get(point);
			sum += a;
		}
		return sum / data.size();
	}

	static double getVariance(TreeMap<String, Double> data) {
		double mean = getMean(data);
		double temp = 0;
		for (String point : data.keySet()) {
			double a = data.get(point);
			temp += (a - mean) * (a - mean);
		}
		return temp / (data.size() - 1);
	}

	static double getStdDev(TreeMap<String, Double> data) {
		return Math.sqrt(getVariance(data));
	}
}
