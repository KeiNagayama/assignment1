package prg1.assignment1

object FIB {
  //An implementation of the Fibonacci function using the definition of the Fibonacci number
  def fib_rec(n: Int): BigInt = n match {
    case 0 | 1 => n
    case _ => fib_rec(n-1) + fib_rec(n-2)
  }

  //An implementation of the Fibonacci function using iteration (tail recursion)
  def fib_itr(n: Int): BigInt = {
    var m = n
    var a: BigInt = 1
    var b: BigInt = 0
    while(m >= 1) {
    	val c = a
    	a = a + b
    	b = c
    	m = m - 1
    }
  }

  //An implementation of the Fibonacci function using matrix products
  def fib_matrix(n: Int): BigInt = {
  	def mulMatrix(List[BigInt],List[BigInt]): List[BigInt] = (X,Y) match{
  		case ((a,b,c,d),(e,f,g,h)) => (ae+bg, af+bh, ce+dg, cf+dh)
  	}
  	val A = List(1,1,1,0)
  	def pow(List[BigInt],n): List[BigInt] = n match{
  		case 0 => A
  		case n%2 = 0 => mulMatrix(A, pow(mulMatrix(A,A), (n-1)/2))
  		case n%2 = 1 => pow(mulMatrix(A,A), n/2)
  	}
  	val A_n = pow(A,n)
  	A_n[2]
  	 }

  //An implementation of the Fibonacci function using polynomial products
  def fib_polynomial(n: Int): BigInt = {
    0
  }

  def bench(f: Int => BigInt, n: Int, name: String): Unit = {
    val start = System.nanoTime()
    val r = f(n)
    val end = System.nanoTime()
    println(r)
    println(name + ": " + (" " * (20 - name.length)) + (end-start) + "ns")
  }

  def main(arg: Array[String]): Unit = {
    val n = 10

    bench(fib_rec, n, "fib_rec")
    bench(fib_itr, n, "fib_itr")
    bench(fib_matrix, n, "fib_matrix")
    bench(fib_polynomial, n, "fib_polynomial")
  }
}
