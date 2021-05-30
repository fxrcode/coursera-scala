# The problem
* An anagram of a word is a rearrangement of its letters such that a word with a different meaning is formed. For example, if we rearrange the letters of the word `Elvis` we can obtain the word `lives`, which is one of its anagrams.

* In a similar way, an anagram of a sentence is a rearrangement of all the characters in the sentence such that a new sentence is formed. The new sentence consists of meaningful words, the number of which may or may not correspond to the number of words in the original sentence. For example, the sentence:

* `I love you`
is an anagram of the sentence:

* `You olive`
In this exercise, we will consider permutations of words anagrams of the sentence. In the above example:

* `You I love`
is considered a separate anagram.

* When producing anagrams, we will ignore character casing and punctuation characters.

* When producing anagrams, we will ignore character casing and punctuation characters.

* Your ultimate goal is to implement a method `sentenceAnagrams`, which, given a list of words representing a sentence, finds all the anagrams of that sentence. Note that we used the term meaningful in defining what anagrams are. You will be given a dictionary, i.e. a list of words indicating words that have a meaning.

* Here is the general idea. We will transform the characters of the sentence into a list saying how often each character appears. We will call this list the occurrence list. To find anagrams of a word we will find all the words from the dictionary which have the same occurrence list. Finding an anagram of a sentence is slightly more difficult. We will transform the sentence into its occurrence list, then try to extract any subset of characters from it to see if we can form any meaningful words. From the remaining characters we will solve the problem recursively and then combine all the meaningful words we have found with the recursive solution.

* Let's apply this idea to our example, the sentence `You olive`. Lets represent this sentence as an occurrence list of characters `eiloouvy`. We start by subtracting some subset of the characters, say `i`. We are left with the characters `eloouvy`.

* Looking into the dictionary we see that `i` corresponds to word `I` in the English language, so we found one meaningful word. We now solve the problem recursively for the rest of the characters `eloouvy` and obtain a list of solutions `List(List(love, you), List(you, love))`. We can combine`I` with that list to obtain sentences `I love you` and `I you love`, which are both valid anagrams.


