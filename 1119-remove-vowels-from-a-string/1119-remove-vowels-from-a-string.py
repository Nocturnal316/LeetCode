class Solution:
    def removeVowels(self, s: str) -> str:
        vowels = {'a','e','i','o', 'u'}
        ans = []
        for letter in s:
            if letter not in 'aeiou':
                ans.append(letter)
        return ''.join(ans)