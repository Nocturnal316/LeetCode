class Solution:
    def mergeAlternately2(self, word1: str, word2: str) -> str:
        
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
    
    def mergeAlternately(self,word1: str, word2: str) -> str:
        merged_str = ''
        for char1, char2 in zip(word1, word2):
            merged_str += char1 + char2

        # Append the remaining characters from longer word
        merged_str += word1[len(word2):] + word2[len(word1):]

        return merged_str
        