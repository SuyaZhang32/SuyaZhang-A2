import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Compare by membershipPoints first
        int pointsComparison = Integer.compare(v1.getMembershipPoints(), v2.getMembershipPoints());
        if (pointsComparison != 0) {
            return pointsComparison;
        }

        // If points are equal, compare by name
        int nameComparison = v1.getName().compareTo(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }

        // If name is also equal, compare by age
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}
