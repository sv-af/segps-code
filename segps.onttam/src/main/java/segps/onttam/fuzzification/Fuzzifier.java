package segps.onttam.fuzzification;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChartImpl;

public class Fuzzifier {
	public static void main(String[] args) {
		double value = getOverallFuzzyScore(3, 27, 0.9, 0.004, 249, 123, 10, 2, 5);
		System.out.println(value);
	}

	public static double getWVDFuzzyScore(double score, double weight) {
		String file = "src/main/resources/segps/onttam/fcl/measures/weightedVulnerabilityDensity.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		fis.setVariable("WVD_Measure", score);
		fis.setVariable("WVD_Weight", weight);
		fis.evaluate();
		return fis.getVariable("WVD_Score").getLatestDefuzzifiedValue();
	}

	public static double getLVFuzzyScore(double score, double weight) {
		String file = "src/main/resources/segps/onttam/fcl/measures/licenseViolationCount.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		fis.setVariable("LV_Measure", score);
		fis.setVariable("LV_Weight", weight);
		fis.evaluate();
		return fis.getVariable("LV_Score").getLatestDefuzzifiedValue();
	}

	public static double getBCDFuzzyScore(double score, double weight) {
		String file = "src/main/resources/segps/onttam/fcl/measures/breakingChangeDensity.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		fis.setVariable("BCD_Measure", score);
		fis.setVariable("BCD_Weight", weight);
		fis.evaluate();
		return fis.getVariable("BCD_Score").getLatestDefuzzifiedValue();
	}

	public static double getBCIFuzzyScore(double score, double weight) {
		String file = "src/main/resources/segps/onttam/fcl/measures/breakingChangeImpact.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		fis.setVariable("BCI_Measure", score);
		fis.setVariable("BCI_Weight", weight);
		fis.evaluate();
		return fis.getVariable("BCI_Score").getLatestDefuzzifiedValue();
	}

	public static double getNODFuzzyScore(double score, double weight) {
		String file = "src/main/resources/segps/onttam/fcl/measures/dependencies.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		fis.setVariable("NOD_Measure", score);
		fis.setVariable("NOD_Weight", weight);
		fis.evaluate();
		return fis.getVariable("NOD_Score").getLatestDefuzzifiedValue();
	}

	public static double getNSDFuzzyScore(double score, double weight) {
		String file = "src/main/resources/segps/onttam/fcl/measures/switchedDependencies.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		fis.setVariable("NSD_Measure", score);
		fis.setVariable("NSD_Weight", weight);
		fis.evaluate();
		return fis.getVariable("NSD_Score").getLatestDefuzzifiedValue();
	}

	public static double getExploitabilityFuzzyScore(double wvdScore, double lvScore, double bcdScore, double bciScore,
			double nodScore, double nsdScore, double securityWeight, double legalityWeight, double reliabilityWeight) {
		String file = "src/main/resources/segps/onttam/fcl/attributes/exploitability.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		double WVD_Score = getWVDFuzzyScore(wvdScore, (securityWeight + legalityWeight + reliabilityWeight) / 3);
		fis.setVariable("WVD_Score", WVD_Score);
		fis.evaluate();
		return fis.getVariable("score").getLatestDefuzzifiedValue();
	}

	public static double getImpactFuzzyScore(double wvdScore, double lvScore, double bcdScore, double bciScore,
			double nodScore, double nsdScore, double securityWeight, double legalityWeight, double reliabilityWeight) {
		String file = "src/main/resources/segps/onttam/fcl/attributes/impact.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		double WVD_Score = getWVDFuzzyScore(wvdScore, (securityWeight + legalityWeight + reliabilityWeight) / 3);
		double LV_Score = getLVFuzzyScore(lvScore, (securityWeight + legalityWeight + reliabilityWeight) / 3);
		double BCI_Score = getBCIFuzzyScore(bciScore, (securityWeight + legalityWeight + reliabilityWeight) / 3);
		fis.setVariable("WVD_Score", WVD_Score);
		fis.setVariable("LV_Score", LV_Score);
		fis.setVariable("BCI_Score", BCI_Score);
		fis.evaluate();
		return fis.getVariable("score").getLatestDefuzzifiedValue();
	}

	public static double getPopularityFuzzyScore(double wvdScore, double lvScore, double bcdScore, double bciScore,
			double nodScore, double nsdScore, double securityWeight, double legalityWeight, double reliabilityWeight) {
		String file = "src/main/resources/segps/onttam/fcl/attributes/popularity.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		double NOD_Score = getNODFuzzyScore(nodScore, reliabilityWeight);
		double NSD_Score = getNSDFuzzyScore(nsdScore, reliabilityWeight);
		fis.setVariable("NOD_Score", NOD_Score);
		fis.setVariable("NSD_Score", NSD_Score);
		fis.evaluate();
		return fis.getVariable("score").getLatestDefuzzifiedValue();
	}

