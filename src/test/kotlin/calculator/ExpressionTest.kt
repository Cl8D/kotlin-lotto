package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ExpressionTest : StringSpec({

    "주어진 문자열이 숫자인지 확인한다" {
        forAll(
            row("1", true),
            row("1,", false),
            row(":", false),
            row("//", false),
            row("\n", false),
        ) { text, expected ->
            Expression(text).isNumber() shouldBe expected
        }
    }

    "주어진 문자열을 숫자로 반환한다" {
        Expression("1").toInt() shouldBe 1
    }

    "숫자로만 이루어지지 않은 수식에 대해 숫자로 반환하려고 하면 예외가 발생한다." {
        shouldThrow<RuntimeException> { Expression("1,").toInt() }
    }
})
