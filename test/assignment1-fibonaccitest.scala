package prg1.assignment1

import org.scalatest._
import FIB._

class FIBTest extends FunSuite with Matchers {
   test("fib_itr") {
     fib_itr(0) should equal (fib_rec(0))
     fib_itr(1) should equal (fib_rec(1))
     fib_itr(5) should equal (fib_rec(5))
     fib_itr(10) should equal (fib_rec(10))
   }

   test("fib_matrix") {
     fib_matrix(0) should equal (fib_itr(0))
     fib_matrix(1) should equal (fib_itr(1))
     fib_matrix(5) should equal (fib_itr(5))
     fib_matrix(100) should equal (fib_itr(100))
   }

}



