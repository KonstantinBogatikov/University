package ComporatorsForUniversities;

import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversitiesComparatorById implements UniversitiesComparator {
    @Override
    public int compare(University a, University b) {
        return StringUtils.compare(a.getId(), b.getId());
    }
}