package Lesson3.exercises

import TweetReader._

class Tweet(val user: String, val text: String, val retweets: Int) {
  override def toString: String =
    "User: " + user + "\n" +
    "Text: " + text + " [" + retweets + "]"
}

abstract class TweetSet extends TweetSetInterface {
  def filter(p: Tweet => Boolean): TweetSet = filterAcc(p, this)
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet
  def union(that: TweetSet): TweetSet
  def mostRetweeted: Tweet
  def descendingByRetweet: TweetList

  //The following methods are already implemented
  def incl(tweet: Tweet): TweetSet
  def remove(tweet: Tweet): TweetSet
  def contains(tweet: Tweet): Boolean
  def foreach(f: Tweet => Unit): Unit
}

class Empty extends TweetSet {
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = new Empty
  def union(that: TweetSet): TweetSet = that
  def mostRetweeted: Tweet = throw new NoSuchElementException("Empty Set")
  def descendingByRetweet: TweetList = Nil

  //The following methods are already implemented
  def contains(tweet: Tweet): Boolean = false
  def incl(tweet: Tweet): TweetSet = new NonEmpty(tweet, new Empty, new Empty)
  def remove(tweet: Tweet): TweetSet = this
  def foreach(f: Tweet => Unit): Unit = ()
}

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
    var tweetSet: TweetSet = new Empty

    for (t <- acc) {
      if (p(t)) tweetSet = tweetSet.incl(t)
    }

    tweetSet
  }

  def union(that: TweetSet): TweetSet = {
    val tweetSet: TweetSet = new Empty

    for (t <- this) {
      tweetSet.incl(t)
    }

    for (t <- that) {
      tweetSet.incl(t)
    }

    tweetSet
  }

  def mostRetweeted: Tweet = {
    var tweet: Tweet = new Tweet("", "", 0)

    for (t <- this) {
      if(t.retweets > tweet.retweets) tweet = t
    }

    tweet
  }

  private def lessRetweeted: Tweet = {
    var tweet: Tweet = new Tweet("", "", mostRetweeted.retweets)

    for (t <- this) {
      if(t.retweets < tweet.retweets) tweet = t
    }

    tweet
  }

  def descendingByRetweet: TweetList = {
    var tweetList: TweetList = Nil

    while (this.isInstanceOf[NonEmpty]) {
      tweetList = new Cons(lessRetweeted, tweetList)
      remove(lessRetweeted)
    }

    tweetList
  }

  //The following methods are already implemented
  def contains(x: Tweet): Boolean =
    if (x.text < elem.text) left.contains(x)
    else if (elem.text < x.text) right.contains(x)
    else true

  def incl(x: Tweet): TweetSet = {
    if (x.text < elem.text) new NonEmpty(elem, left.incl(x), right)
    else if (elem.text < x.text) new NonEmpty(elem, left, right.incl(x))
    else this
  }

  def remove(tw: Tweet): TweetSet =
    if (tw.text < elem.text) new NonEmpty(elem, left.remove(tw), right)
    else if (elem.text < tw.text) new NonEmpty(elem, left, right.remove(tw))
    else left.union(right)

  def foreach(f: Tweet => Unit): Unit = {
    f(elem)
    left.foreach(f)
    right.foreach(f)
  }
}

trait TweetList {
  def head: Tweet
  def tail: TweetList
  def isEmpty: Boolean
  def foreach(f: Tweet => Unit): Unit =
    if (!isEmpty) {
      f(head)
      tail.foreach(f)
    }
}

object Nil extends TweetList {
  def head = throw new java.util.NoSuchElementException("head of EmptyList")
  def tail = throw new java.util.NoSuchElementException("tail of EmptyList")
  def isEmpty = true
}

class Cons(val head: Tweet, val tail: TweetList) extends TweetList {
  def isEmpty = false
}


object GoogleVsApple {
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  lazy val googleTweets: TweetSet = {
    var tweetSet: TweetSet = new Empty

    for (t <- TweetReader.allTweets) {
      for (g <- google) {
        if (t.text.contains(g)) tweetSet = tweetSet.incl(t)
      }
    }

    tweetSet
  }

  lazy val appleTweets: TweetSet = {
    var tweetSet: TweetSet = new Empty

    for (t <- TweetReader.allTweets) {
      for (a <- apple) {
        if (t.text.contains(a)) tweetSet = tweetSet.incl(t)
      }
    }

    tweetSet
  }

  lazy val trending: TweetList = {
    (googleTweets union appleTweets).descendingByRetweet
  }
}

object Main extends App {
  GoogleVsApple.trending foreach println
}
