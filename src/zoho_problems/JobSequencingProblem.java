package zoho_problems;

import java.util.ArrayList;
import java.util.List;

public class JobSequencingProblem {

    public static class Job {
        int deadline;
        int profit;
        public Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        List<Job> jobs = new ArrayList<>();
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(deadline[i], profit[i]));
            if (deadline[i] > maxDeadline) {
                maxDeadline = deadline[i];
            }
        }
        jobs.sort((a, b) -> b.profit - a.profit);
        int limit = Math.min(maxDeadline, n);
        int[] parent = new int[limit + 1];
        for (int i = 0; i <= limit; i++) {
            parent[i] = i;
        }
        int countJobs = 0;
        int totalProfit = 0;
        for (Job job : jobs) {
            int availableSlot = find(parent, Math.min(job.deadline, limit));
            if (availableSlot > 0) {
                parent[availableSlot] = find(parent, availableSlot - 1);
                countJobs++;
                totalProfit += job.profit;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(totalProfit);
        return result;
    }

    public static void main(String[] args) {
        int[] deadline = { 4, 1, 1, 1 };
        int[] profit = { 20, 10, 40, 30 };
        System.out.println("Output: " + jobSequencing(deadline, profit));
    }
}
