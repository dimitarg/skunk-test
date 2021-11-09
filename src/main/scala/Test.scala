
      import skunk._
      import skunk.implicits._
      import skunk.codec.all._

      object Test {

        final case class Foo(a: String, b: String, c: String)
        final case class Bar(a: String, b: String, c: String, d: String, e: String, f: String)


        val fooCodec = (text ~ text ~ text).imap{ case a ~ b  ~ c => Foo(a, b, c) }(x => x.a ~ x.b ~ x.c)
        val barCodec = (text ~ text ~ text ~ text ~ text ~ text).imap{ case a ~ b  ~ c ~ d ~ e ~ f => Bar(a, b, c, d, e, f) }(x => x.a ~ x.b ~ x.c ~ x.d ~ x.e ~ x.f)


        (
          fooCodec ~ barCodec ~ barCodec ~ fooCodec ~ fooCodec ~ barCodec ~ fooCodec ~ barCodec // 37 cols
        ).map {
        case foo ~ bar1 ~ bar2 ~ foo2 ~ foo3 ~ bar3 ~ foo4 ~ bar4 => ()
        }
      }
      