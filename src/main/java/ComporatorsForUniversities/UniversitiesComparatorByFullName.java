package ComporatorsForUniversities;

import Universities.University;
import org.apache.commons.lang3.StringUtils;

public class UniversitiesComparatorByFullName implements UniversitiesComparator {
    @Override
    public int compare(University a, University b) {
        return StringUtils.compare(a.getFullName(), b.getFullName());
    }
}