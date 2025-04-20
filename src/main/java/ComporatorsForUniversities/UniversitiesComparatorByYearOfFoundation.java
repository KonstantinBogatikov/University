package ComporatorsForUniversities;

import Universities.University;

public class UniversitiesComparatorByYearOfFoundation implements UniversitiesComparator {
    @Override
    public int compare(University a, University b) {
        return Integer.compare(a.getYearOfFoundation(), b.getYearOfFoundation());
    }
}