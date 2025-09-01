class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = getGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] top = pq.poll();
            
            int pass = (int) top[1];
            int total = (int) top[2];

            pass++;
            total++;
            double gain = getGain(pass, total);

            pq.offer(new double[]{gain, pass, total});
        }

        double sum = 0.0;
        int n = classes.length;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int pass = (int) cur[1];
            int total = (int) cur[2];
            sum += (double) pass / total;
        }

        return sum / n;
    }

    private double getGain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}