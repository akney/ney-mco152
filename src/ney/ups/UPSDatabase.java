package ney.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
	HashMap<Package, Location> packMap = new HashMap<Package, Location>();
	HashMap<Location, HashSet<Package>> locationSets = new HashMap<>();
	HashSet<Package> pkgSet = new HashSet<>();

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		packMap.put(pkg, location);

		if (locationSets.containsKey(location)) {
			pkgSet = locationSets.get(location);
			pkgSet.add(pkg);
			locationSets.replace(location, pkgSet);
		} else {
			pkgSet.add(pkg);
			locationSets.put(location, pkgSet);
		}
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		locationSets.get(packMap.get(pkg)).remove(pkg);
		packMap.replace(pkg, location);

		if (locationSets.containsKey(location)) {
			pkgSet = locationSets.get(location);
			pkgSet.add(pkg);
			locationSets.replace(location, pkgSet);
		} else {
			pkgSet.add(pkg);
			locationSets.put(location, pkgSet);
		}
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		if (locationSets.containsKey(location)) {
			return locationSets.get(location);
		} else {
			HashSet<Package> empty = new HashSet<>();
			return empty;
		}
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		return packMap.get(pkg);
	}

}
