package com.searchingsortingbigopartb.prework;

import java.util.List;

/**
 * Manages a list of AmazonPackages.
 * Individual packages can be found by ASIN.
 */
public class AmazonOrderService {

    private List<AmazonPackage> packages;

    /**
     * Constructs an AmazonOrderService object.
     * @param packages - The List of packages in the order
     */
    public AmazonOrderService(List<AmazonPackage> packages) {
        this.packages = packages;
    }

    /**
     * Does a linear search for a package in the known list of packages
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageLinear(String asin) throws PackageNotFoundException {
        // PARTICIPANTS - Implement a linear search for a package matching the requested ASIN
        for (AmazonPackage amazonPackage : packages ) {
            if (amazonPackage.getAsin().equals(asin)) {
                return amazonPackage;
            }
        }
        throw new PackageNotFoundException("Package not found with this asin");
    }

    /**
     * Does a binary search for a package in the known list of packages
     * Note: You should assume that the package list is already sorted when this method is called.
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageBinary(String asin) throws PackageNotFoundException {
        // PARTICIPANTS - Implement a binary search for a package matching the requested ASIN
        int start = 0;
        int end = packages.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            AmazonPackage midPackage = packages.get(mid);
            int comparison = midPackage.getAsin().compareTo(asin);

            if (comparison == 0) {
                return midPackage;
            } else if (comparison < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        throw  new PackageNotFoundException();
}

}
