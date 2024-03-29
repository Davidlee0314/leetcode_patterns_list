'''
Sort the array by start time first, then check the overlap one by one
time O(nlogn) space O(1)
'''
# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def canAttendMeetings(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: bool
        """

        intervals = sorted(intervals, key=lambda x: x.start)
        for i in range(1, len(intervals)):
            if intervals[i - 1].end > intervals[i].start:
                return False
        return True

if __name__ == "__main__":
    input_list = [[7,10],[2,4]]
    interval_list = [Interval(x[0], x[1]) for x in input_list]

    s = Solution()
    res = s.canAttendMeetings(interval_list)
    print(res)