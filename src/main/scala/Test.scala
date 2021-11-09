
      import skunk._
      import skunk.implicits._
      import skunk.codec.all._

      object Test {
        (
          text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text ~ text
        ).map {case
         ((((((((((((((((((((((((_, _), _), _), _), _), _), _), _), _), _), _), _), _), _), _), _), _), _), _), _), _), _), _), _) => ()
        // case _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ ~ _ => ()
        }

      }
      