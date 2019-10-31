def factorial(x: Int): Int = {
  def fact(x: Int, accumulator: Int): Int = {
    if (x <= 1) accumulator
    else fact(x - 1, accumulator * x)
  }
  fact(x, 1)
}

factorial(5)