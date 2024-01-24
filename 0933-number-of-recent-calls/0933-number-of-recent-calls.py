from queue import Queue

class RecentCounter:
    recentCalls = None
    
    def __init__(self):
        self.recentCalls = Queue()

        
    def ping(self, t: int) -> int:
        self.recentCalls.put(t)
        while(self.recentCalls.queue[0] < t - 3000):
            self.recentCalls.get()
        return self.recentCalls.qsize()
        


# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)