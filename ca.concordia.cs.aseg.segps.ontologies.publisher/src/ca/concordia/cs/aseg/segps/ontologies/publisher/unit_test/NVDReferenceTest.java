package ca.concordia.cs.aseg.segps.ontologies.publisher.unit_test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class NVDReferenceTest {

	List<String> refList1 = new ArrayList<>();
	List<String> refList2 = new ArrayList<>();
	List<String> refList3 = new ArrayList<>();
	List<String> refList4 = new ArrayList<>();
	List<String> refList5 = new ArrayList<>();

	private void setup() {
		refList1.add("UNKNOWN");
		refList1.add("url1");
		refList1.add("source1");
		refList1.add("PATCH");
		refList1.add("url2");
		refList1.add("source2");
		refList1.add("VENDOR_ADVISORY");
		refList1.add("url3");
		refList1.add("source3");

		refList2.add("UNKNOWN");
		refList2.add("url4");
		refList2.add("source4");
		refList2.add("PATCH");
		refList2.add("source5");
		refList2.add("VENDOR_ADVISORY");
		refList2.add("url6");
		refList2.add("source6");

		refList3.add("UNKNOWN");
		refList3.add("url7");
		refList3.add("source7");
		refList3.add("PATCH");
		refList3.add("url8");
		refList3.add("source8");
		refList3.add("VENDOR_ADVISORY");
		refList3.add("source9");

		refList4.add("UNKNOWN");
		refList4.add("url10");
		refList4.add("source10");

		refList5.add("UNKNOWN");
		refList5.add("source11");
	}

	private List<Map<String, String>> parse(List<String> rfl) {
		String ReferenceType = null, ReferenceSource = null, ReferenceURL = null;
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		for (int index = 0; index < rfl.size();index++) {
			if (rfl.get(index).equalsIgnoreCase("PATCH") || rfl.get(index).equalsIgnoreCase("UNKNOWN")
					|| rfl.get(index).equalsIgnoreCase("VENDOR_ADVISORY")) {
				// beginning of new reference type
				ReferenceType = null;
				ReferenceSource = null;
				ReferenceURL = null;
				ReferenceType = rfl.get(index);
			}

			if (index + 2 < rfl.size()) {
				if (rfl.get(index + 2).equalsIgnoreCase("PATCH") || rfl.get(index + 2).equalsIgnoreCase("UNKNOWN")
						|| rfl.get(index + 2).equalsIgnoreCase("VENDOR_ADVISORY")) {
					ReferenceURL = rfl.get(index + 1);
					index = index + 2;
				} else {
					ReferenceSource = rfl.get(index + 1);

					ReferenceURL = rfl.get(index + 2);

					index = index + 3;
				}
			}

			map.put("Type", ReferenceType);
			map.put("Source", ReferenceSource);
			map.put("URL", ReferenceURL);
			list.add(map);
		}
		return list;
	}

	@Test
	public void testReferenceList1() {
		setup();
		List<Map<String, String>> list = parse(refList1);
		System.out.println(list.toString());

	}

	@Test
	public void testReferenceList2() {
		setup();
		List<Map<String, String>> list = parse(refList2);
		System.out.println(list.toString());

	}

	@Test
	public void testReferenceList3() {
		setup();
		List<Map<String, String>> list = parse(refList3);
		System.out.println(list.toString());
	}

	@Test
	public void testReferenceList4() {
		setup();
		List<Map<String, String>> list = parse(refList4);
		System.out.println(list.toString());

	}

	@Test
	public void testReferenceList5() {
		setup();
		List<Map<String, String>> list = parse(refList5);
		System.out.println(list.toString());

	}
}
