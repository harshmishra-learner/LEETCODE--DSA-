class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] frequencyCount = new int[1001];
        for (int element : nums1) {
            frequencyCount[element]++;
        }
        List<Integer> intersectionResult = new ArrayList<>();
        for (int element : nums2) {
            if (frequencyCount[element] > 0) {
                frequencyCount[element]--;
                intersectionResult.add(element);
            }
        }
        return intersectionResult.stream()
                                .mapToInt(Integer::intValue)
                                .toArray();
    }
}