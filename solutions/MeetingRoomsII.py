'''
Sort the array by start time first, then we maintain a priorityqueue sorted by end time
Next, for each interval, we check the earliest ended interval
if not overlapped, we assign it to the meeting room. Otherwise, it will need a new meeting room

time O(nlogn) space O(n)
'''
import heapq

# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        intervals = sorted(intervals, key=lambda x: x.start)

        ended_intervals = [(intervals[0].end, intervals[0])]
        for i in range(1, len(intervals)):
            earliest_ended = heapq.heappop(ended_intervals)
            if earliest_ended[1].end <= intervals[i].start:
                earliest_ended[1].end = intervals[i].end
            else:
                heapq.heappush(ended_intervals, (intervals[i].end, intervals[i]))
            heapq.heappush(ended_intervals, earliest_ended)
        
        return len(ended_intervals)

if __name__ == "__main__":
    input_list = [[7,10],[2,4]]
    interval_list = [Interval(x[0], x[1]) for x in input_list]

    s = Solution()
    res = s.minMeetingRooms(interval_list)
    print(res)