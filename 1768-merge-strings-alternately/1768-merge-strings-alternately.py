class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        
        maxLen = len(word1)+len(word2)
        mergedStr = ''
        for i in range(maxLen):
            
            if len(word1) == 0 or len(word2)== 0:
                mergedStr += word1
                mergedStr += word2
                return mergedStr
            if i%2 == 0:
                mergedStr += word1[0]
                word1  = word1[1:]
            else:
                mergedStr += word2[0]
                word2  = word2[1:]
        return mergedStr
        
        