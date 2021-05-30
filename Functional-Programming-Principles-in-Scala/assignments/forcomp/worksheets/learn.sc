import forcomp.Anagrams.{Occurrences, Word, dictionary, dictionaryByOccurrences, sentenceOccurrences, wordOccurrences}

object Learn {
  val s = "Hello"
  println(s + " world")

  println(wordOccurrences(s))

  // sentenceOccurrences()
  val sen = List("I", "love", "you")
  sen.map(w => wordOccurrences(w))
  sen.flatMap(w => wordOccurrences(w))
    .groupBy(_._1)   // hashmap [char -> list( (char, int) )]
    .map( p => (p._1, p._2.map(_._2).sum)).toList.sorted

  // dictionaryByOccurrences(): reverse-index
  //  dictionary is predefined List[Word]
  //  build up Map[Occurrence -> List[Word]]
//  dictionary.map(w => (wordOccurrences(w),w)).groupBy(_._1).map(x => (x._1, x._2.map(_._2))) withDefaultValue List()

  // wordAnagrams
  dictionaryByOccurrences(wordOccurrences("post"))

//  def combinations(occurrences: Occurrences): List[Occurrences] = ???

}

