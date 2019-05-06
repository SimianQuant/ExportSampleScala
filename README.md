Export Sample - Scala
===

This project illustrates how a model generated in Scala using the SimianQuant environment can be integrated with an sbt project. As an illustration, the example in the help section of the environment is reproduced here. The steps are:

1. Add the extracted jar to the `lib` folder of the `sample` project
1. Write run code in the `main` folder of the `sample` project
1. Write tests in the `test` folder of the `sample` project (Optional)
1. Write `benchmarks` in the `bench` project (Optional)

The project sets up the wiring for writing tests using [ScalaTest](http://www.scalatest.org/) and [ScalaCheck](https://www.scalacheck.org/), and two illustrative tests are written. The project also sets up the wiring for writing benchmarks using [sbt-jmh](https://github.com/ktoso/sbt-jmh), and one illustrative benchmark is written. 