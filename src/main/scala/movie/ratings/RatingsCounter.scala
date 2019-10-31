package movie.ratings

import org.apache.spark._

object RatingsCounter {

  def main(args: Array[String]): Unit = {

    // Create a SparkContext using every core of the local machine, named RatingsCounter.
    val sc = new SparkContext("local[*]", "RatingsCounter")

    // Load up each line of the ratings data into an RDD.
    val lines = sc.textFile(
      "/home/martin/Documents/spark_udemy_tutorial/ml-100k/u.data")

    val ratings = lines.map(x => x.toString().split("\t")(2))

    val results = ratings.countByValue()

    val sortedResults = results.toSeq.sortBy(_._1)

    sortedResults.foreach(println)
  }

}
