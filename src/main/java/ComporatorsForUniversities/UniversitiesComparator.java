package ComporatorsForUniversities;

import Universities.University;
import java.util.Comparator;

public interface UniversitiesComparator extends Comparator<University> {
    int compare(University a, University b);
}
