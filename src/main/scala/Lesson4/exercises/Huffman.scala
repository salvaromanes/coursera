package Lesson4.exercises

import scala.annotation.tailrec

abstract class CodeTree
case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
case class Leaf(char: Char, weight: Int) extends CodeTree

trait Huffman extends HuffmanInterface {
  def weight(tree: CodeTree): Int = tree match {
    case Leaf(_, w: Int) => w
    case Fork(l: CodeTree, r: CodeTree, _, w: Int) => w
  }

  def chars(tree: CodeTree): List[Char] = tree match {
    case Leaf(c: Char, _) => List(c)
    case Fork(l: CodeTree, r: CodeTree, cs: List[Char], _) => cs
  }

  def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))

  def string2Chars(str: String): List[Char] = str.toList

  def times(chars: List[Char]): List[(Char, Int)] = chars match {
    case Nil => List()
    case x::Nil => List((x, 1))
    case _ => timesHelper(chars, List())
  }

  @tailrec
  private def timesHelper(chars: List[Char], list: List[(Char, Int)]): List[(Char, Int)] = chars match {
    case Nil => list
    case x::xs =>
      if (list.contains(x)) timesHelper(xs, list.updated(x, list.find(_._1 == x).get._2 + 1))
      else timesHelper(xs, list :+ (x, 1))
  }

  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = freqs match {
    case Nil => List()
    case x::Nil => List(Leaf(x._1, x._2))
    case _ => leafListHelper(freqs, List())
  }

  private def leafListHelper(freqs: List[(Char, Int)], list: List[Leaf]): List[Leaf] = {
    if (freqs.isEmpty) list
    else {
      val leaf = searchLessWeigth(freqs)
      val newFreqs = freqs.filter(_ != (leaf.char, leaf.weight))
      leafListHelper(newFreqs, list :+ leaf)
    }
  }

  private def searchLessWeigth(freqs: List[(Char, Int)]): Leaf = {
    var (c, w): (Char, Int) = freqs.head

    for ((c1, w1) <- freqs.tail){
      if (w1 < w){
        c = c1
        w = w1
      }
    }

    Leaf(c, w)
  }

  def singleton(trees: List[CodeTree]): Boolean = {
    trees.length == 1
  }

  def combine(trees: List[CodeTree]): List[CodeTree] = trees match {
    case Nil || _::Nil => trees
    case x::y::xs => xs :+ Fork(x, y, chars(x) ::: chars(y), weight(x) + weight(y))
  }

  def until(done: List[CodeTree] => Boolean, merge: List[CodeTree] => List[CodeTree])(trees: List[CodeTree]): List[CodeTree] = {
    while (done(trees)){
      merge(trees)
    }

    trees
  }

  def createCodeTree(chars: List[Char]): CodeTree = {
    val list: List[(Char, Int)] = times(chars)
    makeOrderedLeafList(list)
    until(singleton, combine)(makeOrderedLeafList(list)).head
  }

  type Bit = Int

  def decode(tree: CodeTree, bits: List[Bit]): List[Char] = {
     if (tree.isInstanceOf[Leaf]) chars(tree)
     else decodeHelper(tree, bits, List())
  }

  @tailrec
  private def decodeHelper(tree: CodeTree, bits: List[Bit], decode: List[Char]): List[Char] = bits match {
    case Nil => decode
    case x::xs =>
      if (tree.isInstanceOf[Leaf]) chars(tree)
      else {
        val fork: Fork = tree.asInstanceOf[Fork]

        if(x == 0) decodeHelper(fork.left, xs, List())
        else decodeHelper(fork.right, xs, List())
      }
  }

  val frenchCode: CodeTree = Fork(Fork(Fork(Leaf('s',121895),Fork(Leaf('d',56269),Fork(Fork(Fork(Leaf('x',5928),Leaf('j',8351),List('x','j'),14279),Leaf('f',16351),List('x','j','f'),30630),Fork(Fork(Fork(Fork(Leaf('z',2093),Fork(Leaf('k',745),Leaf('w',1747),List('k','w'),2492),List('z','k','w'),4585),Leaf('y',4725),List('z','k','w','y'),9310),Leaf('h',11298),List('z','k','w','y','h'),20608),Leaf('q',20889),List('z','k','w','y','h','q'),41497),List('x','j','f','z','k','w','y','h','q'),72127),List('d','x','j','f','z','k','w','y','h','q'),128396),List('s','d','x','j','f','z','k','w','y','h','q'),250291),Fork(Fork(Leaf('o',82762),Leaf('l',83668),List('o','l'),166430),Fork(Fork(Leaf('m',45521),Leaf('p',46335),List('m','p'),91856),Leaf('u',96785),List('m','p','u'),188641),List('o','l','m','p','u'),355071),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u'),605362),Fork(Fork(Fork(Leaf('r',100500),Fork(Leaf('c',50003),Fork(Leaf('v',24975),Fork(Leaf('g',13288),Leaf('b',13822),List('g','b'),27110),List('v','g','b'),52085),List('c','v','g','b'),102088),List('r','c','v','g','b'),202588),Fork(Leaf('n',108812),Leaf('t',111103),List('n','t'),219915),List('r','c','v','g','b','n','t'),422503),Fork(Leaf('e',225947),Fork(Leaf('i',115465),Leaf('a',117110),List('i','a'),232575),List('e','i','a'),458522),List('r','c','v','g','b','n','t','e','i','a'),881025),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u','r','c','v','g','b','n','t','e','i','a'),1486387)
  val secret: List[Bit] = List(0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1)

  def decodedSecret: List[Char] = decode(frenchCode, secret)

  /**
   * This function encodes `text` using the code tree `tree`
   * into a sequence of bits.
   */
  def encode(tree: CodeTree)(text: List[Char]): List[Bit] = ???

  // Part 4b: Encoding using code table

  type CodeTable = List[(Char, List[Bit])]

  /**
   * This function returns the bit sequence that represents the character `char` in
   * the code table `table`.
   */
  def codeBits(table: CodeTable)(char: Char): List[Bit] = ???

  /**
   * Given a code tree, create a code table which contains, for every character in the
   * code tree, the sequence of bits representing that character.
   *
   * Hint: think of a recursive solution: every sub-tree of the code tree `tree` is itself
   * a valid code tree that can be represented as a code table. Using the code tables of the
   * sub-trees, think of how to build the code table for the entire tree.
   */
  def convert(tree: CodeTree): CodeTable = ???

  /**
   * This function takes two code tables and merges them into one. Depending on how you
   * use it in the `convert` method above, this merge method might also do some transformations
   * on the two parameter code tables.
   */
  def mergeCodeTables(a: CodeTable, b: CodeTable): CodeTable = ???

  /**
   * This function encodes `text` according to the code tree `tree`.
   *
   * To speed up the encoding process, it first converts the code tree to a code table
   * and then uses it to perform the actual encoding.
   */
  def quickEncode(tree: CodeTree)(text: List[Char]): List[Bit] = ???
}

object Huffman extends Huffman
