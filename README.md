## Purpose

This repo is to demonstrate long compile times when working with wide codecs. It contains an sbt task that will produce a program containing a codec of n columns wide.

### Example
```
import skunk._
import skunk.implicits._
import skunk.codec.all._

object Test {
  (
    text ~ text ~ text ~ text ~ text
  ).map {
  case _ ~ _ ~ _ ~ _ ~ _ => ()
  }
}
      
```

## How to use
```
sbt runTest <number of columns>; compile
```

## Findings 
The compile time is exponentially long per number of columns.
**columns**|**compile time (s)**
:-----:|:-----:
21|1
22|2
23|4
24|9
25|15
26|28
27|58
28|117
29|230
30|467
