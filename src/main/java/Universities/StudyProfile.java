package Universities;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"),
    MATHEMATICS("Математика");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public String toString() {
        return "Universities.StudyProfile{" +
                "profileName='" + profileName + '\'' +
                '}';
    }
}