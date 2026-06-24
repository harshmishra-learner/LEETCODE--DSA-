class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        // Loop for each row
        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            // First element is always 1
            row.add(1);

            // Add middle elements
            for (int j = 1; j < i; j++) {

                int value = result.get(i - 1).get(j - 1)
                          + result.get(i - 1).get(j);

                row.add(value);
            }

            // Last element is also 1
            if (i > 0) {
                row.add(1);
            }

            // Add row to result
            result.add(row);
        }

        return result;
    }
}