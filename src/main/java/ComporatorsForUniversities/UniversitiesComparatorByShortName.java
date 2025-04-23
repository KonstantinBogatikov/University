package ComporatorsForUniversities;

import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversitiesComparatorByShortName implements UniversitiesComparator {
    @Override
    public int compare(University a, University b) {
        return StringUtils.compare(a.getShortName(), b.getShortName());
    }
}