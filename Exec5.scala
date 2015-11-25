import beans.BeanProperty

object Exec5 extends App {
  // 1.
  class Counter {
    private var counter: Int = 0
    def increment() {
      if (counter < Int.MaxValue) counter += 1
    }
    def current() = counter
  }
  val counter = new Counter()
  // for (i <- Range.Long(0, Int.MaxValue, 1)) counter.increment()
  println(counter.current)
  
  // 2.
  class BankAccount {
    private var balance: Double = 0
    
    def getBalance = balance  // how to define a read-only property?
    
    def deposit(money: Double) {
      balance += money
    }
    
    def withdraw(money: Double) = {
      if (money <= balance) {
        balance -= money
        true
      } else {
        false
      }
    }
  }
  
  // 3
  class Time(val hours: Int, val minutes: Int) {
    if (hours < 0 || hours > 23) {
      throw new IllegalArgumentException("Hours must within [0, 23].")
    }
    if (minutes < 0 || minutes > 59) {
      throw new IllegalArgumentException("Minutes must within [0, 59]")      
    }
    
    def before(other: Time) = 
      (hours < other.hours) || (hours == other.hours && minutes < other.minutes)
  }
  
  try {
    val time1 = new Time(21, 43)
    val time2 = new Time(10, 2)
    println(time1.before(time2))
    println(time1.hours, time1.minutes)
    val time3 = new Time(0, 100)
  } catch {
    case ex: Throwable => println("Error: " + ex.getMessage)
  }
  
  // 4
  class Time2(hours: Int, minutes: Int) {
    private var minutesSinceMidNight = 0
    if (hours < 0 || hours > 23) {
      throw new IllegalArgumentException("Hours must within [0, 23].")
    }
    if (minutes < 0 || minutes > 59) {
      throw new IllegalArgumentException("Minutes must within [0, 59]")      
    }
    minutesSinceMidNight = hours * 60 + minutes
    
    def hours() = minutesSinceMidNight / 60
    def minutes() = minutesSinceMidNight % 60
    
    def before(other: Time) = 
      (hours < other.hours) || (hours == other.hours && minutes < other.minutes)
  }
  try {
    val time1 = new Time(21, 43)
    val time2 = new Time(10, 2)
    println(time1.before(time2))
    println(time1.hours, time1.minutes)
    val time3 = new Time(0, 100)
  } catch {
    case ex: Throwable => println("Error: " + ex.getMessage)
  }
  
  // 5
  class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {
  }
  val s1 = new Student("ipiszy", 12)
  println(s1.name, s1.id, s1.getName(), s1.getId())
  
  // 6
  class Person(var age: Int) {
    if (age < 0) age = 0
  }
  val p1 = new Person(-4)
  val p2 = new Person(100)
  println(p1.age, p2.age)
  
  // 7
  class Person2(fullName: String) {
    var firstName: String = ""
    var lastName: String = ""
    val names = fullName.split(" ")
    if (names.length != 2) 
      throw new IllegalArgumentException("The full name is not correct: " + fullName)
    firstName = names(0)
    lastName = names(1)
  }
  
  // 8
  class Car(val manufacturer: String, val modelName: String, 
            val modelYear: Int, var licensePlate: String) {
    def this(manufacturer: String, modelName: String) {
      this(manufacturer, modelName, -1, "")
    }
    
    def this(manufacturer: String, modelName: String, modelYear: Int) {
      this(manufacturer, modelName, modelYear, "")
    }
    
    def this(manufacturer: String, modelName: String, licensePlate: String) {
      this(manufacturer, modelName, -1, licensePlate)
    }  
  }
  
  // 9 
  class Employee() {
    var name: String = ""
    var salary: Double = 0
    def this(name: String, salary: Double) {
      this()
      this.name = name
      this.salary = salary
    }
  }
}