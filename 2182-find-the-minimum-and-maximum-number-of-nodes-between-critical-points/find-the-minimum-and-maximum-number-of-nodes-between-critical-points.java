class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstCriticalIndex = -1;
        int prevCriticalIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        while (curr.next != null) {
            ListNode next = curr.next;

            // Check if current node is a local maxima or minima
            if ((curr.val > prev.val && curr.val > next.val) || 
                (curr.val < prev.val && curr.val < next.val)) {

                if (firstCriticalIndex == -1) {
                    firstCriticalIndex = index;
                } else {
                    minDistance = Math.min(minDistance, index - prevCriticalIndex);
                }

                prevCriticalIndex = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        // Return [-1, -1] if fewer than two critical points were found
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevCriticalIndex - firstCriticalIndex;
        return new int[]{minDistance, maxDistance};
    }
}