	public static double getStabilityFuzzyScore(double wvdScore, double lvScore, double bcdScore, double bciScore,
			double nodScore, double nsdScore, double securityWeight, double legalityWeight, double reliabilityWeight) {
		String file = "src/main/resources/segps/onttam/fcl/attributes/stability.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		double BCD_Score = getBCDFuzzyScore(bcdScore, reliabilityWeight);
		double NSD_Score = getNSDFuzzyScore(nsdScore, reliabilityWeight);
		fis.setVariable("BCD_Score", BCD_Score);
		fis.setVariable("NSD_Score", NSD_Score);
		fis.evaluate();
		return fis.getVariable("score").getLatestDefuzzifiedValue();
	}

	public static double getLegalityFuzzyScore(double wvdScore, double lvScore, double bcdScore, double bciScore,
			double nodScore, double nsdScore, double securityWeight, double legalityWeight, double reliabilityWeight) {
		String file = "src/main/resources/segps/onttam/fcl/subfactors/legality.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		double impactScore = getImpactFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore, nsdScore,
				securityWeight, legalityWeight, reliabilityWeight);
		fis.setVariable("Impact_Score", impactScore);
		fis.evaluate();
		return fis.getVariable("score").getLatestDefuzzifiedValue();
	}

	public static double getReliabilityFuzzyScore(double wvdScore, double lvScore, double bcdScore, double bciScore,
			double nodScore, double nsdScore, double securityWeight, double legalityWeight, double reliabilityWeight) {
		String file = "src/main/resources/segps/onttam/fcl/subfactors/reliability.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		double Impact_Score = getImpactFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore, nsdScore,
				securityWeight, legalityWeight, reliabilityWeight);
		double Stability_Score = getStabilityFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore, nsdScore,
				securityWeight, legalityWeight, reliabilityWeight);
		double Popularity_Score = getPopularityFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore, nsdScore,
				securityWeight, legalityWeight, reliabilityWeight);
		fis.setVariable("Impact_Score", Impact_Score);
		fis.setVariable("Stability_Score", Stability_Score);
		fis.setVariable("Popularity_Score", Popularity_Score);
		fis.evaluate();
		return fis.getVariable("score").getLatestDefuzzifiedValue();
	}

	public static double getSecurityFuzzyScore(double wvdScore, double lvScore, double bcdScore, double bciScore,
			double nodScore, double nsdScore, double securityWeight, double legalityWeight, double reliabilityWeight) {
		String file = "src/main/resources/segps/onttam/fcl/subfactors/security.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		double Exploitability_Score = getExploitabilityFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore,
				nsdScore, securityWeight, legalityWeight, reliabilityWeight);
		double Impact_Score = getImpactFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore, nsdScore,
				securityWeight, legalityWeight, reliabilityWeight);
		fis.setVariable("Exploitability_Score", Exploitability_Score);
		fis.setVariable("Impact_Score", Impact_Score);
		fis.evaluate();
		return fis.getVariable("score").getLatestDefuzzifiedValue();
	}

	public static double getReusabilityFuzzyScore(double wvdScore, double lvScore, double bcdScore, double bciScore,
			double nodScore, double nsdScore, double securityWeight, double legalityWeight, double reliabilityWeight) {
		String file = "src/main/resources/segps/onttam/fcl/factors/reusability.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		double securityScore = getSecurityFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore, nsdScore, securityWeight, legalityWeight, reliabilityWeight);
		double legalityScore = getLegalityFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore, nsdScore, securityWeight, legalityWeight, reliabilityWeight);
		double reliabilityScore = getReliabilityFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore, nsdScore, securityWeight, legalityWeight, reliabilityWeight);
		fis.setVariable("Security_Score", securityScore);
		fis.setVariable("Legality_Score", legalityScore);
		fis.setVariable("Reliability_Score", reliabilityScore);
		fis.evaluate();
		return fis.getVariable("score").getLatestDefuzzifiedValue();
	}

	public static double getOverallFuzzyScore(double wvdScore, double lvScore, double bcdScore, double bciScore,
			double nodScore, double nsdScore, double securityWeight, double legalityWeight, double reliabilityWeight) {
		String file = "src/main/resources/segps/onttam/fcl/overall.fcl";
		FIS fis = FIS.load(file, true);
		JFuzzyChartImpl chartImpl = new JFuzzyChartImpl();
		// chartImpl.chart(fis);
		double score = getReusabilityFuzzyScore(wvdScore, lvScore, bcdScore, bciScore, nodScore, nsdScore,
				securityWeight, legalityWeight, reliabilityWeight);
		fis.setVariable("Reusability_Score", score);
		fis.evaluate();
		return fis.getVariable("score").getLatestDefuzzifiedValue();
	}

}
