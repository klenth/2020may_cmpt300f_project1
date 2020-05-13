class P01_Numbers {

  /*
   * An example: the sequence 0, 1, 2, 3, 4, 5, …, ending with 100
   */
  def example(): Sequence = {
    Sequence(
      (0, 1),             // First two numbers
      (a, b) => b + 1,    // The rule for getting the next number from the two previous ones
                          //   (in this case, uses just the last number (b), not the next-to-last (a))
      x => x > 100        // When to stop (optional — can be left off for a sequence that should not end)
                          //   (in this case, stops when the number is bigger than 100)
    )
  }

  /*
   * Returns the Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, …
   * It starts with 0 and 1, and then every successive number is the sum of the two previous ones:
   *       0
   *       1
   * 0+1 = 1
   * 1+1 = 2
   * 1+2 = 3
   * 2+3 = 5
   * 3+5 = 8
   * (and so on)
   *
   * You do not need a "done" condition because the Fibonacci sequence does not end.
   */
  def fibonacci(): Sequence = {
    Sequence(
      // Fill this in! (Refer to the example() method above)

    )
  }

  /*
   * Returns the alternating sequence 1, -1, 1, -1, 1, -1, … ending after n numbers.
   *
   * Hint: you will want to use the "count" variable defined below in your done condition; don't forget to update it!
   * FYI, Scala doesn't have a ++ operator (count++ won't work). To add 1 to count, do
   * count += 1
   */
  def alternate(n: Int): Sequence = {
    var count = 0
    Sequence(
      // Fill this in! (Refer to the example() method above)

    )
  }

  /*
   * Returns the sequence 1, 2, 0, 7, -13, 58, …, where each number is three times the next-to-last, minus two times the
   * last, plus 1:
   *                       1
   *                       2
   * 3(1) - 2(2)   + 1 =   0
   * 3(2) - 2(0)   + 1 =   7
   * 3(0) - 2(7)   + 1 = -13
   * 3(7) - 2(-13) + 1 =  58
   * (and so on)
   *
   * The sequence should stop when it is over 500,000 in absolute value (Math.abs(x) is the absolute value of x).
   */
  def complicated(): Sequence = {
    Sequence(
      // Fill this in! (Refer to the example() method above)

    )
  }
}

object P01_Numbers_Test {
  def main(args: Array[String]): Unit = {
    // Put any code you want here for testing purposes
    new P01_Numbers().example().print()
  }
}