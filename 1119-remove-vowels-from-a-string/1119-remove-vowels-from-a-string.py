class Solution:
    def removeVowels(self, s: str) -> str:
        vowels = {'a','e','i','o', 'u'}
        ans = ''
        for letter in s:
            if not letter in vowels:
                ans += letter
        return ans