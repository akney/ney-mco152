package ney.ups;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/**
	 * Add a Package to a Location. Verify that the Package is returned with
	 * getPackages(). Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase upsDB = new UPSDatabase();
		Package pkg = new Package("a1");
		Location location = new Location(30, 40);

		upsDB.addPackageToLocation(location, pkg);
		Assert.assertEquals(location, upsDB.getLocation(pkg));
	}

	@Test
	/**
	 * Add a Package to a Location then update the Package Location to a
	 * different Location. Verify that the Package is returned with
	 * getPackages(). Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with
	 * the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase upsDB = new UPSDatabase();
		Package pkg = new Package("a1");
		Location location = new Location(30, 40);
		upsDB.addPackageToLocation(location, pkg);

		Location loc = new Location(50, 60);
		upsDB.updatePackageLocation(pkg, loc);

		Assert.assertEquals(loc, upsDB.getLocation(pkg));

	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with a
	 * Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase upsDB = new UPSDatabase();
		HashSet<Package> empty = new HashSet<>();
		Location location = new Location(30, 40);
		Assert.assertEquals(empty, upsDB.getPackages(location));
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase upsDB = new UPSDatabase();
		Package pkg = new Package("a1");
		Assert.assertEquals(null, upsDB.getLocation(pkg));
	}

	@Test
	public void testAddTwoLocations() {
		UPSDatabase upsDB = new UPSDatabase();
		Package p1 = new Package("p1");
		Package p2 = new Package("p2");
		Location l1 = new Location(0, 0);
		Location l2 = new Location(1, 1);
		upsDB.addPackageToLocation(l1, p1);
		upsDB.addPackageToLocation(l2, p2);

		Set<Package> result = upsDB.getPackages(l1);
		Assert.assertTrue(result.contains(p1));
		Assert.assertFalse(result.contains(p2));
		Assert.assertEquals(1, result.size());
	}

}
