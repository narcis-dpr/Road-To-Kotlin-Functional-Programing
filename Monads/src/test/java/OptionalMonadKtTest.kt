import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class OptionalMonadKtTest {

    @Test
    fun `when input is not valid returns None`() {
        assert(strToInt("onTwoThree").equals(None))
    }
}