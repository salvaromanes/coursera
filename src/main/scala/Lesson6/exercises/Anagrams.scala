package Lesson6.exercises

import scala.annotation.tailrec
import scala.io.{Codec, Source}

object Anagrams extends AnagramsInterface {
  private type Word = String
  private type Sentence = List[Word]
  private type Occurrences = List[(Char, Int)]

  val dictionary: List[Word] = Dictionary.loadDictionary

  def wordOccurrences(w: Word): Occurrences = {
    var s: List[Char] = List()

    for (c <- w) {
      s = s :+ c
    }

    countOccurrences(s, List())
  }

  @tailrec
  private def countOccurrences(list: List[Char], occurrences: Occurrences): Occurrences = list match {
    case Nil => occurrences
    case c::cs =>
      var occ = occurrences

      if (occurrences.contains(c)) {
        val i: Int = occ.indexOf(c)
        val (l, o): (Char, Int) = occ(i)

        occ = occ.drop(i)
        occ = occ.updated(l, o + 1)

        countOccurrences(cs, occ)
      } else {
        occ = occ :+ (c, 1)
        countOccurrences(cs, occ)
      }
  }

  def sentenceOccurrences(s: Sentence): Occurrences = s match {
    case Nil => List()
    case x::xs => wordOccurrences(x) :: sentenceOccurrences(xs)
  }

  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = dictionary.groupBy(wordOccurrences).withDefaultValue(List())

  def wordAnagrams(word: Word): List[Word] = {
    dictionaryByOccurrences(wordOccurrences(word))
  }

  def combinations(occurrences: Occurrences): List[Occurrences] = {
    var list: List[Occurrences] = List()

    for (o <- occurrences) {
      list = list :+ List(o)
    }

    list
  }

  def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    require(x.contains(y))
    var occ: Occurrences = List()

    for (o <- x) {
      if (y.contains(o)) {
        val i: Int = y.indexOf(o)
        val (_, n): (Char, Int) = y(i)
        val (l, m): (Char, Int) = o

        if (m - n > 0) {
          occ = occ :+ (l, m - n)
        }
      } else {
        occ = occ :+ o
      }
    }

    occ
  }

  def sentenceAnagrams(sentence: Sentence): List[Sentence] = {
    def occurrenceAnagrams(occurrences: Occurrences): List[Sentence] = occurrences match {
      case Nil => List()
      case _ =>
        for {
          combination <- combinations(occurrences)
          word <- dictionaryByOccurrences.getOrElse(combination, Nil)
          sentence <- occurrenceAnagrams(subtract(occurrences, wordOccurrences(word)))
          if combination.nonEmpty
        } yield word :: sentence
    }

    occurrenceAnagrams(sentenceOccurrences(sentence))
  }
}

object Dictionary {
  def loadDictionary: List[String] = {
    val wordstream = Option {
      getClass.getResourceAsStream(List("forcomp", "linuxwords.txt").mkString("/", "/", ""))
    } getOrElse {
      sys.error("Could not load word list, dictionary file not found")
    }
    try {
      val s = Source.fromInputStream(wordstream)(Codec.UTF8)
      s.getLines().toList
    } catch {
      case e: Exception =>
        println("Could not load word list: " + e)
        throw e
    } finally {
      wordstream.close()
    }
  }
}
