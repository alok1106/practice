import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> usersToTeach = new HashSet<>();

        for (int[] friendship : friendships) {
            int user1 = friendship[0] - 1;
            int user2 = friendship[1] - 1;

            if (!hasCommonLanguage(languages[user1], languages[user2])) {
                usersToTeach.add(user1);
                usersToTeach.add(user2);
            }
        }

        if (usersToTeach.isEmpty()) {
            return 0;
        }

        int[] languageCounts = new int[n + 1];
        for (int user : usersToTeach) {
            for (int language : languages[user]) {
                languageCounts[language]++;
            }
        }

        int maxKnownLanguageCount = 0;
        for (int count : languageCounts) {
            maxKnownLanguageCount = Math.max(maxKnownLanguageCount, count);
        }

        return usersToTeach.size() - maxKnownLanguageCount;
    }

    private boolean hasCommonLanguage(int[] langSet1, int[] langSet2) {
        Set<Integer> setA = new HashSet<>();
        for (int language : langSet1) {
            setA.add(language);
        }
        for (int language : langSet2) {
            if (setA.contains(language)) {
                return true;
            }
        }
        return false;
    }
}
